DROP TABLE  IF EXISTS longan_jersey_permission_user;
CREATE TABLE longan_jersey_permission_user (
  id int auto_increment primary key,
  guid varchar(255) not null unique,
  createTime datetime,
  updateTime datetime,
  username varchar(255) not null unique,
  password varchar(255) not null,
  INDEX username_index (username)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;