package com.mnasf.system.mapper;

import com.mnasf.system.domain.TDoctor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TDoctorMapper {
    /**
     * 查询医生信息列表
     */
    List<TDoctor> selectDoctorList(TDoctor doctor);

    /**
     * 查询医生信息
     */
    TDoctor selectById(@Param("doctorId") Long doctorId);

    /**
     * 新增医生信息
     */
    int insert(TDoctor doctor);

    /**
     * 修改医生信息
     */
    int updateById(TDoctor doctor);

    /**
     * 批量删除医生信息
     */
    int deleteBatchIds(@Param("ids") Long[] ids);

    /**
     * 删除医生信息
     */
    int deleteById(@Param("doctorId") Long doctorId);
} 