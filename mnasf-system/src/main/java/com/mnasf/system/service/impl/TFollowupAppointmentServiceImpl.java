package com.mnasf.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mnasf.system.mapper.TFollowupAppointmentMapper;
import com.mnasf.system.domain.TFollowupAppointment;
import com.mnasf.system.service.ITFollowupAppointmentService;

/**
 * 随访预约Service业务层处理
 */
@Service
public class TFollowupAppointmentServiceImpl implements ITFollowupAppointmentService {
    @Autowired
    private TFollowupAppointmentMapper tFollowupAppointmentMapper;

    /**
     * 查询随访预约
     */
    @Override
    public TFollowupAppointment selectTFollowupAppointmentById(Long appointmentId) {
        return tFollowupAppointmentMapper.selectTFollowupAppointmentById(appointmentId);
    }

    /**
     * 查询随访预约列表
     */
    @Override
    public List<TFollowupAppointment> selectTFollowupAppointmentList(TFollowupAppointment tFollowupAppointment) {
        return tFollowupAppointmentMapper.selectTFollowupAppointmentList(tFollowupAppointment);
    }

    /**
     * 新增随访预约
     */
    @Override
    public int insertTFollowupAppointment(TFollowupAppointment tFollowupAppointment) {
        return tFollowupAppointmentMapper.insertTFollowupAppointment(tFollowupAppointment);
    }

    /**
     * 修改随访预约
     */
    @Override
    public int updateTFollowupAppointment(TFollowupAppointment tFollowupAppointment) {
        return tFollowupAppointmentMapper.updateTFollowupAppointment(tFollowupAppointment);
    }

    /**
     * 批量删除随访预约
     */
    @Override
    public int deleteTFollowupAppointmentByIds(Long[] appointmentIds) {
        return tFollowupAppointmentMapper.deleteTFollowupAppointmentByIds(appointmentIds);
    }

    /**
     * 删除随访预约信息
     */
    @Override
    public int deleteTFollowupAppointmentById(Long appointmentId) {
        return tFollowupAppointmentMapper.deleteTFollowupAppointmentById(appointmentId);
    }
}