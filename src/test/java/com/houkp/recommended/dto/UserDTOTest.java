package com.houkp.recommended.dto;

import com.houkp.recommended.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDTOTest {

    @Test
    public void converterToUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setAge(1);
        User user = userDTO.converterToUser();
        System.out.println(user);
    }

    @Test
    public void converterTo() {
    }
}