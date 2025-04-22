package com.mnasf.system.service;

import java.util.List;
import com.mnasf.system.domain.TFollowupAppointment;

/**
 * 随访预约Service接口
 */
public interface ITFollowupAppointmentService {
    /**
     * 查询随访预约
     */
    public TFollowupAppointment selectTFollowupAppointmentById(Long appointmentId);

    /**
     * 查询随访预约列表
     */
    public List<TFollowupAppointment> selectTFollowupAppointmentList(TFollowupAppointment tFollowupAppointment);

    /**
     * 新增随访预约
     */
    public int insertTFollowupAppointment(TFollowupAppointment tFollowupAppointment);

    /**
     * 修改随访预约
     */
    public int updateTFollowupAppointment(TFollowupAppointment tFollowupAppointment);

    /**
     * 批量删除随访预约
     */
    public int deleteTFollowupAppointmentByIds(Long[] appointmentIds);

    /**
     * 删除随访预约信息
     */
    public int deleteTFollowupAppointmentById(Long appointmentId);
} 