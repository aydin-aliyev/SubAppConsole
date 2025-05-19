import com.sun.tools.javac.Main;

public class MainPage implements Greeting {
    @Override
    public void welcome() {
        System.out.println("Welcome to SUBMACHINE");
    }

    // MAIN
    public static void main(String[] args) {
        //полиморфизм
        Greeting greeting = new MainPage();
        greeting.welcome();
        greeting.line();


        //Показать категории
        Menu menu = new Menu();
        menu.showMenuItems();
        menu.chooseCategory();

    }

}


interface Greeting{
    void welcome();
    default void line(){
        System.out.println("---------------------");
    }
}
