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
import com.mnasf.system.domain.TMedicalStaff;
import com.mnasf.system.service.ITMedicalStaffService;
import com.mnasf.common.utils.poi.ExcelUtil;
import com.mnasf.common.core.page.TableDataInfo;

/**
 * 医护人员信息Controller
 */
@RestController
@RequestMapping("/followup/appointment")
public class TMedicalStaffController extends BaseController {
    @Autowired
    private ITMedicalStaffService tMedicalStaffService;

    /**
     * 查询医护人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TMedicalStaff tMedicalStaff) {
        startPage();
        List<TMedicalStaff> list = tMedicalStaffService.selectTMedicalStaffList(tMedicalStaff);
        return getDataTable(list);
    }

    /**
     * 导出医护人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:export')")
    @Log(title = "医护人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TMedicalStaff tMedicalStaff) {
        List<TMedicalStaff> list = tMedicalStaffService.selectTMedicalStaffList(tMedicalStaff);
        ExcelUtil<TMedicalStaff> util = new ExcelUtil<TMedicalStaff>(TMedicalStaff.class);
        util.exportExcel(response, list, "医护人员信息数据");
    }

    /**
     * 获取医护人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:query')")
    @GetMapping(value = "/{staffId}")
    public AjaxResult getInfo(@PathVariable("staffId") Long staffId) {
        return success(tMedicalStaffService.selectTMedicalStaffById(staffId));
    }

    /**
     * 新增医护人员信息
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:add')")
    @Log(title = "医护人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TMedicalStaff tMedicalStaff) {
        return toAjax(tMedicalStaffService.insertTMedicalStaff(tMedicalStaff));
    }

    /**
     * 修改医护人员信息
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:edit')")
    @Log(title = "医护人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TMedicalStaff tMedicalStaff) {
        return toAjax(tMedicalStaffService.updateTMedicalStaff(tMedicalStaff));
    }

    /**
     * 删除医护人员信息
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:remove')")
    @Log(title = "医护人员信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{staffIds}")
    public AjaxResult remove(@PathVariable Long[] staffIds) {
        return toAjax(tMedicalStaffService.deleteTMedicalStaffByIds(staffIds));
    }
} 