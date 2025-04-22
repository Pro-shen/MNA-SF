package com.mnasf.web.controller.followup;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mnasf.common.annotation.Log;
import com.mnasf.common.core.controller.BaseController;
import com.mnasf.common.core.domain.AjaxResult;
import com.mnasf.common.enums.BusinessType;
import com.mnasf.system.domain.TNutritionAssessment;
import com.mnasf.system.service.ITNutritionAssessmentService;
import com.mnasf.common.utils.poi.ExcelUtil;
import com.mnasf.common.core.page.TableDataInfo;

/**
 * 营养状况评估Controller
 */
@RestController
@RequestMapping("/followup/assessment")
public class TNutritionAssessmentController extends BaseController {
    @Autowired
    private ITNutritionAssessmentService tNutritionAssessmentService;

    /**
     * 查询营养状况评估列表
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TNutritionAssessment tNutritionAssessment) {
        startPage();
        List<TNutritionAssessment> list = tNutritionAssessmentService.selectTNutritionAssessmentList(tNutritionAssessment);
        return getDataTable(list);
    }

    /**
     * 导出营养状况评估列表
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:export')")
    @Log(title = "营养状况评估", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TNutritionAssessment tNutritionAssessment) {
        List<TNutritionAssessment> list = tNutritionAssessmentService.selectTNutritionAssessmentList(tNutritionAssessment);
        ExcelUtil<TNutritionAssessment> util = new ExcelUtil<TNutritionAssessment>(TNutritionAssessment.class);
        util.exportExcel(response, list, "营养状况评估数据");
    }

    /**
     * 获取营养状况评估详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(tNutritionAssessmentService.selectTNutritionAssessmentById(id));
    }

    /**
     * 新增营养状况评估
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:add')")
    @Log(title = "营养状况评估", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TNutritionAssessment tNutritionAssessment) {
        return toAjax(tNutritionAssessmentService.insertTNutritionAssessment(tNutritionAssessment));
    }

    /**
     * 修改营养状况评估
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:edit')")
    @Log(title = "营养状况评估", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TNutritionAssessment tNutritionAssessment) {
        return toAjax(tNutritionAssessmentService.updateTNutritionAssessment(tNutritionAssessment));
    }

    /**
     * 删除营养状况评估
     */
    @PreAuthorize("@ss.hasPermi('followup:assessment:remove')")
    @Log(title = "营养状况评估", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tNutritionAssessmentService.deleteTNutritionAssessmentByIds(ids));
    }
} 