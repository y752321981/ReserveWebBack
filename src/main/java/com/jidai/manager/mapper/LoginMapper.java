package com.jidai.manager.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface LoginMapper {
    Integer isAccountExist(String account);
    String selectPassword(String account);
    String selectName(String account);
}
