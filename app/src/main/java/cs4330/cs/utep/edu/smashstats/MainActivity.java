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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
