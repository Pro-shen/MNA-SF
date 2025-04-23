package com.mnasf.system.service;

import java.util.List;
import com.mnasf.system.domain.TNutritionTrend;

/**
 * 营养状况趋势分析Service接口
 */
public interface ITNutritionTrendService {
    /**
     * 查询营养状况趋势分析
     */
    public TNutritionTrend selectTNutritionTrendById(Long trendId);

    /**
     * 查询营养状况趋势分析列表
     */
    public List<TNutritionTrend> selectTNutritionTrendList(TNutritionTrend tNutritionTrend);

    /**
     * 新增营养状况趋势分析
     */
    public int insertTNutritionTrend(TNutritionTrend tNutritionTrend);

    /**
     * 修改营养状况趋势分析
     */
    public int updateTNutritionTrend(TNutritionTrend tNutritionTrend);

    /**
     * 批量删除营养状况趋势分析
     */
    public int deleteTNutritionTrendByIds(Long[] trendIds);

    /**
     * 删除营养状况趋势分析信息
     */
    public int deleteTNutritionTrendById(Long trendId);
} 