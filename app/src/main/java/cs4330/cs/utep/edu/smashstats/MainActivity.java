package cs4330.cs.utep.edu.smashstats;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PieChart pieChartPlayer = findViewById(R.id.piechartPlayer);
        final PieChart pieChartStage = findViewById(R.id.piechartStage);

        //PieChar Player settings
        pieChartPlayer.setDrawHoleEnabled(false);
        pieChartPlayer.setUsePercentValues(true);
        pieChartPlayer.setTransparentCircleRadius(5f);
        pieChartPlayer.setEntryLabelColor(Color.BLACK);
        pieChartPlayer.getDescription().setEnabled(false);

        //PieChart Stage settings
        pieChartStage.setDrawHoleEnabled(false);
        pieChartStage.setUsePercentValues(true);
        pieChartStage.setTransparentCircleRadius(5f);
        pieChartStage.setEntryLabelColor(Color.BLACK);
        pieChartStage.getDescription().setEnabled(false);


        //Array for PieChart Player
        ArrayList characters = new ArrayList();

        characters.add(new PieEntry(12f, "Kirby"));
        characters.add(new PieEntry(30f, "Marth"));
        characters.add(new PieEntry(8f, "Link"));
        characters.add(new PieEntry(21f, "Lucina"));
        characters.add(new PieEntry(13f, "Pikachu"));


        //Array for PieChart Stage
        ArrayList stages = new ArrayList();
        stages.add(new PieEntry(13f, "Hyrule Castle"));
        stages.add(new PieEntry(39f, "Mario Galaxy"));
        stages.add(new PieEntry(22f, "Duck Hunt"));
        stages.add(new PieEntry(40f, "Battlefield"));


        //Enter Data PieChart Player
        PieDataSet dataSetPlayer = new PieDataSet(characters, "Characters");
        dataSetPlayer.setValueTextSize(8f);
        dataSetPlayer.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData dataPlayer = new PieData(dataSetPlayer);
        dataPlayer.setValueTextSize(10f);
        dataPlayer.setValueTextColor(Color.WHITE);

        pieChartPlayer.setData(dataPlayer);


        //Enter Data PieChart Stage
        PieDataSet dataSetStage = new PieDataSet(stages, "Stages");
        dataSetStage.setValueTextSize(8f);
        dataSetStage.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData dataStage = new PieData(dataSetStage);
        dataStage.setValueTextSize(10f);
        dataStage.setValueTextColor(Color.WHITE);

        pieChartStage.setData(dataStage);

        pieChartPlayer.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                Intent i = new Intent(MainActivity.this, PieChartActivity.class);
                startActivity(i);
            }
            @Override
            public void onNothingSelected() {
            }
        });

        pieChartStage.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                Intent i = new Intent(MainActivity.this, StageActivity.class);
                startActivity(i);
            }

            @Override
            public void onNothingSelected() {

            }
        });
    }

    /**
     * Method to create menu in Action bar
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate Menu xml
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Method for when Action bar item selected
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return (super.onOptionsItemSelected(item));
    }
}
