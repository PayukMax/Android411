package com.example.prototypeapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.ContentView;
import androidx.annotation.Nullable;

import java.util.LinkedList;

public class DbHelper extends SQLiteOpenHelper {

    private static String dbName = "prototype.db";
    private static final String TABLE_NAME = "users";
    private static final String COL_1 = "id";
    private static final String COL_2 = "username";
    private static final String COL_3 = "passwd";
    private static final String COL_4 = "role";
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_2 + " TEXT NOT NULL," + COL_3 + " TEXT NOT NULL, " + COL_4 + " INTEGER NOT NULL);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME + " ;";

    public DbHelper(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL(CREATE_TABLE);
        } catch (Exception ignored) {

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    public boolean addUser(String name, String pass, int role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COL_2, name);
        cv.put(COL_3, pass); // вот тут надо приправить пароль солью и сохранить хеш
        cv.put(COL_4, role);
        long result = db.insert(TABLE_NAME, null, cv);
        return result != -1;
    }

    public boolean checkRoot() {
        // нужно сделать выборку на предмет записей с ролью 0. если таковые нашлись - переходим на ЛОГИН если нет - регистрируем админа
        LinkedList<UsersData> list = getUsersList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).role == 0) return true;
        }
        return false;

//        } else return false;
    }

    public boolean checkUser(String t_user, String t_passw) {
        LinkedList<UsersData> list = getUsersList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(t_user)) { // ищем пользователя
                if (list.get(i).passw.equals(t_passw)) return true; // Проверка совпадения пароля
            }
        }

//            }
            return false;
    }

    public int getRole(String t_user) {
        LinkedList<UsersData> list = getUsersList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).name.equals(t_user)) { // ищем пользователя
                return list.get(i).role; // выдаем его роль
            }
        }
    return 404; // если вдруг не нашли юзера выдаем ошибку - 404
    }

    private LinkedList<UsersData> getUsersList() {
        LinkedList<UsersData> list = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                int pos1 = cursor.getColumnIndex(COL_1);
                int pos2 = cursor.getColumnIndex(COL_2);
                int pos3 = cursor.getColumnIndex(COL_3);
                int pos4 = cursor.getColumnIndex(COL_4);
                UsersData data = new UsersData(cursor.getInt(pos1), cursor.getString(pos2), cursor.getString(pos3), cursor.getInt(pos4));
                list.add(data);
            } while (cursor.moveToNext());

        }
        return list;
    }
}
