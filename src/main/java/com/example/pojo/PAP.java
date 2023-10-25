package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor

//phone and password : use in login
public class PAP {
    private String phone;
    private String pwd;
    private String role;
}
