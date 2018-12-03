drop table if exists t_material;

create table t_material (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  name          VARCHAR(30) NOT NULL                    COMMENT '名称',
  figure_number VARCHAR(30) NOT NULL                    COMMENT '图号',
  PRIMARY KEY (id)
);

alter table t_material comment '物料信息表';

## 权限的初始化数据
insert into t_material(corporation, name, figure_number) values (-1, "物料1", "th1234");
insert into t_material(corporation, name, figure_number) values (-1, "物料2", "th1235");