package com.hsj;
import com.alibaba.fastjson.JSONArray;
import com.hsj.bean.BookAndDestination;
import com.hsj.bean.GlobalVaiable;
import com.hsj.bean.User;
import com.hsj.entity.GiveTime;
import com.hsj.servier.Person;
import com.hsj.servier.ReadJson;
import com.hsj.servier.UserServicer;
import com.hsj.servier.impl.BookAndServiceImpl;
import com.hsj.servier.impl.BookserviceImpl;
import com.hsj.servier.impl.GetServiceImpl;
import com.hsj.servier.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AgorithmwebApplicationTests {
	@Autowired
	private ReadJson readJson;
	@Autowired
	private BookserviceImpl person;
	@Autowired
	private BookAndServiceImpl bookAndService;
	@Test
	public void a() throws IOException {

	}
}
