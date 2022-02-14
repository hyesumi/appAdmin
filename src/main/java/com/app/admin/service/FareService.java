package com.app.admin.service;

import com.app.admin.dto.AdminCode;
import com.app.admin.dto.ExceptionFare;
import com.app.admin.dto.Fare;
import com.app.admin.dto.PagingInfo;
import com.app.admin.mapper.ExceptionFareMapper;
import com.app.admin.mapper.FareMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FareService {
    FareMapper fareMapper;

    public FareService(FareMapper fareMapper) {
        this.fareMapper = fareMapper;
    }

    public List<Fare> getFareList(PagingInfo pagingInfo) {
        return fareMapper.getFareList(pagingInfo);
    }
    public int fareTotalCnt(PagingInfo pagingInfo) {
        return fareMapper.fareTotalCnt(pagingInfo);
    }

    public AdminCode findAdminCodeByIdx(String id) {
        return fareMapper.findAdminCodeByIdx(id);
    }
}