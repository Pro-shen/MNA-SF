package com.mnasf.system.mapper;

import java.util.List;
import com.mnasf.system.domain.TFollowupAppointment;

/**
 * 随访预约Mapper接口
 */
public interface TFollowupAppointmentMapper {
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
     * 删除随访预约
     */
    public int deleteTFollowupAppointmentById(Long appointmentId);

    /**
     * 批量删除随访预约
     */
    public int deleteTFollowupAppointmentByIds(Long[] appointmentIds);
} 