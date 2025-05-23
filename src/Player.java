import java.util.ArrayList;
import java.util.List;

public class Player extends InHouse {
    int id;
    String name;
    String lastName;
    int age;
    String belt;

    public Player(int id, String name, String lastName, int age, String belt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.belt = belt;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", belt='" + belt + '\'' +
                '}';
    }
}