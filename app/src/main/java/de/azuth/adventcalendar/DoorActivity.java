package de.azuth.adventcalendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mark on 29.11.2015.
 */
public class DoorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int doornumber = getIntent().getExtras().getInt("door");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Door " + doornumber);


        int doorimage = getResources().getIdentifier("door" + doornumber, "raw", "de.azuth.adventcalendar");

        setContentView(R.layout.activity_door_image_text);
        ImageView iv = (ImageView) findViewById(R.id.imageView);
        if (doorimage != 0) {
            iv.setImageResource(doorimage);
        } else {
            iv.setImageResource(R.mipmap.ic_launcher);
            //setContentView(R.layout.activity_door_text);
        }


        String doorText = getDoorText(doornumber);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(doorText);
    }

    private String getDoorText(int doornumber) {
        switch (doornumber) {
            case 1:
                return getResources().getString(R.string.door1);
            case 2:
                return getResources().getString(R.string.door2);
            case 3:
                return getResources().getString(R.string.door3);
            case 4:
                return getResources().getString(R.string.door4);
            case 5:
                return getResources().getString(R.string.door5);
            case 6:
                return getResources().getString(R.string.door6);
            case 7:
                return getResources().getString(R.string.door7);
            case 8:
                return getResources().getString(R.string.door8);
            case 9:
                return getResources().getString(R.string.door9);
            case 10:
                return getResources().getString(R.string.door10);
            case 11:
                return getResources().getString(R.string.door11);
            case 12:
                return getResources().getString(R.string.door12);
            case 13:
                return getResources().getString(R.string.door13);
            case 14:
                return getResources().getString(R.string.door14);
            case 15:
                return getResources().getString(R.string.door15);
            case 16:
                return getResources().getString(R.string.door16);
            case 17:
                return getResources().getString(R.string.door17);
            case 18:
                return getResources().getString(R.string.door18);
            case 19:
                return getResources().getString(R.string.door19);
            case 20:
                return getResources().getString(R.string.door20);
            case 21:
                return getResources().getString(R.string.door21);
            case 22:
                return getResources().getString(R.string.door22);
            case 23:
                return getResources().getString(R.string.door23);
            case 24:
                return getResources().getString(R.string.door24);
            default:
                return "";
        }
    }
}
