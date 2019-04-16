-- CREATE EXTENSION pgcrypto;

CREATE TYPE LoginType AS ENUM ('school', 'phone');
CREATE TYPE UserIdentity AS ENUM ('student', 'official', 'admin', 'superAdmin', 'spider');
CREATE TABLE tbl_user (
  id                    UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
  register_way          LoginType  NOT NULL, -- 1是学校接口， 2是手机登录(校外编制特殊注册方式)
  nickname              VARCHAR(32) UNIQUE, -- 昵称
  editable_nickname_times INT DEFAULT 2, -- 可修改昵称次数
  student_card_id       VARCHAR(32) UNIQUE, -- 学号
  normal_login_id       VARCHAR(32) UNIQUE, -- 自定义登录方式
  password              VARCHAR(256) , -- 密码
  password_salt         VARCHAR(20), -- 加盐密码
  actual_name           VARCHAR(32), -- 真实姓名
  department            VARCHAR(20), -- 学院
  phone                 VARCHAR(16), -- 手机号
  mail                  VARCHAR(100), -- 邮箱
  birthday              DATE,         -- 生日
  gender                CHAR(2),    -- 性别
  about                 VARCHAR(100), -- 个性签名
  location              VARCHAR(100), -- 用户所在地
  birthplace            VARCHAR(8), -- 用户籍贯
  school                VARCHAR(100), -- 用户学校
  job                   VARCHAR(100), -- 用户行业
  identity              UserIdentity, --用户的身份，1是学生，2是官方账户， 3是管理员， 4是超管
  invalid               BOOLEAN          DEFAULT false, -- 是否禁止登陆
  avatar                VARCHAR(128), -- 用户头像
  background            VARCHAR(128), -- 背景图
  consequent_login_days INT              DEFAULT 0, -- 连续登陆的日期，默认为0
  last_login_time       TIMESTAMP(0) DEFAULT current_timestamp, -- 上次登录的时间
  push_interval         SMALLINT DEFAULT 1, -- 推送的间隔，默认一日两推，2是一日一推
  last_push_time        TIMESTAMP(0) DEFAULT current_timestamp,  -- 上次推送的时间                           -- 3是两日一推， 4是一周一推
  social_group_num      INT              DEFAULT 0, -- 我加入的圈子数
  following_num         INT              DEFAULT 0, -- 我关注人的数量
  follower_num          INT              DEFAULT 0, -- 关注我的人的数目
  my_groups_num         INT              DEFAULT 0, -- 我创建的圈子的数目
  create_time           TIMESTAMP(0)     DEFAULT current_timestamp, -- 每一条数据插入的时间
  delete_time           TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

--   -- 用户登陆具体日期的情况表
--   CREATE TABLE tbl_user_login_timestamp (
--     id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
--     user_id     UUID NOT NULL, --当前用户的主键id
--     create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 用户当前登录的时间
--     delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
--   );

-- 用户关注了哪些用户的中间表
--[冗余了target_nickname，target_avatar]
CREATE TABLE tbl_follow_relation (
 id              UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
 user_id         UUID NOT NULL, -- 关注其他人的当前用户的主键id
 target_id       UUID NOT NULL, -- 关注的其他人的用户id
 target_nickname TEXT NOT NULL, -- 关注的其他人的用户昵称
 target_avatar   TEXT NOT NULL, -- 关注的其他人的用户图标
 create_time     TIMESTAMP(0)     DEFAULT current_timestamp, -- 关注时间
 delete_time     TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 数据分析出来的标签表
CREATE TABLE tbl_label (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
name        TEXT UNIQUE, -- 标签名
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 创建标签的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 仅允许携带一个主要链接，但可以携带多张图片
CREATE TYPE MediaType AS ENUM ('imgs', 'url');
CREATE TYPE MessageType AS ENUM ('news', 'moment', 'discuss');
-- 新闻表
--[自冗余precontent]
CREATE TABLE tbl_news (
id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
user_id             VARCHAR(16)   NOT NULL, -- 发布者的主键id

content             VARCHAR(2000) , -- 新闻的内容，最多2000字。此键值的作用是在发布新闻的人想要直接发布新闻的时候书写的内容。请爬虫将新闻主体前140字写入这里，超出140字的在第140字后标'...'存在这里。
pre_content          VARCHAR(141) , -- 文章前140字会存到这里，如果该值长度为141，则表示字数大于140字。请爬虫将新闻主体前140字写入这里，超出140字的，在第140字后标'#'共计141字存到这里。

media_type          MediaType, -- 这里是设置新闻附带的多媒体类型。url由标题和地址组成，imgs可以为多个
media_imgs          VARCHAR(128) [], -- 新闻的图片
media_title         VARCHAR(50)   NOT NULL, -- 新闻标题
news_url            VARCHAR(256), -- 新闻的URL
news_labels         VARCHAR(128) [], -- 新闻的标签          ---------------------*
discuss_num         INT              DEFAULT 0, -- 评论数
discuss_liked_num   INT              DEFAULT 0, -- 评论的总赞数
liked_num           INT              DEFAULT 0, -- 点赞数
re_post_num         INT              DEFAULT 0, -- 转发数
views_num           INT              DEFAULT 0, -- 浏览数

content_from_scrapy TEXT, -- 爬取的新闻的内容，做分析用，不限字数。
md5                 VARCHAR(256), -- 为了新闻唯一而添加的字段

create_time         TIMESTAMP(0)     DEFAULT current_timestamp, -- 发布新闻的时间
discuss_update_time TIMESTAMP(0), -- 最后一个回复的时间
delete_time         TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 置顶的需求有所问题
-- 用户动态表
CREATE TABLE tbl_moment (
id                  UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
user_id             UUID          NOT NULL, -- 发布者的主键id

content             VARCHAR(2000) NOT NULL, -- 动态的内容，最多2000字
pre_content          VARCHAR(141)  NOT NULL, -- 文章前140字会存到这里，如果该值长度为141，则表示字数大于140字。请爬虫将新闻主体前140字写入这里，超出140字的，在第140字后标'#'共计141字存到这里。
---------------*
moment_type         BIT NOT NULL, -- 动态的种类，转发的还是原创的
re_post_target_id   UUID, -- 转发的内容的主键
re_post_type        MessageType, -- 转发的消息的种类，动态或者新闻

media_imgs          VARCHAR(128) [], -- 动态的图片
location            point, -- 定位经纬度
location_place      VARCHAR(50), -- 具体地点
group_id            UUID, -- 如果发布到了某个圈子，则非空

discuss_num         INT              DEFAULT 0, -- 评论数
discuss_liked_num   INT              DEFAULT 0, -- 评论的总赞数
liked_num           INT              DEFAULT 0, -- 点赞数
re_post_num          INT              DEFAULT 0, -- 转发数
views_num           INT              DEFAULT 0, -- 浏览数

create_time         TIMESTAMP(0)     DEFAULT current_timestamp, -- 发布动态的时间
discuss_update_time TIMESTAMP(0), -- 最后一个回复的时间
delete_time         TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 新闻和标签的中间表，表示每个新闻有哪些标签
-- [冗余了label_name]
--   CREATE TABLE tbl_news_and_label (
--           id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
--           news_id     UUID        NOT NULL, -- 新闻的主键id
--           label_id    UUID        NOT NULL, -- 标签的主键id
--           label_name  VARCHAR(16) NOT NULL, -- 标签名
--           create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 插入这条数据的时间
--           delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
--   );

-- 对每一个Message进行点赞的记录表
CREATE TABLE tbl_like (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
target_type MessageType NOT NULL, -- 对哪种MessageType进行点赞
target_id   UUID        NOT NULL, -- 目标MessageType的主键id
operator_id UUID        NOT NULL, -- 操作人的主键id
liked       BOOLEAN          DEFAULT true, -- 点赞的状态
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 第一次点赞的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 对每一个Message（非discuss）进行转发的记录表
-- 不进行冗余
--   CREATE TABLE tbl_repost (
--   id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
--   target_type MessageType  NOT NULL, -- 对哪种MessageType进行转发。当然，不能是discuss。
--   target_id   UUID         NOT NULL, -- 目标MessageType的主键id
--   operator_id UUID         NOT NULL, -- 操作人的主键id
--   content     VARCHAR(2000), -- 转发附带的内容，不能超过2000字
--   pre_content  VARCHAR(141) NOT NULL, -- 转发附带的内容前140字会存到这里，如果该值长度为141，则表示字数大于140字。请爬虫将新闻主体前140字写入这里，超出140字的，在第140字后标'#'共计141字存到这里。
--   create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 转发的时间
--   delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
--   );

-- 对每一个Message的评论表
CREATE TABLE tbl_discuss (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
target_type MessageType NOT NULL, -- 对哪种MessageType进行评论
target_id   UUID        NOT NULL, -- 目标MessageType的主键id
ancestor_id UUID, -- 当MessageType为discuss的时候，为了让每一个评论的回复和那些回复的回复都出现在这个评论下
-- 我在这种时候让他们都维护一个评论的id，这样就不存在对回复的回复无限循环了
operator_id UUID        NOT NULL, -- 对某一个新闻、动态、评论、回复进行操作的人的主键id
content     VARCHAR(140), -- 评论的内容不能超过140字
discuss_num INT              DEFAULT 0, -- 被评论数
liked_num   INT              DEFAULT 0, -- 被点赞的数目
img         VARCHAR(128), -- discuss携带的img只能有一个
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 评论的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 圈子表
CREATE TABLE tbl_group (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
name        VARCHAR(16) UNIQUE, -- 圈子名字
description VARCHAR(256), -- 圈子的简介

avatar      VARCHAR(128),
background  VARCHAR(128),

creator_id  UUID NOT NULL, -- 创建圈子的人的主键id
member_num  INT              DEFAULT 1, -- 圈子内人的数目，如果是系统创建，则为0
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 创建圈子的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 用户加入了哪些圈子的中间表
CREATE TABLE tbl_group_member (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
group_id    UUID NOT NULL, -- 关注的其他人的圈子id
user_id     UUID NOT NULL, -- 关注其他人的当前用户的主键id
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 关注圈子的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

-- 用户订阅了哪些标签的中间表
CREATE TABLE tbl_user_subscribe_label (
      id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
      user_id     UUID NOT NULL, -- 订阅者主键id
      label_id    UUID NOT NULL, -- 订阅的标签主键id
------------- *
      need_send_msg BOOLEAN DEFAULT true, -- 是否需要推送该标签，默认需要
      create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 关注标签的时间
      delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);

----------------------------------------*
-- 回复消息，点赞消息，转发消息，关注消息
CREATE TYPE NoticeType AS ENUM ('reply', 'like', 'rePost', 'concern');

-- 类似QQ空间的用户消息提醒
CREATE TABLE tbl_user_message (
id          UUID PRIMARY KEY DEFAULT gen_random_uuid(), -- 主键
user_id     UUID NOT NULL, -- 用户的主键
notice_type        NoticeType NOT NULL,  -- 用户QQ空间的消息是点赞还是他人评论了你之类的
message_type  MessageType NOT NULL, -- 提醒用户的小心是来自哪种，是新闻还是动态还是评论
message_id UUID NOT NULL, -- 对应消息的主键
have_read BOOLEAN DEFAULT false, -- 消息是否是已读消息，默认未读
create_time TIMESTAMP(0)     DEFAULT current_timestamp, -- 关注标签的时间
delete_time TIMESTAMP(0) -- 标记删除日期，被删除的元组不应出现在检索结果中
);


-- 新闻的推送临时储存
CREATE TABLE tbl_user_interest_news (
    id VARCHAR(20) PRIMARY KEY, -- 主键
    content VARCHAR(128), -- 推送的内容
    create_time TIMESTAMP(0)     DEFAULT current_timestamp -- 创建时间
);