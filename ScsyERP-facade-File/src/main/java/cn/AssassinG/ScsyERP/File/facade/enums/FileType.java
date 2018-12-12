package cn.AssassinG.ScsyERP.File.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum FileType {
    IMAGE("图片", 0), VIDEO("视频", 1), OTHER("其他", 2);
    private String Name;
    private Integer Value;

    static Map<String, FileType> enumMap = new HashMap<String, FileType>();
    static{
        for(FileType type : FileType.values()){
            enumMap.put(type.getName(), type);
        }
    }

    private FileType(String name, Integer value) {
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

    public static FileType getEnum(String name){
        return enumMap.get(name);
    }
    static Map<Integer, FileType> intMap = new HashMap<>();
    static{
        for(FileType type : FileType.values()){
            intMap.put(type.getValue(), type);
        }
    }
    public static FileType getEnum(Integer value){
        return intMap.get(value);
    }
}
