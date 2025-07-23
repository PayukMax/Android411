package com.example.prototypeapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public void updateUser(int id, String name, String passw, int role) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, passw); // вот тут надо приправить пароль солью и сохранить хеш
        contentValues.put(COL_4, role);
        db.update(TABLE_NAME, contentValues, "ID=?", new String[]{String.valueOf(id)});
    }

    public void deleteUser(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id=?", new String[]{String.valueOf(id)});
    }

    public boolean checkRoot() {
        // нужно сделать выборку на предмет записей с ролью 0. если таковые нашлись - переходим на ЛОГИН если нет - регистрируем админа
        LinkedList<UsersData> list = getUsersList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRole() == 0) return true;
        }
        return false;

//        } else return false;
    }

    public boolean checkUser(String t_user, String t_passw) {
        LinkedList<UsersData> list = getUsersList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(t_user)) { // ищем пользователя
                if (list.get(i).getPassw().equals(t_passw)) return true; // Проверка совпадения пароля
            }
        }

//            }
            return false;
    }

    public boolean checkUserName(String t_user) {
        LinkedList<UsersData> list = getUsersList();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(t_user)) return true;
        }

//            }
        return false;
    }

    public int getRole(String t_user) {
        LinkedList<UsersData> list = getUsersList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(t_user)) { // ищем пользователя
                return list.get(i).getRole(); // выдаем его роль
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
                UsersData data = new UsersData();
                data.setId(cursor.getInt(pos1));
                data.setName(cursor.getString(pos2));
                data.setPassw(cursor.getString(pos3));
                data.setRole(cursor.getInt(pos4));
                list.add(data);
            } while (cursor.moveToNext());

        }
        return list;
    }

    @SuppressLint("Range")
    public List<UsersData> getAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = null;
        List<UsersData> usersList = new ArrayList<>();

        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME,null,null,null,null,null,null,null);
            if (cursor != null){
                if (cursor.moveToFirst()){
                    do {
                        UsersData usData = new UsersData();
                        usData.setId(cursor.getInt(cursor.getColumnIndex(COL_1)));
                        usData.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
                        usData.setPassw(cursor.getString(cursor.getColumnIndex(COL_3)));
                        usData.setRole(cursor.getInt(cursor.getColumnIndex(COL_4)));
                        usersList.add(usData);
                    } while (cursor.moveToNext());
                }
            }

        } finally {
            db.endTransaction();
            cursor.close();
        }
        return usersList;
    }
}
