package cn.AssassinG.ScsyERP.Fee.facade.entity;

import cn.AssassinG.ScsyERP.common.entity.FormEntity;
import cn.AssassinG.ScsyERP.common.enums.AccountStatus;
import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Set;

@Entity
public class OnTruckForm extends FormEntity {
    private static final long serialVersionUID = -8479773852205967905L;
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

    @JSONField(serialize = false)
    public cn.AssassinG.ScsyERP.common.enums.AccountStatus getAccountStatus() {
        return AccountStatus;
    }

    @JSONField(deserialize = false)
    public void setAccountStatus(cn.AssassinG.ScsyERP.common.enums.AccountStatus accountStatus) {
        AccountStatus = accountStatus;
    }

    @JSONField(name = "accountStatus")
    public String getAccountStatusName(){
        if(AccountStatus != null)
            return this.AccountStatus.getName();
        else
            return "";
    }

    @JSONField(name = "accountStatus")
    public void setAccountStatusName(String name){
        this.AccountStatus = cn.AssassinG.ScsyERP.common.enums.AccountStatus.getEnum(name);
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
                ", IfCompleted=" + IfCompleted +
                ", Id=" + Id +
                ", Corporation=" + Corporation +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
