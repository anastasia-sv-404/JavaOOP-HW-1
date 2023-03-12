package geoTreeResearch;

import java.util.SortedMap;

public class View {
    public void getFamilyInfo(Person person){
        System.out.printf("Человек: %s, пол: %s, возраст: %d. В семью данного человека входят: \n", person.getName(),
                person.getGender(), person.getAge());
        for(Person pr : person.getFamily()){
            System.out.printf("Человек: %s, пол: %s, возраст: %d. \n", pr.getName(), pr.getGender(), pr.getAge());
        }
    }//В методе addToFamily для Person: если человек 1 был добавлен в семью человека 2, то в семью человека 1 будет добавлен человек 2.
    // Поэтому без рекурсии.
}

