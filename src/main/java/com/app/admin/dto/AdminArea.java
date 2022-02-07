package com.app.admin.dto;

import lombok.Data;


@Data
public class AdminArea {

    private Long id;
    private String areaName;
    private String areaCode;
    private String extraData;
    private String effectiveTs;
    private String createTs;
}
