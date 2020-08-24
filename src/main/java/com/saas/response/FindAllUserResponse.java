package com.saas.response;

import com.saas.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 21:19
 **/
@Data
public class FindAllUserResponse {
    private List<User> userList;
    private Long total;
}
