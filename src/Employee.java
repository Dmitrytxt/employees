import java.io.Serializable;

public record Employee(String name, String specialization, String position, int age,
                       String martialStatus, int experience) implements Serializable {
    
    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public String getMartialStatus() {
        return martialStatus;
    }

    public int getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return (this.getName() + " " + this.getSpecialization() + " " + this.getPosition() + " " +
                this.getAge() + " " + this.getMartialStatus() + " " + this.getExperience());
    }
}
