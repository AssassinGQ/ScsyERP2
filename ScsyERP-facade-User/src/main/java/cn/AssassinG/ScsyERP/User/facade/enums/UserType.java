package cn.AssassinG.ScsyERP.User.facade.enums;

import java.util.HashMap;
import java.util.Map;

public enum UserType {

    Corporation(cn.AssassinG.ScsyERP.User.facade.entity.Corporation.class.getSimpleName(), 0, cn.AssassinG.ScsyERP.User.facade.entity.Corporation.class.getName()),
    Government(cn.AssassinG.ScsyERP.User.facade.entity.Government.class.getSimpleName(), 1, cn.AssassinG.ScsyERP.User.facade.entity.Government.class.getName()),
    Admin(cn.AssassinG.ScsyERP.User.facade.entity.Admin.class.getSimpleName(), 2, cn.AssassinG.ScsyERP.User.facade.entity.Admin.class.getName()),
    Driver(cn.AssassinG.ScsyERP.User.facade.entity.Driver.class.getSimpleName(), 3, cn.AssassinG.ScsyERP.User.facade.entity.Driver.class.getName()),
    Escort(cn.AssassinG.ScsyERP.User.facade.entity.Escort.class.getSimpleName(), 4, cn.AssassinG.ScsyERP.User.facade.entity.Escort.class.getName()),
    Customer(cn.AssassinG.ScsyERP.User.facade.entity.Customer.class.getSimpleName(), 5, cn.AssassinG.ScsyERP.User.facade.entity.Customer.class.getName()),
    Manufacturer(cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer.class.getSimpleName(), 6, cn.AssassinG.ScsyERP.User.facade.entity.Manufacturer.class.getName()),
    Consignee(cn.AssassinG.ScsyERP.User.facade.entity.Consignee.class.getSimpleName(), 7, cn.AssassinG.ScsyERP.User.facade.entity.Consignee.class.getName());

    private String Name;
    private Integer Value;
    private String ClassName;

    static Map<String, UserType> NameMap = new HashMap<String, UserType>();
    static{
        for(UserType type : UserType.values()){
            NameMap.put(type.getName(), type);
        }
    }

    static Map<String, UserType> ClassNameMap = new HashMap<String, UserType>();
    static{
        for(UserType type : UserType.values()){
            ClassNameMap.put(type.getClassName(), type);
        }
    }


    private UserType(String name, Integer value, String className) {
        Name = name;
        Value = value;
        ClassName = className;
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

    public String getClassName() {
        return ClassName;
    }

    public void setClassName(String className) {
        ClassName = className;
    }

    public static UserType getEnumByName(String name){
        return NameMap.get(name);
    }

    public static UserType getEnumByClassName(String className){
        return ClassNameMap.get(className);
    }
}
