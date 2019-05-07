package cs4330.cs.utep.edu.smashstats;

import java.util.ArrayList;

public class Character {

    String name;
    ArrayList<Fight> fights;

    public Character(String name){
        this.name = name;
    }
    public Character(String name, Fight f){
        this.name = name;
        fights.add(f);
    }

    public void addFight(Fight f){
        fights.add(f);
    }
}
