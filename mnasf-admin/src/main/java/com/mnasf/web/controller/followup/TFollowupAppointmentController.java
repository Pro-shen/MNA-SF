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
import com.mnasf.system.domain.TFollowupAppointment;
import com.mnasf.system.service.ITFollowupAppointmentService;
import com.mnasf.common.utils.poi.ExcelUtil;
import com.mnasf.common.core.page.TableDataInfo;

/**
 * 随访预约Controller
 */
@RestController
@RequestMapping("/followup/appointment")
public class TFollowupAppointmentController extends BaseController {
    @Autowired
    private ITFollowupAppointmentService tFollowupAppointmentService;

    /**
     * 查询随访预约列表
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:list')")
    @GetMapping("/list")
    public TableDataInfo list(TFollowupAppointment tFollowupAppointment) {
        startPage();
        List<TFollowupAppointment> list = tFollowupAppointmentService.selectTFollowupAppointmentList(tFollowupAppointment);
        return getDataTable(list);
    }

    /**
     * 导出随访预约列表
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:export')")
    @Log(title = "随访预约", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TFollowupAppointment tFollowupAppointment) {
        List<TFollowupAppointment> list = tFollowupAppointmentService.selectTFollowupAppointmentList(tFollowupAppointment);
        ExcelUtil<TFollowupAppointment> util = new ExcelUtil<TFollowupAppointment>(TFollowupAppointment.class);
        util.exportExcel(response, list, "随访预约数据");
    }

    /**
     * 获取随访预约详细信息
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:query')")
    @GetMapping(value = "/{appointmentId}")
    public AjaxResult getInfo(@PathVariable("appointmentId") Long appointmentId) {
        return success(tFollowupAppointmentService.selectTFollowupAppointmentById(appointmentId));
    }

    /**
     * 新增随访预约
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:add')")
    @Log(title = "随访预约", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TFollowupAppointment tFollowupAppointment) {
        return toAjax(tFollowupAppointmentService.insertTFollowupAppointment(tFollowupAppointment));
    }

    /**
     * 修改随访预约
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:edit')")
    @Log(title = "随访预约", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TFollowupAppointment tFollowupAppointment) {
        return toAjax(tFollowupAppointmentService.updateTFollowupAppointment(tFollowupAppointment));
    }

    /**
     * 删除随访预约
     */
    @PreAuthorize("@ss.hasPermi('followup:appointment:remove')")
    @Log(title = "随访预约", businessType = BusinessType.DELETE)
    @DeleteMapping("/{appointmentIds}")
    public AjaxResult remove(@PathVariable Long[] appointmentIds) {
        return toAjax(tFollowupAppointmentService.deleteTFollowupAppointmentByIds(appointmentIds));
    }
} 