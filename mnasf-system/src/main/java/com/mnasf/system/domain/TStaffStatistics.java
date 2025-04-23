package com.mnasf.system.domain;

import com.mnasf.common.annotation.Excel;
import com.mnasf.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 医护人员工作统计对象 t_staff_statistics
 */
public class TStaffStatistics  {

    /** 统计ID */
    private Long statId;

    /** 医护人员ID */
    @Excel(name = "医护人员ID")
    private Long staffId;

    /** 人员类型（1医生 2护士） */
    @Excel(name = "人员类型", readConverterExp = "1=医生,2=护士")
    private String staffType;

    /** 统计日期 */
    @Excel(name = "统计日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date statDate;

    /** 评估次数 */
    @Excel(name = "评估次数")
    private Integer assessmentCount;

    /** 随访次数 */
    @Excel(name = "随访次数")
    private Integer followupCount;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public void setStatId(Long statId) {
        this.statId = statId;
    }

    public Long getStatId() {
        return statId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setAssessmentCount(Integer assessmentCount) {
        this.assessmentCount = assessmentCount;
    }

    public Integer getAssessmentCount() {
        return assessmentCount;
    }

    public void setFollowupCount(Integer followupCount) {
        this.followupCount = followupCount;
    }

    public Integer getFollowupCount() {
        return followupCount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}