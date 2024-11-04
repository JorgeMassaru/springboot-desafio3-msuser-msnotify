package com.jorgeMassaru.desafio3.service;

import com.jorgeMassaru.desafio3.models.NotifyModel;
import com.jorgeMassaru.desafio3.repository.NotifyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    @Autowired
    private NotifyRepository notifyRepository;

    public NotifyModel saveNotification(NotifyModel notifyModel) {
        return notifyRepository.save(notifyModel);
    }
}
