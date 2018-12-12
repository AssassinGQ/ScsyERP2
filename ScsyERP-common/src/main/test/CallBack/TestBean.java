package CallBack;

public class TestBean {
    private String name;
    private Long id;
    private Double value;
    private TestEnum testEnum;

    public TestBean() {
    }

    public TestBean(String name, Long id, Double value, TestEnum testEnum) {
        this.name = name;
        this.id = id;
        this.value = value;
        this.testEnum = testEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TestEnum getTestEnum() {
        return testEnum;
    }

    public void setTestEnum(TestEnum testEnum) {
        this.testEnum = testEnum;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", value=" + value +
                '}';
    }
}
