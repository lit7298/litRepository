package com.spring.lwxm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 *因为spring boot默认会加载org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration类
  *因为工程中没有关于dataSource相关的配置信息，加注解阻止自动注入
*/
@SpringBootApplication
@Configuration
@ServletComponentScan
@EnableAutoConfiguration
public class App  extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}
  public static void main(String[] args) {
      SpringApplication.run(App.class, args);
  }
}




//@SpringBootApplication
//public class App {
//	
//    public static void main( String[] args ) {
//    	SpringApplication.run(App.class, args);
//        
//    }
//}
