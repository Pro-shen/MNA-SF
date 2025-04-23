-- 营养状况趋势分析表
CREATE TABLE t_nutrition_trend (
    trend_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '趋势ID',
    patient_id BIGINT(20) NOT NULL COMMENT '患者ID',
    assessment_date DATETIME NOT NULL COMMENT '评估日期',
    mna_score DECIMAL(5,2) COMMENT 'MNA评分',
    conut_score DECIMAL(5,2) COMMENT 'CONUT评分',
    gnri_score DECIMAL(5,2) COMMENT 'GNRI评分',
    pni_score DECIMAL(5,2) COMMENT 'PNI评分',
    create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (trend_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='营养状况趋势分析表';

-- 医护人员工作统计表
CREATE TABLE t_staff_statistics (
    stat_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '统计ID',
    staff_id BIGINT(20) NOT NULL COMMENT '医护人员ID',
    staff_type CHAR(1) NOT NULL COMMENT '人员类型（1医生 2护士）',
    stat_date DATE NOT NULL COMMENT '统计日期',
    assessment_count INT(11) DEFAULT 0 COMMENT '评估次数',
    followup_count INT(11) DEFAULT 0 COMMENT '随访次数',
    create_by VARCHAR(64) DEFAULT '' COMMENT '创建者',
    create_time DATETIME COMMENT '创建时间',
    update_by VARCHAR(64) DEFAULT '' COMMENT '更新者',
    update_time DATETIME COMMENT '更新时间',
    remark VARCHAR(500) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (stat_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='医护人员工作统计表'; 