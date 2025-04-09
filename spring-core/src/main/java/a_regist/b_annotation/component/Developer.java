package a_regist.b_annotation.component;

public class Developer {
    
    private final String name;

    public Developer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Developer{" +
            "name='" + name + '\'' +
            '}';
    }
}
