package com.example.quiz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {

    private static final String db_name = "quiz.db";

    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context){
        if(instance == null)
            instance = new DBHelper(context);
        return instance;
    }

    public DBHelper(Context context) {
        super(context, db_name, null, 1);
    }

    public List<Category> getAllCategories(){
        SQLiteDatabase db = instance.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM Kategorie;", null);
        List<Category> categories = new ArrayList<>();
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                Category category = new Category(cursor.getInt(cursor.getColumnIndex("Id_kategorii")),
                        cursor.getString(cursor.getColumnIndex("Nazwa_kategorii")));
                categories.add(category);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();

        return categories;
    }

}
