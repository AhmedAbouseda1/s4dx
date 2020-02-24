package com.s4dx.xdevice.controller.v1;

import com.s4dx.xdevice.model.dao.HCP;
import com.s4dx.xdevice.service.HCPService;
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
@RequestMapping("/v1/hcp")
@Api(value = "HCP control", tags = {"HCP control"})
public class HCPController {

    private final HCPService hcpService;

    @Autowired
    public HCPController(HCPService hcpService) {
        this.hcpService = hcpService;
    }

    @ApiOperation(value = "find all x devices", tags = {"Get all hcp offices"})
    @GetMapping(path = "/findAllHCPs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HCP> findAllHCPs() {
        return hcpService.findAllHCPs();
    }

    @PostMapping(path = "/addHCP", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HCP> addHCP(@RequestBody HCP hcp) {
        return new ResponseEntity<>(hcpService.addHCP(hcp), HttpStatus.OK);
    }

    @ApiOperation(value = "delete hcp office", tags = {"delete hcp office"})
    @DeleteMapping(path = "/deleteHCP/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteHCP(@PathVariable int id) {
        hcpService.deleteHCP(id);
    }

    @ApiOperation(value = "update hcp office", tags = {"update hcp office"})
    @PutMapping(path = "/updateHCP/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HCP> updateHCP(@RequestBody HCP hcp, @PathVariable int id) {
        return new ResponseEntity<>(hcpService.updateHCP(hcp, id), HttpStatus.OK);
    }
}
