package com.app.admin.service;

import com.app.admin.dto.AdminCode;
import com.app.admin.dto.ExceptionFare;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.AdminCodeMapper;
import com.app.admin.mapper.ExceptionFareMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionFareService {
    ExceptionFareMapper exceptionFareMapper;

    public ExceptionFareService(ExceptionFareMapper exceptionFareMapper) {
        this.exceptionFareMapper = exceptionFareMapper;
    }

    public List<ExceptionFare> getExceptionFareList(PagingInfo pagingInfo) {
        return exceptionFareMapper.getExceptionFareList(pagingInfo);
    }
    public int exceptionFareTotalCnt(PagingInfo pagingInfo) {
        return exceptionFareMapper.exceptionFareTotalCnt(pagingInfo);
    }

    public AdminCode findAdminCodeByIdx(String id) {
        return exceptionFareMapper.findAdminCodeByIdx(id);
    }
}