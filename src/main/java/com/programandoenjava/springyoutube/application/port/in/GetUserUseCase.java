package com.programandoenjava.springyoutube.application.port.in;

import com.programandoenjava.springyoutube.domain.model.User;

import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> findById(Long id);
}
