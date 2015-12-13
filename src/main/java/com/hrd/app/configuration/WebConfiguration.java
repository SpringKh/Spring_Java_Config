package com.hrd.app.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.hrd.app.services.StudentService;
import com.hrd.app.services.impl.StudentServiceImpl;

@Configuration
@ComponentScan("com.hrd.app")
@EnableWebMvc
public class WebConfiguration {
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/studentDB");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123");
		return dataSource;
	}
	
	
	// via constructor
	/*@Bean
	public StudentService studentService(){
		return new StudentServiceImpl(getDataSource());
	}*/
	
	
	// via setter
	/*@Bean
	public StudentService studentService(){
		StudentServiceImpl obj = new StudentServiceImpl();
		obj.setDataSource(getDataSource());
		return obj;
	}*/
	
	// via @AutoWired on DataSource in StudentServerImpl
	/*@Bean
	public StudentService studentService(){
		return new StudentServiceImpl();
	}*/
	
	
	
	
	/*@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}*/
}
