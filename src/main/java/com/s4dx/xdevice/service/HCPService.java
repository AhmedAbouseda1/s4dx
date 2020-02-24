package com.s4dx.xdevice.service;

import com.s4dx.xdevice.exception.NotFoundException;
import com.s4dx.xdevice.model.dao.HCP;
import com.s4dx.xdevice.model.entity.HCPEntity;
import com.s4dx.xdevice.repository.HCPRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HCPService {

    private final HCPRepository hcpRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public HCPService(final HCPRepository hcpRepository) {
        this.hcpRepository = hcpRepository;
    }

    public List<HCP> findAllHCPs() {
        return hcpRepository.findAll().stream()
                .map(hcpEntity -> modelMapper.map(hcpEntity, HCP.class))
                .collect(Collectors.toList());
    }

    public void deleteHCP(int id) {
        hcpRepository.deleteById(id);
    }

    public HCP updateHCP(HCP hcp, int id) {
        //TODO check the relation between them
        HCPEntity hcpEntity1 = hcpRepository.findById(id)
                .map(hcpEntity -> {
                    hcpEntity.setCityCode(hcp.getCityCode());
                    hcpEntity.setStreet(hcp.getStreet());
                    hcpEntity.setName(hcp.getName());
                    hcpEntity.setHcpId(hcp.getHcpId());
                    return hcpRepository.save(hcpEntity);
                }).orElseThrow(() -> new NotFoundException("We can't find this id in our db "));
        return modelMapper.map(hcpEntity1, HCP.class);
    }

    public HCP addHCP(HCP hcp) {
        HCPEntity hcpEntity =
                new HCPEntity(
                        hcp.getHcpId(),
                        hcp.getStreet(),
                        hcp.getCityCode(),
                        hcp.getName());
        hcpEntity = hcpRepository.save(hcpEntity);
        return modelMapper.map(hcpEntity, HCP.class);
    }
}
