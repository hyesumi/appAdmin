package com.app.admin.dto;

import lombok.Data;


@Data
public class ExceptionFare extends PagingInfo{

    private Long id;
    private String name;
    private String code;
    private String type;
    private String area;
    private String extraData;
    private String editType;
    private String extraTaxiType;
}
