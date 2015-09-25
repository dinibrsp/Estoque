package br.com.cast.turmaformacao.estoque.model.persistence;


import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public final class EstoqueContract {

    public static final String TABLE = "estoque";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String QUANT = "quant";
    public static final String MINQUANT = "minquant";
    public static final String VALUE = "value";

    public static final String [] COLUNS = {ID, NAME, DESCRIPTION, QUANT, MINQUANT, VALUE};


    private EstoqueContract(){
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(NAME + " TEXT NOT NULL, ");
        create.append(DESCRIPTION + " TEXT, ");
        create.append(QUANT + " INTEGER NOT NULL, ");
        create.append(MINQUANT + " INTEGER NOT NULL, ");
        create.append(VALUE + " REAL NOT NULL ");
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Estoque estoque){
        ContentValues values = new ContentValues();
        values.put(EstoqueContract.ID, estoque.getId());
        values.put(EstoqueContract.NAME, estoque.getName());
        values.put(EstoqueContract.DESCRIPTION, estoque.getDescription());
        values.put(EstoqueContract.QUANT, estoque.getQuant());
        values.put(EstoqueContract.MINQUANT, estoque.getMinQuant());
        values.put(EstoqueContract.VALUE, estoque.getValue());
        return values;
    }

    public static Estoque getEstoque(Cursor cursor){
        Estoque estoque = new Estoque();
        if(!cursor.isBeforeFirst() || cursor.moveToNext()) {
            estoque.setId(cursor.getLong(cursor.getColumnIndex(EstoqueContract.ID)));
            estoque.setName(cursor.getString(cursor.getColumnIndex(EstoqueContract.NAME)));
            estoque.setDescription(cursor.getString(cursor.getColumnIndex(EstoqueContract.DESCRIPTION)));
            estoque.setQuant(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EstoqueContract.QUANT))));
            estoque.setMinQuant(Integer.parseInt(cursor.getString(cursor.getColumnIndex(EstoqueContract.MINQUANT))));
            estoque.setValue(Double.parseDouble(cursor.getString(cursor.getColumnIndex(EstoqueContract.VALUE))));
            return estoque;
        }
        return null;
    }

    public static List<Estoque> getEstoques(Cursor cursor){
        ArrayList<Estoque> estoques = new ArrayList<>();
        while(cursor.moveToNext()) {
            estoques.add(getEstoque(cursor));
        }
        return estoques;
    }

}
