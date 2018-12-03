#remote
#MmabCD123419930926
drop table if exists t_user;

create table t_user (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT    COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                     COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()      COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()      COMMENT '最后修改时间',
  delete_time   DATETIME                                  COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false      COMMENT '数据是否已经删除',
  user_name     VARCHAR(30) NOT NULL                     COMMENT '登录用户名',
  _password     VARCHAR(30) NOT NULL                      COMMENT '登录密码',
  phone         VARCHAR(11) NOT NULL                      COMMENT '手机号',
  vcode         VARCHAR(6)                                 COMMENT '验证码',
  vcode_time    DATETIME                                   COMMENT '验证码有效期',
  if_registered BOOLEAN     NOT NULL  DEFAULT false     COMMENT '是否已经注册',
  user_type     VARCHAR(20) NOT NULL                     COMMENT '用户类型',
  user_info     BIGINT(20)  NOT NULL                      COMMENT '用户信息',
  PRIMARY KEY (id)
);

alter table t_user comment '用户信息表';

## 用户的初始化数据(密码123456)
insert into t_user (corporation, user_name, _password, if_registered, phone, user_type, user_info) values (1, "superadmin", "{noop}123456", true, 18888888888, "Corporation", 1);
insert into t_user (corporation, user_name, _password, if_registered, phone, user_type, user_info) values (1, "hgq", "{noop}123456", true, 18868187538, "Corporation", 1);