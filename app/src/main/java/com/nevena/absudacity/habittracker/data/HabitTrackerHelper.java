package com.nevena.absudacity.habittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.nevena.absudacity.habittracker.data.HabitTrackerContract.HabitEntry;
import com.nevena.absudacity.habittracker.data.HabitTrackerContract.HabitEntry.Habit;


public class HabitTrackerHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "habit.db";

    // Database version. If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    public HabitTrackerHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // create database
        db.execSQL(
                "CREATE TABLE " + HabitEntry.TABLE_NAME + " ("
                + HabitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_TIME + " INTEGER NOT NULL DEFAULT 0, "
                + HabitEntry.COLUMN_COMMENT + " TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public Cursor readSomeData() {
        // retrieve all habits and time spent, where time spent on habit is more than 2 hours
        return getReadableDatabase().query(
                HabitEntry.TABLE_NAME,
                new String[]{HabitEntry.COLUMN_HABIT, HabitEntry.COLUMN_TIME},
                HabitEntry.COLUMN_TIME + ">2",
                null,
                null,
                null,
                HabitEntry.COLUMN_TIME + " DESC");
    }

    public void insertSomeData() {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(HabitEntry.COLUMN_HABIT, Habit.HABIT_SLEEP.toString());
        cv.put(HabitEntry.COLUMN_TIME, 1);
        cv.put(HabitEntry.COLUMN_COMMENT, "Nap");
        db.insert(HabitEntry.TABLE_NAME, null, cv);

        cv.put(HabitEntry.COLUMN_HABIT, Habit.HABIT_STUDY.toString());
        cv.put(HabitEntry.COLUMN_TIME, 3);
        cv.put(HabitEntry.COLUMN_COMMENT, "Android");
        db.insert(HabitEntry.TABLE_NAME, null, cv);

        cv.put(HabitEntry.COLUMN_HABIT, Habit.HABIT_LEISURE.toString());
        cv.put(HabitEntry.COLUMN_TIME, 1);
        cv.put(HabitEntry.COLUMN_COMMENT, "Read a book");
        db.insert(HabitEntry.TABLE_NAME, null, cv);

        cv.put(HabitEntry.COLUMN_HABIT, Habit.HABIT_SLEEP.toString());
        cv.put(HabitEntry.COLUMN_TIME, 8);
        cv.put(HabitEntry.COLUMN_COMMENT, "A good night sleep");
        db.insert(HabitEntry.TABLE_NAME, null, cv);

        cv.put(HabitEntry.COLUMN_HABIT, Habit.HABIT_WORK.toString());
        cv.put(HabitEntry.COLUMN_TIME, 8);
        cv.put(HabitEntry.COLUMN_COMMENT, "");
        db.insert(HabitEntry.TABLE_NAME, null, cv);

    }

}
