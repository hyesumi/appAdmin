package com.app.admin.service;

import com.app.admin.dto.CommonArea;
import com.app.admin.dto.Member;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.CommonAreaMapper;
import com.app.admin.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommonAreaService {
    CommonAreaMapper commonAreaMapper;

    public CommonAreaService(CommonAreaMapper commonAreaMapper) {
        this.commonAreaMapper = commonAreaMapper;
    }

    public List<CommonArea> getCommonBusinessAreaList(PagingInfo pagingInfo) {
        return commonAreaMapper.getCommonBusinessAreaList(pagingInfo);
    }

    public CommonArea findCommonAreaById(String id){
        return commonAreaMapper.findCommonAreaById(id);
    }

    public void updateAuthAdminList(Member member){
        commonAreaMapper.updateAuthAdminList(member);
    }

    public int insertAuthAdminList(Member uxUser){
        return commonAreaMapper.insertAuthAdminList(uxUser);
    }

    public void deleteAuthUser(Map<String,Object> idxArray){
        commonAreaMapper.deleteAuthUser(idxArray);
    }

    public Member checkPassword(String loginId){ return commonAreaMapper.checkPassword(loginId); }

    public void updateUserPassword(Member member){
        commonAreaMapper.updateUserPassword(member);
    }
}
