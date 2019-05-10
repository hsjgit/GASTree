package com.hsj.controller;

import com.hsj.bean.Blog;

import com.hsj.bean.User;
import com.hsj.entity.GetSession;
import com.hsj.entity.temporary.UserClass;
import com.hsj.servier.impl.GetServiceImpl;
import com.hsj.servier.otherservice.EnhanceGetBlogService;
import com.hsj.servier.otherservice.GivePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@SuppressWarnings({"all"})
@CrossOrigin
@Controller
public class Bolg {
    private static String UPLOADED_FOLDER = "D://temp//";
    @Autowired
    private GetServiceImpl getService;
    @Autowired
    private GivePath givePath;
    @Autowired
    private EnhanceGetBlogService enhanceGetBlogService;
    @Autowired
    private UserClass userClass;
    /**
     * 把提交的博客的存储的路径存到数据库
     * @param blog
     * @param request
     */
    @RequestMapping("/submit")
    public String su(Blog blog,HttpServletRequest request) {
        try {
            User user = (User) userClass.getser("D:\\userclass\\data.ser");
            request.getSession().setAttribute("user", user);
            System.out.println(request.getSession().getAttribute("user"));
            String path = givePath.getPath(blog);
            PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\blog\\网络.txt"), true );
            Scanner in = new Scanner(blog.getContent());
            while (in.hasNext()) {
                printWriter.println(in.nextLine());
            }
            printWriter.flush();
           /* System.out.println(request.getSession().getId());
            User user = GetSession.getuser(request);*/
            //这里还有一个视屏路径的问题，不知道怎么把博客和视屏路径一起传给后台
            enhanceGetBlogService.addPath(blog,user,"dsa");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }


    /**
     * <p>java总结<p/>
     * @param request
     * @return
     */
    @RequestMapping("/getblog")
    public String huang(HttpServletRequest request){
        StringBuilder str = new StringBuilder();
        Scanner scanner=null;
        try {
             scanner= new Scanner(new FileInputStream("D:\\blog\\data.txt"));
            while (scanner.hasNext()) {
                str.append(" "+scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        request.setAttribute("code", str);
        return "blog/makehtml";
    }

    /**
     * <p>操作系统<p/>
     * @param request
     * @return
     */
    @RequestMapping("/getblog1")
    public String huang1(HttpServletRequest request){
        StringBuilder str = new StringBuilder();
        Scanner scanner=null;
        try {
            scanner= new Scanner(new FileInputStream("D:\\data.txt"));
            while (scanner.hasNext()) {
                str.append(" "+scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        request.setAttribute("code", str);
        return "blog/makehtml";
    }

    /**
     * <p>数据结构入门<p/>
     * @param request
     * @return
     */
    @RequestMapping("/getblog2")
    public String huang2(HttpServletRequest request){
        StringBuilder str = new StringBuilder();
        Scanner scanner=null;
        try {
            scanner= new Scanner(new FileInputStream("D:\\blog\\数据结构入门.txt"));
            while (scanner.hasNext()) {
                str.append(" "+scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        request.setAttribute("code", str);
        return "blog/makehtml";
    }

    /**
     * <p>计算机网络的笔记<p/>
     * @param request
     * @return
     */
    @RequestMapping("/getblog3")
    public String huang3(HttpServletRequest request){
        StringBuilder str = new StringBuilder();
        Scanner scanner=null;
        try {
            scanner= new Scanner(new FileInputStream("D:\\blog\\计算机网络.txt"));
            while (scanner.hasNext()) {
                str.append(" "+scanner.nextLine()+"\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }
        request.setAttribute("code", str);
        return "blog/makehtml";
    }
    @RequestMapping("/l")
    public String la(){
        return "loader";
    }
    @ResponseBody
    @RequestMapping(value="/uploadimg")
    public Map<String,Object> demo(@RequestParam(value = "editormd-image-file", required = false) MultipartFile file, HttpServletRequest request) {
        Map<String,Object> resultMap = new HashMap<>();
        System.out.println(request.getContextPath());
        String realPath = UPLOADED_FOLDER;
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        //保存
        try {
/*            file.transferTo(targetFile);*/
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            resultMap.put("success", 1);
            resultMap.put("message", "上传成功！");
            resultMap.put("url",UPLOADED_FOLDER+fileName);
        } catch (Exception e) {
            resultMap.put("success", 0);
            resultMap.put("message", "上传失败！");
            e.printStackTrace();
        }
        return resultMap;
    }

}
