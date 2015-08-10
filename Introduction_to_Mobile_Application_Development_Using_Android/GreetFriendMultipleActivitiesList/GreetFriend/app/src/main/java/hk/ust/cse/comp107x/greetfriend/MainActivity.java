package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ListActivity {

    String [] names;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        names = getResources().getStringArray(R.array.friends);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.friend_item, names));

        Log.i(TAG, "in onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "in onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "in onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "in onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "in onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "in onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "in onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // create a new intent. The first parameter is the Context which is the current Activity.
        // Hence we use "this". The second parameter is the Activity class that we wish to start.
        // Hence it is specified as ShowMessage.class
        Intent in = new Intent(this, ShowMessage.class);

        // Add the message as a payload to the Intent. We add data to be carried by the intern using
        // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
        // the key, specified as a string, and the second parameter is the value.
        in.putExtra("message", getGreeting(getHourOfDay()) + names[(int) id] + "!");

        // We start the new activity by calling this method to inform the Android framework to start
        // the new activity. The parameter is the Intent we just created earlier
        startActivity(in);
    }

    private String getGreeting(int hour) {
        String greeting = "";

        if(hour >= 6 && hour < 12) {
            greeting = "Good Morning ";
        }else if(hour >= 12 && hour < 17) {
            greeting = "Good Afternoon ";
        }else if(hour >= 17 && hour < 21) {
            greeting = "Good Evening ";
        }else {
            greeting = "Good Night ";
        }
        return greeting;
    }

    private int getHourOfDay() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
        return hourOfDay;
    }
}
