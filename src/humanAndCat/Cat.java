package humanAndCat;

import java.util.Random;

public class Cat {
    private String name;
    private boolean isHungry;
    private String[] catName = new String[]{"Барсик", "Мурка", "Пушок", "Снежок", "Пятнышко", "Мистер Лапка"};

    enum State {
        isSleeping,
        isNotSleeping
    }

    private State state;

    /**
     * Общий приватный конструктор для класса.
     *
     * @param name     имя
     * @param isHungry статус: голодный или нет
     * @param state    статус: спит или нет
     */
    private Cat(String name, boolean isHungry, State state) {
        if (name.isEmpty()) {
            Random random = new Random();
            this.name = catName[random.nextInt(0, catName.length)];
        } else {
            this.name = name;
        }
        this.isHungry = isHungry;
        this.state = state;
    }

    /**
     * Публичный переопределенный конструктор класса. Есть возможность задать произвольное имя.
     *
     * @param name имя
     */
    public Cat(String name) {
        this(name, false, State.isNotSleeping);
    }

    /**
     * Публичный переопределенный конструктор класса. Без аргументов.
     */
    public Cat() {
        this("");
    }

    public String getName() {
        return name;
    }

    public boolean getHungry() {
        return isHungry;
    }

    public State getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void takeFood() {
        if(this.isHungry) {
            this.isHungry = false;
        }
    }

    private void gettingHungry(State state) {
        if (this.state == State.isSleeping) {
            isHungry = true;
        }
    }

    public void changeState() {
        if (this.state == State.isNotSleeping) {
            this.state = State.isSleeping;
            gettingHungry(this.state);
        } else {
            this.state = State.isNotSleeping;
        }
    }

    public void voice() {
        System.out.println("Мяу.");
    }

    public void scratch(Human human){
        System.out.printf("Питомец %s поцарапал человека %s.\n", this.name, human.getName());
        human.setHasWounds(true);
    }

    @Override
    public String toString() {
        return "У нас есть кот/кошка " + name + ". Питомец голоден? Ответ: " + this.isHungry + ". Питомец спит? Ответ: " + this.state + ".";
    }
}
