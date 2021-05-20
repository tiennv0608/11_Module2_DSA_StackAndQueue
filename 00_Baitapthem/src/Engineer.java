public class Engineer extends Officier {
    private String specialize;

    public Engineer() {
    }

    public Engineer(String name, int age, String gender, String address, String specialize) {
        super(name, age, gender, address);
        this.specialize = specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    @Override
    public String toString() {
        return "Engineer {" + super.toString() +
                ", specialize: '" + specialize + '\'' + "}";
    }
}
