package com.xxx.noticeproject.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Department {
    public final static Department NONE = new Department(null,null);

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String code;

    @OneToMany(mappedBy = "department")
    private List<User> userList;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @Column(updatable = false)
    @CreatedBy
    private String createBy;

    @LastModifiedBy
    private String updateBy;

//    public Department(){};

    public Department( @NotNull @Size(min = 1, max = 16) String name, @NotNull @Size(min = 3, max = 20) String code) {
        this.name = name;
        this.code = code;
    }
}
