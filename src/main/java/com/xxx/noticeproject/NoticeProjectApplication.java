package com.xxx.noticeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

@SpringBootApplication
@EnableJpaAuditing
public class NoticeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeProjectApplication.class, args);
    }

}
