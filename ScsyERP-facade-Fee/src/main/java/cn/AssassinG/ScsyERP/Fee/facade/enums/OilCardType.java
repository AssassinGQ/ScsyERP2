package cn.AssassinG.ScsyERP.Fee.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum OilCardType {
    ChinaSY("中国石油", 0), ChinaSH("中国石化", 1);
    private String Name;
    private Integer Value;

    static Map<String, OilCardType> enumMap = new HashMap<String, OilCardType>();
    static{
        for(OilCardType type : OilCardType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private OilCardType(String name, Integer value) {
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

    public static OilCardType getEnum(String name){
        return enumMap.get(name);
    }
}
