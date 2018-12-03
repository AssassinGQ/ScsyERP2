package cn.AssassinG.ScsyERP.Fee.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.BaseEntity;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;

import java.util.Date;
import java.util.Set;

public class OnTruckForm extends BaseEntity {
    private String FormNumber;
    private Long Project;
    private Long OutStorageForm;
    private Long TallyMan;
    private Long QualityTestMan;
    private String SignMan;
    private Date SignTime;
    private AccountStatus AccountStatus;
    private Set<Long> Pictures;

    public OnTruckForm() {
        super();
    }

    public String getFormNumber() {
        return FormNumber;
    }

    public void setFormNumber(String formNumber) {
        FormNumber = formNumber;
    }

    public Long getProject() {
        return Project;
    }

    public void setProject(Long project) {
        Project = project;
    }

    public Long getOutStorageForm() {
        return OutStorageForm;
    }

    public void setOutStorageForm(Long outStorageForm) {
        OutStorageForm = outStorageForm;
    }

    public Long getTallyMan() {
        return TallyMan;
    }

    public void setTallyMan(Long tallyMan) {
        TallyMan = tallyMan;
    }

    public Long getQualityTestMan() {
        return QualityTestMan;
    }

    public void setQualityTestMan(Long qualityTestMan) {
        QualityTestMan = qualityTestMan;
    }

    public String getSignMan() {
        return SignMan;
    }

    public void setSignMan(String signMan) {
        SignMan = signMan;
    }

    public Date getSignTime() {
        return SignTime;
    }

    public void setSignTime(Date signTime) {
        SignTime = signTime;
    }

    public cn.AssassinG.ScsyERP.common.enums.AccountStatus getAccountStatus() {
        return AccountStatus;
    }

    public void setAccountStatus(cn.AssassinG.ScsyERP.common.enums.AccountStatus accountStatus) {
        AccountStatus = accountStatus;
    }

    public Set<Long> getPictures() {
        return Pictures;
    }

    public void setPictures(Set<Long> pictures) {
        Pictures = pictures;
    }

    @Override
    public String toString() {
        return "OnTruckForm{" +
                "FormNumber='" + FormNumber + '\'' +
                ", Project=" + Project +
                ", OutStorageForm=" + OutStorageForm +
                ", TallyMan=" + TallyMan +
                ", QualityTestMan=" + QualityTestMan +
                ", SignMan='" + SignMan + '\'' +
                ", SignTime=" + SignTime +
                ", AccountStatus=" + AccountStatus +
                ", Pictures=" + Pictures +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
