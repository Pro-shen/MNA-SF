package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TPatientMapper;
import com.mnasf.system.domain.TPatient;
import com.mnasf.system.service.ITPatientService;

/**
 * 患者信息Service业务层处理
 */
@Service
public class TPatientServiceImpl implements ITPatientService {
    @Autowired
    private TPatientMapper tPatientMapper;

    /**
     * 查询患者信息
     * 
     * @param patientId 患者ID
     * @return 患者信息
     */
    @Override
    public TPatient selectTPatientById(Long patientId) {
        return tPatientMapper.selectTPatientById(patientId);
    }

    /**
     * 查询患者信息列表
     * 
     * @param tPatient 患者信息
     * @return 患者信息
     */
    @Override
    public List<TPatient> selectTPatientList(TPatient tPatient) {
        return tPatientMapper.selectTPatientList(tPatient);
    }

    /**
     * 新增患者信息
     * 
     * @param tPatient 患者信息
     * @return 结果
     */
    @Override
    public int insertTPatient(TPatient tPatient) {
        return tPatientMapper.insertTPatient(tPatient);
    }

    /**
     * 修改患者信息
     * 
     * @param tPatient 患者信息
     * @return 结果
     */
    @Override
    public int updateTPatient(TPatient tPatient) {
        return tPatientMapper.updateTPatient(tPatient);
    }

    /**
     * 批量删除患者信息
     * 
     * @param patientIds 需要删除的患者ID
     * @return 结果
     */
    @Override
    public int deleteTPatientByIds(Long[] patientIds) {
        return tPatientMapper.deleteTPatientByIds(patientIds);
    }

    /**
     * 删除患者信息信息
     * 
     * @param patientId 患者ID
     * @return 结果
     */
    @Override
    public int deleteTPatientById(Long patientId) {
        return tPatientMapper.deleteTPatientById(patientId);
    }
} 