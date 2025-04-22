package com.mnasf.system.service;

import java.util.List;
import com.mnasf.system.domain.TPatient;

/**
 * 患者信息Service接口
 */
public interface ITPatientService {
    /**
     * 查询患者信息
     * 
     * @param patientId 患者ID
     * @return 患者信息
     */
    public TPatient selectTPatientById(Long patientId);

    /**
     * 查询患者信息列表
     * 
     * @param tPatient 患者信息
     * @return 患者信息集合
     */
    public List<TPatient> selectTPatientList(TPatient tPatient);

    /**
     * 新增患者信息
     * 
     * @param tPatient 患者信息
     * @return 结果
     */
    public int insertTPatient(TPatient tPatient);

    /**
     * 修改患者信息
     * 
     * @param tPatient 患者信息
     * @return 结果
     */
    public int updateTPatient(TPatient tPatient);

    /**
     * 批量删除患者信息
     * 
     * @param patientIds 需要删除的患者ID
     * @return 结果
     */
    public int deleteTPatientByIds(Long[] patientIds);

    /**
     * 删除患者信息信息
     * 
     * @param patientId 患者ID
     * @return 结果
     */
    public int deleteTPatientById(Long patientId);
} 