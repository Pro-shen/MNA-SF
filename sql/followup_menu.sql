-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约', '5', '1', 'appointment', 'followup/appointment/index', 1, 0, 'C', '0', '0', 'followup:appointment:list', 'appointment', 'admin', sysdate(), '', null, '随访预约菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'followup:appointment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'followup:appointment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约修改', @parentId, '3',  '#', '', 1, 0, 'F', 'F', '0', 'followup:appointment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'followup:appointment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('随访预约导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'followup:appointment:export',       '#', 'admin', sysdate(), '', null, ''); 