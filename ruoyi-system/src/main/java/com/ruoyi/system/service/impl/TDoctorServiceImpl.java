package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.TDoctorMapper;
import com.ruoyi.system.domain.TDoctor;
import com.ruoyi.system.service.ITDoctorService;

/**
 * 医生信息Service业务层处理
 */
@Service
public class TDoctorServiceImpl implements ITDoctorService {
    @Autowired
    private TDoctorMapper tDoctorMapper;

    /**
     * 查询医生信息
     * 
     * @param doctorId 医生ID
     * @return 医生信息
     */
    @Override
    public TDoctor selectTDoctorById(Long doctorId) {
        return tDoctorMapper.selectTDoctorById(doctorId);
    }

    /**
     * 查询医生信息列表
     * 
     * @param tDoctor 医生信息
     * @return 医生信息
     */
    @Override
    public List<TDoctor> selectTDoctorList(TDoctor tDoctor) {
        return tDoctorMapper.selectTDoctorList(tDoctor);
    }

    /**
     * 新增医生信息
     * 
     * @param tDoctor 医生信息
     * @return 结果
     */
    @Override
    public int insertTDoctor(TDoctor tDoctor) {
        return tDoctorMapper.insertTDoctor(tDoctor);
    }

    /**
     * 修改医生信息
     * 
     * @param tDoctor 医生信息
     * @return 结果
     */
    @Override
    public int updateTDoctor(TDoctor tDoctor) {
        return tDoctorMapper.updateTDoctor(tDoctor);
    }

    /**
     * 批量删除医生信息
     * 
     * @param doctorIds 需要删除的医生ID
     * @return 结果
     */
    @Override
    public int deleteTDoctorByIds(Long[] doctorIds) {
        return tDoctorMapper.deleteTDoctorByIds(doctorIds);
    }

    /**
     * 删除医生信息信息
     * 
     * @param doctorId 医生ID
     * @return 结果
     */
    @Override
    public int deleteTDoctorById(Long doctorId) {
        return tDoctorMapper.deleteTDoctorById(doctorId);
    }
} 