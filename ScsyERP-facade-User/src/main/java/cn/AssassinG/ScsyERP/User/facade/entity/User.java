package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.UserType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class User extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String UserName;
    @Valid(varType = Valid.VarType.String, maxLength = 30)
    private String PassWord;
    @Valid(varType = Valid.VarType.String, minLength = 11, maxLength = 11)
    private String Phone;
    @Valid(varType = Valid.VarType.String, nullAble = true, minLength = 6, maxLength = 6)
    private String Vcode;
    private Date VcodeTime;
    @Valid(varType = Valid.VarType.Other)
    private Boolean IfRegistered;
    @Valid(varType = Valid.VarType.Other)
    private UserType UserType;
    @Valid(varType = Valid.VarType.Number, minValue = -1)
    private Long UserInfo;

    public User() {
        super();
        this.IfRegistered = false;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getVcode() {
        return Vcode;
    }

    public void setVcode(String vcode) {
        Vcode = vcode;
    }

    public Date getVcodeTime() {
        return VcodeTime;
    }

    public void setVcodeTime(Date vcodeTime) {
        VcodeTime = vcodeTime;
    }

    public Boolean getIfRegistered() {
        return IfRegistered;
    }

    public void setIfRegistered(Boolean ifRegistered) {
        IfRegistered = ifRegistered;
    }

    public UserType getUserType() {
        return UserType;
    }

    public void setUserType(UserType userType) {
        UserType = userType;
    }

    public Long getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(Long userInfo) {
        UserInfo = userInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Vcode='" + Vcode + '\'' +
                ", VcodeTime=" + VcodeTime +
                ", IfRegistered=" + IfRegistered +
                ", UserType=" + UserType +
                ", UserInfo=" + UserInfo +
                ", Id=" + Id +
                ", CreateTime=" + CreateTime +
                ", UpdateTime=" + UpdateTime +
                ", DeleteTime=" + DeleteTime +
                ", IfDeleted=" + IfDeleted +
                '}';
    }
}
