package com.acn.nemo.service;

import com.acn.nemo.dto.UserDtoOutput;
import com.acn.nemo.entity.User;

public interface UserService {
    User createUser(User user);

    UserDtoOutput retriveUser(Long userId);
}
