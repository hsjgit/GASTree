package com.hsj.servier;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author waja
 * Created by 黄仕杰 on 2019/4/25.
 */
@Component
public class ReadJson {
    /**
     * 读取json文件，并将其转换成java对象
     * @param path
     * @param c
     * @return
     * @throws IOException
     */
    public List getjson(String path,Class c) throws IOException {
        String str = com.mchange.io.FileUtils.getContentsAsString(new File(path));
        return JSONArray.parseArray(str, c);
    }

    /**
     * 将java对象转换成json
     * @param object
     * @return
     */
    public String tojson(Object object) {
        ObjectMapper map = new ObjectMapper();
        String json = "";
        try {
            json = map.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
