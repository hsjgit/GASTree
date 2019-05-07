package com.hsj;
import com.hsj.bean.Blog;
import com.hsj.bean.GetBlog;
import com.hsj.bean.User;
import com.hsj.mapper.UserMapper;
import com.hsj.servier.ReadJson;
import com.hsj.servier.impl.BookAndServiceImpl;
import com.hsj.servier.impl.BookserviceImpl;
import com.hsj.servier.impl.GetServiceImpl;
import com.hsj.servier.impl.UserServiceImpl;
import com.hsj.servier.otherservice.EnhanceGetBlogService;
import com.sun.org.apache.xpath.internal.operations.Gt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.util.resources.cldr.es.CalendarData_es_GT;

import java.io.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AgorithmwebApplicationTests {
	@Autowired
	private EnhanceGetBlogService enhanceGetBlogService;
	@Test
	public void a() throws IOException {
		Blog blog = new Blog();
		blog.setContent("sda");
		blog.setTitle("ds");
		blog.setHtmlContent("ds");
		blog.setSummary("dssds");
		User user = new User();
		user.setUsername("hsj");
		enhanceGetBlogService.addPath(blog, user, "dsa");
	}
}
