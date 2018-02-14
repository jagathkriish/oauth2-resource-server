package com.resource.service.oauth2;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class Oauth2ResouceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResouceServerApplication.class, args);
	}
	
	Map<Integer, Account> accMap = new HashMap<>();
	
	@GetMapping("/accounts")
	private Collection<Account> getAccountDetails(){
			if(ObjectUtils.isEmpty(accMap)) {
				accMap.put(12345, new Account(12345,"savings", "jagath", "HDFC"));
				accMap.put(12346, new Account(12346,"business", "venki", "HSBC"));
			}
			return accMap.values();
	}
}
