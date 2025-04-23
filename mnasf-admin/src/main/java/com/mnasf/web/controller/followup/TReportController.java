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
import com.mnasf.system.domain.TNutritionTrend;
import com.mnasf.system.domain.TStaffStatistics;
import com.mnasf.system.service.ITNutritionTrendService;
import com.mnasf.system.service.ITStaffStatisticsService;
import com.mnasf.common.utils.poi.ExcelUtil;
import com.mnasf.common.core.page.TableDataInfo;

/**
 * 报表统计Controller
 */
@RestController
@RequestMapping("/followup/report")
public class TReportController extends BaseController {
    @Autowired
    private ITNutritionTrendService tNutritionTrendService;

    @Autowired
    private ITStaffStatisticsService tStaffStatisticsService;

    /**
     * 查询营养状况趋势分析列表
     */
    @PreAuthorize("@ss.hasPermi('followup:report:list')")
    @GetMapping("/nutrition/list")
    public TableDataInfo listNutrition(TNutritionTrend tNutritionTrend) {
        startPage();
        List<TNutritionTrend> list = tNutritionTrendService.selectTNutritionTrendList(tNutritionTrend);
        return getDataTable(list);
    }

    /**
     * 导出营养状况趋势分析列表
     */
    @PreAuthorize("@ss.hasPermi('followup:report:export')")
    @Log(title = "营养状况趋势分析", businessType = BusinessType.EXPORT)
    @PostMapping("/nutrition/export")
    public void exportNutrition(HttpServletResponse response, TNutritionTrend tNutritionTrend) {
        List<TNutritionTrend> list = tNutritionTrendService.selectTNutritionTrendList(tNutritionTrend);
        ExcelUtil<TNutritionTrend> util = new ExcelUtil<TNutritionTrend>(TNutritionTrend.class);
        util.exportExcel(response, list, "营养状况趋势分析数据");
    }

    /**
     * 获取营养状况趋势分析详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:report:query')")
    @GetMapping(value = "/nutrition/{trendId}")
    public AjaxResult getNutritionInfo(@PathVariable("trendId") Long trendId) {
        return success(tNutritionTrendService.selectTNutritionTrendById(trendId));
    }

    /**
     * 新增营养状况趋势分析
     */
    @PreAuthorize("@ss.hasPermi('followup:report:add')")
    @Log(title = "营养状况趋势分析", businessType = BusinessType.INSERT)
    @PostMapping("/nutrition")
    public AjaxResult addNutrition(@RequestBody TNutritionTrend tNutritionTrend) {
        return toAjax(tNutritionTrendService.insertTNutritionTrend(tNutritionTrend));
    }

    /**
     * 修改营养状况趋势分析
     */
    @PreAuthorize("@ss.hasPermi('followup:report:edit')")
    @Log(title = "营养状况趋势分析", businessType = BusinessType.UPDATE)
    @PutMapping("/nutrition")
    public AjaxResult editNutrition(@RequestBody TNutritionTrend tNutritionTrend) {
        return toAjax(tNutritionTrendService.updateTNutritionTrend(tNutritionTrend));
    }

    /**
     * 删除营养状况趋势分析
     */
    @PreAuthorize("@ss.hasPermi('followup:report:remove')")
    @Log(title = "营养状况趋势分析", businessType = BusinessType.DELETE)
    @DeleteMapping("/nutrition/{trendIds}")
    public AjaxResult removeNutrition(@PathVariable Long[] trendIds) {
        return toAjax(tNutritionTrendService.deleteTNutritionTrendByIds(trendIds));
    }

    /**
     * 查询医护人员工作统计列表
     */
    @PreAuthorize("@ss.hasPermi('followup:report:list')")
    @GetMapping("/staff/list")
    public TableDataInfo listStaff(TStaffStatistics tStaffStatistics) {
        startPage();
        List<TStaffStatistics> list = tStaffStatisticsService.selectTStaffStatisticsList(tStaffStatistics);
        return getDataTable(list);
    }

    /**
     * 导出医护人员工作统计列表
     */
    @PreAuthorize("@ss.hasPermi('followup:report:export')")
    @Log(title = "医护人员工作统计", businessType = BusinessType.EXPORT)
    @PostMapping("/staff/export")
    public void exportStaff(HttpServletResponse response, TStaffStatistics tStaffStatistics) {
        List<TStaffStatistics> list = tStaffStatisticsService.selectTStaffStatisticsList(tStaffStatistics);
        ExcelUtil<TStaffStatistics> util = new ExcelUtil<TStaffStatistics>(TStaffStatistics.class);
        util.exportExcel(response, list, "医护人员工作统计数据");
    }

    /**
     * 获取医护人员工作统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:report:query')")
    @GetMapping(value = "/staff/{statId}")
    public AjaxResult getStaffInfo(@PathVariable("statId") Long statId) {
        return success(tStaffStatisticsService.selectTStaffStatisticsById(statId));
    }

    /**
     * 新增医护人员工作统计
     */
    @PreAuthorize("@ss.hasPermi('followup:report:add')")
    @Log(title = "医护人员工作统计", businessType = BusinessType.INSERT)
    @PostMapping("/staff")
    public AjaxResult addStaff(@RequestBody TStaffStatistics tStaffStatistics) {
        return toAjax(tStaffStatisticsService.insertTStaffStatistics(tStaffStatistics));
    }

    /**
     * 修改医护人员工作统计
     */
    @PreAuthorize("@ss.hasPermi('followup:report:edit')")
    @Log(title = "医护人员工作统计", businessType = BusinessType.UPDATE)
    @PutMapping("/staff")
    public AjaxResult editStaff(@RequestBody TStaffStatistics tStaffStatistics) {
        return toAjax(tStaffStatisticsService.updateTStaffStatistics(tStaffStatistics));
    }

    /**
     * 删除医护人员工作统计
     */
    @PreAuthorize("@ss.hasPermi('followup:report:remove')")
    @Log(title = "医护人员工作统计", businessType = BusinessType.DELETE)
    @DeleteMapping("/staff/{statIds}")
    public AjaxResult removeStaff(@PathVariable Long[] statIds) {
        return toAjax(tStaffStatisticsService.deleteTStaffStatisticsByIds(statIds));
    }
} 