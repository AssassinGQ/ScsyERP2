drop table if exists t_workshop;

create table t_workshop (
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
  manufacturer  BIGINT(20)                               COMMENT '所属生产厂家',
  man_name      VARCHAR(20)                              COMMENT '车间联系人姓名',
  PRIMARY KEY (id)
);

alter table t_workshop comment '生产车间信息表';

## 权限的初始化数据
insert into t_workshop(corporation, name, phone, address, manufacturer) values (-1, "生产车间1", 18811111111, "浙江绍兴", 1);
insert into t_workshop(corporation, name, phone, address, manufacturer) values (-1, "生产车间2", 18811111111, "湖北武汉", 1);