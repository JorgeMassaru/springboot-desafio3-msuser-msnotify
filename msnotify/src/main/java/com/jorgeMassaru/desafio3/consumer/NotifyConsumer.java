package com.jorgeMassaru.desafio3.consumer;

import com.jorgeMassaru.desafio3.dto.NotifyRecordDto;
import com.jorgeMassaru.desafio3.models.NotifyModel;
import com.jorgeMassaru.desafio3.service.NotifyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class NotifyConsumer {

    @Autowired
    private NotifyService notifyService;

    @RabbitListener(queues = "${broker.queue.notify.name}")
    public void listenEmailQueue(@Payload NotifyRecordDto notifyRecordDto) {
        NotifyModel notifyModel = new NotifyModel();
        BeanUtils.copyProperties(notifyRecordDto, notifyModel);
        notifyService.saveNotification(notifyModel);
    }
}