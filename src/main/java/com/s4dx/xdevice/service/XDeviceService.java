package com.s4dx.xdevice.service;

import com.s4dx.xdevice.exception.NotFoundException;
import com.s4dx.xdevice.model.dao.XDevice;
import com.s4dx.xdevice.model.entity.XDeviceEntity;
import com.s4dx.xdevice.repository.XDeviceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class XDeviceService {

    private final XDeviceRepository xDeviceRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public XDeviceService(final XDeviceRepository xDeviceRepository) {
        this.xDeviceRepository = xDeviceRepository;
    }

    public List<XDevice> findAllXDevices() {
        return xDeviceRepository.findAll().stream()
                .map(xDeviceEntity -> modelMapper.map(xDeviceEntity, XDevice.class))
                .collect(Collectors.toList());
    }

    public void deleteXDevice(int id) {
        xDeviceRepository.deleteById(id);
    }

    public XDevice updateXDevice(XDevice xDevice, int id) {
        //TODO check the relation between them
        XDeviceEntity xDeviceEntity1 = xDeviceRepository.findById(id)
                .map(xDeviceEntity -> {
                    xDeviceEntity.setHardwareState(xDevice.getHardwareState());
                    xDeviceEntity.setHcpId(xDevice.getHcpId());
                    xDeviceEntity.setManufacturerId(xDevice.getManufacturerId());
                    return xDeviceRepository.save(xDeviceEntity);
                }).orElseThrow(() -> new NotFoundException("We can't find this id in our db "));
        return modelMapper.map(xDeviceEntity1, XDevice.class);
    }

    public XDevice addXDevice(XDevice xDevice) {
        XDeviceEntity xDeviceEntity =
                new XDeviceEntity(
                        xDevice.getManufacturerId(),
                        xDevice.getHcpId(),
                        xDevice.getHardwareState());
        xDeviceEntity = xDeviceRepository.save(xDeviceEntity);
        return modelMapper.map(xDeviceEntity, XDevice.class);
    }
}
