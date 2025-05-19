import java.util.ArrayList;
import java.util.List;

public class Player extends InHouse {
    String name;
    String lastName;
    int age;
    String belt;

    public Player(String name, String lastName, int age, String belt) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.belt = belt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", belt='" + belt + '\'' +
                '}';
    }
}