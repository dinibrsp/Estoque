package br.com.cast.turmaformacao.estoque.model.persistence;


import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public final class EstoqueContract {

    public static final String TABLE = "estoque";
    public static final String ID = "id";
    public static final String WEBID = "webId";
    public static final String IMAGE = "image";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String QUANT = "quant";
    public static final String MINQUANT = "minquant";
    public static final String VALUE = "value";
    public static final String DATE = "date";

    public static final String [] COLUNS = {ID, WEBID, IMAGE, NAME, DESCRIPTION, QUANT, MINQUANT, VALUE, DATE};


    private EstoqueContract(){
        super();
    }

    public static String getCreateTableScript(){
        final StringBuilder create = new StringBuilder();

        create.append(" CREATE TABLE " + TABLE);
        create.append(" ( ");
        create.append(ID + " INTEGER PRIMARY KEY, ");
        create.append(WEBID + " INTEGER, ");
        create.append(IMAGE + " TEXT, ");
        create.append(NAME + " TEXT, ");
        create.append(DESCRIPTION + " TEXT, ");
        create.append(QUANT + " INTEGER, ");
        create.append(MINQUANT + " INTEGER, ");
        create.append(VALUE + " REAL, ");
        create.append(DATE + " INTEGER ");
        create.append(" ); ");

        return create.toString();
    }

    public static ContentValues getContentValues(Estoque estoque){
        ContentValues values = new ContentValues();
        values.put(EstoqueContract.ID, estoque.get_Id());
        values.put(EstoqueContract.WEBID, estoque.getIdWeb());
        values.put(EstoqueContract.IMAGE, estoque.getImage());
        values.put(EstoqueContract.NAME, estoque.getName());
        values.put(EstoqueContract.DESCRIPTION, estoque.getDescription());
        values.put(EstoqueContract.QUANT, estoque.getQuant());
        values.put(EstoqueContract.MINQUANT, estoque.getMinQuant());
        values.put(EstoqueContract.VALUE, estoque.getValue());
        values.put(EstoqueContract.DATE, estoque.getDate());
        return values;
    }

    public static Estoque getEstoque(Cursor cursor){
        Estoque estoque = new Estoque();
        if(!cursor.isBeforeFirst() || cursor.moveToNext()) {
            estoque.set_Id(cursor.getLong(cursor.getColumnIndex(EstoqueContract.ID)));
            estoque.setIdWeb(cursor.getLong(cursor.getColumnIndex(EstoqueContract.WEBID)));
            estoque.setImage(cursor.getString(cursor.getColumnIndex(EstoqueContract.IMAGE)));
            estoque.setName(cursor.getString(cursor.getColumnIndex(EstoqueContract.NAME)));
            estoque.setDescription(cursor.getString(cursor.getColumnIndex(EstoqueContract.DESCRIPTION)));
            estoque.setQuant(cursor.getLong(cursor.getColumnIndex(EstoqueContract.QUANT)));
            estoque.setMinQuant(cursor.getLong(cursor.getColumnIndex(EstoqueContract.MINQUANT)));
            estoque.setValue(cursor.getDouble(cursor.getColumnIndex(EstoqueContract.VALUE)));
            estoque.setDate(cursor.getLong(cursor.getColumnIndex(EstoqueContract.DATE)));
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
