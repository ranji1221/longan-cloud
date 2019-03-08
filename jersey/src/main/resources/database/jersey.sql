#==========权限模块开始=================================================
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
  userId bigint,
  roleId bigint,
  constraint pk_longan_jersey_permission_user_role primary key(userId, roleId)
) charset=utf8 engine=InnoDB;

#权限模块-角色权限关系表
create table longan_jersey_permission_role_permission (
  roleId bigint,
  permissionId bigint,
  constraint pk_longan_jersey_permission_role_permission primary key(roleId, permissionId)
) charset=utf8 engine=InnoDB;

#模拟数据
#模拟用户数据
insert into longan_jersey_permission_user(username, password, salt, locked, createTime, updateTime) values("zhangsan","123456","xk123hj", 0, now(), now());
insert into longan_jersey_permission_user(username, password, salt, locked, createTime, updateTime) values("lisi","654321","xk123hj", 0, now(), now());
insert into longan_jersey_permission_user(username, password, salt, locked, createTime, updateTime) values("wangwu","456123","xk123hj", 0, now(), now());
insert into longan_jersey_permission_user(username, password, salt, locked, createTime, updateTime) values("zhaoliu","123456","xk123hj", 0, now(), now());
insert into longan_jersey_permission_user(username, password, salt, locked, createTime, updateTime) values("wangba","789456","xk123hj", 0, now(), now());

#模拟角色数据
insert into longan_jersey_permission_role(role, description, available,createTime,updateTime) values("admin","管理员",1,now(),now());
insert into longan_jersey_permission_role(role, description, available,createTime,updateTime) values("manager","经理",1,now(),now());
insert into longan_jersey_permission_role(role, description, available,createTime,updateTime) values("emp","员工",1,now(),now());
insert into longan_jersey_permission_role(role, description, available,createTime,updateTime) values("teacher","教师",1,now(),now());
insert into longan_jersey_permission_role(role, description, available,createTime,updateTime) values("student","学生",1,now(),now());

#模拟权限数据
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("user:create","添加用户",1,now(),now());
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("user:delete","删除用户",1,now(),now());
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("article:create","添加文章",1,now(),now());
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("article:delete","删除文章",1,now(),now());
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("task:create","添加任务",1,now(),now());
insert into longan_jersey_permission_permission(permission, description, available,createTime,updateTime) values("task:delete","删除任务",1,now(),now());

#给用户添加角色
insert into longan_jersey_permission_user_role(userId,roleId) values(1,1);
insert into longan_jersey_permission_user_role(userId,roleId) values(1,2);
insert into longan_jersey_permission_user_role(userId,roleId) values(1,3);
insert into longan_jersey_permission_user_role(userId,roleId) values(2,1);
insert into longan_jersey_permission_user_role(userId,roleId) values(2,2);

#给角色授权
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(1,1);
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(1,2);
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(1,3);
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(1,4);
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(2,1);
insert into longan_jersey_permission_role_permission(roleId,permissionId) values(2,2);

#查询某员工所拥有的角色
select r.* from longan_jersey_permission_user u, longan_jersey_permission_role r,longan_jersey_permission_user_role ur where u.username='zhangsan' and u.id=ur.userId and r.id=ur.roleId;
#查询某员工所拥有的权限
select p.* from
		longan_jersey_permission_user u, 
		longan_jersey_permission_role r,
		longan_jersey_permission_permission p,
		longan_jersey_permission_user_role ur,
		longan_jersey_permission_role_permission rp
		where 
		u.username='zhangsan'
		and u.id=ur.userId 
		and r.id=ur.roleId 
		and r.id=rp.roleId 
		and p.id=rp.permissionId;

#==========权限模块结束=================================================
