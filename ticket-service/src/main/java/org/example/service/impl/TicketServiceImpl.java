package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.client.AccountServiceClient;
import org.example.client.dto.AccountRequest;
import org.example.dto.TicketDto;
import org.example.model.PriorityType;
import org.example.model.Ticket;
import org.example.model.TicketStatus;
import org.example.model.elasticSearch.ElasticTicket;
import org.example.repository.TicketRepository;
import org.example.repository.elasticSearch.TicketElasticRepository;
import org.example.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketElasticRepository elasticRepository;
    private final ModelMapper mapper;
    private final AccountServiceClient accountServiceClient;
    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        // Ticket Entity
        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description bos olamaz");

        Ticket ticket = new Ticket();
        ResponseEntity<AccountRequest> accountRequest = accountServiceClient.getAccount(Long.valueOf(ticketDto.getAssignee()));


        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountRequest.getBody().getName()+" " + accountRequest.getBody().getSurname());

        // mysql kaydet
        ticket = ticketRepository.save(ticket);

        ElasticTicket model = ElasticTicket.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();
        // olusan nesneyi döndür

        ticketDto.setId(ticket.getId());

        //elastic search save
        elasticRepository.save(model);

        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String ticketId) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
