package com.hsj.controller;

import com.hsj.bean.User;
import com.hsj.servier.impl.BookAndServiceImpl;
import com.hsj.servier.impl.GetServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 写的一些功能，但是觉得好像和server有点冲突
 * Created by 黄仕杰 on 2019/4/25.
 */
@Controller
public class FunctionController {
    @Autowired
    private GetServiceImpl getService;
    @Autowired
    private BookAndServiceImpl andService;
    /**
     * <p>跳到博客的列表页面，在跳到博客的页面之前把所有的博客都查出来，放到session中<p/>
     * <p>跳到博客的列表页面，在跳到博客的页面之前把所有的捐赠记录都查出来，放到session中<p/>
     * @param request
     * @return
     */
    @RequestMapping(value = "/learnjava")
    public String leanjava(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        //把用户所有的博客都查出来
        //request.getSession().setAttribute("allblog", getService.select(user.getUsername()));
        //把用户所有的捐赠记录都查出来
        //request.getSession().setAttribute("destination",andService.select(user.getUsername()));
        return "redirect:/getbook";
    }

    /**
     * 视频上传
     * @param video
     * @return
     */
    @RequestMapping(value = "/video")
    public String uploadvideo(MultipartFile video) {
        //获取视频的名字
        String name = video.getOriginalFilename();
        System.out.println(name);
        String dirparh = "D:\\intelliJ\\java_idea\\agorithmweb\\src\\main\\resources\\resources\\video\\";
        File file = new File(dirparh);
        if (!file.exists()){
            file.mkdir();
        }
        //给一个新的名字
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(new Date());
        String newName = UUID.randomUUID() + time+name.substring(name.lastIndexOf("."));
        System.out.println(newName);
        try {
            video.transferTo(new File(dirparh+newName));
            return "redirect:/getblog";
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/getblog";
        }
    }
}
