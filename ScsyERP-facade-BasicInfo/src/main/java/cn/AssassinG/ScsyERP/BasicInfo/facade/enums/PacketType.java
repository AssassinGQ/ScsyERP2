package cn.AssassinG.ScsyERP.BasicInfo.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum PacketType {
    IronFrame("铁框架", 0), IronBracket("铁支架", 1), WoodBracket("木支架", 2), IronBox("铁箱", 3), WoodBox("木箱", 4), TieUp("捆扎", 5), None("裸装", 6);
    private String Name;
    private Integer Value;

    static Map<String, PacketType> enumMap = new HashMap<String, PacketType>();
    static{
        for(PacketType type : PacketType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private PacketType(String name, Integer value) {
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

    public static PacketType getEnum(String name){
        return enumMap.get(name);
    }
}
