package com.mnasf.system.domain;

import com.mnasf.common.annotation.Excel;
import com.mnasf.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 营养状况趋势分析对象 t_nutrition_trend
 */
public class TNutritionTrend  {

    /** 趋势ID */
    private Long trendId;

    /** 患者ID */
    @Excel(name = "患者ID")
    private Long patientId;

    /** 评估日期 */
    @Excel(name = "评估日期", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date assessmentDate;

    /** MNA评分 */
    @Excel(name = "MNA评分")
    private BigDecimal mnaScore;

    /** CONUT评分 */
    @Excel(name = "CONUT评分")
    private BigDecimal conutScore;

    /** GNRI评分 */
    @Excel(name = "GNRI评分")
    private BigDecimal gnriScore;

    /** PNI评分 */
    @Excel(name = "PNI评分")
    private BigDecimal pniScore;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public void setTrendId(Long trendId) {
        this.trendId = trendId;
    }

    public Long getTrendId() {
        return trendId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    public Date getAssessmentDate() {
        return assessmentDate;
    }

    public void setMnaScore(BigDecimal mnaScore) {
        this.mnaScore = mnaScore;
    }

    public BigDecimal getMnaScore() {
        return mnaScore;
    }

    public void setConutScore(BigDecimal conutScore) {
        this.conutScore = conutScore;
    }

    public BigDecimal getConutScore() {
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