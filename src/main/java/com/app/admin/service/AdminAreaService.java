package com.app.admin.service;

import com.app.admin.dto.AdminArea;
import com.app.admin.dto.CommonArea;
import com.app.admin.dto.Member;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.AdminAreaMapper;
import com.app.admin.mapper.CommonAreaMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminAreaService {
    AdminAreaMapper adminAreaMapper;

    public AdminAreaService(AdminAreaMapper adminAreaMapper) {
        this.adminAreaMapper = adminAreaMapper;
    }

    public List<AdminArea> getAdminAreaList(PagingInfo pagingInfo) {
        return adminAreaMapper.getAdminAreaList(pagingInfo);
    }

    public Member findUserByEmail(String email){
        return adminAreaMapper.findUserByEmail(email);
    }

    public void updateAuthAdminList(Member member){
        adminAreaMapper.updateAuthAdminList(member);
    }

    public int insertAuthAdminList(Member uxUser){
        return adminAreaMapper.insertAuthAdminList(uxUser);
    }

    public void deleteAuthUser(Map<String,Object> idxArray){
        adminAreaMapper.deleteAuthUser(idxArray);
    }

    public Member checkPassword(String loginId){ return adminAreaMapper.checkPassword(loginId); }

    public void updateUserPassword(Member member){
        adminAreaMapper.updateUserPassword(member);
    }
}
