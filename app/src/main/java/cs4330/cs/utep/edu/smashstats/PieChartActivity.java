package cs4330.cs.utep.edu.smashstats;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class PieChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        final PieChart pieChart = findViewById(R.id.piechart);
        ImageView mImageView = findViewById(R.id.image);

        mImageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(PieChartActivity.this, CharacterActivity.class);
                startActivity(i);
            }
        });


        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleRadius(30f);
        pieChart.setUsePercentValues(true);
        pieChart.setTransparentCircleRadius(35f);
        pieChart.setEntryLabelColor(Color.BLACK);

        Description description = new Description();
        description.setText("Characters you've used.");
        description.setTextSize(15);
        pieChart.setDescription(description);

        ArrayList characters = new ArrayList();

        characters.add(new PieEntry(12f, "kirby"));
        characters.add(new PieEntry(30f, "marth"));
        characters.add(new PieEntry(8f, "link"));
        characters.add(new PieEntry(4f, "roy"));
        characters.add(new PieEntry(21f, "lucina"));
        characters.add(new PieEntry(13f, "pikachu"));
        characters.add(new PieEntry(5f, "luigi"));
        characters.add(new PieEntry(9f, "ganon"));

        PieDataSet dataSet = new PieDataSet(characters, "Characters");
        dataSet.setSliceSpace(1f);
        dataSet.setValueTextSize(8f);
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.WHITE);

        pieChart.setData(data);
        pieChart.animateXY(2000, 2000);

        Legend legend = pieChart.getLegend();
        legend.setEnabled(true);


        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                TextView textView = findViewById(R.id.textview);
                ImageView mImageView = findViewById(R.id.image);

                PieEntry value = (PieEntry) entry;

                String labelString = value.getLabel();
                float valueFloat = value.getValue();

                switch(labelString){
                    case "marth":
                       mImageView.setImageResource(R.drawable.marth);
                        break;
                    case "ganon":
                       // mImageView.setImageResource(R.drawable.ganon2);
                        break;
                    case "link":
                       // mImageView.setImageResource(R.drawable.link2);
                        break;
                    case "lucina":
                       // mImageView.setImageResource(R.drawable.lucina2);
                        break;
                    case "roy":
                       // mImageView.setImageResource(R.drawable.roy2);
                        break;
                    case "pikachu":
                       // mImageView.setImageResource(R.drawable.pikachu2);
                        break;
                    case "kirby":
                       // mImageView.setImageResource(R.drawable.kirby2);
                        break;
                    case "luigi":
                       // mImageView.setImageResource(R.drawable.luigi2);
                        break;
                }

                textView.setText("You've used " + labelString + " " + valueFloat + " times.");
            }

            @Override
            public void onNothingSelected() {
                ImageView mImageView = findViewById(R.id.image);
                TextView textView = findViewById(R.id.textview);
                mImageView.setImageResource(0);
                textView.setText("");
            }
        });
    }

}
