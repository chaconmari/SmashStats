package cs4330.cs.utep.edu.smashstats;

import java.util.ArrayList;

public class Stage {

    String name;
    ArrayList<Fight> fights;

    public Stage(String name){
        this.name = name;
    }

    public Stage(String name, ArrayList<Fight>fights){
        this.fights = fights;
        this.name = name;
    }

    public void addFight(Fight f){
        fights.add(f);
    }

}
