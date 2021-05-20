public class Worker extends Officier {
    private int level;

    public Worker() {
    }

    public Worker(String name, int age, String gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker {" + super.toString() +
                ", level: " + level +
                "} ";
    }
}
