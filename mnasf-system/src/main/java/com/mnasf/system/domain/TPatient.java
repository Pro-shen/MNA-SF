package com.mnasf.system.domain;

import com.mnasf.common.annotation.Excel;

import java.util.Date;

/**
 * 患者信息对象 t_patient
 */
public class TPatient {

    /** 患者ID */
    private Long patientId;

    /** 患者姓名 */
    @Excel(name = "患者姓名")
    private String patientName;

    /** 性别（0男 1女 2未知） */
    @Excel(name = "性别", readConverterExp = "0=男,1=女,2=未知")
    private String gender;

    /** 年龄 */
    @Excel(name = "年龄")
    private Integer age;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 身份证号 */
    @Excel(name = "身份证号")
    private String idCard;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 症状描述 */
    @Excel(name = "症状描述")
    private String symptoms;

    /** 病史 */
    @Excel(name = "病史")
    private String medicalHistory;

    /** 用药情况 */
    @Excel(name = "用药情况")
    private String medication;

    /** 心理状态 */
    @Excel(name = "心理状态")
    private String psychologicalStatus;

    /** 生活方式 */
    @Excel(name = "生活方式")
    private String lifestyle;

    /** 跌倒史 */
    @Excel(name = "跌倒史")
    private String fallHistory;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String remark;

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getMedication() {
        return medication;
    }

    public void setPsychologicalStatus(String psychologicalStatus) {
        this.psychologicalStatus = psychologicalStatus;
    }

    public String getPsychologicalStatus() {
        return psychologicalStatus;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setFallHistory(String fallHistory) {
        this.fallHistory = fallHistory;
    }

    public String getFallHistory() {
        return fallHistory;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
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