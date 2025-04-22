package com.mnasf.system.service.impl;

import com.mnasf.common.utils.SecurityUtils;
import com.mnasf.system.domain.TDoctor;
import com.mnasf.system.mapper.TDoctorMapper;
import com.mnasf.system.service.ITDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TDoctorServiceImpl implements ITDoctorService {

    @Autowired
    public TDoctorMapper tDoctorMapper;

    @Override
    public List<TDoctor> selectDoctorList(TDoctor doctor) {
        return tDoctorMapper.selectDoctorList(doctor);
    }

    @Override
    public TDoctor selectDoctorById(Long doctorId) {
        return tDoctorMapper.selectById(doctorId);
    }

    @Override
    public int insertDoctor(TDoctor doctor) {
        doctor.setCreateBy(SecurityUtils.getUsername());
        return tDoctorMapper.insert(doctor);
    }

    @Override
    public int updateDoctor(TDoctor doctor) {
        doctor.setUpdateBy(SecurityUtils.getUsername());
        return tDoctorMapper.updateById(doctor);
    }

    @Override
    public int deleteDoctorByIds(Long[] doctorIds) {
        return tDoctorMapper.deleteBatchIds(doctorIds);
    }

    @Override
    public int deleteDoctorById(Long doctorId) {
        return tDoctorMapper.deleteById(doctorId);
    }
} 