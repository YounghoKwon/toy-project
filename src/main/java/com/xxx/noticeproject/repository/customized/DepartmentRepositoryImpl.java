package com.xxx.noticeproject.repository.customized;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.xxx.noticeproject.dto.DepartmentDto;
import com.xxx.noticeproject.entity.Department;
import com.xxx.noticeproject.entity.QDepartment;
import com.xxx.noticeproject.entity.QUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

public class DepartmentRepositoryImpl extends QuerydslRepositorySupport

implements DepartmentCustomRepository {
    private final JPAQueryFactory queryFactory;
    public DepartmentRepositoryImpl(JPAQueryFactory queryFactory){
        super(Department.class);
        this.queryFactory = queryFactory;
    }

    QDepartment qDepartment = QDepartment.department;
    QUser qUser = QUser.user;


    @Override
    public Page<Department> getSearchDepartmentList(Pageable pageable, String searchText) {

        QueryResults<Department> results = from(qDepartment)
                .join(qUser)
                .on(qUser.department.id.eq(qDepartment.id))
                .where(qUser.loginId.contains(searchText)
                        .or(qDepartment.code.contains(searchText))
                        .or(qDepartment.name.contains(searchText))
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        long count =  results.getTotal();
        return new PageImpl<>(results.getResults(), pageable, count);
    }

    @Override
    public Page<DepartmentDto.Department> getSearchDepartmentListUsingJPAQueryFactory(Pageable pageable, String searchText) {


        QueryResults<DepartmentDto.Department> results = queryFactory.select(Projections.bean(DepartmentDto.Department.class,
                qDepartment.id,
                qDepartment.code,
                qDepartment.name,
                qDepartment.updateDate
        )).from(qDepartment)
                .leftJoin(qUser)
                .on(qUser.department.id.eq(qDepartment.id))
                .where(likeUserLoginIdOrLikeDepartmentCodeOrLikeDepartmentName(searchText))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        long count =  results.getTotal();
        return new PageImpl<>(results.getResults(), pageable, count);
    }

    private BooleanExpression likeUserLoginId(String loginId) {
        if (!StringUtils.hasText(loginId)) return null;
        else return qUser.loginId.contains(loginId);
    }

    private BooleanExpression likeDepartmentCode(String code) {
        if (!StringUtils.hasText(code)) return null;
        else return qDepartment.code.contains(code);
    }
    private BooleanExpression likeDepartmentName(String name) {
        if (!StringUtils.hasText(name)) return null;
        else return qDepartment.name.contains(name);
    }

    private BooleanExpression likeUserLoginIdOrLikeDepartmentCodeOrLikeDepartmentName(String searchText){
        return likeUserLoginId(searchText).or(likeDepartmentCode(searchText)).or(likeDepartmentName(searchText));
    }

}

