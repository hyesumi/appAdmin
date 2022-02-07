package com.app.admin.mapper;


import com.app.admin.dto.AdminArea;
import com.app.admin.dto.CommonArea;
import com.app.admin.dto.Member;
import com.app.admin.dto.PagingInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminAreaMapper {
    List<AdminArea> getAdminAreaList(PagingInfo pagingInfo) throws DataAccessException;

    Member findUserByEmail(String email) throws DataAccessException;

    void updateAuthAdminList(Member member) throws DataAccessException;

    int insertAuthAdminList(Member member) throws DataAccessException;

    void deleteAuthUser(Map<String,Object> idxArray) throws DataAccessException;

    Member checkPassword(String loginId) throws DataAccessException;

    void updateUserPassword(Member member) throws DataAccessException;

}
