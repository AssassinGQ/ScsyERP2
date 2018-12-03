package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class Material extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String Name;
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String FigureNumber;

    public Material() {
        super();
    }

    public String getFigureNumber() {
        return FigureNumber;
    }

    public void setFigureNumber(String figureNumber) {
        FigureNumber = figureNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Override
    public String toString() {
        return "Material{" +
                "Name='" + Name + '\'' +
                ", FigureNumber='" + FigureNumber + '\'' +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
