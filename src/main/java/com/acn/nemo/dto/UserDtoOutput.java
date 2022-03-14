package com.acn.nemo.dto;


import com.acn.nemo.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoOutput {

    private User user;
    private Department department;
}
