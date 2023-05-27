package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    private Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase.db";

    private static final String TABLE_NAME = "Users";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CONFIRM = "confirm_password";

    private static final String TABLE_ORDONNANCE = "Ordonnance";
    private static final String COLUMN_ID_ORD = "id";

    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_NOM_MEDE = "doctor";
    private static final String COLUMN_SPECIALITE = "specialite";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_TELEPHONE = "phone";
    private static final String COLUMN_MAIL = "email";
    private static final String COLUMN_NOM_MEDI = "medecin";
    private static final String COLUMN_DOSAGE = "dose";
    private static final String COLUMN_FREQUENCE = "frequence";
    private static final String COLUMN_NOMBRES_BOITES = "box_numbers";
    private static final String COLUMN_MOMENT_PRISE = "take_moment";
    private static final String COLUMN_IMAGE = "image";

    private static final String TABLE_DONS = "Dons";
    private static final String COLUMN_ID_DONS = "id";
    private static final String COLUMN_NOM_DONS = "name_dons";
    private static final String COLUMN_QUANTITES = "quantity";
    private static final String COLUMN_DATE_EXPIRARTION = "expriration_date";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_CONFIRM + " TEXT);";
        sqLiteDatabase.execSQL(query);

        String query1 = "CREATE TABLE " + TABLE_ORDONNANCE + " (" + COLUMN_ID_ORD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_NOM_MEDE + " TEXT, " + COLUMN_SPECIALITE + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_TELEPHONE + " TEXT, " + COLUMN_MAIL + " TEXT, " + COLUMN_NOM_MEDI + " TEXT, " + COLUMN_DOSAGE + " TEXT, " + COLUMN_FREQUENCE + " TEXT, " + COLUMN_NOMBRES_BOITES + " TEXT, " + COLUMN_MOMENT_PRISE + " TEXT, " + COLUMN_IMAGE + " TEXT);";
        sqLiteDatabase.execSQL(query1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDONNANCE);
    }

    void register(String name, String email, String password, String confirm) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PASSWORD, password);
        cv.put(COLUMN_CONFIRM, confirm);
        long result = sqLiteDatabase.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Echec dans l'enregistrement de données", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Vous êtes inscrit !", Toast.LENGTH_SHORT).show();
        }
    }

    void addOrdonnace(String date, String doctor, String specialite, String address, String phone, String email, String medecin, String dose, String frequence, String box_numbers, String take_moment, String image) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DATE, date);
        cv.put(COLUMN_NOM_MEDE, doctor);
        cv.put(COLUMN_SPECIALITE, specialite);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_TELEPHONE, phone);
        cv.put(COLUMN_MAIL, email);
        cv.put(COLUMN_NOM_MEDI, medecin);
        cv.put(COLUMN_DOSAGE, dose);
        cv.put(COLUMN_FREQUENCE, frequence);
        cv.put(COLUMN_NOMBRES_BOITES, box_numbers);
        cv.put(COLUMN_MOMENT_PRISE, take_moment);
        cv.put(COLUMN_IMAGE, image);

        long result = sqLiteDatabase.insert(TABLE_ORDONNANCE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Echec dans l'enregistrement de données", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Ordonnance ajoutée avec succès !", Toast.LENGTH_SHORT).show();
        }
    }


    public boolean checkUser(String name, String password) {
        // array of columns to fetch
        String[] columns = {COLUMN_ID};
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_NAME + " = ?" + " AND " + COLUMN_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {name, password};
        // query user table with conditions

        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }
}
