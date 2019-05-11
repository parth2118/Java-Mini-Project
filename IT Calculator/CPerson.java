/**
 * CPerson
 * 
 * @author parth2118
 */
class CPerson implements IConst {
    private String name;
    private String PAN;
    private int age;
    private String email;

    public CPerson(String name, String PAN, int age, String email) {
        this.name = name;
        this.PAN = PAN;
        this.age = age;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
