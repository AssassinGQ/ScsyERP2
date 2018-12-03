package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class Role_Permission extends BaseEntity {
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long RoleId;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 50)
    private Long PermissionId;

    public Role_Permission() {
    }

    public Long getRoleId() {
        return RoleId;
    }

    public void setRoleId(Long roleId) {
        RoleId = roleId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }
}
