package com.app.admin.mapper;


import com.app.admin.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

@Mapper
public interface FareMapper {
    List<Fare> getFareList(PagingInfo pagingInfo) throws DataAccessException;

    int fareTotalCnt(PagingInfo pagingInfo) throws DataAccessException;

    AdminCode findAdminCodeByIdx(String id) throws DataAccessException;

    void updateAuthAdminList(Member member) throws DataAccessException;

    int insertAuthAdminList(Member member) throws DataAccessException;

    void deleteAuthUser(Map<String,Object> idxArray) throws DataAccessException;

    Member checkPassword(String loginId) throws DataAccessException;

    void updateUserPassword(Member member) throws DataAccessException;

}
