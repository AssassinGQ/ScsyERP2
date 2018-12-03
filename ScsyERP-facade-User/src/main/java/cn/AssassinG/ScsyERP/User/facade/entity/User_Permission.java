package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.User.facade.enums.UserPermissionType;
import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class User_Permission extends BaseEntity {
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long UserId;
    @Valid(varType = Valid.VarType.Number, minLength = 20, maxLength = 20)
    private Long PermissionId;
    @Valid(varType = Valid.VarType.Other)
    private UserPermissionType Type;

    public User_Permission() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
    }

    public Long getPermissionId() {
        return PermissionId;
    }

    public void setPermissionId(Long permissionId) {
        PermissionId = permissionId;
    }

    public UserPermissionType getType() {
        return Type;
    }

    public void setType(UserPermissionType type) {
        Type = type;
    }
}
