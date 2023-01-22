package com.example.springsecurity.confings;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaBeanConfiguration {
    /**
     * Consumer
     */
    @Bean
    public Map<String, Object> consumerProps(){
        Map<String,Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"group");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);

        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"100");
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,"15000");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }

    //Configuración  del consumer
    @Bean
    public ConsumerFactory<Integer, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerProps());
    }

    //Configuración del lisener para el consumer
    @Bean
    public ConcurrentKafkaListenerContainerFactory<Integer,String> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
    /**
     * Producer
     */
    private Map<String, Object> producerProps(){
        Map<String,Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ProducerConfig.RETRIES_CONFIG,0); //Numero de reintentos
        props.put(ProducerConfig.BATCH_SIZE_CONFIG,16384); //Tamo de los mensajes
        props.put(ProducerConfig.LINGER_MS_CONFIG,1); //Tiempo a enviar cada bath

        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,333554432);//numero de baths
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerDeserializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        return props;
    }

    @Bean
    public KafkaTemplate<Integer, String> createTemlate(){
        Map<String, Object> senderProps = producerProps();

        ProducerFactory<Integer,String> pf = new
                DefaultKafkaProducerFactory<Integer,String>(senderProps);

        KafkaTemplate<Integer,String> template = new
                KafkaTemplate<>(pf);

        return template;
    }
}