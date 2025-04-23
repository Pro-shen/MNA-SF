package com.mnasf.system.mapper;

import java.util.List;
import com.mnasf.system.domain.TNutritionTrend;

/**
 * 营养状况趋势分析Mapper接口
 */
public interface TNutritionTrendMapper {
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
     * 删除营养状况趋势分析
     */
    public int deleteTNutritionTrendById(Long trendId);

    /**
     * 批量删除营养状况趋势分析
     */
    public int deleteTNutritionTrendByIds(Long[] trendIds);
} 