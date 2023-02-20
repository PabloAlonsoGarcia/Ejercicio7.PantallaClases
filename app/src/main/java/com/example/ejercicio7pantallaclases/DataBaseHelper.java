package com.example.ejercicio7pantallaclases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {



    public static final String PERSONAJE = "PERSONAJE";
    public static final String COLUMN_NOMBRE_PERSONAJE = "NOMBRE_PERSONAJE";
    public static final String COLUMN_RAZA_PERSONAJE = "RAZA_PERSONAJE";
    public static final String COLUMN_CLASE_PERSONAJE = "CLASE_PERSONAJE";
    public static final String COLUMN_FUERZA_PERSONAJE = "FUERZA_PERSONAJE";
    public static final String COLUMN_DEFENSA_PERSONAJE = "DEFENSA_PERSONAJE";
    public static final String COLUMN_VIDA_PERSONAJE = "VIDA_PERSONAJE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "app.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTablePersonaje=
                "CREATE TABLE " + PERSONAJE + " (" + COLUMN_NOMBRE_PERSONAJE + " TEXT PRIMARY KEY, " + COLUMN_RAZA_PERSONAJE + " TEXT, " + COLUMN_CLASE_PERSONAJE + " TEXT," + COLUMN_FUERZA_PERSONAJE + " INTEGER," + COLUMN_DEFENSA_PERSONAJE + " INTEGER," + COLUMN_VIDA_PERSONAJE + " INTEGER)";

        sqLiteDatabase.execSQL(createTablePersonaje);


    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Personaje p1){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NOMBRE_PERSONAJE,p1.getNombre());
        cv.put(COLUMN_RAZA_PERSONAJE,p1.getRaza());
        cv.put(COLUMN_CLASE_PERSONAJE,p1.getClase());
        cv.put(COLUMN_FUERZA_PERSONAJE,p1.getFuerza());
        cv.put(COLUMN_DEFENSA_PERSONAJE,p1.getDefensa());
        cv.put(COLUMN_VIDA_PERSONAJE,p1.getVida());


        long insert = db.insert(PERSONAJE, null, cv);
        if(insert == -1){
            return  false;
        }else {
            return true;
        }

    }

    public List<String> getEveryone2(){
        List<Personaje> returnList = new ArrayList<>();

        //Obtener la informacion de los personajes de la base de datos

        String queryString = "SELECT * FROM " + PERSONAJE;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);

        if(cursor.moveToFirst()){
            do{
                String nombrePj  = cursor.getString(0);
                String razaPj = cursor.getString(1);
                String clasePj = cursor.getString(2);
                int ataquePj = cursor.getInt(3);
                int defensaPj = cursor.getInt(4);
                int vidaPj = cursor.getInt(5);


                Personaje pJ = new Personaje(nombrePj,razaPj,clasePj,ataquePj,defensaPj,0,vidaPj,0);
                returnList.add(pJ);



            }while(cursor.moveToFirst());

        }else{
            //fallo. no añadir a la lista.
        }

        cursor.close();
        db.close();

        List<String> listaNombres = new ArrayList<>();

        for (Personaje p1:returnList) {
            listaNombres.add(p1.getNombre());
        }



        return listaNombres;
    }

}
