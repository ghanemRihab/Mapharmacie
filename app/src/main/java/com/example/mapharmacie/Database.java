package com.example.mapharmacie;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "MyDatabase.db";
    private static final String TABLE_NAME = "Ordonnance";

    // Noms des colonnes de la table de ordonnance
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_NOM_MEDE = "nom_medecin";
    private static final String COLUMN_SPECIALITE = "specialite_medecin";
    private static final String COLUMN_ADRESS = "adress_medecin";
    private static final String COLUMN_TELEPHONE = "telephone_medecin";
    private static final String COLUMN_MAIL = "mail_medecin";
    private static final String COLUMN_NOM_MEDI= "nom_medi";
    private static final String COLUMN_DOSAGE = "dosage";
    private static final String COLUMN_FREQUENCE = "frequence";
    private static final String COLUMN_NOMBRES_BOITES = "nombres_boites";
    private static final String COLUMN_MOMENT_PRISE = "moment_prise";
    private static final String COLUMN_IMAGE = "image";


    // Requête SQL pour la création de la table des médicaments
    private static final String CREATE_TABLE_ORDONNANCE = "CREATE TABLE " + TABLE_NAME +
            "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY," +
            COLUMN_DATE + " TEXT," +
            COLUMN_NOM_MEDE + " TEXT," +
            COLUMN_SPECIALITE + " TEXT," +
            COLUMN_ADRESS + " TEXT," +
            COLUMN_TELEPHONE + " TEXT," +
            COLUMN_MAIL + " TEXT," +
            COLUMN_NOM_MEDI + " TEXT," +
            COLUMN_DOSAGE + " TEXT," +
            COLUMN_FREQUENCE + " TEXT," +
            COLUMN_NOMBRES_BOITES + " INTEGER," +
            COLUMN_MOMENT_PRISE + " TEXT," +
            COLUMN_IMAGE + " TEXT" +
            ")";
    Context context ;
    public Database(Context context) {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase  sqLiteDatabase) {
        String qry1 = "create table users(nomEng text,email text,passwordEng text)";
        sqLiteDatabase.execSQL(qry1);
        // Création de la table des médicaments
        sqLiteDatabase.execSQL(CREATE_TABLE_ORDONNANCE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
    //fonction pour assurer l'enregistrement
    public boolean register(String nomEng, String email, String passwordEng){
        ContentValues cv = new ContentValues();
        cv.put("nomEng",nomEng);
        cv.put("email",email);
        cv.put("passwordEng",passwordEng);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("users",null,cv);
        sqLiteDatabase.close();
        return true ;
    }
    // fonction  pour assurer login
    @SuppressLint("Range")
    public int login(String nom, String password){
        int result = 0;  //utilisateur n'existe pas
        String[] str =new String[2];
        str[0]= nom ;
        str[1]= password;
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor c = sqLiteDatabase.rawQuery("select * from users where nomEng=? and passwordEng=?",str);
        // les données  sont trouvées
        if (c.getString(c.getColumnIndex("passwordEng")).equals(password)) {
            result = 1; // utilisateur existe et mot de passe correct
        }
        return result;
    }
    // Méthode pour ajouter un ordonnance dans la base de données
    public void ajouterOrdonnance(String tvdate, String tvmedi, String edSpecialite, String edAdress, String edTelephone, String edMail, String edmedicament, String edDosage, String edFrequence, int edNb_boite, String Sp, String tvimg) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, tvdate);
        values.put(COLUMN_NOM_MEDE, tvmedi);
        values.put(COLUMN_SPECIALITE, edSpecialite);
        values.put(COLUMN_ADRESS, edAdress);
        values.put(COLUMN_TELEPHONE,edTelephone);
        values.put(COLUMN_MAIL , edMail);
        values.put(COLUMN_NOM_MEDI, edmedicament);
        values.put(COLUMN_DOSAGE, edDosage);
        values.put(COLUMN_FREQUENCE, edFrequence);
        values.put(COLUMN_NOMBRES_BOITES, edNb_boite);
        values.put(COLUMN_MOMENT_PRISE, Sp);
        values.put(COLUMN_IMAGE, tvimg);
        long result = db.insert(TABLE_NAME, null, values);
        if (result == -1){
            Toast.makeText(context, "votre donnée n'est pas ajouter", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Votre donnée est ajouté avec succée ", Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    Cursor readAllData (){
        String query = "SELECT * FROM " + TABLE_NAME ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null ;
        if(db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor ;
    }
}
