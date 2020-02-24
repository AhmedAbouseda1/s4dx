package com.s4dx.xdevice.controller.v1;

import com.s4dx.xdevice.model.dao.XDevice;
import com.s4dx.xdevice.service.XDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/xdevice")
@Api(value = "XDevice control", tags = {"XDevice control"})
public class XDeviceController {

    private final XDeviceService xDeviceService;

    @Autowired
    public XDeviceController(XDeviceService xDeviceService) {
        this.xDeviceService = xDeviceService;
    }

    @ApiOperation(value = "find all x devices", tags = {"list of all x devices"})
    @GetMapping(path = "/findAllXDevices", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<XDevice> findAllXDevices() {
        return xDeviceService.findAllXDevices();
    }

    @ApiOperation(value = "add a new x device", tags = {"add a new x device"})
    @PostMapping(path = "/addXDevice", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XDevice> addXDevice(@RequestBody XDevice xDevice) {
        return new ResponseEntity<>(xDeviceService.addXDevice(xDevice), HttpStatus.OK);
    }

    @ApiOperation(value = "delete a x devices", tags = {"delete a x device"})
    @DeleteMapping(path = "/deleteXDevice/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteXDevice(@PathVariable int id) {
        xDeviceService.deleteXDevice(id);
    }

    @ApiOperation(value = "update a x devices", tags = {"update a x device"})
    @PutMapping(path = "/updateXDevice/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<XDevice> updateXDevice(@RequestBody XDevice xDevice, @PathVariable int id) {
        return new ResponseEntity<>(xDeviceService.updateXDevice(xDevice, id), HttpStatus.OK);
    }
}
