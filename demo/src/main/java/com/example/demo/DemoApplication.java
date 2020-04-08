package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*可以使用@EnableAutoConfiguration，@ComponentScan，@SpringBootConfiguration三个注解组合代替@SpringBootApplication
 * 
 * 
 * 
 * 
 * 
 * */
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement
/*
 * mybatis中的注解，用来扫描数据库（dao层方法与sql对应）层
 * 
*/
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
