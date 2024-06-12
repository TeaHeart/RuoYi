# drop database if exists ry;
# create database ry charset utf8mb4;
use ry;

drop table if exists mms_produce_like;
drop table if exists mms_product;
drop table if exists mms_product_type;
drop table if exists mms_address;
drop table if exists mms_feedback;
drop table if exists mms_user;

create table mms_product_type
(
    id          bigint primary key auto_increment comment '编号',
    name        varchar(32) not null comment '名称',
    picture     varchar(255) default null comment '图片',
    content     text         default null comment '介绍',
    create_time datetime     default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '产品类型表';

create table mms_product
(
    id          bigint primary key auto_increment comment '编号',
    type_id     bigint         not null comment '产品类型编号',
    foreign key (type_id) references mms_product_type (id),
    title       varchar(32)    not null comment '标题',
    price       decimal(10, 2) not null comment '价格',
    picture     varchar(255) default null comment '图片',
    brief       varchar(255) default null comment '摘要',
    content     text         default null comment '介绍',
    create_time datetime     default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '产品表';

create table mms_user
(
    id          bigint primary key auto_increment comment '编号',
    username    varchar(32) unique not null comment '用户名',
    create_time datetime default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '用户表';

create table mms_address
(
    id          bigint primary key auto_increment comment '编号',
    user_id     bigint                  not null comment '用户编号',
    foreign key (user_id) references mms_user (id),
    name        varchar(32)             not null comment '收件人姓名',
    gender      enum ('无', '男', '女') not null comment '性别',
    phone       varchar(32)             not null comment '联系电话',
    address     varchar(255)            not null comment '收获地址',
    room        varchar(32)  default null comment '门牌号',
    remark      varchar(255) default null comment '备注',
    is_default  bool         default null comment '是否默认',
    create_time datetime     default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '收货地址表';

create table mms_feedback
(
    id          bigint primary key auto_increment comment '编号',
    user_id     bigint not null comment '用户编号',
    foreign key (user_id) references mms_user (id),
    content     text   not null comment '内容',
    create_time datetime default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '反馈表';

create table mms_produce_like
(
    id          bigint primary key auto_increment comment '编号',
    product_id  bigint not null comment '产品编号',
    user_id     bigint not null comment '用户编号',
    foreign key (product_id) references mms_product (id),
    foreign key (user_id) references mms_user (id),
    unique key (product_id, user_id),
    create_time datetime default current_timestamp comment '创建时间',
    update_time datetime on update current_timestamp comment '修改时间'
) comment '产品收藏表';

insert into mms_user (username)
values ('z3'),
       ('l4');

insert into mms_product_type (name)
values ('笔记本电脑'),
       ('手机');

insert into mms_product (type_id, title, price)
values (1, 'laptop', 7000),
       (2, 'android', 3000);

insert into mms_address (user_id, name, gender, phone, address)
values (1, 'z3', '男', '13000000000', '中国'),
       (2, 'l4', '女', '13000000001', '中国');

insert into mms_feedback (user_id, content)
values (1, '商品太少了'),
       (2, '商品太贵了');

insert into mms_produce_like (product_id, user_id)
values (1, 1),
       (1, 2),
       (2, 1),
       (2, 2);

select *
from mms_product_type;

select *
from mms_product;

select *
from mms_user;

select *
from mms_address;

select *
from mms_feedback;

select *
from mms_produce_like;
