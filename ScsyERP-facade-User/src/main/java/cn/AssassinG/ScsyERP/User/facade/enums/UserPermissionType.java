package cn.AssassinG.ScsyERP.User.facade.enums;

public enum UserPermissionType {

    Include("Include", 0), Declude("Declude", 1);
    private String Name;
    private Integer Value;

    private UserPermissionType(String name, Integer value) {
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
}
