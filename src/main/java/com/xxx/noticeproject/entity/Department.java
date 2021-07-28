package com.xxx.noticeproject.entity;

import lombok.*;
import net.bytebuddy.implementation.bytecode.Throw;
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
//    public final static Department NONE = new Department(null,null);

    @Id @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 1, max = 16)
    private String name;

    @NotNull
    @Size(min = 3, max = 20)
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

    public Department( String name, String code) throws IllegalArgumentException{
        if(name == null) throw new IllegalArgumentException("name is null !!");
        if(code == null) throw new IllegalArgumentException("code is null !!");
        if(1 > name.length() || name.length() > 16 ) throw new IllegalArgumentException("name size 1~16 this : " + name.length());
        if(3 > code.length() || code.length() > 20  ) throw new IllegalArgumentException("code size 3~20 this : " + code.length());
        this.name = name;
        this.code = code;
    }

}
