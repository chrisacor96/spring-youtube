package com.programandoenjava.springyoutube.application.service;

import com.programandoenjava.springyoutube.application.port.in.CreateUserUseCase;
import com.programandoenjava.springyoutube.application.port.in.GetUserUseCase;
import com.programandoenjava.springyoutube.application.port.out.UserRepositoryPort;
import com.programandoenjava.springyoutube.domain.model.User;
import com.programandoenjava.springyoutube.domain.service.UserValidationService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements CreateUserUseCase, GetUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public User createUser(User user) {
        if(!UserValidationService.validateUser(user)){
            throw new IllegalArgumentException("Invalid user");
        }
        return userRepositoryPort.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepositoryPort.findById(id);
    }
}
