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
import com.mnasf.system.domain.TPatient;
import com.mnasf.system.service.ITPatientService;
import com.mnasf.common.utils.poi.ExcelUtil;
import com.mnasf.common.core.page.TableDataInfo;

/**
 * 患者信息Controller
 */
@RestController
@RequestMapping("/followup/patient")
public class TPatientController extends BaseController {
    @Autowired
    private ITPatientService tPatientService;

    /**
     * 查询患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:list')")
    @GetMapping("/list")
    public TableDataInfo list(TPatient tPatient) {
        startPage();
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        return getDataTable(list);
    }

    /**
     * 导出患者信息列表
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:export')")
    @Log(title = "患者信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TPatient tPatient) {
        List<TPatient> list = tPatientService.selectTPatientList(tPatient);
        ExcelUtil<TPatient> util = new ExcelUtil<TPatient>(TPatient.class);
        util.exportExcel(response, list, "患者信息数据");
    }

    /**
     * 获取患者信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:query')")
    @GetMapping(value = "/{patientId}")
    public AjaxResult getInfo(@PathVariable("patientId") Long patientId) {
        return success(tPatientService.selectTPatientById(patientId));
    }

    /**
     * 新增患者信息
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:add')")
    @Log(title = "患者信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TPatient tPatient) {
        return toAjax(tPatientService.insertTPatient(tPatient));
    }

    /**
     * 修改患者信息
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:edit')")
    @Log(title = "患者信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TPatient tPatient) {
        return toAjax(tPatientService.updateTPatient(tPatient));
    }

    /**
     * 删除患者信息
     */
    @PreAuthorize("@ss.hasPermi('followup:patient:remove')")
    @Log(title = "患者信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{patientIds}")
    public AjaxResult remove(@PathVariable Long[] patientIds) {
        return toAjax(tPatientService.deleteTPatientByIds(patientIds));
    }
} 