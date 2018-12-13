package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

import javax.persistence.Entity;

@Entity
public class User_Role extends BaseEntity {
    private static final long serialVersionUID = -1855395697947087939L;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long UserId;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long RoleId;

    public User_Role() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "UserId=" + UserId +
                ", RoleId=" + RoleId +
                '}';
    }
}
