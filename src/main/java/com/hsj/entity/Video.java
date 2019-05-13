package com.hsj.entity;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.logging.Level;

/**
 * <p>处理视屏的一些方法<p/>
 * @author waja
 * @date 2019/5/7
 */
@Component
public class Video {
    public String upload(MultipartFile video) throws IOException {
        String name = video.getOriginalFilename();
        String dirparh = "D:\\intelliJ\\java_idea\\agorithmweb\\src\\main\\resources\\resources\\video\\";
        File file = new File(dirparh);
        if (!file.exists()){
            file.mkdir();
        }
        //给一个新的名字
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(new Date());
        String newName = UUID.randomUUID() + time+name.substring(name.lastIndexOf("."));
        video.transferTo(new File(dirparh + "\\"+newName));
        return dirparh + "\\"+newName;
    }

    public String getvideopath(String content) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = content.indexOf("(")+1; i < content.length(); i++) {
            if (content.charAt(i) == ')') {
                break;
            }else {
                stringBuilder.append(content.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
