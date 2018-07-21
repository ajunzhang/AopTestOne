package com.fiberhome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fiberhome.aop.TestBean;

@RunWith(value=SpringRunner.class)
@SpringBootTest(classes=App.class)
@WebAppConfiguration()
public class AopTest {
	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test(){
		Object obj = context.getBean(TestBean.class);
		((TestBean)obj).test();
		
	}

}
