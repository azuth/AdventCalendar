package de.azuth.adventcalendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        for (int i = 1; i <= 24; i++) {
            if (settings.contains("" + i)) {
                int id = getResources().getIdentifier("button" + i, "id", getPackageName());
                Button b = (Button) findViewById(id);
                Log.d("onCreate", "id " + id);
                setDoorOpend(b);
            }
        }

        Calendar c = Calendar.getInstance();
        Log.d("Day", "" + c.get(Calendar.DAY_OF_MONTH));
        Log.d("Month", "" + (c.get(Calendar.MONTH) + 1));
    }


    public void openDoor(View view) {
        String doorNumber = ((Button) view).getText().toString();
        Calendar c = Calendar.getInstance();

        /*
        if( !( Integer.parseInt(doorNumber) <= c.get(Calendar.DAY_OF_MONTH)
               && c.get(Calendar.MONTH)>10 )){ // Calendar.MONTH [0-11]
            Log.d("openDoor", "Its still not time to open door "+doorNumber+".");
            String message = String.format(getString(R.string.openDoorPermissionDenied), doorNumber);
            Toast.makeText(getApplicationContext(), message,
            Toast.LENGTH_LONG).show();
            return;
        }
        */

        int count = settings.getInt(doorNumber, 0);
        settings.edit().putInt(doorNumber, ++count).commit();

        setDoorOpend((Button) view);
        Log.d("openDoor", "Number:Count " + doorNumber + ":" + count);

        Intent intent = new Intent(this, DoorActivity.class);
        intent.putExtra("door", Integer.parseInt(doorNumber));
        startActivity(intent);
    }

    public void setDoorOpend(Button door) {
        door.setBackground(getResources().getDrawable(R.drawable.button_door_open));
    }
}
