package cn.AssassinG.ScsyERP.InStorage.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum InStorageFormStatus {
    Workging("正在入库", 0), Done("入库完成", 1);
    private String Name;
    private Integer Value;

    static Map<String, InStorageFormStatus> enumMap = new HashMap<String, InStorageFormStatus>();
    static{
        for(InStorageFormStatus type : InStorageFormStatus.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private InStorageFormStatus(String name, Integer value) {
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

    public static InStorageFormStatus getEnum(String name){
        return enumMap.get(name);
    }
}
