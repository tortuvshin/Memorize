package programmer.laboratore_6;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import programmer.laboratore_6.Database.MyDbHandler;
import programmer.laboratore_6.Model.Word;


public class WordLookFragment extends Fragment {

    private static final String TAG = "===WordLookFragment===";
    public static View rootView;
    public TextView english;
    public TextView mongolia;
    MainFragment mainFragment;
    MyDbHandler myDbHandler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_word_look, container, false);
        init();
        return rootView;
    }
    public void init(){
        String eng = "";
        String type = "";
        String mon = "";
        english = (TextView)rootView.findViewById(R.id.englishText);
        mongolia= (TextView)rootView.findViewById(R.id.mongolianText);
        myDbHandler = new MyDbHandler(getActivity());
        SharedPreferences prefs = getActivity().getSharedPreferences(MainFragment.PREFER_NAME, 0);
        String searchedWord = prefs.getString("SearchedWord", "");
        Word word = myDbHandler.getWord(searchedWord);
        eng = word.getEnglish();
        type = word.getType();
        mon = word.getMongolia();
        english.setText(eng);
        mongolia.setText(type+", "+mon);
        }

}
