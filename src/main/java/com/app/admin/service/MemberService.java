package com.app.admin.service;

import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.MemberMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.app.admin.dto.Member;

@Service
public class MemberService {
    MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public List<Member> getMemberList(PagingInfo pagingInfo) {
        return memberMapper.getMemberList(pagingInfo);
    }

    public Member findUserByEmail(String email){
        return memberMapper.findUserByEmail(email);
    }

    public void updateAuthAdminList(Member member){
        memberMapper.updateAuthAdminList(member);
    }

    public int insertAuthAdminList(Member uxUser){
        return memberMapper.insertAuthAdminList(uxUser);
    }

    public void deleteAuthUser(Map<String,Object> idxArray){
        memberMapper.deleteAuthUser(idxArray);
    }

    public Member checkPassword(String loginId){ return memberMapper.checkPassword(loginId); }

    public void updateUserPassword(Member member){
        memberMapper.updateUserPassword(member);
    }
}
