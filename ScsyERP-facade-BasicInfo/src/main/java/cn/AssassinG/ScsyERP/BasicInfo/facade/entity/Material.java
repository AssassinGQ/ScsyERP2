package cn.AssassinG.ScsyERP.BasicInfo.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.UnLoginableEntity;

import javax.persistence.Entity;

@Entity
public class Material extends UnLoginableEntity {
    private static final long serialVersionUID = 1627244813115392117L;
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

    @Override
    public String toString() {
        return "Material{" +
                "FigureNumber='" + FigureNumber + '\'' +
                ", Name='" + Name + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
