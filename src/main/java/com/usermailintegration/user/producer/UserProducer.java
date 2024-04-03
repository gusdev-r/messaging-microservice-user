package com.usermailintegration.user.producer;

import com.usermailintegration.user.domain.UserModel;
import com.usermailintegration.user.dto.EmailDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingLKey;

    public void emailMessagePublished(UserModel userModel) {
        EmailDto emailDto = new EmailDto();
        emailDto.setUserId(userModel.getId());
        emailDto.setEmailTo(userModel.getEmail());
        emailDto.setSubject("Action: Registration completed successfully.");
        emailDto.setText(userModel.getName() + " Welcome! \nThank you for registering, now you can take advantage of all the features of our platform");
        //default exchange - empty string with the name of the queue
        rabbitTemplate.convertAndSend("", routingLKey, emailDto);
    }
}
