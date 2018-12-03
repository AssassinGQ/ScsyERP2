package cn.AssassinG.ScsyERP.User.facade.service;

import cn.AssassinG.ScsyERP.User.facade.entity.Permission;
import cn.AssassinG.ScsyERP.User.facade.entity.Role;
import cn.AssassinG.ScsyERP.User.facade.entity.User;
import cn.AssassinG.ScsyERP.common.core.service.BaseService;

import java.util.List;
import java.util.Set;

public interface UserServiceFacade extends BaseService<User> {
    User findUserByUname(String username);
    User findUserByPhone(String phone);
    String getVcode(String phone);
    boolean login(String userName, String password);
    void ChangePSW(String phone, String vcode, String password);
    void ChangeUserName(Long userId, String newUserName);
    void ChangeUserName(User user, String newUserName);
    void ChangePhone(Long userId, String newPhone);
    void ChangePhone(User user, String newPhone);

    Set<Role> findUserRoles(Long userid);
    List<Role> findAllRoles();
    Role findRoleByRoleName(String rolename);
    Set<Permission> findUserPermissions(Long userid);
    Set<Permission> findRolePermissions(Long roleid);
    Set<Permission> findFatherRolePermissions(Long roleid);
    List<Permission> findAllPermission();
    boolean addPermissionToRole(Long roleid, Long permissionid);
    boolean removePermissionFromRole(Long roleid, Long permissionid);
    boolean addUserRole(Long userid, Long roleid);
    boolean removeUserRole(Long userid, Long roleid);
}
