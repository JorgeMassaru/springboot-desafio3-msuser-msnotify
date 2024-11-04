package com.jorgeMassaru.desafio3.clients;

import com.jorgeMassaru.desafio3.dto.ViaCepResponseDto;
import com.jorgeMassaru.desafio3.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viaCepClient", url = "https://viacep.com.br/ws")
public interface ViaCepClient {
    @GetMapping("/{cep}/json")
    ViaCepResponseDto getAddressByCep(@PathVariable("cep") String cep);
}
