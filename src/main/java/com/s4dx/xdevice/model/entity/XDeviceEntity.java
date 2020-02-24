package com.s4dx.xdevice.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "xdevices")
@Data
@NoArgsConstructor
public class XDeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "manufacturer_id", nullable = false)
    private String manufacturerId;

    @Column(name = "hcp_id")
    private Integer hcpId;

    @Column(name = "hardware_state", nullable = false)
    private String hardwareState;

    public XDeviceEntity(String manufacturerId, Integer hcpId, String hardwareState) {
        this.manufacturerId = manufacturerId;
        this.hardwareState = hardwareState;
        this.hcpId = hcpId;
    }
}