package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TNutritionTrendMapper;
import com.mnasf.system.domain.TNutritionTrend;
import com.mnasf.system.service.ITNutritionTrendService;

/**
 * 营养状况趋势分析Service业务层处理
 */
@Service
public class TNutritionTrendServiceImpl implements ITNutritionTrendService {
    @Autowired
    private TNutritionTrendMapper tNutritionTrendMapper;

    /**
     * 查询营养状况趋势分析
     */
    @Override
    public TNutritionTrend selectTNutritionTrendById(Long trendId) {
        return tNutritionTrendMapper.selectTNutritionTrendById(trendId);
    }

    /**
     * 查询营养状况趋势分析列表
     */
    @Override
    public List<TNutritionTrend> selectTNutritionTrendList(TNutritionTrend tNutritionTrend) {
        return tNutritionTrendMapper.selectTNutritionTrendList(tNutritionTrend);
    }

    /**
     * 新增营养状况趋势分析
     */
    @Override
    public int insertTNutritionTrend(TNutritionTrend tNutritionTrend) {
        return tNutritionTrendMapper.insertTNutritionTrend(tNutritionTrend);
    }

    /**
     * 修改营养状况趋势分析
     */
    @Override
    public int updateTNutritionTrend(TNutritionTrend tNutritionTrend) {
        return tNutritionTrendMapper.updateTNutritionTrend(tNutritionTrend);
    }

    /**
     * 批量删除营养状况趋势分析
     */
    @Override
    public int deleteTNutritionTrendByIds(Long[] trendIds) {
        return tNutritionTrendMapper.deleteTNutritionTrendByIds(trendIds);
    }

    /**
     * 删除营养状况趋势分析信息
     */
    @Override
    public int deleteTNutritionTrendById(Long trendId) {
        return tNutritionTrendMapper.deleteTNutritionTrendById(trendId);
    }
} 