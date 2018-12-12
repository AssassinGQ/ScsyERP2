package cn.AssassinG.ScsyERP.User.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum AdminDeptType {

    WarehouseAdmin("仓库管理员", 0), ProjectAdmin("项目管理员", 1), FinancialAdmin("财务管理员", 2);
    private String Name;
    private Integer Value;

    static Map<String, AdminDeptType> enumMap = new HashMap<String, AdminDeptType>();
    static{
        for(AdminDeptType type : AdminDeptType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private AdminDeptType(String name, Integer value) {
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

    public static AdminDeptType getEnum(String name){
        return enumMap.get(name);
    }

    static Map<Integer, AdminDeptType> intMap = new HashMap<>();
    static{
        for(AdminDeptType type : AdminDeptType.values()){
            intMap.put(type.getValue(), type);
        }
    }
    public static AdminDeptType getEnum(Integer value){
        return intMap.get(value);
    }
}
