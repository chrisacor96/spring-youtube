package com.programandoenjava.springyoutube.domain.service;

import com.programandoenjava.springyoutube.domain.model.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserValidationService {

    public static boolean validateUser(User user){
        return user.firstName() != null && user.lastName() != null;
    }

}
