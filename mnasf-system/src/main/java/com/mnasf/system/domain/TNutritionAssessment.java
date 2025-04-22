package com.mnasf.system.domain;

import com.mnasf.common.annotation.Excel;
import com.mnasf.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 营养状况评估对象 t_nutrition_assessment
 */
public class TNutritionAssessment {

    /** 主键ID */
    private Long id;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 评估时间 */
    @Excel(name = "评估时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date assessmentTime;

    /** 评估人员ID */
    @Excel(name = "评估人员ID")
    private Long assessorId;

    /** CONUT评分 */
    @Excel(name = "CONUT评分")
    private Integer conutScore;

    /** GNRI评分 */
    @Excel(name = "GNRI评分")
    private BigDecimal gnriScore;

    /** PNI评分 */
    @Excel(name = "PNI评分")
    private BigDecimal pniScore;

    /** MNA评分 */
    @Excel(name = "MNA评分")
    private BigDecimal mnaScore;

    /** MNA-SF评分 */
    @Excel(name = "MNA-SF评分")
    private BigDecimal mnaSfScore;

    /** 小腿围(cm) */
    @Excel(name = "小腿围(cm)")
    private BigDecimal calfCircumference;

    /** 握力(kg) */
    @Excel(name = "握力(kg)")
    private BigDecimal gripStrength;

    /** 营养干预方案 */
    @Excel(name = "营养干预方案")
    private String interventionPlan;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setAssessmentTime(Date assessmentTime) {
        this.assessmentTime = assessmentTime;
    }

    public Date getAssessmentTime() {
        return assessmentTime;
    }

    public void setAssessorId(Long assessorId) {
        this.assessorId = assessorId;
    }

    public Long getAssessorId() {
        return assessorId;
    }

    public void setConutScore(Integer conutScore) {
        this.conutScore = conutScore;
    }

    public Integer getConutScore() {
        return conutScore;
    }

    public void setGnriScore(BigDecimal gnriScore) {
        this.gnriScore = gnriScore;
    }

    public BigDecimal getGnriScore() {
        return gnriScore;
    }

    public void setPniScore(BigDecimal pniScore) {
        this.pniScore = pniScore;
    }

    public BigDecimal getPniScore() {
        return pniScore;
    }

    public void setMnaScore(BigDecimal mnaScore) {
        this.mnaScore = mnaScore;
    }

    public BigDecimal getMnaScore() {
        return mnaScore;
    }

    public void setMnaSfScore(BigDecimal mnaSfScore) {
        this.mnaSfScore = mnaSfScore;
    }

    public BigDecimal getMnaSfScore() {
        return mnaSfScore;
    }

    public void setCalfCircumference(BigDecimal calfCircumference) {
        this.calfCircumference = calfCircumference;
    }

    public BigDecimal getCalfCircumference() {
        return calfCircumference;
    }

    public void setGripStrength(BigDecimal gripStrength) {
        this.gripStrength = gripStrength;
    }

    public BigDecimal getGripStrength() {
        return gripStrength;
    }

    public void setInterventionPlan(String interventionPlan) {
        this.interventionPlan = interventionPlan;
    }

    public String getInterventionPlan() {
        return interventionPlan;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}