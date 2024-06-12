-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理', '2003', '1', '/mms/address', 'C', '0', 'mms:address:view', '#', 'admin', sysdate(), '', null, '收货地址管理菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理查询', @parentId, '1',  '#',  'F', '0', 'mms:address:list',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理新增', @parentId, '2',  '#',  'F', '0', 'mms:address:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理修改', @parentId, '3',  '#',  'F', '0', 'mms:address:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理删除', @parentId, '4',  '#',  'F', '0', 'mms:address:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('收货地址管理导出', @parentId, '5',  '#',  'F', '0', 'mms:address:export',       '#', 'admin', sysdate(), '', null, '');

select *
from sys_menu;