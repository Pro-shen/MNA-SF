package com.mnasf.system.service;

import java.util.List;
import com.mnasf.system.domain.TMedicalStaff;

/**
 * 医护人员信息Service接口
 */
public interface ITMedicalStaffService {
    /**
     * 查询医护人员信息
     * 
     * @param staffId 医护人员ID
     * @return 医护人员信息
     */
    public TMedicalStaff selectTMedicalStaffById(Long staffId);

    /**
     * 查询医护人员信息列表
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 医护人员信息集合
     */
    public List<TMedicalStaff> selectTMedicalStaffList(TMedicalStaff tMedicalStaff);

    /**
     * 新增医护人员信息
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 结果
     */
    public int insertTMedicalStaff(TMedicalStaff tMedicalStaff);

    /**
     * 修改医护人员信息
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 结果
     */
    public int updateTMedicalStaff(TMedicalStaff tMedicalStaff);

    /**
     * 批量删除医护人员信息
     * 
     * @param staffIds 需要删除的医护人员ID
     * @return 结果
     */
    public int deleteTMedicalStaffByIds(Long[] staffIds);

    /**
     * 删除医护人员信息信息
     * 
     * @param staffId 医护人员ID
     * @return 结果
     */
    public int deleteTMedicalStaffById(Long staffId);
} 