package com.jorgeMassaru.desafio3.service;

import com.jorgeMassaru.desafio3.clients.ViaCepClient;
import com.jorgeMassaru.desafio3.dto.ViaCepResponseDto;
import com.jorgeMassaru.desafio3.model.User;
import com.jorgeMassaru.desafio3.model.Address;
import com.jorgeMassaru.desafio3.producers.UserProducer;
import com.jorgeMassaru.desafio3.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final ViaCepClient viaCepClient;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserProducer userProducer;

    public UserService(ViaCepClient viaCepClient, UserRepository userRepository, PasswordEncoder passwordEncoder, UserProducer userProducer) {
        this.viaCepClient = viaCepClient;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userProducer = userProducer;
    }

    public User register(User user) {
        String cep = user.getCep();

        // Busca e atribui o endereço completo usando o cep
        ViaCepResponseDto viaCepResponse = viaCepClient.getAddressByCep(cep);
        if (viaCepResponse == null || viaCepResponse.getCep() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP inválido.");
        }

        // Mapeia ViaCepResponseDto para Address
        Address address = new Address(
                viaCepResponse.getCep(),
                viaCepResponse.getLogradouro(),
                viaCepResponse.getComplemento(),
                viaCepResponse.getBairro(),
                viaCepResponse.getLocalidade(),
                viaCepResponse.getUf()
        );

        user.setAddress(address);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User savedUser = userRepository.save(user);

        // Envia a notificação após salvar o usuário
        userProducer.publishMessageNotify(savedUser);

        return savedUser;
    }



    public void updatePassword(String username, String oldPassword, String newPassword) {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Incorrect old password");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Transactional
    public User save(User userModel) {
        // Valida o CEP usando o ViaCepClient
        var viaCepResponse = viaCepClient.getAddressByCep(userModel.getCep());
        if (viaCepResponse.getCep() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP inválido.");
        }

        // Criptografa a senha
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));

        // Salva o usuário e envia a notificação
        userModel = userRepository.save(userModel);
        userProducer.publishMessageNotify(userModel);
        return userModel;
    }
}
