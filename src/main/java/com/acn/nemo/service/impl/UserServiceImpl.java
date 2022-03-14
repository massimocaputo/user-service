package com.acn.nemo.service.impl;

import com.acn.nemo.dto.Department;
import com.acn.nemo.dto.UserDtoOutput;
import com.acn.nemo.entity.User;
import com.acn.nemo.repository.UserRepository;
import com.acn.nemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User createUser(User user) {
        log.info("Inside createUser of UserServiceImpl");
        return userRepository.save(user);
    }

    @Override
    public UserDtoOutput retriveUser(Long userId) {
        log.info("Inside retriveUser of UserServiceImpl");
        UserDtoOutput dtoOutput = new UserDtoOutput();

        log.info("Find User");
        User user = userRepository.findByUserId(userId);

        log.info("Call service with RestTemplate");
        Department department = restTemplate.getForObject("http://localhost:9001/nemo/api/department/" + user.getDepartmentId(),
                Department.class);

        dtoOutput.setDepartment(department);
        dtoOutput.setUser(user);
        return dtoOutput;
    }
}
