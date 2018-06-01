package com.houkp.recommended.dto;


import com.houkp.recommended.entity.User;
import com.houkp.recommended.utils.UserDTOConverter;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    private  UserDTOConverter userDTOConverter = new UserDTOConverter();

    @NotNull
    private String username;
    @NotNull
    private int age;

    public User converterToUser() {

        User converter = userDTOConverter.convert(this);
        return converter;
    }

    public UserDTO converterTo(User user) {
        UserDTO convert = userDTOConverter.reverse().convert(user);
        return convert;
    }


}
