-- 患者信息表
CREATE TABLE `t_patient` (
  `patient_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '患者ID',
  `patient_name` varchar(50) NOT NULL COMMENT '患者姓名',
  `gender` char(1) DEFAULT '0' COMMENT '性别（0男 1女 2未知）',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `symptoms` varchar(500) DEFAULT NULL COMMENT '症状描述',
  `medical_history` varchar(500) DEFAULT NULL COMMENT '病史',
  `medication` varchar(500) DEFAULT NULL COMMENT '用药情况',
  `psychological_status` varchar(500) DEFAULT NULL COMMENT '心理状态',
  `lifestyle` varchar(500) DEFAULT NULL COMMENT '生活方式',
  `fall_history` varchar(500) DEFAULT NULL COMMENT '跌倒史',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='患者信息表'; 