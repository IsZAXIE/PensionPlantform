package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * This class is used for display information in browser like name or phone ...
 */
public class Display {
    private String id;
    private String alias;

}
