package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TMedicalStaffMapper;
import com.mnasf.system.domain.TMedicalStaff;
import com.mnasf.system.service.ITMedicalStaffService;

/**
 * 医护人员信息Service业务层处理
 */
@Service
public class TMedicalStaffServiceImpl implements ITMedicalStaffService {
    @Autowired
    private TMedicalStaffMapper tMedicalStaffMapper;

    /**
     * 查询医护人员信息
     * 
     * @param staffId 医护人员ID
     * @return 医护人员信息
     */
    @Override
    public TMedicalStaff selectTMedicalStaffById(Long staffId) {
        return tMedicalStaffMapper.selectTMedicalStaffById(staffId);
    }

    /**
     * 查询医护人员信息列表
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 医护人员信息
     */
    @Override
    public List<TMedicalStaff> selectTMedicalStaffList(TMedicalStaff tMedicalStaff) {
        return tMedicalStaffMapper.selectTMedicalStaffList(tMedicalStaff);
    }

    /**
     * 新增医护人员信息
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 结果
     */
    @Override
    public int insertTMedicalStaff(TMedicalStaff tMedicalStaff) {
        return tMedicalStaffMapper.insertTMedicalStaff(tMedicalStaff);
    }

    /**
     * 修改医护人员信息
     * 
     * @param tMedicalStaff 医护人员信息
     * @return 结果
     */
    @Override
    public int updateTMedicalStaff(TMedicalStaff tMedicalStaff) {
        return tMedicalStaffMapper.updateTMedicalStaff(tMedicalStaff);
    }

    /**
     * 批量删除医护人员信息
     * 
     * @param staffIds 需要删除的医护人员ID
     * @return 结果
     */
    @Override
    public int deleteTMedicalStaffByIds(Long[] staffIds) {
        return tMedicalStaffMapper.deleteTMedicalStaffByIds(staffIds);
    }

    /**
     * 删除医护人员信息信息
     * 
     * @param staffId 医护人员ID
     * @return 结果
     */
    @Override
    public int deleteTMedicalStaffById(Long staffId) {
        return tMedicalStaffMapper.deleteTMedicalStaffById(staffId);
    }
} 