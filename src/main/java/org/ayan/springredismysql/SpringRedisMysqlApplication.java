package org.ayan.springredismysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringRedisMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRedisMysqlApplication.class, args);
    }

}
