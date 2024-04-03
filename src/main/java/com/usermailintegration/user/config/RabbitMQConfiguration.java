package com.usermailintegration.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration  {
    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        ObjectMapper objMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter();
    }
}
