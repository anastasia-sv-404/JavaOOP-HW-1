package bookcase;

import java.util.LinkedList;

public class Bookcase {

    private int maxCapacity;
    private LinkedList<Book> list;

    /**
     * Конструктор экземпляра класса в случае, если передаем сразу и вместимость шкафа, и список Книг.
     *
     * @param maxCapacity это максимальная вместимость шкафа
     * @param list        это список книг в шкафу
     */
    public Bookcase(int maxCapacity, LinkedList<Book> list) {
        this.list = list;
        if (list.size() > maxCapacity) {
            this.maxCapacity = list.size();
        } else {
            this.maxCapacity = maxCapacity;
        }
    }

    /**
     * Конструктор экземпляра класса в случае, если передаем только вместимость шкафа (шкаф исходно пуст).
     *
     * @param maxCapacity это максимальная вместимость шкафа.
     */
    public Bookcase(int maxCapacity) {
        this(maxCapacity, new LinkedList<Book>());
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    /**
     * @return количество книг в шкафу
     */
    public int getCountOfBooks() {
        return this.list.size();
    }

    /**
     * Добавление книги в шкаф.
     */
    public void addBook(Book book) {
        if (this.list.size() < this.maxCapacity) {
            this.list.addLast(book);
        } else {
            System.out.println("Нельзя добавить новую книгу, шкаф полон.");
        }
    }

    /**
     * Проверка наличия книги в шкафу.
     *
     * @param nameOfBook имя книги
     * @return -1 - если книги нет
     */
    private int checkInBookcase(String nameOfBook) {
        int i = 0;
        for (Book book : this.list) {
            if (book.getName().equals(nameOfBook)) {
                System.out.printf("Книга '%s' есть в шкафу.\n", nameOfBook);
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    /**
     * Достать книгу из шкафа.
     *
     * @param nameOfBook имя книги
     */
    public void getBook(String nameOfBook) {
        if (list.isEmpty()) {
            int status = 0;
            System.out.println("Шкаф пуст.");
            return;
        }
        int check = checkInBookcase(nameOfBook);
        if (check == -1) {
            System.out.printf("Книги '%s' нет в шкафу.\n", nameOfBook);
        } else {
            Book book = list.get(check);
            System.out.printf("Из шкафа взята книга '%s' с количеством страниц %d.\n", nameOfBook,
                    book.getNumberOfPages());
            list.remove(check);
        }
    }

    /**
     * Вывести в консоль все книги, которые есть в шкафу.
     */
    public void getStatus() {
        if (list.isEmpty()) {
            System.out.println("Шкаф пуст.");
            return;
        }
        for (Book book : list) {
            System.out.printf("Книга: '%s', количество страниц: %d, стоит на позиции: %d\n", book.getName(),
                    book.getNumberOfPages(), book.getId());
        }
    }
}
