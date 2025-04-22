package com.mnasf.system.mapper;

import java.util.List;
import com.mnasf.system.domain.TNutritionAssessment;

/**
 * 营养状况评估Mapper接口
 */
public interface TNutritionAssessmentMapper {
    /**
     * 查询营养状况评估
     * 
     * @param id 营养状况评估主键
     * @return 营养状况评估
     */
    public TNutritionAssessment selectTNutritionAssessmentById(Long id);

    /**
     * 查询营养状况评估列表
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 营养状况评估集合
     */
    public List<TNutritionAssessment> selectTNutritionAssessmentList(TNutritionAssessment tNutritionAssessment);

    /**
     * 新增营养状况评估
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 结果
     */
    public int insertTNutritionAssessment(TNutritionAssessment tNutritionAssessment);

    /**
     * 修改营养状况评估
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 结果
     */
    public int updateTNutritionAssessment(TNutritionAssessment tNutritionAssessment);

    /**
     * 删除营养状况评估
     * 
     * @param id 营养状况评估主键
     * @return 结果
     */
    public int deleteTNutritionAssessmentById(Long id);

    /**
     * 批量删除营养状况评估
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTNutritionAssessmentByIds(Long[] ids);
} 