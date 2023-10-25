package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestInfoEditor {
    private String alias;
    private String name;
    private String phone;
    private String address;
    private String community_id;
    private String emergency_call;
}
