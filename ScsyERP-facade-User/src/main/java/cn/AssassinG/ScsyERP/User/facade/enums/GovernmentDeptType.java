package cn.AssassinG.ScsyERP.User.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum GovernmentDeptType {

    YGB("TransportDept", 0), JJB("TrafficPoliceDept", 1), HBB("EnvironmentalDept", 2), XFB("FireDept", 3), AJB("SafetySupervisionDept", 4);
    private String Name;
    private Integer Value;

    static Map<String, GovernmentDeptType> enumMap = new HashMap<String, GovernmentDeptType>();
    static{
        for(GovernmentDeptType type : GovernmentDeptType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private GovernmentDeptType(String name, Integer value) {
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

    public static GovernmentDeptType getEnum(String name){
        return enumMap.get(name);
    }
}
