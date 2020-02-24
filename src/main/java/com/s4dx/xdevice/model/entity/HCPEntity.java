package com.s4dx.xdevice.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "hcps")
@Data
@NoArgsConstructor
public class HCPEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "hcpid")
    private String hcpId;

    @Column(name = "street")
    private String street;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "name")
    private String name;

    public HCPEntity(String hcpId, String street, String cityCode, String name) {
        this.hcpId = hcpId;
        this.street = street;
        this.cityCode = cityCode;
        this.name = name;
    }
}
