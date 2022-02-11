package com.app.admin.service;

import com.app.admin.dto.AdminCode;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.AdminCodeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminCodeService {
    AdminCodeMapper adminCodeMapper;

    public AdminCodeService(AdminCodeMapper adminCodeMapper) {
        this.adminCodeMapper = adminCodeMapper;
    }

    public List<AdminCode> getAdminCodeList(PagingInfo pagingInfo) {
        return adminCodeMapper.getAdminCodeList(pagingInfo);
    }
    public int adminCodeTotalCnt(PagingInfo pagingInfo) {
        return adminCodeMapper.adminCodeTotalCnt(pagingInfo);
    }

    public AdminCode findAdminCodeByIdx(String id) {
        return adminCodeMapper.findAdminCodeByIdx(id);
    }
}