package cn.AssassinG.ScsyERP.OnWayWatch.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum WarnStatus {
    Created("已创建", 0), Pushed("已推送", 1), Received("司机已收到", 2), Handled("司机已处理并上传", 3);
    private String Name;
    private Integer Value;

    static Map<String, WarnStatus> enumMap = new HashMap<String, WarnStatus>();
    static{
        for(WarnStatus type : WarnStatus.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private WarnStatus(String name, Integer value) {
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

    public static WarnStatus getEnum(String name){
        return enumMap.get(name);
    }
}
