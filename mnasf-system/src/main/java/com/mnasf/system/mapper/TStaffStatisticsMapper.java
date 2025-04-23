package com.mnasf.system.mapper;

import java.util.List;
import com.mnasf.system.domain.TStaffStatistics;

/**
 * 医护人员工作统计Mapper接口
 */
public interface TStaffStatisticsMapper {
    /**
     * 查询医护人员工作统计
     */
    public TStaffStatistics selectTStaffStatisticsById(Long statId);

    /**
     * 查询医护人员工作统计列表
     */
    public List<TStaffStatistics> selectTStaffStatisticsList(TStaffStatistics tStaffStatistics);

    /**
     * 新增医护人员工作统计
     */
    public int insertTStaffStatistics(TStaffStatistics tStaffStatistics);

    /**
     * 修改医护人员工作统计
     */
    public int updateTStaffStatistics(TStaffStatistics tStaffStatistics);

    /**
     * 删除医护人员工作统计
     */
    public int deleteTStaffStatisticsById(Long statId);

    /**
     * 批量删除医护人员工作统计
     */
    public int deleteTStaffStatisticsByIds(Long[] statIds);
} 