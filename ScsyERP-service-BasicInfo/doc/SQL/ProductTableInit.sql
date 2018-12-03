drop table if exists t_product;

create table t_product (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  project       BIGINT(20)  NOT NULL                    COMMENT '所属工程',
  material      BIGINT(20)  NOT NULL                    COMMENT '所属物料',
  name          VARCHAR(30) NOT NULL                    COMMENT '名称',
  status        VARCHAR(15) NOT NULL                    COMMENT '货物状态',
  packet_number VARCHAR(30) NOT NULL                    COMMENT '包号',
  warehouse     BIGINT(20)  NOT NULL                    COMMENT '仓库',
  warehouse_location  VARCHAR(30)                        COMMENT '仓库定位',
  in_storage_form     BIGINT(20)  NOT NULL               COMMENT '入库单',
  out_storage_form    BIGINT(20)                          COMMENT '出库单',
  packet_type   VARCHAR(15) NOT NULL                     COMMENT '包装类型',
  width         DOUBLE(5,2)                               COMMENT '货物宽度',
  length        DOUBLE(5,2)                               COMMENT '货物长度',
  height        DOUBLE(5,2)                               COMMENT '货物高度',
  weight        DOUBLE(5,2)                               COMMENT '货物重量',
  volume        DOUBLE(5,2)                               COMMENT '货物体积',
  PRIMARY KEY (id)
);

alter table t_product comment '货物信息表';

## 权限的初始化数据
insert into t_product(corporation, name, project, material, status, packet_number, warehouse, in_storage_form, packet_type) values (-1, "货物1", 1, 1, "已出库", "bh1234", 1, 1, "裸装");
insert into t_product(corporation, name, project, material, status, packet_number, warehouse, in_storage_form, packet_type) values (-1, "货物2", 1, 1, "已出库", "bh1234", 1, 1, "裸装");