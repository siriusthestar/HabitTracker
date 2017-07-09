package com.nevena.absudacity.habittracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nevena.absudacity.habittracker.data.HabitTrackerContract.HabitEntry;
import com.nevena.absudacity.habittracker.data.HabitTrackerHelper;

import static android.util.Log.wtf;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HabitTrackerHelper htHelper = new HabitTrackerHelper(this);

        // insert and display dummy data
        htHelper.insertSomeData();
        Cursor cursor = htHelper.readSomeData();
        try {
            int colIndexHabit = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT);
            int colIndexTime = cursor.getColumnIndex(HabitEntry.COLUMN_TIME);
            StringBuilder stringBuilder = new StringBuilder();
            while (cursor.moveToNext()) {
                stringBuilder
                        .append(cursor.getString(colIndexHabit))
                        .append(":")
                        .append(cursor.getString(colIndexTime))
                        .append("\n");
            }
            wtf("Results", stringBuilder.toString());
        } finally {
            cursor.close();
        }
    }


}
