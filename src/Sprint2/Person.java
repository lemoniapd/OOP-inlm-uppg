package Sprint2;

public class Person {
    private String IDnr;
    private String name;

    public Person(String IDnr, String name) {
        this.IDnr = IDnr;
        this.name = name;
    }

    public String getIDnr() {
        return IDnr;
    }

    public void setIDnr(String IDnr) {
        this.IDnr = IDnr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
