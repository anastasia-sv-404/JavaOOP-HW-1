package geoTreeResearch;

import java.util.ArrayList;

public class Research {
    private ArrayList<Node> tree;

    private ArrayList<String> result = new ArrayList<>();

    public Research(GeoTree geoTree) {
        this.tree = geoTree.getTree();
    }

    public ArrayList<String> spendRelationships(Person p, Relationship re) {
        for (Node t : this.tree) {
            if (t.getPersonFirst().getName() == p.getName() && t.getRelationship() == re) {
                result.add(t.getPersonSecond().getName());
            }
        }
        return result;
    }

    public ArrayList<String> spendGender(Person.Gender gender){
        for (Node t : this.tree){
            if(t.getPersonFirst().getGender() == gender && !this.result.contains(t.getPersonFirst().getName())){
                result.add(t.getPersonFirst().getName());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format(String.valueOf(result));
    }
}
