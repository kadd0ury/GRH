package com.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.Interceptors.LogInterceptor;
import com.Interceptors.PermissionInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com"})
public class WebAppConfig implements WebMvcConfigurer  {
	
	
	 	@Bean
	    public InternalResourceViewResolver resolver(){
	        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
	        resolver.setViewClass(JstlView.class);
	        resolver.setPrefix("/WEB-INF/pages/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	
	 	@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry)   {
	        registry.addResourceHandler("/resources/**")
	                .addResourceLocations("/resources/");
	    }
	 	
	 	
	    @Override
	    public void addInterceptors (InterceptorRegistry registry) {
	        registry.addInterceptor(new LogInterceptor())
	                .addPathPatterns(new String[]{
	         "/employee/*","/dept/*","/renum/*","/user/*"
	                }).excludePathPatterns("/login");
	        
	        
	        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns(new String[]{
	        		
	        		"/employee/saveEmployee","/employee/delete","/employee/update","/employee/showFormC",
	        		"/dept/show","/dept/save","/dept/delete","/dept/update",
	        		"/renum/show","/renum/save","/renum/delete","/renum/update",
	        		
	        		
	        		
	        		
	               // "/article/add/*","/article/save/*","/article/delete/*"
	        });
	        
	        
	        
	

}
}
