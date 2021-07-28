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

//    public final static User NONE = new User(null, null, null, null);

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

    public User(String loginId,String name, String passwd, Department department) throws IllegalArgumentException{
        if(loginId == null) throw new IllegalArgumentException("loginId is null !!");
        if(name == null) throw new IllegalArgumentException("name is null !!");
        if(passwd == null) throw new IllegalArgumentException("passwd is null !!");
        if(department == null) throw new IllegalArgumentException("department is null !!");
        if(5 > loginId.length() || loginId.length() > 16 ) throw new IllegalArgumentException("name size 5~16 this : " + loginId.length());
        if(2 > name.length() || name.length() > 30 ) throw new IllegalArgumentException("code size 2~30 this : " + name.length());
        if(8 > passwd.length() || passwd.length() > 40  ) throw new IllegalArgumentException("code size 8~40 this : " + passwd.length());
        this.loginId = loginId;
        this.name = name;
        this.passwd = passwd;
        this.department = department;
    }


//    public boolean isAuthCheck(String auth) {
//        return Boolean.FALSE;
//    }
}
