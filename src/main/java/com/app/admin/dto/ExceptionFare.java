package com.app.admin.dto;

import lombok.Data;


@Data
public class ExceptionFare {

    private Long id;
    private String name;
    private String code;
    private String type;
    private String area;
    private String extraData;

}
