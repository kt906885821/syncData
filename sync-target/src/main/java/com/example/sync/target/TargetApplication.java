package com.example.sync.target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 接收同步数据
 *
 * @author yuming
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class TargetApplication {

    public static void main(String[] args) {
        SpringApplication.run(TargetApplication.class, args);
    }

}
