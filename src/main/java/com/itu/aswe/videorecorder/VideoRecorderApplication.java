package com.itu.aswe.videorecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VideoRecorderApplication extends SpringBootServletInitializer {
 
    public static void main(String[] args) 
    {
        SpringApplication.run(VideoRecorderApplication.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
    	return application.sources(VideoRecorderApplication.class);
    }
    
 
}
