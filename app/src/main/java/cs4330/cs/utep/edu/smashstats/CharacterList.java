package cs4330.cs.utep.edu.smashstats;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * An adapter to display the set of characters in a list
 */
public class CharacterList extends ArrayAdapter<Character> {

    private Activity activity;
    private ArrayList<Character> characterList;
    private static LayoutInflater inflater = null;

    /**
     * Constructor for the Adapter, sends info to superclass
     * @param activity
     * @param rID
     * @param _characterList
     */
    public CharacterList (Activity activity, int rID, ArrayList<Character> _characterList ) {
        super(activity, rID, _characterList);
        try {
            this.activity = activity;
            this.characterList = _characterList;

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {
        }
    }

    /**
     * Returns position of character
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position){
        return position;
    }

    /**
     * Gets the view that displays the data at certain position
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent){
        View view = convertView;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //inflate view using xml layout for list
            view = inflater.inflate(R.layout.activity_list, null);

            //Find all set all values to specific Views
            TextView i = view.findViewById(R.id.name1);

            //Set all the data from item
            i.setText(characterList.get(position).name);


        }
        return view;
    }
}
