package cn.AssassinG.ScsyERP.File.facade.entity;

import cn.AssassinG.ScsyERP.File.facade.enums.FileType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

@Entity
public class MyFile extends BaseEntity {
    private static final long serialVersionUID = 5316079170608205903L;
    @Valid(varType = Valid.VarType.Other)
    private FileType Type;
    @Valid(varType = Valid.VarType.String, maxLength = 100)
    private String Name;
    @Valid(varType = Valid.VarType.String, maxLength = 10)
    private String Extension;
    @Valid(varType = Valid.VarType.Other)
    private String Content;

    public MyFile() {
        super();
    }

    @JSONField(serialize = false)
    public FileType getType() {
        return Type;
    }

    @JSONField(deserialize = false)
    public void setType(FileType type) {
        Type = type;
    }

    @JSONField(name = "type")
    public String getFileTypeName(){
        if(Type != null)
            return this.Type.getName();
        else
            return "";
    }

    @JSONField(name = "type")
    public void setFileTypeName(String name){
        this.Type = FileType.getEnum(name);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setContent(File file) {
        if(file == null && file.isDirectory()){
            Content = null;
        }else{
            FileInputStream inputStream = null;
            try{
                inputStream = new FileInputStream(file);
                byte[] buffer = new byte[(int)file.length()];
                inputStream.read(buffer);
                Content = Base64.getEncoder().encodeToString(buffer);
            }catch(Exception e){
                Content = null;
            }finally {
                try{
                    if(inputStream != null)
                        inputStream.close();
                }catch(Exception e){}
            }
        }
    }

    @Override
    public String toString() {
        return "MyFile{" +
                "Type=" + Type +
                ", Name='" + Name + '\'' +
                ", Extension='" + Extension + '\'' +
                ", Content='" + Content + '\'' +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
