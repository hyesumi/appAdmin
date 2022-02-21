package com.app.admin.mapper;


import com.app.admin.dto.AdminCode;
import com.app.admin.dto.ExceptionFare;
import com.app.admin.dto.Member;
import com.app.admin.dto.PagingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface ExceptionFareMapper {
    List<ExceptionFare> getExceptionFareList(ExceptionFare exceptionFare) throws DataAccessException;

    int exceptionFareTotalCnt(ExceptionFare exceptionFare) throws DataAccessException;

    ExceptionFare findExceptionFareByIdx(String id) throws DataAccessException;

    void updateAuthAdminList(Member member) throws DataAccessException;

    int insertAuthAdminList(Member member) throws DataAccessException;

    void deleteAuthUser(Map<String,Object> idxArray) throws DataAccessException;

    Member checkPassword(String loginId) throws DataAccessException;

    void updateUserPassword(Member member) throws DataAccessException;

    public List<HashMap<String, Object>> getExceptionAreaList() throws DataAccessException;
}
