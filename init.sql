create table tbl_User (
  user_id varchar(8) primary key comment '用户工号',
  user_name varchar(8) comment '用户姓名',
  department varchar(32) comment '部门(学院)',
  phone varchar(16) comment '电话',
  mail varchar(32) comment '邮箱'
) comment '用户表' charset = utf8;

create table tbl_News (
  md5_id varchar(255) primary key comment '新闻的url md5转化为key',
  title varchar(64) not null comment '新闻标题',
  author varchar(32) comment '作者',
  create_date timestamp not null comment '发布时间',
  web_name varchar(64) not null comment '来源网站',
  url varchar(255) not null,
  apartment varchar(32) comment '发布部门',
  tag varchar(1024) comment '标签',
  content varchar(4096) not null comment '网站内容的html',
  image_url_list varchar(2048) comment '图片地址'
  ) comment '新闻表' charset = utf8;