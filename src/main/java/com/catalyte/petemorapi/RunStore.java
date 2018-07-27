package com.catalyte.petemorapi;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RunStore {

    public static void main(String[] args) {
        SpringApplication.run(RunStore.class);
    }
}
