package humanAndCat;

//Подумать как описать логику взаимодействия человека и домашнего питомца.
public class Main {
    public static void main(String[] args) {

        Cat cat = new Cat(); // Исходно: у питомца есть имя, он не голоден и не спит.
        // Имя может быть задано при создании экземпляра.
        System.out.println(cat);

        Human human = new Human();// Исходно: у человека есть имя, и у него нет повреждений на коже.
        // Имя может быть задано при создании экземпляра.
        System.out.println(human);
        System.out.println();

        human.giveAnotherNameForPet(cat); // Меняем питомцу имя.
        System.out.println();

        human.callPet(cat); //Человек позвал питомца. Питомец не спит.
        human.giveFoodToPet(cat); // Человек пробует покормить питомца. Питомец не голоден.
        System.out.println();

        cat.changeState(); // Питомец уснул
        System.out.println("Питомец " + cat.getName() + " сейчас: " + cat.getState() +
                ". Питомец проголодался? Ответ: " + cat.getHungry());// Если питомец уснул, то он стал голодным.
        human.callPet(cat); // Человек разбудил питомца.
        System.out.println();
        human.giveFoodToPet(cat); // Человек покормил питомца.
    }
}
