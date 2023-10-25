package com.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Announcement {

    // publisherName
    private String alias;
    // url
    private String link;
    // title of announcement
//    private String title;
    // time
    private String time;
    // content of announcement
    private String content;
}
