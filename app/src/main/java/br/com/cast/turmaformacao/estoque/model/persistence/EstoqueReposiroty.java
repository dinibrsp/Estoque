package br.com.cast.turmaformacao.estoque.model.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public final class EstoqueReposiroty {

    private EstoqueReposiroty(){
        super();
    }

    public static void save(Estoque estoque){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = EstoqueContract.getContentValues(estoque);
        if(estoque.getId() == null) {
            db.insert(EstoqueContract.TABLE, null, values);
        }else{
            String where = EstoqueContract.ID + " = ? ";
            String[] params = {estoque.getId().toString()};
            db.update(EstoqueContract.TABLE, values, where, params);
        }
        db.close();
        databaseHelper.close();
    }


    public static List<Estoque> getAll(){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(EstoqueContract.TABLE, EstoqueContract.COLUNS, null, null, null, null, null);
        List<Estoque> values = EstoqueContract.getEstoques(cursor);

        db.close();
        databaseHelper.close();
        return values;
    }

    public static void delete (long id){
        DatabaseHelper databaseHelper = DatabaseHelper.getInstance();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String where = EstoqueContract.ID + " = ? ";
        String[] params = {String.valueOf(id)};
        db.delete(EstoqueContract.TABLE, where, params);

        db.close();
        databaseHelper.close();
    }




}
