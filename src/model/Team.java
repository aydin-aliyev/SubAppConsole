package model;

import model.showMenuItems;

import java.util.Scanner;

public class Team implements showMenuItems {
    @Override
    public void showMenuItems() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Coaches");
        System.out.println("2.Achievements");

        // Выбор категории
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                coaches();
                break;
            case 2:
                achievements();
                break;
            default:
                System.out.println("Неверный выбор");
        }
    }

    void coaches(){
        System.out.println("Najmaddin Quluzada");
        System.out.println("Maqsudxan Quluzada");
    }

    void achievements(){
        System.out.println("Объявили 3 чемпионов на Чемпионате Республики");

    }
}