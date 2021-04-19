package com.baizhi.service;

import com.baizhi.dao.OurPostDao;
import com.baizhi.entity.OurPost;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OurPostService {
   @Autowired
   private OurPostDao ourPostDao;

   public void savePost(OurPost ourPost, HttpServletRequest httpServletRequest){


       String cur_username=(String)httpServletRequest.getSession().getAttribute("username");
       String cur_realname=(String)httpServletRequest.getSession().getAttribute("realname");
       //ourPost.setId(UUID.randomUUID().toString());
       String cur_kind= (String)httpServletRequest.getSession().getAttribute("kind");
       Integer kind = cur_kind=="International"?1:(cur_kind=="Policy"?2:3);
       ourPost.setAuthor(cur_username);
       ourPost.setRealname(cur_realname);
       ourPost.setKind(kind);
       System.out.println(ourPost);
       ourPostDao.savePost(ourPost);
   }

   public List<OurPost> findIntertionalPosts(){
       Sort sort;
       //PageHelper.startPage(pageNum,2);
       List<OurPost> temp = ourPostDao.findInternationalPosts();
       Collections.reverse(temp);
       //Collections.shuffle(temp);
       return temp;
   }

    public List<OurPost> findPolicyPosts(){
        Sort sort;
        //PageHelper.startPage(pageNum,2);
        List<OurPost> temp = ourPostDao.findPolicyPosts();
        Collections.reverse(temp);
        //Collections.shuffle(temp);
        return temp;
    }

    public List<OurPost> findSocietyPosts(){
        Sort sort;
        //PageHelper.startPage(pageNum,2);
        List<OurPost> temp = ourPostDao.findSocietyPosts();
        Collections.reverse(temp);
        //Collections.shuffle(temp);
        return temp;
    }



   public OurPost findPost(Integer id){
       return ourPostDao.findPost(id);
   }
}
