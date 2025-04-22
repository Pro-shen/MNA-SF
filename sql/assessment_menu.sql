-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估', '5', '2', 'assessment', 'followup/assessment/index', 1, 0, 'C', '0', '0', 'followup:assessment:list', 'assessment', 'admin', sysdate(), '', null, '营养状况评估菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'followup:assessment:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'followup:assessment:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'followup:assessment:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'followup:assessment:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('营养状况评估导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'followup:assessment:export',       '#', 'admin', sysdate(), '', null, ''); 