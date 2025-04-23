-- 医护人员信息表
CREATE TABLE `t_medical_staff` (
  `staff_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '医护人员ID',
  `staff_name` varchar(50) NOT NULL COMMENT '姓名',
  `gender` char(1) DEFAULT '0' COMMENT '性别（0男 1女 2未知）',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `id_card` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `staff_type` char(1) DEFAULT '0' COMMENT '人员类型（0医生 1护士）',
  `professional_title` varchar(50) DEFAULT NULL COMMENT '职称',
  `department` varchar(50) DEFAULT NULL COMMENT '所属科室',
  `specialty` varchar(500) DEFAULT NULL COMMENT '专业特长',
  `work_experience` varchar(500) DEFAULT NULL COMMENT '工作经验',
  `education` varchar(50) DEFAULT NULL COMMENT '学历',
  `status` char(1) DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COMMENT='医护人员信息表'; 