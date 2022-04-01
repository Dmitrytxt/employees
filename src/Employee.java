import java.io.Serializable;

public record Employee(String name, String specialization, String position, int age,
                       String martialStatus, int experience) implements Serializable { }
