-- 随访预约表
CREATE TABLE t_followup_appointment (
    appointment_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '预约ID',
    patient_id BIGINT(20) NOT NULL COMMENT '患者ID',
    doctor_id BIGINT(20) NOT NULL COMMENT '医生ID',
    appointment_time DATETIME NOT NULL COMMENT '预约时间',
    status CHAR(1) DEFAULT '0' COMMENT '状态（0待确认 1已确认 2已取消）',
    remark VARCHAR(500) DEFAULT '' COMMENT '备注',
    create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    PRIMARY KEY (appointment_id)
) ENGINE=InnoDB AUTO_INCREMENT=100 COMMENT='随访预约表'; 