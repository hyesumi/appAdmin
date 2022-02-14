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

    public List<AdminCode> getAdminCodeList(AdminCode adminCode) {
        return adminCodeMapper.getAdminCodeList(adminCode);
    }
    public int adminCodeTotalCnt(AdminCode adminCode) {
        return adminCodeMapper.adminCodeTotalCnt(adminCode);
    }

    public AdminCode findAdminCodeByIdx(String id) {
        return adminCodeMapper.findAdminCodeByIdx(id);
    }

    public String findDetailCode(String areaName) {
        return adminCodeMapper.findDetailCode(areaName);
    }
}