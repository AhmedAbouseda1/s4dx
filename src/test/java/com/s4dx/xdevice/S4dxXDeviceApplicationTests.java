package com.s4dx.xdevice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.s4dx.xdevice.repository.HCPRepository;
import com.s4dx.xdevice.repository.XDeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public abstract class S4dxXDeviceApplicationTests {

    @Autowired
    protected HCPRepository hcpRepository;

    @Autowired
    protected XDeviceRepository xDeviceRepository;

    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    public ModelMapper modelMapper = new ModelMapper();

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    @After
    @Before
    public void clean() {
        log.info("========= clean db ==========");
        hcpRepository.deleteAll();
        xDeviceRepository.deleteAll();
    }
}
