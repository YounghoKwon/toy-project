package com.xxx.noticeproject.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@NoArgsConstructor
public class DepartmentDto {

    @Data
    public static class Department {

        private Long id;

        private String code;

        private String name;

        private LocalDateTime updateDate;

    }
}
