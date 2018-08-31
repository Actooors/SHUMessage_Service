create table tbl_User (
  user_id varchar(8) primary key comment '用户工号',
  user_name varchar(8) comment '用户姓名',
  department varchar(32) comment '部门(学院)',
  phone varchar(16) comment '电话',
  mail varchar(32) comment '邮箱',
  big_img varchar(256) comment '原图像',
  img varchar(256) comment '裁剪后的图像'
) comment '用户表' charset = utf8;

create table tbl_News (
  news_id int auto_increment primary key  comment '新闻id'
  md5_id varchar(255) not null comment '新闻的url md5转化为key',
  title varchar(64) not null comment '新闻标题',
  author varchar(32) comment '作者',
  create_date timestamp not null comment '发布时间',
  web_name_id varchar(8) comment '发布网站对应用户表的id',
  web_name varchar(64) not null comment '来源网站',
  url varchar(255) not null,
  apartment varchar(32) comment '发布部门',
  tag_id int comment '标签id',
  tag varchar(1024) comment '标签',
  content varchar(4096) not null comment '网站内容的html',
  image_url_list varchar(2048) comment '图片地址',
  comment_num int default 0 comment '评论数',
  like_num int default 0 comment '点赞数',
  shares_num int default 0 comment '分享数',
  type int comment '1是url 2是img'
  ) comment '新闻表' charset = utf8;

create table tbl_Label (
  label_id int auto_increment primary key comment '标签id',
  label_name varchar(16)  comment '标签名字',
  user_id varchar(8) comment '创建此标签的管理员id'
) comment '标签表' charset = utf8;

create table tbl_Comment (
  comment_id int primary key comment '评论id',
  type int comment '0评论的是新闻 1某人的动态 2某人的评论',
  id int comment '根据type为对应的id',
  user_id varchar(8) comment '发布者id',
  content varchar(512) comment '评论内容',
  comment_num int default 0 comment '评论数',
  like_num int default 0 comment '点赞数',
  img_url varchar(256) comment '评论如果有图片的话那么为图片地址'
  create_time timestamp DEFAULT current_timestamp NULL COMMENT '创建评论的时间';
  eplay_id      int(11) null comment '要回复的回复ID',
  replay_user_id varchar(8) null comment '要回复的用户ID'
) comment '评论表' charset = utf8;

create table tbl_Like (
  like_id int primary key comment '点赞id',
  type int comment '0点赞的是新闻 1是某人的动态 2是某人的评论',
  news_id int comment '根据type对应的新闻或动态的id',
  user_id varchar(8) comment '发布者id',
  is_liked int comment '是否点赞 1点赞 2取消点赞'
) comment '点赞表' charset = utf8;

create table tbl_Topic (
  topic_id int primary key comment '动态id',
  content varchar(4096) not null comment '动态的内容',
  news_id int comment '链接对应的新闻的id',
  comment_num int default 0 comment '评论数',
  like_num int default 0 comment '点赞数',
  shares_num int default 0 comment '分享数',
  img_url varchar(256) comment '评论如果有图片的话那么为图片地址'
) comment '点赞表' charset = utf8;


create table tbl_Iframe (
  host varchar(128) primary key comment 'host作为id'
)