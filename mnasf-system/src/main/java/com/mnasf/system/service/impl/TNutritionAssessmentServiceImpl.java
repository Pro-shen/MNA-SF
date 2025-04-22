package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TNutritionAssessmentMapper;
import com.mnasf.system.domain.TNutritionAssessment;
import com.mnasf.system.service.ITNutritionAssessmentService;

/**
 * 营养状况评估Service业务层处理
 */
@Service
public class TNutritionAssessmentServiceImpl implements ITNutritionAssessmentService {
    @Autowired
    private TNutritionAssessmentMapper tNutritionAssessmentMapper;

    /**
     * 查询营养状况评估
     * 
     * @param id 营养状况评估主键
     * @return 营养状况评估
     */
    @Override
    public TNutritionAssessment selectTNutritionAssessmentById(Long id) {
        return tNutritionAssessmentMapper.selectTNutritionAssessmentById(id);
    }

    /**
     * 查询营养状况评估列表
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 营养状况评估
     */
    @Override
    public List<TNutritionAssessment> selectTNutritionAssessmentList(TNutritionAssessment tNutritionAssessment) {
        return tNutritionAssessmentMapper.selectTNutritionAssessmentList(tNutritionAssessment);
    }

    /**
     * 新增营养状况评估
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 结果
     */
    @Override
    public int insertTNutritionAssessment(TNutritionAssessment tNutritionAssessment) {
        return tNutritionAssessmentMapper.insertTNutritionAssessment(tNutritionAssessment);
    }

    /**
     * 修改营养状况评估
     * 
     * @param tNutritionAssessment 营养状况评估
     * @return 结果
     */
    @Override
    public int updateTNutritionAssessment(TNutritionAssessment tNutritionAssessment) {
        return tNutritionAssessmentMapper.updateTNutritionAssessment(tNutritionAssessment);
    }

    /**
     * 批量删除营养状况评估
     * 
     * @param ids 需要删除的营养状况评估主键
     * @return 结果
     */
    @Override
    public int deleteTNutritionAssessmentByIds(Long[] ids) {
        return tNutritionAssessmentMapper.deleteTNutritionAssessmentByIds(ids);
    }

    /**
     * 删除营养状况评估信息
     * 
     * @param id 营养状况评估主键
     * @return 结果
     */
    @Override
    public int deleteTNutritionAssessmentById(Long id) {
        return tNutritionAssessmentMapper.deleteTNutritionAssessmentById(id);
    }
} 