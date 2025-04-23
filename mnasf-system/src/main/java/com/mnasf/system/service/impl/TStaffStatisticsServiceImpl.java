package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TStaffStatisticsMapper;
import com.mnasf.system.domain.TStaffStatistics;
import com.mnasf.system.service.ITStaffStatisticsService;

/**
 * 医护人员工作统计Service业务层处理
 */
@Service
public class TStaffStatisticsServiceImpl implements ITStaffStatisticsService {
    @Autowired
    private TStaffStatisticsMapper tStaffStatisticsMapper;

    /**
     * 查询医护人员工作统计
     */
    @Override
    public TStaffStatistics selectTStaffStatisticsById(Long statId) {
        return tStaffStatisticsMapper.selectTStaffStatisticsById(statId);
    }

    /**
     * 查询医护人员工作统计列表
     */
    @Override
    public List<TStaffStatistics> selectTStaffStatisticsList(TStaffStatistics tStaffStatistics) {
        return tStaffStatisticsMapper.selectTStaffStatisticsList(tStaffStatistics);
    }

    /**
     * 新增医护人员工作统计
     */
    @Override
    public int insertTStaffStatistics(TStaffStatistics tStaffStatistics) {
        return tStaffStatisticsMapper.insertTStaffStatistics(tStaffStatistics);
    }

    /**
     * 修改医护人员工作统计
     */
    @Override
    public int updateTStaffStatistics(TStaffStatistics tStaffStatistics) {
        return tStaffStatisticsMapper.updateTStaffStatistics(tStaffStatistics);
    }

    /**
     * 批量删除医护人员工作统计
     */
    @Override
    public int deleteTStaffStatisticsByIds(Long[] statIds) {
        return tStaffStatisticsMapper.deleteTStaffStatisticsByIds(statIds);
    }

    /**
     * 删除医护人员工作统计信息
     */
    @Override
    public int deleteTStaffStatisticsById(Long statId) {
        return tStaffStatisticsMapper.deleteTStaffStatisticsById(statId);
    }
} 