package com.example.creditcardbillpayment.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.creditcardbillpayment.model.AccountCommandModel;

@Configuration
public class KafkaProducerConfig {

	// Assigning the address of the Kafka Broker
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	// Configuring and creating the Kafka Producer Factory
	@Bean
	public ProducerFactory<String, AccountCommandModel> claimProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		// Address of the Kafka Broker
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		// Class for Key serialization 
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		// Class for Value serialization 
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		// Disabling adding type headers
		//configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	// Creating the Kafka Template using the Kafka Producer Factory
	@Bean
	public KafkaTemplate<String, AccountCommandModel> kafkaTemplate() {
		return new KafkaTemplate<>(claimProducerFactory());
	}
	
}