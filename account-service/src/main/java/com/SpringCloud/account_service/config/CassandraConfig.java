package com.SpringCloud.account_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspace}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.data.cassandra.username}")
    private String username;
    @Value("${spring.data.cassandra.password}")
    private String password;
    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
        // Cassandra anahtar alanı adınızı buraya girin
    }


    @Override
    protected String getContactPoints() {
        return contactPoints; // Cassandra sunucularının IP adresi veya host adı buraya girin
    }

    @Override
    protected int getPort() {
        return port; // Cassandra sunucularının bağlantı noktası (varsayılan olarak 9042)
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public CassandraClusterFactoryBean cluster(){
        CassandraClusterFactoryBean cluster = super.cluster();
        cluster.setUsername(username);
        cluster.setPassword(password);
        return cluster;
    }

    // Opsiyonel olarak Cassandra kimlik doğrulama bilgilerini ekleyebilirsiniz
    // @Override
    // protected String getLocalDataCenter() {
    //     return "datacenter1"; // Opsiyonel olarak Cassandra yerel veri merkezini buraya girin
    // }
}
