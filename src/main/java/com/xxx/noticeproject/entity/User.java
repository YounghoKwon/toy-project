package com.xxx.noticeproject.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class User {

    public final static User NONE = new User(null, null, null, null);

    @Id @GeneratedValue @Setter
    private Long id;

    @NotNull @Size(min = 5, max = 16)
    private String loginId;

    @NotNull @Size(min = 2, max = 30)
    private String name;

    @NotNull @Size(min = 8, max = 40)
    private String passwd;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    private Department department;

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

    public User(@NotNull @Size(min = 5, max = 16) String loginId, @NotNull @Size(min = 2, max = 30) String name, @NotNull @Size(min = 8, max = 40) String passwd, @NotNull Department department) {
        this.loginId = loginId;
        this.name = name;
        this.passwd = passwd;
        this.department = department;
    }

}
