package com.fiberhome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fiberhome.aop.AspectJTest;

@Configuration
public class Config {
	@Bean
	public AspectJTest aspectJTest(){
		return new AspectJTest();
	}

}
