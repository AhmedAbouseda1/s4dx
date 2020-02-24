package com.s4dx.xdevice.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HCP {

    private int id;

    private String hcpId;

    private String street;

    private String cityCode;

    private String name;
}
