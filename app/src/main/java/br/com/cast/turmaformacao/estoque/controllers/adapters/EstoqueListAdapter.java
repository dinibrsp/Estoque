package br.com.cast.turmaformacao.estoque.controllers.adapters;


import android.app.Activity;
import android.graphics.PorterDuff;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import java.util.List;
import java.util.ResourceBundle;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;
import br.com.cast.turmaformacao.estoque.R;
import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public abstract class EstoqueListAdapter extends BaseAdapter {

    private List<Estoque> estoqueList;
    private Activity context;
    private ResourceBundle resources;
    private Estoque estoque;

    public EstoqueListAdapter(Activity context, List<Estoque> estoqueList){
        this.context = context;
        this.estoqueList = estoqueList;
    }


    public void setDataValues(List<Estoque> values){
        estoqueList.clear();
        estoqueList.addAll(values);
    }

    @Override
    public int getCount() {
        return estoqueList.size();
    }

    @Override
    public Estoque getItem(int position) {
        return estoqueList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        estoque = getItem(position);
        View estoqueListItemView = context.getLayoutInflater().inflate(R.layout.list_item_estoque, parent, false);

        int hexColor = android.graphics.Color.parseColor("#673AB7");



        ImageView imageView = (ImageView)estoqueListItemView.findViewById(R.id.ViewImage);
        //imageView.findViewById(R.id.ViewImage).setBackgroundColor(hexColor);


        TextView textViewName = (TextView)estoqueListItemView.findViewById(R.id.textViewName);
        textViewName.setText(estoque.getName());

        TextView textViewAmount = (TextView)estoqueListItemView.findViewById(R.id.textViewAmount);
        textViewAmount.setText(estoque.getQuant().toString());

        TextView textViewValue = (TextView)estoqueListItemView.findViewById(R.id.textViewValue);
        textViewValue.setText(estoque.getValue().toString());

        /*Toolbar toolbar = (Toolbar) estoqueListItemView.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.menu_context_estoque_list);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.menu_delete:
                        onMenuDeleteClick(estoque);
                        break;
                    case R.id.menu_edit:
                        onMenuEditClick(estoque);
                        break;
                }
                return true;
            }
        });*/


        return estoqueListItemView;
    }
    public abstract void onMenuEditClick(Estoque estoque);

    public abstract void onMenuDeleteClick(Estoque estoque);

}
