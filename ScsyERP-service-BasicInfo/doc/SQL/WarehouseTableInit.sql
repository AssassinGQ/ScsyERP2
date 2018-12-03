drop table if exists t_warehouse;

create table t_warehouse (
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
  address       VARCHAR(100) NOT NULL                   COMMENT '地址',
  admin         BIGINT(20)  NOT NULL                    COMMENT '对应仓库管理员',
  drive_workers TEXT                                     COMMENT '仓库拥有的行车工信息主键JsonArray字符串',
  lift_workers  TEXT                                     COMMENT '仓库拥有的起重工信息主键JsonArray字符串',
  PRIMARY KEY (id)
);

alter table t_warehouse comment '仓库信息表';

## 权限的初始化数据
insert into t_warehouse(corporation, name, phone, address, admin) values (-1, "仓库1", 18811111111, "浙江绍兴", 1);
insert into t_warehouse(corporation, name, phone, address, admin) values (-1, "仓库2", 18811111111, "湖北武汉", 1);