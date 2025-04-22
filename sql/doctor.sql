-- 医生信息表
create table t_doctor (
    doctor_id           bigint(20)      not null auto_increment    comment '医生ID',
    user_id            bigint(20)      not null                   comment '用户ID',
    doctor_name        varchar(30)     not null                   comment '医生姓名',
    gender             char(1)         default '0'                comment '性别（0男 1女 2未知）',
    age                int(3)          default null               comment '年龄',
    phone              varchar(11)     default ''                 comment '手机号码',
    email              varchar(50)     default ''                 comment '邮箱',
    department         varchar(50)     default ''                 comment '所属科室',
    title              varchar(50)     default ''                 comment '职称',
    specialty          varchar(500)    default ''                 comment '专业特长',
    status             char(1)         default '0'                comment '状态（0正常 1停用）',
    create_by          varchar(64)     default ''                 comment '创建者',
    create_time        datetime                                   comment '创建时间',
    update_by          varchar(64)     default ''                 comment '更新者',
    update_time        datetime                                   comment '更新时间',
    remark             varchar(500)    default null               comment '备注',
    primary key (doctor_id)
) engine=innodb auto_increment=100 comment = '医生信息表'; 