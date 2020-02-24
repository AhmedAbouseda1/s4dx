package com.s4dx.xdevice.controller.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s4dx.xdevice.S4dxXDeviceApplicationTests;
import com.s4dx.xdevice.model.dao.HCP;
import com.s4dx.xdevice.model.entity.HCPEntity;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
public class HCPControllerTest extends S4dxXDeviceApplicationTests {

    private final static String FIND_ALL_URL = "/v1/hcp/findAllHCPs";

    private final static String ADD_ALL_URL = "/v1/hcp/addHCP";

    private final static String DELETE_ALL_URL = "/v1/hcp/deleteHCP/{id}";

    private final static String UPDATE_ALL_URL = "/v1/hcp/updateHCP/{id}";

    @Autowired
    MockMvc mvc;

    @Autowired
    ObjectMapper mapper;

    ModelMapper modelMapper = new ModelMapper();

    @Test
    public void testFindAllHCPsEmptyDB() throws Exception {
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testFindAllHCPs() throws Exception {
        HCP hcp = new HCP();
        hcp.setCityCode("cityCode");
        HCPEntity HCPEntity = hcpRepository.save(modelMapper.map(hcp, HCPEntity.class));
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":" + HCPEntity.getId() + ",\"hcpId\":null,\"street\":null,\"cityCode\":\"cityCode\",\"name\":null}]"));
    }

    @Test
    public void testDeleteHCPs() throws Exception {
        HCP hcp = new HCP();
        hcp.setCityCode("cityCode");
        HCPEntity HCPEntity = hcpRepository.save(modelMapper.map(hcp, HCPEntity.class));
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":" + HCPEntity.getId() + ",\"hcpId\":null,\"street\":null,\"cityCode\":\"cityCode\",\"name\":null}]"));
        this.mvc.perform(delete(DELETE_ALL_URL, HCPEntity.getId()))
                .andExpect(status().isOk());
        this.mvc.perform(get(FIND_ALL_URL))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }

    @Test
    public void testAddHCPs() throws Exception {
        HCP hcp = new HCP();
        hcp.setCityCode("add");
        this.mvc.perform(post(ADD_ALL_URL).contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(hcp)))
                .andExpect(status().isOk());

        HCPEntity hcpEntity = hcpRepository.findAll().get(0);
        assertEquals(hcp.getCityCode(), hcpEntity.getCityCode());
    }

    @Test
    public void testUpdateHCPs() throws Exception {

        HCP hcp = new HCP();
        hcp.setCityCode("cityCode");
        HCPEntity HCPEntity = hcpRepository.save(modelMapper.map(hcp, HCPEntity.class));
        HCP updateHcp = new HCP();
        hcp.setCityCode("update");

        this.mvc.perform(put(UPDATE_ALL_URL, HCPEntity.getId()).contentType(APPLICATION_JSON_UTF8)
                .content(convertObjectToJsonBytes(updateHcp)))
                .andExpect(status().isOk());

        HCPEntity hcpEntity = hcpRepository.findAll().get(0);
        assertEquals(updateHcp.getCityCode(), hcpEntity.getCityCode());
    }
}