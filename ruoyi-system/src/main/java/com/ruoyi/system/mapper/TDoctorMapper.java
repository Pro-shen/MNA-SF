package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.TDoctor;

/**
 * 医生信息Mapper接口
 */
public interface TDoctorMapper {
    /**
     * 查询医生信息
     * 
     * @param doctorId 医生ID
     * @return 医生信息
     */
    public TDoctor selectTDoctorById(Long doctorId);

    /**
     * 查询医生信息列表
     * 
     * @param tDoctor 医生信息
     * @return 医生信息集合
     */
    public List<TDoctor> selectTDoctorList(TDoctor tDoctor);

    /**
     * 新增医生信息
     * 
     * @param tDoctor 医生信息
     * @return 结果
     */
    public int insertTDoctor(TDoctor tDoctor);

    /**
     * 修改医生信息
     * 
     * @param tDoctor 医生信息
     * @return 结果
     */
    public int updateTDoctor(TDoctor tDoctor);

    /**
     * 删除医生信息
     * 
     * @param doctorId 医生ID
     * @return 结果
     */
    public int deleteTDoctorById(Long doctorId);

    /**
     * 批量删除医生信息
     * 
     * @param doctorIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDoctorByIds(Long[] doctorIds);
} 