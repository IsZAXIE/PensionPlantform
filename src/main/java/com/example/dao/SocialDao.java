package com.example.dao;

import com.example.pojo.Announcement;
import com.example.pojo.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
@NoArgsConstructor
public class SocialDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Announcement> getAllAnnouncement(){
        String sql="Select announcement.content,announcement.time,community_user.alias " +
                "from announcement inner join community_user " +
                "on announcement.publisher_id = community_user.id;";
        return jdbcTemplate.query(sql,new Object[]{}, BeanPropertyRowMapper.newInstance(Announcement.class));
    }

    public List<Post> getAllPost(){
        String sql=
                "Select post.title as title,post.content as content,post.time as time,elder.alias as publisherName from post inner join elder on post.publisher_id=elder.id;";
        return jdbcTemplate.query(sql,new String[]{},BeanPropertyRowMapper.newInstance(Post.class));
    }

    public int saveNewPost(Post post){
        String sql="Insert into post (publisher_id,title,content,time) values(?,?,?,?);";
        return jdbcTemplate.update(sql,new String[]{post.getPublisherName(),post.getTitle(),post.getContent(),post.getTime()});

    }
}
