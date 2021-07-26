package com.xxx.noticeproject.mapper;

import com.xxx.noticeproject.dto.UserDto;
import com.xxx.noticeproject.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto.User, User> {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );


}
