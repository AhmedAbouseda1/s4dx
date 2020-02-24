package com.s4dx.xdevice.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s4dx.xdevice.S4dxXDeviceApplicationTests;
import com.s4dx.xdevice.model.dao.XDevice;
import com.s4dx.xdevice.model.entity.XDeviceEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class XDeviceControllerTest extends S4dxXDeviceApplicationTests {

    private final static String FIND_ALL_URL = "/v1/xdevice/findAllXDevices";

    private final static String ADD_ALL_URL = "/v1/xdevice/addXDevice";

    private final static String DELETE_ALL_URL = "/v1/xdevice/deleteXDevice/{id}";

    private final static String UPDATE_ALL_URL = "/v1/xdevice/updateXDevice/{id}";

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testFindAllXDevicesEmptyDB() throws Exception {
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testFindAllXDevices() throws Exception {
        XDevice xDevice = new XDevice();
        xDevice.setHardwareState("HardwareState");
        xDevice.setManufacturerId("ManufacturerId");
        XDeviceEntity XDeviceEntity = xDeviceRepository.save(modelMapper.map(xDevice, XDeviceEntity.class));
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":" + XDeviceEntity.getId() + ",\"hardwareState\":HardwareState,\"hcpId\":0,\"manufacturerId\":\"ManufacturerId\"}]"));
    }

    @Test
    public void testDeleteXDevices() throws Exception {
        XDevice xDevice = new XDevice();
        xDevice.setHardwareState("HardwareState");
        xDevice.setManufacturerId("ManufacturerId");
        XDeviceEntity XDeviceEntity = xDeviceRepository.save(modelMapper.map(xDevice, XDeviceEntity.class));
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":" + XDeviceEntity.getId() + ",\"hardwareState\":HardwareState,\"hcpId\":0,\"manufacturerId\":\"ManufacturerId\"}]"));
        this.mvc.perform(delete(DELETE_ALL_URL, XDeviceEntity.getId()))
                .andExpect(status().isOk());
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testAddXDevices() throws Exception {
        XDevice xDevice = new XDevice();
        xDevice.setHardwareState("add");
        xDevice.setManufacturerId("ManufacturerId");
        this.mvc.perform(post(ADD_ALL_URL).contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(xDevice)))
                .andExpect(status().isOk());

        XDeviceEntity xDeviceEntity = xDeviceRepository.findAll().get(0);
        assertEquals(xDevice.getHardwareState(), xDeviceEntity.getHardwareState());
    }

    @Test
    public void testUpdateXDevices() throws Exception {

        XDevice xDevice = new XDevice();
        xDevice.setHardwareState("setHardwareState");
        xDevice.setManufacturerId("ManufacturerId");
        XDeviceEntity XDeviceEntity = xDeviceRepository.save(modelMapper.map(xDevice, XDeviceEntity.class));
        XDevice xDevice1 = new XDevice();
        xDevice1.setHardwareState("update");
        xDevice1.setManufacturerId("ManufacturerId");

        this.mvc.perform(put(UPDATE_ALL_URL, XDeviceEntity.getId()).contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(xDevice1)))
                .andExpect(status().isOk());

        XDeviceEntity xDeviceEntity = xDeviceRepository.findAll().get(0);
        assertEquals(xDevice1.getHardwareState(), xDeviceEntity.getHardwareState());
    }
}