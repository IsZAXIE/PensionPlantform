package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@NoArgsConstructor
// all element of elders: use in change information
public class FullAccount {
    private int id;
    private String alias;
    private String emergency_call;
    private String phone;
    private String address;
    private String password;
    private String community_id;
    private String name;
}
