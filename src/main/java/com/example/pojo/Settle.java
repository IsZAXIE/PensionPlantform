package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Settle {
    private String id;
    private MultipartFile image;
    private String info;
    private float price;
    private int num;
    private float totalMoney;
}
