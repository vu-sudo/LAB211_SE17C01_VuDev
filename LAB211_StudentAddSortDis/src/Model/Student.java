package Model;

public class Student {
    private String name;
    private Float mark;
    private String classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMark() {
        return mark;
    }

    public void setMark(Float mark) {
        this.mark = mark;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public Student(String name, Float mark, String classes) {
        this.name = name;
        this.mark = mark;
        this.classes = classes;
    }

}
