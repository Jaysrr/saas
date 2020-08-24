package com.saas.response;

import com.saas.dto.UserDto;
import lombok.Data;


/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:53
 **/
@Data
public class UserLoginResponse {
    private UserDto userDto;

    private String token;
}
