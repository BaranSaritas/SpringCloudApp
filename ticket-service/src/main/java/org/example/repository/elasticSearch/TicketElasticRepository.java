package org.example.repository.elasticSearch;

import org.example.model.elasticSearch.ElasticTicket;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketElasticRepository  extends ElasticsearchRepository<ElasticTicket,String> {
}
