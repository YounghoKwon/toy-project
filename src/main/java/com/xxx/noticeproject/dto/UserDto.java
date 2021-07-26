package com.xxx.noticeproject.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
public class UserDto {

    @Data
    public static class User {

        private Long id;

        private String loginId;

        private String name;

        private LocalDateTime createDate;

        private LocalDateTime updateDate;

        private String createBy;
    }
}
