package com.saas.service;

 import com.saas.request.*;
 import com.saas.response.FindAllUserResponse;
 import com.saas.response.IntegerResultResponse;
import com.saas.response.UserLoginResponse;

public interface UserService {
    IntegerResultResponse addUser(AddUserRequest request);

    IntegerResultResponse updateUser(UpdateUserRequest request);

    UserLoginResponse login(UserLoginRequest request);

    FindAllUserResponse findAll(Integer page, Integer size);
}
