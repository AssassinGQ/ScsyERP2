drop table if exists t_project;

create table t_project (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME   NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME   NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  name          VARCHAR(30) NOT NULL                   COMMENT '名称',
  project_number  VARCHAR(30)  NOT NULL                 COMMENT '工程号',
  customer      BIGINT(20)  NOT NULL                    COMMENT '客户主键',
  manufacturer  BIGINT(20)  NOT NULL                    COMMENT '生产厂家主键',
  consignee     BIGINT(20)  NOT NULL                    COMMENT '收货方主键',
  admin         BIGINT(20)  NOT NULL                    COMMENT '项目管理员主键',
  materials     TEXT                                     COMMENT '物料们主键',
  PRIMARY KEY (id)
);

alter table t_project comment '项目信息表';

## 权限的初始化数据
insert into t_project(corporation, name, project_number, customer, manufacturer, consignee, admin) values (-1, "项目1", "xm1", 1, 1, 1, 1);
insert into t_project(corporation, name, project_number, customer, manufacturer, consignee, admin) values (-1, "项目2", "xm1", 1, 1, 1, 1);