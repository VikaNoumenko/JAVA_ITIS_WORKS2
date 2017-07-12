package ru.itis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import ru.itis.handlers.AuthHandler;

/**
 * 25.01.17
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@ComponentScan("ru.itis.config")
@EnableWebSocket
public class Application extends SpringBootServletInitializer implements
        WebSocketConfigurer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // конфигурирует статику
        return application.sources(Application.class);
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(authHandler(), "/authHandler");
    }

    @Bean
    public WebSocketHandler authHandler() {
        return new AuthHandler();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
