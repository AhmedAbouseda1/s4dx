package com.s4dx.xdevice.repository;

import com.s4dx.xdevice.model.entity.XDeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XDeviceRepository extends JpaRepository<XDeviceEntity, Integer> {

}
