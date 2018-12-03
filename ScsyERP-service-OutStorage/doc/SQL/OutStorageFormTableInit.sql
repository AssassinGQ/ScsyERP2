drop table if exists t_out_storage_form;

create table t_out_storage_form (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  project       BIGINT(20)  NOT NULL                    COMMENT '所属项目',
  outstorage_status  VARCHAR(15) NOT NULL                COMMENT '入库单状态',
  outstorage_number  VARCHAR(30) NOT NULL                COMMENT '入库单号',
  outstorage_time    DATETIME    NOT NULL DEFAULT now() COMMENT '入库时间',
  warehouse     BIGINT(20)  NOT NULL                     COMMENT '入库仓库',
  truck         BIGINT(20)  NOT NULL                     COMMENT '入库时运输车辆',
  pick_worker   BIGINT(20)  NOT NULL                     COMMENT '提货人',
  lister        BIGINT(20)  NOT NULL                     COMMENT '制单人',
  drive_workers TEXT                                      COMMENT '行车工们',
  lift_workers  TEXT                                      COMMENT '起重工们',
  account_status VARCHAR(15)                              COMMENT '记账状态',
  total_amount  INT(4)                                    COMMENT '总件数',
  total_volume  DOUBLE(5,2)                               COMMENT '总体积',
  total_weight  DOUBLE(5,2)                               COMMENT '总重量',
  products      TEXT                                      COMMENT '明细',
  real_outstorage_weight  DOUBLE(5,2)                     COMMENT '实际出库重量',
  drive_worker_average_weight  DOUBLE(5,2)                COMMENT '行车工平均重量',
  lift_worker_average_weight  DOUBLE(5,2)                 COMMENT '起重工平均重量',
  PRIMARY KEY (id)
);

alter table t_out_storage_form comment '入库单信息表';

## 权限的初始化数据
insert into t_out_storage_form(corporation, project, outstorage_status, outstorage_number, outstorage_time, warehouse, truck, pick_worker, lister) values (1, 1, "正在入库", "rkh12345", now(), 1, 1, 1, 1);