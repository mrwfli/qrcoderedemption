package com.dksh.qrcoderedemption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class QrcoderedemptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrcoderedemptionApplication.class, args);
	}
}
