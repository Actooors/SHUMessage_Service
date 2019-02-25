CREATE TABLE tbl_users (
  users_id SERIAL PRIMARY KEY, -- 主键
  type INT NOT NULL, -- 登录使用的方式，学校接口还是手机号码，1是学校接口， 2是手机登录
  username VARCHAR(16) UNIQUE, -- 昵称
  student_id VARCHAR(16) NOT NULL UNIQUE, -- 学号
  password VARCHAR(128) NOT NULL, -- 密码
  real_name VARCHAR(16), -- 真实姓名
  department VARCHAR(16), -- 学院
  phone VARCHAR(16), -- 的手机号
  mail VARCHAR(32),  -- 邮箱
  label VARCHAR(64), -- 个性标签
  birthday VARCHAR(8), -- 生日
  sex VARCHAR(2), -- 性别
  location VARCHAR(16), -- 用户所在地
  school VARCHAR(16), -- 用户学校
  job VARCHAR(16), -- 用户行业
  identity INT DEFAULT 1, --用户的身份
  is_able_login BOOLEAN DEFAULT true, -- 是否允许登陆

  user_img VARCHAR(128), -- 用户头像
  user_big_img VARCHAR(128), -- 用户头像大图
  back_img VARCHAR(128), -- 背景图

  lasting_num INT DEFAULT 0, -- 连续登陆的日期，默认为0
  last_login_time TIMESTAMP(0), -- 上次登陆时间

  social_group_num INT DEFAULT 0, -- 我加入的圈子数
  follow_num INT DEFAULT 0, -- 我关注人的数量
  be_concerned_num INT DEFAULT 0, -- 关注我的人的数目
  my_social_group_num INT DEFAULT 0, -- 我创建的圈子的数目
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 每一条数据插入的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 用户连续登陆具体日期的情况表
CREATE TABLE tbl_users_and_date (
  users_and_date_id SERIAL PRIMARY KEY, -- 主键
  users_id INT NOT NULL, --当前用户的主键id
  create_time timestamp(0) DEFAULT current_timestamp, -- 用户当前登录的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 用户关注了哪些用户的中间表
CREATE TABLE tbl_users_and_users(
  users_and_users_id SERIAL PRIMARY KEY, -- 主键
  users_id INT NOT NULL, -- 关注其他人的当前用户的主键id
  other_user_id INT NOT NULL,-- 关注的其他人的用户id
  other_username VARCHAR(16) NOT NULL, -- 关注的其他人的用户昵称
  other_user_img VARCHAR(128) NOT NULL, -- 关注的其他人的用户图标
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 关注时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 数据分析出来的标签表
CREATE TABLE tbl_labels(
  labels_id SERIAL PRIMARY KEY, -- 主键
  labels_name VARCHAR(16) UNIQUE, -- 标签名
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 创建标签的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 新闻表
CREATE TABLE tbl_news(
  news_id SERIAL PRIMARY KEY, -- 主键
  news_name VARCHAR(32) NOT NULL, -- 新闻名字
  users_id INT NOT NULL, -- 发布者的主键id
  news_url VARCHAR(128), -- 新闻的url
  news_content TEXT, -- 新闻的内容，关于这个键值，请爬虫的同学不要把新闻的内容写入这里，
                     -- 此键值的作用是在发布新闻的人想要直接发布新闻的时候书写的内容
  news_description VARCHAR(256), -- 新闻的介绍，这个是管理员发布新闻的时候，文章前200字会存到这里
  img_url VARCHAR(2048), -- 新闻图片的地址
  type INT NOT NULL, -- 这里是设置新闻的返回格式，1是url，2是图片
  comment_num INT DEFAULT 0, -- 评论数
  like_num INT DEFAULT 0, -- 点赞数
  share_num INT DEFAULT 0, -- 转发数
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 发布新闻的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 新闻和标签的中间表，表示每个新闻有哪些标签
CREATE TABLE tbl_news_and_labels(
  news_and_labels_id SERIAL PRIMARY KEY, -- 主键
  news_id INT NOT NULL, -- 新闻的主键id
  labels_id INT NOT NULL, -- 标签的主键id
  labels_name VARCHAR(16) NOT NULL, -- 标签名
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 插入这条数据的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 对每一篇动态、新闻、评论、回复进行点赞的记录表
CREATE TABLE tbl_like(
  like_id SERIAL PRIMARY KEY, -- 主键
  id INT NOT NULL, -- 对应新闻、动态、评论的主键id
  type INT NOT NULL, -- 1表示这是新闻的点赞，2表示这是动态的点赞，
                     -- 3表示这是评论的点赞
  user_id INT NOT NULL, -- 对某一个新闻、动态、评论进行操作的人的主键id
  liked BOOLEAN DEFAULT false, -- 是否对当前的内容进行点赞
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 点赞的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 对每一篇动态、新闻进行转发的记录表
CREATE TABLE tbl_share(
  share_id SERIAL PRIMARY KEY, -- 主键
  id INT NOT NULL, -- 对应新闻、动态的主键id
  type INT NOT NULL, -- 1表示这是新闻的转发，2表示这是动态的转发
  user_id INT NOT NULL, -- 对某一个新闻、动态进行操作的人的主键id
  shared BOOLEAN NOT NULL, -- 是否转发
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 转发的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 对每一篇动态、新闻、评论、回复的评论表
CREATE TABLE tbl_discuss(
  discuss_id SERIAL PRIMARY KEY, -- 主键
  id INT NOT NULL, -- 对应新闻或者动态的主键id
  type INT NOT NULL, -- 1表示这是新闻的评论，2表示这是动态的评论，
                     -- 3表示这是评论的评论
  comment_id INT, -- 当type为3的时候，为了让每一个评论的回复和那些回复的回复都出现在这个评论下
                  -- 我在这种时候让他们都维护一个评论的id，这样就不存在对回复的回复无限循环了
  users_id INT NOT NULL, -- 对某一个新闻、动态、评论、回复进行操作的人的主键id
  content VARCHAR(64), -- 评论的内容
  reply_num INT DEFAULT 0, -- 你这条评论或者回复被别人回复的数目
  reply_like_num INT DEFAULT 0, -- 这条评论或者回复被点赞的数目
  img_url VARCHAR(2048), -- 评论或回复图片的地址
  discussed BOOLEAN NOT NULL, -- 是否评论
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 评论的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 用户发布动态或者圈子里面的动态的表
CREATE TABLE tbl_dynamics(
  dynamics_id SERIAL PRIMARY KEY, -- 主键
  users_id VARCHAR(16) NOT NULL, -- 发布者的主键id
  dynamics_content TEXT, -- 动态的内容
  dynamics_description VARCHAR(256), -- 动态的介绍，文章前200字会存到这里
  img_url VARCHAR(2048), -- 动态图片的地址
  type INT NOT NULL, -- 这里是动态的格式，1是原创的的，2是某个圈子里面的
  comment_num INT DEFAULT 0, -- 评论数
  like_num INT DEFAULT 0, -- 点赞数
  share_num INT DEFAULT 0, -- 转发数
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 发布动态的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 圈子表
CREATE TABLE tbl_groups(
  groups_id SERIAL PRIMARY KEY, -- 主键
  groups_name VARCHAR(16) UNIQUE, -- 圈子名字
  description VARCHAR(256), -- 圈子的简介
  groups_label INT NOT NULL, -- 圈子的标签，id日后统一选择
  users_id INT NOT NULL, -- 创建圈子的人的主键id
  people_num INT DEFAULT 1, -- 圈子内人的数目，默认情况下只有自己
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 创建圈子的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);

-- 用户关注了哪些圈子的中间表
CREATE TABLE tbl_users_and_groups(
  users_and_groups_id SERIAL PRIMARY KEY, -- 主键
  users_id INT NOT NULL, -- 关注其他人的当前用户的主键id
  other_group_id INT NOT NULL, -- 关注的其他人的圈子id
  other_group_img VARCHAR(128) NOT NULL, -- 其他圈子的圈子图片
  other_group_name VARCHAR(16) NOT NULL, -- 关注的其他圈子的名字
  create_time TIMESTAMP(0) DEFAULT current_timestamp, -- 关注圈子的时间
  delete_time TIMESTAMP(0) -- 是否被删除如果，如果删了就不是null了
);