package com.houkp.recommended.utils;


import com.google.common.base.Converter;
import com.houkp.recommended.dto.UserDTO;
import com.houkp.recommended.entity.User;
import org.springframework.beans.BeanUtils;

/**
* @Description:    实体转换类
* @Author:         houkp
* @CreateDate:     2018/6/1 15:31
* @UpdateUser:     houkp
* @UpdateDate:     2018/6/1 15:31
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class UserDTOConverter extends Converter<UserDTO,User> {

    @Override
    protected User doForward(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return user;
    }

    @Override
    protected UserDTO doBackward(User user) {
        UserDTO userDTO =new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }
}
