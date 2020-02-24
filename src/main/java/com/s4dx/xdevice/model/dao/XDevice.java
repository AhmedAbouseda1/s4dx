package com.s4dx.xdevice.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class XDevice {

    private int id;

    private String manufacturerId;

    private int hcpId;

    private String hardwareState;
}
