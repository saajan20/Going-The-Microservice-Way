package com.example.creditcardbillpayment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;


/*
 * Instead of creating topics through the command line console, 
 * we can use KafkaAdmin bean, which will automatically add topics for all beans of type NewTopic
 */


@Configuration
public class KafkaTopicConfig {
     
	// Assigning the address of the Kafka Broker
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;
 
    // Configuring the KakfkaAdmin bean
    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        // Address of the Kafka Broker
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    // Creating a new Topic and mentioning the partition and replication factor
    @Bean
    public NewTopic topic1() {
    	// log.info("New Topic Claims Created");
         return new NewTopic("account", 1, (short) 1);
    }
    
}