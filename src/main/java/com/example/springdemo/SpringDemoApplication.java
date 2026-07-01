package com.example.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);

		/*ApplicationContext ctx=SpringApplication.run(SpringDemoApplication.class, args);
		ApisController api=ctx.getBean(ApisController.class);
         String str=api.hello();
		System.out.println(str);*/

		/*ApisController apiController=new ApisController();
		String str=apiController.hello();
		System.out.println(str);*/
	}

}
