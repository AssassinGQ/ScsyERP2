package cn.AssassinG.ScsyERP.common.enums;

import java.util.HashMap;
import java.util.Map;

public enum AccountStatus {
    WRZ("未入账", 0), YRZ("已入账", 1);
    private String Name;
    private Integer Value;

    private AccountStatus(String name, Integer value) {
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

    static Map<String, AccountStatus> enumMap = new HashMap<String, AccountStatus>();
    static{
        for(AccountStatus type : AccountStatus.values()){
            enumMap.put(type.getName(), type);
        }
    }
    public static AccountStatus getEnum(String name){
        return enumMap.get(name);
    }
    static Map<Integer, AccountStatus> intMap = new HashMap<>();
    static{
        for(AccountStatus type : AccountStatus.values()){
            intMap.put(type.getValue(), type);
        }
    }
    public static AccountStatus getEnum(Integer value){
        return intMap.get(value);
    }
}
