-- 医护人员类型字典数据
INSERT INTO sys_dict_type(dict_name, dict_type, status, create_by, create_time, update_by, update_time, remark)
VALUES ('医护人员类型', 'medical_staff_type', '0', 'admin', sysdate(), '', null, '医护人员类型列表');

INSERT INTO sys_dict_data(dict_sort, dict_label, dict_value, dict_type, css_class, list_class, is_default, status, create_by, create_time, update_by, update_time, remark)
VALUES (1, '医生', '0', 'medical_staff_type', '', 'primary', 'Y', '0', 'admin', sysdate(), '', null, '医生');

INSERT INTO sys_dict_data(dict_sort, dict_label, dict_value, dict_type, css_class, list_class, is_default, status, create_by, create_time, update_by, update_time, remark)
VALUES (2, '护士', '1', 'medical_staff_type', '', 'success', 'N', '0', 'admin', sysdate(), '', null, '护士'); 