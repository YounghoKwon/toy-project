package com.xxx.noticeproject.repository.customized;

import com.querydsl.jpa.JPQLQuery;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.entity.QDepartment;
import com.xxx.noticeproject.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class DepartmentRepositoryImpl extends QuerydslRepositorySupport

implements DepartmentCustomRepository {

    public DepartmentRepositoryImpl(){
        super(Department.class);
    }


    @Override
    public Page<Department> getSearchDepartmentList(Pageable pageable, String searchText) {
        QDepartment qDepartment = QDepartment.department;
        QUser qUser = QUser.user;
        JPQLQuery<Department> query = from(qDepartment)
                .join(qUser)
                .on(qUser.department.id.eq(qDepartment.id))
                .where(qUser.loginId.contains(searchText)
                        .or(qDepartment.code.contains(searchText))
                        .or(qDepartment.name.contains(searchText))
                );

        query = getQuerydsl().applyPagination(pageable, query);
        List<Department> myObjectList = query.fetch();
        long count =  myObjectList.size();
        Page<Department> noticePage = new PageImpl<>(myObjectList, pageable, count);
        return noticePage;
    }
}

