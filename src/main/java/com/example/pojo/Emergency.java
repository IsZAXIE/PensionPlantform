package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emergency {
    // Associated with emergencies in the database
    private String phone;
    private String name;
    private String time;
    private String description;
}
