package com.example.lab4;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

       public static final String CUSTOMER_TABLE = "CUSTOMER_Table";
        public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
        public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";

    public static final String COLUMN_IS_ACTIVE = "IS_ACTIVE";

    public static final String COLUMN_ID = "ID";

        public DataBaseHelper(@Nullable Context context) {
            super(context, "student.db", null, 1);
        }

        // when creating the database
        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            String createTableStatement = "Create TABLE " + CUSTOMER_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_CUSTOMER_NAME + " TEXT, " +
                    COLUMN_CUSTOMER_AGE + " INT, " + COLUMN_IS_ACTIVE + " BOOLEAN )";
            sqLiteDatabase.execSQL(createTableStatement);

        }
        // when upgrading
        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }

        public boolean addOne(customerModel customerModel){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put( COLUMN_ID , customerModel.getId());
            cv.put(COLUMN_CUSTOMER_NAME, customerModel.getName());
            cv.put(COLUMN_CUSTOMER_AGE, customerModel.getAge());
            cv.put(COLUMN_IS_ACTIVE, customerModel.isActive());
            long insert = db.insert(CUSTOMER_TABLE, null, cv);
            if(insert == -1){
                return false;
            }
            else {
                return true;
            }
        }

    }

