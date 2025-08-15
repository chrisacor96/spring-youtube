package com.programandoenjava.springyoutube.application.port.in;

import com.programandoenjava.springyoutube.domain.model.User;

public interface CreateUserUseCase {

    User createUser(User user);
}
