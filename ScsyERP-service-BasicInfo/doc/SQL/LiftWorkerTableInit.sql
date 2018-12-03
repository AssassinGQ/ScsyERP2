drop table if exists t_lift_worker;

create table t_lift_worker (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  name          VARCHAR(30) NOT NULL                    COMMENT '名称',
  phone         VARCHAR(11)                             COMMENT '联系方式',
  PRIMARY KEY (id)
);

alter table t_lift_worker comment '起重工信息表';

## 权限的初始化数据
insert into t_lift_worker(corporation, name, phone) values (-1, "起重工1", 18811111111);
insert into t_lift_worker(corporation, name, phone) values (-1, "起重工2", 18811111111);