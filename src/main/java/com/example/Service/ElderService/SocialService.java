package com.example.Service.ElderService;


import com.example.dao.SocialDao;
import com.example.pojo.Announcement;
import com.example.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    SocialDao socialDao;

    public List<Announcement> getAllAnnouncement() {
        List<Announcement> announcements = socialDao.getAllAnnouncement();
        for(Announcement announcement:announcements){
            announcement.setLink("https://en.usst.edu.cn/");
            System.out.println("SocialService: announcement : "+announcement);
        }
        return announcements;
    }


    public List<Post> getAllPost() {
        List<Post> posts = socialDao.getAllPost();
        for(Post post:posts){
            System.out.println("SocialService: posts : "+post);
        }
        return posts;
    }

    public int saveNewPost(Post post){
        return socialDao.saveNewPost(post);
    }
}
