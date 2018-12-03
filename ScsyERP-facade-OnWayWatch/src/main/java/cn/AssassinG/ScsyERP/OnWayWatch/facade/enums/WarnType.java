package cn.AssassinG.ScsyERP.OnWayWatch.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum WarnType {
    Lock("锁异常", 1), Leak("泄露异常", 2), Tire("胎压异常", 3), Fuel("油量异常", 4),
    OverSpeed("超速异常", 5), Park("停车异常", 6), FatigueDrive("疲劳驾驶异常", 7), SuddenBrake("急刹车异常", 8),
    SuddenAccelerate("急加速异常", 9), Accident("事故异常", 10), OverLoad("超载异常", 11);
    private String Name;
    private Integer Value;

    static Map<String, WarnType> enumMap = new HashMap<String, WarnType>();
    static{
        for(WarnType type : WarnType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private WarnType(String name, Integer value) {
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

    public static WarnType getEnum(String name){
        return enumMap.get(name);
    }
}
