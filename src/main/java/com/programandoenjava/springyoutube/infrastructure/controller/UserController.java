package com.programandoenjava.springyoutube.infrastructure.controller;

import com.programandoenjava.springyoutube.application.port.in.CreateUserUseCase;
import com.programandoenjava.springyoutube.application.port.in.GetUserUseCase;
import com.programandoenjava.springyoutube.domain.model.User;
import com.programandoenjava.springyoutube.infrastructure.controller.dto.UserRequest;
import com.programandoenjava.springyoutube.infrastructure.controller.dto.UserResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    public final CreateUserUseCase createUserUseCase;
    public final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        final User user = new User(null, userRequest.firstName(), userRequest.lastName());
        final User userCreated = createUserUseCase.createUser(user);
        return new UserResponse(userCreated.id(), userCreated.firstName(), userCreated.lastName());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        final User user = getUserUseCase.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserResponse(user.id(), user.firstName(), user.lastName());
    }

}
