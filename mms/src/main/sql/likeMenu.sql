-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理', '2003', '1', '/mms/like', 'C', '0', 'mms:like:view', '#', 'admin', sysdate(), '', null, '产品收藏管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理查询', @parentId, '1',  '#',  'F', '0', 'mms:like:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理新增', @parentId, '2',  '#',  'F', '0', 'mms:like:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理修改', @parentId, '3',  '#',  'F', '0', 'mms:like:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理删除', @parentId, '4',  '#',  'F', '0', 'mms:like:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('产品收藏管理导出', @parentId, '5',  '#',  'F', '0', 'mms:like:export',       '#', 'admin', sysdate(), '', null, '');
