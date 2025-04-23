package com.mnasf.system.service;

import java.util.List;
import com.mnasf.system.domain.TStaffStatistics;

/**
 * 医护人员工作统计Service接口
 */
public interface ITStaffStatisticsService {
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
     * 批量删除医护人员工作统计
     */
    public int deleteTStaffStatisticsByIds(Long[] statIds);

    /**
     * 删除医护人员工作统计信息
     */
    public int deleteTStaffStatisticsById(Long statId);
} 