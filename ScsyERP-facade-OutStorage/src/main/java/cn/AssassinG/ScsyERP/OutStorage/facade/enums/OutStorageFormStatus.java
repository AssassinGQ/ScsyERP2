package cn.AssassinG.ScsyERP.OutStorage.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutStorageFormStatus {
    Workging("正在出库", 0), Done("出库完成", 1);
    private String Name;
    private Integer Value;

    static Map<String, OutStorageFormStatus> enumMap = new HashMap<String, OutStorageFormStatus>();
    static{
        for(OutStorageFormStatus type : OutStorageFormStatus.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private OutStorageFormStatus(String name, Integer value) {
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

    public static OutStorageFormStatus getEnum(String name){
        return enumMap.get(name);
    }
}
