package com.learning.consumer.learningconsumerconfig;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.learning.consumer.Learningconsumerdto.LearningConsumerDTO;

@Configuration
public class LearningConsumerConfig {
	
//	@Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> configProps = new HashMap<>();
//        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//      configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
//        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        return new DefaultKafkaConsumerFactory<>(configProps);
//    }
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        return factory;
//    }
	
	@Bean
    public ConsumerFactory<String, LearningConsumerDTO> consumerFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
      configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>( configProps, new StringDeserializer(), jsonDeserializer());
    }
	

	@Bean
	public JsonDeserializer<LearningConsumerDTO> jsonDeserializer() {
	    JsonDeserializer<LearningConsumerDTO> jsonDeserializer = new JsonDeserializer<>(LearningConsumerDTO.class)
	    		.ignoreTypeHeaders();
	    jsonDeserializer.addTrustedPackages("*");
	    return jsonDeserializer;
	}


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LearningConsumerDTO> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, LearningConsumerDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }


}
