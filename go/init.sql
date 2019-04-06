create table users
(
  id    int auto_increment
    primary key,
  uname varchar(32) not null,
  created_at datetime not null ,
  updated_at datetime not null ,
  deleted_at datetime
)charset = utf8,engine=innodb;
