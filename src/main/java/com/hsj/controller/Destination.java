package com.hsj.controller;

import com.hsj.bean.AllDetinationBook;
import com.hsj.servier.impl.AllDetinationBookImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author waja
 * <p>对可以捐献的书操作的控制层<p/>
 */
@Controller
public class Destination {
    @Autowired
    private AllDetinationBookImpl bookie;
    @RequestMapping(value = "/germination")
    public String germination(Map<String, List> map) {
        List<AllDetinationBook> select = bookie.select();
        map.put("destination", select);
        return "user/theme";
    }
}
