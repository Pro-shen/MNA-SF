package com.mnasf.web.controller.followup;

import com.mnasf.common.core.controller.BaseController;
import com.mnasf.common.core.domain.AjaxResult;
import com.mnasf.common.core.page.TableDataInfo;
import com.mnasf.system.domain.TDoctor;
import com.mnasf.system.service.ITDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.mnasf.common.utils.PageUtils.startPage;

@RestController
@RequestMapping("/followup/doctor")
public class TDoctorController extends BaseController {
    @Autowired
    private ITDoctorService doctorService;

    /**
     * 查询医生列表
     */
    @PreAuthorize("@ss.hasPermi('followup:doctor:list')")
    @GetMapping("/list")
    public TableDataInfo list(TDoctor doctor) {
        startPage();
        List<TDoctor> list = doctorService.selectDoctorList(doctor);
        return getDataTable(list);
    }

    /**
     * 获取医生详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:doctor:query')")
    @GetMapping(value = "/{doctorId}")
    public AjaxResult getInfo(@PathVariable("doctorId") Long doctorId) {
        return AjaxResult.success(doctorService.selectDoctorById(doctorId));
    }

    /**
     * 新增医生
     */
    @PreAuthorize("@ss.hasPermi('followup:doctor:add')")
    @PostMapping
    public AjaxResult add(@RequestBody TDoctor doctor) {
        return toAjax(doctorService.insertDoctor(doctor));
    }

    /**
     * 修改医生
     */
    @PreAuthorize("@ss.hasPermi('followup:doctor:edit')")
    @PutMapping
    public AjaxResult edit(@RequestBody TDoctor doctor) {
        return toAjax(doctorService.updateDoctor(doctor));
    }

    /**
     * 删除医生
     */
    @PreAuthorize("@ss.hasPermi('followup:doctor:remove')")
    @DeleteMapping("/{doctorIds}")
    public AjaxResult remove(@PathVariable Long[] doctorIds) {
        return toAjax(doctorService.deleteDoctorByIds(doctorIds));
    }
} 