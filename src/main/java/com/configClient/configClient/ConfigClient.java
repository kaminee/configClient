package com.configClient.configClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configClient.configClient.configuration.ConfigClienAppConfiguration;


@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConfigClient {
	
	/*@Value("${user.role}")
	private String role;*/

	@Autowired
	private ConfigClienAppConfiguration properties;
		
	@Value("${some.other.property}")
	private String someOtherProperty;
	
	 
    public static void main(String[] args) {
        SpringApplication.run(ConfigClient.class, args);
    }

    @RequestMapping("/")
	public String printConfig(){
		   StringBuilder sb=new StringBuilder();
		   sb.append(properties.getProperty());
		   sb.append("||");
		   sb.append(someOtherProperty);
		return sb.toString();
		   
	   }
	    
}
