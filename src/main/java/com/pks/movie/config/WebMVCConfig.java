package com.pks.movie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.pks.movie.common.FileManagerService;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {


	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/movieposters/**")
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH +"/");
	}
	
}
