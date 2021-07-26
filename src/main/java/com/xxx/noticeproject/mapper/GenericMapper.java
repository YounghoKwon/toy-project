package com.xxx.noticeproject.mapper;


import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public interface GenericMapper<D, E> {

    D toDto(E e);
    E toEntity(D d);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<E> toEntity(Set<D> dtoList);

    Set<D> toDto(Set<E> entityList);

    LinkedHashSet<E> toEntity(LinkedHashSet<D> dtoList);

    LinkedHashSet<D> toDto(LinkedHashSet<E> entityList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromDto(D dto, @MappingTarget E entity);
}
