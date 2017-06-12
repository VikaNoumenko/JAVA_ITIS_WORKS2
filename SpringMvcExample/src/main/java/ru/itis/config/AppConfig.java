package ru.itis.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("ru.itis")
@EnableWebMvc
@PropertySource(value = "classpath:ru.itis\\db.properties")
public class AppConfig extends WebMvcConfigurerAdapter {

}
