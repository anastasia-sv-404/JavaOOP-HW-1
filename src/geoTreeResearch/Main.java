package geoTreeResearch;
/*
Реализовать, с учетом ооп подхода, приложение для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
* модель человека
* компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
* компонент для проведения исследований
* дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, получение\построение отдельных моделей человека
Под “проведением исследования” можно понимать получение всех детей выбранного человека.
 */

import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) {

        View viewFamily = new View();

        Person ivan = new Person("Ivan", Person.Gender.man, 34);
        Person stepan = new Person("Stepan", Person.Gender.man, -5);//При вводе неверных значений
        // для возраста используется рандом.
        Person gosha = new Person("Gosha", Person.Gender.man, 12);
        Person olga = new Person("Olga", Person.Gender.woman, 5);

        Person sveta = new Person("Sveta", Person.Gender.woman, 7);

        System.out.println(stepan);
        stepan.setAge(10); // Задаем верное значение для возраста.
        System.out.println(stepan);

        System.out.println();

        ivan.addToFamily(stepan); // Формируем список семьи для Ивана
        ivan.addToFamily(gosha);
        ivan.addToFamily(olga);
        gosha.addToFamily(olga);
        gosha.addToFamily(stepan);
        olga.addToFamily(stepan);

        ivan.addToFamily(ivan); // Проверяем, что не можем добавить персону в семью этой же персоны.
        System.out.println();
        System.out.println();

        viewFamily.getFamilyInfo(ivan); // Вывод в консоль семьи указанной персоны
        viewFamily.getFamilyInfo(gosha);
        viewFamily.getFamilyInfo(olga);


        GeoTree tree = new GeoTree();

        tree.append(ivan, Relationship.parent, stepan, Relationship.child); // Формируем отношения между персонами одной семьи.
        tree.append(ivan, Relationship.parent, gosha, Relationship.child);
        tree.append(ivan, Relationship.parent, olga, Relationship.child);

        System.out.println();

        tree.append(ivan, Relationship.parent, sveta, Relationship.child); // Проверяем, что не можем установить
        // отношения между персонами, если они не входят в одну семью.

        System.out.println();

        System.out.printf("Для семьи %s установлены следующие отношения: \n", ivan.getName());
        System.out.println(tree.getTree());

        System.out.println();
        printResearchRe(tree, ivan, Relationship.parent); // Кому Иван приходится родителем.

        System.out.println();
        printResearchGe(tree, Person.Gender.man); // Выводим всех мужчин

    }
    static void printResearchRe(GeoTree tree, Person p, Relationship re){
        System.out.printf("%s - это %s для: \n", p.getName(), re);
        System.out.println(new Research(tree).spendRelationships(p, re));
    }
    static void printResearchGe(GeoTree tree, Person.Gender gender){
        System.out.printf("Выводим всех %s: \n", gender);
        System.out.println(new Research(tree).spendGender(gender));
    }

}
