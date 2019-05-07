package com.hsj.controller;

import com.hsj.bean.Blog;

import com.hsj.bean.User;
import com.hsj.entity.BlogToGetBolog;
import com.hsj.entity.GiveTime;
import com.hsj.servier.impl.GetServiceImpl;
import com.hsj.servier.otherservice.GivePath;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/13.
 */
@SuppressWarnings({"all"})
@Controller
public class Bolg {
    private static String UPLOADED_FOLDER = "D://temp//";
    @Autowired
    private GetServiceImpl getService;
    @Autowired
    private GivePath givePath;
    /**
     * 把提交的博客的存储的路径存到数据库
     * @param blog
     * @param request
     */
    @ResponseBody
    @RequestMapping("/submit")
    public void su(Blog blog,HttpServletRequest request) {
        try {
            String path = givePath.getPath(blog);
            PrintWriter printWriter = new PrintWriter(new FileWriter(path), true );
            Scanner in = new Scanner(blog.getContent());
            while (in.hasNext()) {
                printWriter.println(in.nextLine());
            }
            printWriter.flush();
            User user = (User)request.getSession().getAttribute("user");
            //这段有问题，现在先去把钟怡教的任务做了，再回来继续写

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 从数据库中查询出博客的存储路径
     * @param request
     * @return
     */
    @RequestMapping("/getblog")
    public String huang(HttpServletRequest request){
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
        System.out.println(resultMap.get("success"));
        return resultMap;
    }

}
