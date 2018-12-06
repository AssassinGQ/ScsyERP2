drop table if exists t_my_file;

create table t_my_file (
  id            BIGINT(20)  NOT NULL AUTO_INCREMENT   COMMENT 'ID',
  corporation   BIGINT(20)  NOT NULL                    COMMENT '所属承运方ID',
  #   create_time DATETIME  NOT NULL DEFAULT now()  COMMENT '创建时间',
  #   update_time DATETIME  NOT NULL DEFAULT now()  COMMENT '最后修改时间',
  create_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '创建时间',
  update_time   DATETIME    NOT NULL DEFAULT now()    COMMENT '最后修改时间',
  delete_time   DATETIME                                COMMENT '删除时间',
  is_deleted    BOOLEAN     NOT NULL DEFAULT false    COMMENT '数据是否已经删除',
  type          VARCHAR(20)  NOT NULL                 COMMENT '文件类型',
  name          VARCHAR(100) NOT NULL                 COMMENT '文件名称',
  extension     VARCHAR(20)  NOT NULL                 COMMENT '文件扩展名',
  content       TEXT          NOT NULL                 COMMENT '文件内容',
  PRIMARY KEY (id)
);

alter table t_my_file comment '存储文件信息表';

## 权限的初始化数据
insert into t_my_file(corporation, type, name, extension, content) values (-1, "图片", "图片1", "jpg", "12345");
insert into t_my_file(corporation, type, name, extension, content) values (-1, "图片", "图片2", "png", "54321");