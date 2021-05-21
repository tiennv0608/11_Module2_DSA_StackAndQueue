public class Customer {
    private String cusId;
    private String name;
    private int age;
    private int gender;
    private String address;
    private String job;
    private String phone;

    public Customer(String cusId, String name, int age, int gender, String address, String job, String phone) {
        this.cusId = cusId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.job = job;
        this.phone = phone;
    }

    public Customer() {
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String sex = "";
        if (getGender() == 1) {
            sex = "nam";
        } else {
            sex = "nữ";
        }
        return "Customer{" +
                "cusId: '" + cusId + '\'' +
                ", name: '" + name + '\'' +
                ", age: " + age +
                ", gender: " + sex +
                ", address: '" + address + '\'' +
                ", job: '" + job + '\'' +
                ", phone: '" + phone + '\'' +
                '}';
    }
}
