package cn.AssassinG.ScsyERP.User.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserPermissionType {

    Include("Include", 0), Declude("Declude", 1);
    private String Name;
    private Integer Value;

    static Map<String, UserPermissionType> enumMap = new HashMap<String, UserPermissionType>();
    static{
        for(UserPermissionType type : UserPermissionType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private UserPermissionType(String name, Integer value) {
        Name = name;
        Value = value;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getValue() {
        return Value;
    }

    public void setValue(Integer value) {
        Value = value;
    }

    public static UserPermissionType getEnum(String name){
        return enumMap.get(name);
    }

    static Map<Integer, UserPermissionType> intMap = new HashMap<>();
    static{
        for(UserPermissionType type : UserPermissionType.values()){
            intMap.put(type.getValue(), type);
        }
    }
    public static UserPermissionType getEnum(Integer value){
        return intMap.get(value);
    }
}
