package com.jorgeMassaru.desafio3.producers;

import com.jorgeMassaru.desafio3.dto.NotifyDto;
import com.jorgeMassaru.desafio3.model.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    @Value("${broker.queue.notify.name}")
    private String notifyQueue;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishMessageNotify(User userModel) {
        // Cria um NotifyDto a partir do UserModel
        NotifyDto notifyDto = new NotifyDto();
        notifyDto.setUserId(userModel.getId());
        notifyDto.setNotifyTo(userModel.getEmail());  // Defina o destinatário da notificação
        notifyDto.setSubject("Welcome!");             // Defina um assunto (exemplo)
        notifyDto.setText("Thank you for registering, " + userModel.getUsername() + "!");

        // Envia o NotifyDto para a fila
        rabbitTemplate.convertAndSend(notifyQueue, notifyDto);
    }
}
