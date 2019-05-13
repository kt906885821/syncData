package com.example.sync.source;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 发送同步数据
 *
 * @author yuming
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SourceApplication.class, args);
    }

}
