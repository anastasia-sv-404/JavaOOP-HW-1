package bookcase;

import java.util.Scanner;

/*
Описать с ООП стиле логику взаимодействия объектов реального мира между собой: шкаф-книга.
Взаимодействие между шкафом и книгой показалось все же более интересным с точки зрения возможностей написания
различных методов (получилось придумать больше возможностей, чем для "человек-шкаф").
Надеюсь на возможность проверки и принятия данной части ДЗ к оценке именно в представленном виде.
P.S. Как видится, сути ДЗ это не сильно меняет - с точки зрения содержания задания.
*/
public class Main {

    public static void main(String[] args) {

        Bookcase bc = new Bookcase(5);

        for (int i = 0; i < bc.getMaxCapacity(); i++) {
            bc.addBook(new Book());
        }//Заполняем шкаф.

        int countOfBook = bc.getCountOfBooks();
        System.out.println("Состояние шкафа на текущий момент: ");
        bc.getStatus();//Выводим в консоль содержимое шкафа.

        if (countOfBook != 0) {
            System.out.printf("В шкафу сейчас %d книг(и).\n", countOfBook);
            System.out.println();

            boolean check = true;

            while (check) {
                System.out.println("Введите наименование книги, которую вы хотите забрать из шкафа: ");
                Scanner sc = new Scanner(System.in);
                String nameBook = sc.nextLine();
                bc.getBook(nameBook);

                if (anotherAction() != 1) {
                    System.out.println();
                    System.out.println("Состояние шкафа на текущий момент: ");
                    bc.getStatus();
                    System.out.printf("В шкафу сейчас %d книг(и).\n", bc.getCountOfBooks());
                    System.out.println();
                    System.out.println("Спасибо, до свидания!");
                    check = false;
                }
            }
        }
    }

    static int anotherAction() {
        while (true) {
            Scanner firstScanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Желаете продолжить? (1 - да, 2 - нет): ");
            if (!firstScanner.hasNextInt()) {
                System.out.println("Вы ввели неверное значение. Попробуйте еще раз.");
            } else {
                int answer = firstScanner.nextInt();
                return answer;
            }
        }
    }
}
