package com.app.admin.service;

import com.app.admin.dto.AdminCode;
import com.app.admin.dto.ExceptionFare;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.AdminCodeMapper;
import com.app.admin.mapper.ExceptionFareMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ExceptionFareService {
    ExceptionFareMapper exceptionFareMapper;

    public ExceptionFareService(ExceptionFareMapper exceptionFareMapper) {
        this.exceptionFareMapper = exceptionFareMapper;
    }

    public List<ExceptionFare> getExceptionFareList(ExceptionFare exceptionFare) {
        return exceptionFareMapper.getExceptionFareList(exceptionFare);
    }
    public int exceptionFareTotalCnt(ExceptionFare exceptionFare) {
        return exceptionFareMapper.exceptionFareTotalCnt(exceptionFare);
    }

    public ExceptionFare findExceptionFareByIdx(String id) {
        return exceptionFareMapper.findExceptionFareByIdx(id);
    }

    public List<HashMap<String, Object>>  getExceptionAreaList() {
        return exceptionFareMapper.getExceptionAreaList();
    }
}