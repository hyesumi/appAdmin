package com.app.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import com.app.admin.dto.Member;

@Mapper
public interface LoginMapper {

    Member findByLoginId(String loginId) throws DataAccessException;

    int checkLoginCount(String loginId)throws DataAccessException;

    void increaseLoginCount(String loginId)throws DataAccessException;

    void lockAuthUser(String loginId)throws DataAccessException;

    void updateLastLoginTime(String loginId)throws DataAccessException;
}
