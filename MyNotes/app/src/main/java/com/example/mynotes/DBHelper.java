package com.example.mynotes;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Note.class,exportSchema = false,version = 1)
public abstract class DBHelper extends RoomDatabase {
    private static final String DB_NAME = "note_db";
    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(),DBHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract NoteDao noteDao();


}
