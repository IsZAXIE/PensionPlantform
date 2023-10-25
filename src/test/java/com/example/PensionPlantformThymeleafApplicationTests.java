package com.example;

import com.example.utils.MyTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class PensionPlantformThymeleafApplicationTests {

	@Test
	void contextLoads() {
		String str=String.valueOf(new Date());
		System.out.println("new Date time : "+new Date());
		System.out.println("str time : "+str);
		str= MyTime.getTime();
		System.out.println("getSysTime : "+str);
	}

}
