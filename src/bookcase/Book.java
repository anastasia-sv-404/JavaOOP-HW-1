package bookcase;

import java.io.File;
import java.util.*;

// Взаимодействие между шкафом и книгой показалось все же более интересным с точки зрения возможностей написания
// различных методов (получилось придумать больше возможностей, чем для "человек-шкаф").
// Надеюсь на возможность проверки и принятия данной части ДЗ к оценке именно в представленном виде.
// P.S. Как видится, сути ДЗ это не сильно меняет - с точки зрения содержания задания.
public class Book {
    private String name;
    private int numberOfPages;
    private int id;

    private static int defaultIndex;
    private static Random random;
    private static List<String> bookName;

    /*
      Тренировка работы со статическими переменными (по аналогии с информацией из лекции 2):
      1) задаем уникальное id экземпляра в рамках класса (место книги на полке).
      2) определяем некий рандом для работы в рамках класса.
      3) определяем общий список названий книг, из которых мы будем генерировать имена книг в шкафу (создавать экземпляры)
     */
    static {
        defaultIndex = 1;
        random = new Random();
        bookName = new ArrayList<>(Arrays.asList(readFile("booksName.txt").split(", ")));
    }

    /**
     * Читаем из файла все имеющиеся названия книг, чтобы потом сгенерировать псевдослучайное наименование книги.
     *
     * @param filePath - путь к файлу с названиями книг
     * @return - строка: все книги из файла
     */
    static private String readFile(String filePath) {
        File file = new File(filePath);
        StringBuilder sb = new StringBuilder();
        try (Scanner sc = new Scanner(file)) {
            sb.append(sc.nextLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Общий конструктор для создания экземпляра класса.
     *
     * @param name          это наименование книги
     * @param numberOfPages это количество страниц в книге
     */
    public Book(String name, int numberOfPages) {
        this.id = defaultIndex++;
        if (name.isEmpty()) {
            int position = random.nextInt(bookName.size());
            this.name = String.format("%s", bookName.get(position));
            if (bookName.size() >= 2) {
                bookName.remove(position);
            }
        } else {
            this.name = String.format("%s", name);
        }
        this.numberOfPages = numberOfPages;
    }

    /**
     * Конструктор для создания экземпляра класса, принимающий на вход только имя книги (перегрузка).
     *
     * @param name это наименование книги
     */
    public Book(String name) {
        this(name, random.nextInt(50, 801));
    }

    /**
     * Конструктор для создания экземпляров класса Книга без аргументов (перегрузка).
     */
    public Book() {
        this("");
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "наименование '" + name + "'" +
                ", количество страниц " + numberOfPages +
                ", порядковое место на полке " + id;
    }
}
