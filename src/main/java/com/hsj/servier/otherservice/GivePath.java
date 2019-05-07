package com.hsj.servier.otherservice;

import com.hsj.bean.Blog;
import com.hsj.entity.GiveTime;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * <p>把博客的存储路径换一下<p/>
 * @author waja
 */
@Component
public class GivePath {
    /**
     * <p>把博客的储存路径变成了D盘下的blog文件夹名字title+时间<p/>
     * @param blog
     * @return 返回新的路径
     * @throws IOException io异常
     */
    public String getPath(Blog blog) throws IOException {
        String time = GiveTime.formatDate(LocalDateTime.now());
        String path1 = "D:\\blog\\"  +time;
        File file = new File(path1);
        if (!file.exists()) {
            file.mkdir();
        }
        String path = path1 + "\\" + blog.getTitle() + time + ".txt";
        File file1 = new File(path);
        file1.createNewFile();
        return path;
    }
}
