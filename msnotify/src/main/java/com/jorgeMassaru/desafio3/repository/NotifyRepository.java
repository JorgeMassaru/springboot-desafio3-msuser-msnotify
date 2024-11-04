package com.jorgeMassaru.desafio3.repository;

import com.jorgeMassaru.desafio3.models.NotifyModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotifyRepository extends JpaRepository<NotifyModel, UUID> {




}
