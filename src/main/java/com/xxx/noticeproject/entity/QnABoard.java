package com.xxx.noticeproject.entity;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class QnABoard implements BorderCheck{

//    public final static User NONE = new User(null, null, null, null);
//    private final String QNA_READ_AUTH = "qna_read_auth";
//    private final String QNA_WRITE_AUTH = "qna_write_auth";
//    private final String QNA_DELETE_AUTH = "qna_delete_auth";

    @Id @GeneratedValue @Setter
    private Long id;

    @NotNull @Size(min = 2, max = 50)
    private String title;

    @NotNull @Size(max = 1500)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

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
//
//    @Override
//    public Boolean writeCheck(){
//        if(this.user == null) return Boolean.FALSE;
//        return user.isAuthCheck(QNA_WRITE_AUTH);
//    }
//
//    @Override
//    public Boolean readCheck(){
//        if(this.user == null) return Boolean.FALSE;
//        return user.isAuthCheck(QNA_READ_AUTH);
//    }
//
//    @Override
//    public Boolean deleteCheck(){
//        if(this.user == null) return Boolean.FALSE;
//        return user.isAuthCheck(QNA_DELETE_AUTH);
//    }

}
