package com.sparta.gunwooklv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing // 생성일자 생성날짜 등을 자동을 관리해주기 위해 JpaAuditing 사용
@SpringBootApplication
public class Gunwooklv2Application {

	public static void main(String[] args) {
		SpringApplication.run(Gunwooklv2Application.class, args);
	}

}
