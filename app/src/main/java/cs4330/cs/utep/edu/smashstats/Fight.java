package cs4330.cs.utep.edu.smashstats;

public class Fight {

    Character player;
    Character opponent;
    Stage stage;
    Boolean win;

    public Fight(Character player, Character opponent, Stage stage, Boolean win){
        this.opponent = opponent;
        this.player = player;
        this.stage = stage;
        this.win = win;
    }
}
