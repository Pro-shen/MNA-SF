package com.ruoyi.web.controller.system;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.TDoctor;
import com.ruoyi.system.service.ITDoctorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 医生信息Controller
 */
@RestController
@RequestMapping("/system/doctor")
public class TDoctorController extends BaseController {
    @Autowired
    private ITDoctorService tDoctorService;

    /**
     * 查询医生信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDoctor tDoctor) {
        startPage();
        List<TDoctor> list = tDoctorService.selectTDoctorList(tDoctor);
        return getDataTable(list);
    }

    /**
     * 导出医生信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:export')")
    @Log(title = "医生信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TDoctor tDoctor) {
        List<TDoctor> list = tDoctorService.selectTDoctorList(tDoctor);
        ExcelUtil<TDoctor> util = new ExcelUtil<TDoctor>(TDoctor.class);
        util.exportExcel(response, list, "医生信息数据");
    }

    /**
     * 获取医生信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:query')")
    @GetMapping(value = "/{doctorId}")
    public AjaxResult getInfo(@PathVariable("doctorId") Long doctorId) {
        return success(tDoctorService.selectTDoctorById(doctorId));
    }

    /**
     * 新增医生信息
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:add')")
    @Log(title = "医生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TDoctor tDoctor) {
        return toAjax(tDoctorService.insertTDoctor(tDoctor));
    }

    /**
     * 修改医生信息
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:edit')")
    @Log(title = "医生信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TDoctor tDoctor) {
        return toAjax(tDoctorService.updateTDoctor(tDoctor));
    }

    /**
     * 删除医生信息
     */
    @PreAuthorize("@ss.hasPermi('system:doctor:remove')")
    @Log(title = "医生信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{doctorIds}")
    public AjaxResult remove(@PathVariable Long[] doctorIds) {
        return toAjax(tDoctorService.deleteTDoctorByIds(doctorIds));
    }
} 