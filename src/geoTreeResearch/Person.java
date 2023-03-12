package geoTreeResearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    private String name;
    private int age;

    enum Gender {
        man, woman
    }

    private Gender gender;
    private List<Person> family = new ArrayList<>();

    /**
     * Общий конструктор для класса.
     *
     * @param name   - имя
     * @param gender - пол
     * @param age    - возраст
     */
    public Person(String name, Gender gender, int age) {
        Random random = new Random();
        this.name = name;
        this.gender = gender;
        if (age < 0 || age > 123) {
            this.age = random.nextInt(1, 123);
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Person> getFamily() {
        return family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addToFamily(Person person) {
        if (!person.equals(this) && person != null) {
            this.family.add(person);
            person.family.add(this);
        } else {
            System.out.printf("%s не может быть добавлен в семью человека %s, и наоборот.", person.name, this.name);
        }
    }

    @Override
    public String toString() {
        return "Person: " +
                "name = '" + name + '\'' +
                ", age = " + age +
                ", gender = " + gender;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.name.equals(this.name) && person.age == this.age
                && person.gender.equals(this.gender);
    }
}
