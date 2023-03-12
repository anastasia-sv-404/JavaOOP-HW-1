package geoTreeResearch;

import java.util.ArrayList;

public class GeoTree {

    private ArrayList<Node> tree = new ArrayList<>();

    public ArrayList<Node> getTree() {
        return this.tree;
    }

    public void append(Person p1, Relationship re1, Person p2, Relationship re2) {
        if(p1.getFamily().contains(p2) && p2.getFamily().contains(p1)) {
            tree.add(new Node(p1, re1, p2));
            tree.add(new Node(p2, re2, p1));
        } else{
            System.out.printf("Нельзя установить отношения: персоны %s и %s принадлежат разным семьям.\n+", p1.getName(), p2.getName());
        }
    }
}






