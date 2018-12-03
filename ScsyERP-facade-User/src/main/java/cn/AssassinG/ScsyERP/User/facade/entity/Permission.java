package cn.AssassinG.ScsyERP.User.facade.entity;

import cn.AssassinG.ScsyERP.common.annitations.Valid;
import cn.AssassinG.ScsyERP.common.entity.BaseEntity;

public class Permission extends BaseEntity {
    @Valid(varType = Valid.VarType.String, maxLength = 50)
    private String PermissionName;
    @Valid(varType = Valid.VarType.String, nullAble = true, maxLength = 50)
    private String PermissionDesc;

    public Permission() {
    }

    public String getPermissionName() {
        return PermissionName;
    }

    public void setPermissionName(String permissionName) {
        PermissionName = permissionName;
    }

    public String getPermissionDesc() {
        return PermissionDesc;
    }

    public void setPermissionDesc(String permissionDesc) {
        PermissionDesc = permissionDesc;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "PermissionName='" + PermissionName + '\'' +
                ", PermissionDesc='" + PermissionDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (PermissionName != null ? !PermissionName.equals(that.PermissionName) : that.PermissionName != null)
            return false;
        return PermissionDesc != null ? PermissionDesc.equals(that.PermissionDesc) : that.PermissionDesc == null;
    }

    @Override
    public int hashCode() {
        int result = PermissionName != null ? PermissionName.hashCode() : 0;
        result = 31 * result + (PermissionDesc != null ? PermissionDesc.hashCode() : 0);
        return result;
    }
}
