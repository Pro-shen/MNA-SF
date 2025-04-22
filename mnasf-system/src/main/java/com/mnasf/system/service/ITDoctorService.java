package com.mnasf.system.service;

import com.mnasf.system.domain.TDoctor;

import java.util.List;

public interface ITDoctorService {
    /**
     * 查询医生信息列表
     */
    List<TDoctor> selectDoctorList(TDoctor doctor);

    /**
     * 查询医生信息
     */
    TDoctor selectDoctorById(Long doctorId);

    /**
     * 新增医生信息
     */
    int insertDoctor(TDoctor doctor);

    /**
     * 修改医生信息
     */
    int updateDoctor(TDoctor doctor);

    /**
     * 批量删除医生信息
     */
    int deleteDoctorByIds(Long[] doctorIds);

    /**
     * 删除医生信息
     */
    int deleteDoctorById(Long doctorId);
} 