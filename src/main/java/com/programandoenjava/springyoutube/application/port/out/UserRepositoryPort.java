package com.programandoenjava.springyoutube.application.port.out;

import com.programandoenjava.springyoutube.domain.model.User;

import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findById(Long id);

}