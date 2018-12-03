package cn.AssassinG.ScsyERP.User.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum AdminDeptType {

    WarehouseAdmin("WarehouseAdmin", 0), ProjectAdmin("ProjectAdmin", 1), FinancialAdmin("FinancialAdmin", 2);
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
}
