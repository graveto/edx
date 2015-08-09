package hk.ust.cse.comp107x.greetfriend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity implements View.OnClickListener {

    Button greetButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        greetButton = (Button) findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);
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
    public void onClick(View v) {

        TextView textMessage = (TextView) findViewById(R.id.textMessage);
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);
        String friendName = editFriendName.getText().toString();

        switch (v.getId()) {
            case R.id.greetButton:
                // create a new intent. The first parameter is the Context which is the current Activity.
                // Hence we use "this". The second parameter is the Activity class that we wish to start.
                // Hence it is specified as ShowMessage.class
                Intent in = new Intent(this, ShowMessage.class);

                // Add the message as a payload to the Intent. We add data to be carried by the intern using
                // the putExtra() methods. The data is specified as a key-value pair. The first parameter is
                // the key, specified as a string, and the second parameter is the value.
                in.putExtra("message", getGreeting(getHourOfDay()) + friendName + "!");

                // We start the new activity by calling this method to inform the Android framework to start
                // the new activity. The parameter is the Intent we just created earlier
                startActivity(in);
                break;
            default:
                break;
        }
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
