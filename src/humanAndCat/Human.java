package humanAndCat;

import java.util.Random;
import java.util.Scanner;

public class Human {
    private String name;
    private boolean hasWounds;
    private String[] humanName = new String[]{"Вася", "Петя", "Степа", "Иван", "Сергей", "Вова"};

    /**
     * Общий приватный конструктор для класса.
     *
     * @param name      имя
     * @param hasWounds статус: есть ли царапины/повреждения на коже
     */
    private Human(String name, boolean hasWounds) {
        if (name.isEmpty()) {
            Random random = new Random();
            this.name = humanName[random.nextInt(0, humanName.length)];
        } else {
            this.name = name;
        }
        this.hasWounds = hasWounds;
    }

    /**
     * Публичный переопределенный конструктор класса. Есть возможность задать произвольное имя.
     *
     * @param name имя
     */
    public Human(String name) {
        this(name, false);
    }

    /**
     * Публичный переопределенный конструктор класса. Без аргументов.
     */
    public Human() {
        this("");
    }

    public String getName() {
        return name;
    }

    public boolean getHasWounds() {
        return hasWounds;
    }

    public void setHasWounds(boolean hasWounds) {
        this.hasWounds = hasWounds;
    }

    public void giveAnotherNameForPet(Cat cat) {
        boolean check = true;

        while (check) {
            System.out.printf("Человек %s хочет поменять имя питомца? 1 - да, 2 - нет\n", this.name);
            Scanner firstScanner = new Scanner(System.in);

            if (!firstScanner.hasNextInt()) {
                System.out.println("Было введено неверное значение. Нужно попробовать еще раз.");
            } else {
                int answer = firstScanner.nextInt();
                if (answer == 1) {
                    System.out.printf("Человеку %s нужно ввести новое имя питомца: ", this.name);
                    Scanner secondScanner = new Scanner(System.in);
                    String anotherName = secondScanner.nextLine();
                    cat.setName(anotherName);
                    System.out.println("Новое имя питомца - это: " + cat.getName());
                    System.out.println("Питомцу не понравилось, что его имя поменяли.");
                    cat.scratch(this);
                } else {
                    System.out.println("Имя питомца осталось прежним.");
                }
                check = false;
            }
        }
    }

    public void giveFoodToPet(Cat cat) {
        System.out.printf("Человек %s пробует покормить питомца %s.\n", this.name, cat.getName());
        if (cat.getHungry()) {
            System.out.printf("Человек %s покормил питомца %s.\n", this.name, cat.getName());
            cat.takeFood();
        } else {
            System.out.printf("Питомец %s не голоден.\n", cat.getName());
        }
    }

    private void toWakePet(Cat cat) {
        if (cat.getState() == Cat.State.isSleeping) {
            System.out.printf("Человек %s разбудил питомца %s.\n", this.name, cat.getName());
            cat.changeState();
        }
    }

    public void callPet(Cat cat) {
        System.out.printf("Человек %s зовет питомца %s. \n", this.name, cat.getName());
        if (cat.getState() == Cat.State.isNotSleeping) {
            System.out.printf("Питомец %s не спит. Питомец отвечает: ", cat.getName());
            cat.voice();
        } else {
            toWakePet(cat);
        }
    }


    @Override
    public String toString() {
        return "У нас есть человек " + name + ". У человека есть повреждения на коже? Ответ: " + this.hasWounds + ".";
    }
}
