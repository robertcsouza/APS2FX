package Models;

public class Person {
    String name;
    int pos;
    String type;

    public Person() {
    }

    public Person(String name, int pos, String type) {
        this.name = name;
        this.pos = pos;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
