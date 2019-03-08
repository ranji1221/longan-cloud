DROP TABLE  IF EXISTS longan_jersey_permission_user;
DROP TABLE  IF EXISTS longan_jersey_permission_role;
DROP TABLE  IF EXISTS longan_jersey_permission_permission;
DROP TABLE  IF EXISTS longan_jersey_permission_user_role;
DROP TABLE  IF EXISTS longan_jersey_permission_role_permission;
#权限模块-用户表
create table longan_jersey_permission_user(
  id bigint auto_increment,
  username varchar(100) not null unique,
  password varchar(100),
  salt varchar(100),
  locked bool default false,
  createTime datetime,
  updateTime datetime,
  index idx_permission_user_username(username),
  constraint pk_longan_jersey_permission_user primary key(id)
) charset=utf8 engine=InnoDB;

#权限模块-角色表
create table longan_jersey_permission_role (
  id bigint auto_increment,
  role varchar(100) not null unique,
  description varchar(100),
  available bool default false,
  createTime datetime,
  updateTime datetime,
  index idx_permission_role_role(role), 
  constraint pk_longan_jersey_permission_role primary key(id)
) charset=utf8 engine=InnoDB;

#权限模块-权限表
create table longan_jersey_permission_permission (
  id bigint auto_increment,
  permission varchar(100) not null unique,
  description varchar(100),
  available bool default false,
  createTime datetime,
  updateTime datetime,
  index idx_permission_permission_permission(permission),
  constraint pk_longan_jersey_permission_permission primary key(id)
) charset=utf8 engine=InnoDB;

#权限模块-用户角色关系表
create table longan_jersey_permission_user_role (
  user_id bigint,
  role_id bigint,
  constraint pk_longan_jersey_permission_user_role primary key(user_id, role_id)
) charset=utf8 engine=InnoDB;

#权限模块-角色权限关系表
create table longan_jersey_permission_role_permission (
  role_id bigint,
  permission_id bigint,
  constraint pk_longan_jersey_permission_role_permission primary key(role_id, permission_id)
) charset=utf8 engine=InnoDB;