package com.example.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/*
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    // use this class to display goods
    int typeId;
    String sellerName;
    private float prize;
    private String description;
    private String proDate; // production date
    private int stock;
    private String manufacture;
    private String name;
    private String expDate;// expiration time
}*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {

    // use this class to display goods
    private String id;
    int typeID;
    String seller_id;
    private String name;
    private MultipartFile image;
    private float price;
    private String manufacture;
    private int stock;
    private String description;
    private String proDate; // production date
    private String expDate;// expiration time
}