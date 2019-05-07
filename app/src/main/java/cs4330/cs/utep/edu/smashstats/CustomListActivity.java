package cs4330.cs.utep.edu.smashstats;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import static cs4330.cs.utep.edu.smashstats.MainActivity.characterList;
import static cs4330.cs.utep.edu.smashstats.MainActivity.fightList;
import static cs4330.cs.utep.edu.smashstats.MainActivity.stageList;

public class CustomListActivity extends AppCompatActivity {

    public static ListView l;
    public static FightList adapterFight;
    public static CharacterList adapterCharacter;
    public static StageList adapterStage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        l = findViewById(R.id.listview);

        Intent input = getIntent();
        String p = input.getStringExtra("name");

        Log.d("TEST TAG TAG", p);

        if(p.equals("f")){
            //list fight
            adapterFight = new FightList(this, 0, fightList);
            l.setAdapter(adapterFight);
        }
        else if(p.equals("c")){
            //list character
            adapterCharacter = new CharacterList(this, 0, characterList);
            l.setAdapter(adapterCharacter);
        }

        else{
            //list stage
            adapterStage = new StageList(this,0,stageList);
            l.setAdapter(adapterStage);
        }
    }

}
