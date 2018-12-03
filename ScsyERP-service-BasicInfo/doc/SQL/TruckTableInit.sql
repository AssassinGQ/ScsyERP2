drop table if exists t_truck;

create table t_truck (
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
  car_number    VARCHAR(30) NOT NULL                    COMMENT '车牌号',
  car_license   VARCHAR(30)                              COMMENT '车辆行驶证号码',
  car_id        VARCHAR(30)                              COMMENT '车辆识别号',
  affiliation   VARCHAR(50)                              COMMENT '所属单位',
  driver        BIGINT(20)                               COMMENT '默认驾驶员信息主键',
  PRIMARY KEY (id)
);

alter table t_truck comment '车辆信息表';

## 权限的初始化数据
insert into t_truck(corporation, name, phone, car_number) values (-1, "车1", 18811111111, "川C1234");
insert into t_truck(corporation, name, phone, car_number) values (-1, "车2", 18811111111, "浙A1234");