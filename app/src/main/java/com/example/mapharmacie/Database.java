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

    //TABLE USERS
    private static final String TABLE_NAME = "Users";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";
    private static final String COLUMN_CONFIRM = "confirm_password";

    //TABLE ORDONNANCE
    private static final String TABLE_ORDONNANCE = "Ordonnances";
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

    //TABLE DONS
    private static final String TABLE_DONS = "Dons";
    private static final String COLUMN_ID_DONS = "id";
    private static final String COLUMN_NOM_DONS = "name_dons";
    private static final String COLUMN_QUANTITES = "quantity";
    private static final String COLUMN_DATE_EXPIRARTION = "expriration_date";
    private static final String COLUMN_MEDICAMENT_ID_DONS = "id";


    //TABLE NOTES
    private static final String TABLE_NOTE = "Notes";
    private static final String COLUMN_ID_NOTE = "id";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_ADVICE = "conseil";
    private static final String COLUMN_EFFETS = "effect";
    private static final String COLUMN_REMARQUES = "remarques";
    private static final String COLUMN_MEDICAMENT_ID_NOTE = "id";


    //TABLE RAPPELS
    private static final String TABLE_RAPPEL = "rappels";
    private static final String COLUMN_ID_RAPPEL = "id";
    private static final String COLUMN_HEURE = "hour";
    private static final String COLUMN_MINUTE = "minute";
    private static final String COLUMN_JOUR = "day";
    private static final String COLUMN_NOMBRE_REP = "rep_number";
    private static final String COLUMN_MEDICAMENT_ID_RAPPEL = "id";


    //TABLE MEDICAMENTS
    private static final String TABLE_MEDICAMENT = "medicaments";
    private static final String COLUMN_ID_MEDICAMENT = "id";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_DOSE = "dose";
    private static final String COLUMN_NB_PRISE = "nb_prise";
    private static final String COLUMN_TRAITEMENT = "traitment";
    private static final String COLUMN_QUANTITE = "quantity";
    private static final String COLUMN_TEMPS_PRISE = "time_prise";

    //TABLE MEDECIN
    private static final String TABLE_DOCTORS = "medecins";
    private static final String COLUMN_ID_DOCTOR = "id";
    private static final String COLUMN_DOCTOR_NAME = "nom_medi";
    private static final String COLUMN_SPE = "specialite";
    private static final String COLUMN_DOCTOR_NUMBER = "telephone";
    private static final String COLUMN_ID_ORDONNACE = "id";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("PRAGMA foreign_keys=ON;");

        String query = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT, " + COLUMN_EMAIL + " TEXT, " + COLUMN_PASSWORD + " TEXT, " + COLUMN_CONFIRM + " TEXT);";
        sqLiteDatabase.execSQL(query);

        String query1 = "CREATE TABLE " + TABLE_ORDONNANCE + " (" + COLUMN_ID_ORD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATE + " TEXT, " + COLUMN_NOM_MEDE + " TEXT, " + COLUMN_SPECIALITE + " TEXT, " + COLUMN_ADDRESS + " TEXT, " + COLUMN_TELEPHONE + " TEXT, " + COLUMN_MAIL + " TEXT, " + COLUMN_NOM_MEDI + " TEXT, " + COLUMN_DOSAGE + " TEXT, " + COLUMN_FREQUENCE + " TEXT, " + COLUMN_NOMBRES_BOITES + " TEXT, " + COLUMN_MOMENT_PRISE + " TEXT, " + COLUMN_IMAGE + " TEXT);";
        sqLiteDatabase.execSQL(query1);

        String query2 = "CREATE TABLE " + TABLE_DONS + " (" + COLUMN_ID_DONS + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_QUANTITES + " TEXT, " + COLUMN_NOM_DONS + " TEXT, " + COLUMN_DATE_EXPIRARTION + " TEXT," + "FOREIGN KEY (" + COLUMN_MEDICAMENT_ID_DONS + ") REFERENCES " + TABLE_MEDICAMENT + "(" + COLUMN_ID_MEDICAMENT + ")" +");";
        sqLiteDatabase.execSQL(query2);

        String query3 = "CREATE TABLE " + TABLE_NOTE + " (" + COLUMN_ID_NOTE + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DESCRIPTION + " TEXT, " + COLUMN_ADVICE + " TEXT, " + COLUMN_EFFETS + " TEXT, " + COLUMN_REMARQUES + " TEXT, " + "FOREIGN KEY (" + COLUMN_MEDICAMENT_ID_NOTE + ") REFERENCES " + TABLE_MEDICAMENT + "(" + COLUMN_ID_MEDICAMENT + ")" +");";
        sqLiteDatabase.execSQL(query3);

        String query4 = "CREATE TABLE " + TABLE_RAPPEL + " (" + COLUMN_ID_RAPPEL + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HEURE + " TEXT, " + COLUMN_MINUTE + " TEXT, " + COLUMN_JOUR + " TEXT, " + COLUMN_NOMBRE_REP + " TEXT, "  + "FOREIGN KEY (" + COLUMN_MEDICAMENT_ID_RAPPEL + ") REFERENCES " + TABLE_MEDICAMENT + "(" + COLUMN_ID_MEDICAMENT + ")" +");";
        sqLiteDatabase.execSQL(query4);

        String query5 = "CREATE TABLE " + TABLE_MEDICAMENT + " (" + COLUMN_ID_MEDICAMENT + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NOM + " TEXT, " + COLUMN_DOSE + " TEXT, " +  COLUMN_NB_PRISE + " INTEGER, " + COLUMN_TRAITEMENT + " TEXT, " + COLUMN_QUANTITE + " INTEGER, " + COLUMN_TEMPS_PRISE + " TEXT);";
        sqLiteDatabase.execSQL(query5);

        String query6 = "CREATE TABLE " + TABLE_DOCTORS + " (" + COLUMN_ID_DOCTOR + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DOCTOR_NAME + " TEXT, " + COLUMN_SPE + " TEXT, " + COLUMN_DOCTOR_NUMBER + " TEXT, " + "FOREIGN KEY (" + COLUMN_ID_ORDONNACE + ") REFERENCES " + TABLE_ORDONNANCE + "(" + COLUMN_ID_ORD + ")" +");";
        sqLiteDatabase.execSQL(query6);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDONNANCE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_DONS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_RAPPEL);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICAMENT);
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

    void addOrdonnace(int date, String doctor, String specialite, String address, String phone, String email, String medecin, String dose, String frequence, String box_numbers, String take_moment, String image) {
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

    void addNote(String descriptions, String conseils, String effets_secon, String remarques,  int medicamentId) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DESCRIPTION, descriptions);
        cv.put(COLUMN_ADVICE, conseils);
        cv.put(COLUMN_EFFETS, effets_secon);
        cv.put(COLUMN_REMARQUES, remarques);
        cv.put(COLUMN_MEDICAMENT_ID_NOTE, medicamentId);
        long result = sqLiteDatabase.insert(TABLE_NOTE, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Echec dans l'enregistrement de données", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Note ajoutée avec succès !", Toast.LENGTH_SHORT).show();
        }
    }

    void addMedicament(String nom, String dose, int nb_prise, String traitment,  int quantity, String time_prise) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOM, nom);
        cv.put(COLUMN_DOSE, dose);
        cv.put(COLUMN_NB_PRISE, nb_prise);
        cv.put(COLUMN_TRAITEMENT, traitment);
        cv.put(COLUMN_QUANTITE, quantity);
        cv.put(COLUMN_TEMPS_PRISE, time_prise);

        long result = sqLiteDatabase.insert(TABLE_MEDICAMENT, null, cv);
        if (result == -1) {
            Toast.makeText(context, "result" +result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "LE médicament a été  ajoutée avec succès !", Toast.LENGTH_SHORT).show();
        }
    }




}
