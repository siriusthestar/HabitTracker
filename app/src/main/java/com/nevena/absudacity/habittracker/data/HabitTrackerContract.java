package com.nevena.absudacity.habittracker.data;

import android.provider.BaseColumns;


public final class HabitTrackerContract {

    public static final class HabitEntry implements BaseColumns {

        public final static String TABLE_NAME = "habits";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_HABIT = "habit";
        public final static String COLUMN_TIME = "time";
        public final static String COLUMN_COMMENT = "comment";

        // habit name values are predefined
        public enum Habit {
            HABIT_SLEEP,
            HABIT_WORK,
            HABIT_STUDY,
            HABIT_LEISURE
        }

    }
}