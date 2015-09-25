package br.com.cast.turmaformacao.estoque.controllers.adapters;


import android.app.Activity;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;
import br.com.cast.turmaformacao.estoque.R;
import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public class EstoqueListAdapter extends BaseAdapter {

    private List<Estoque> estoqueList;
    private Activity context;

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
        Estoque estoque = getItem(position);
        View estoqueListItemView = context.getLayoutInflater().inflate(R.layout.list_item_estoque, parent, false);

        int hexColor = android.graphics.Color.parseColor("#673AB7");

        ImageView imageView = (ImageView)estoqueListItemView.findViewById(R.id.ViewImage);
        imageView.findViewById(R.id.ViewImage).setBackgroundColor(hexColor);

        TextView textViewName = (TextView)estoqueListItemView.findViewById(R.id.textViewName);
        textViewName.setText(estoque.getName());

        TextView textViewDescription = (TextView)estoqueListItemView.findViewById(R.id.textViewDescription);
        textViewDescription.setText(estoque.getDescription());

        TextView textViewAmount = (TextView)estoqueListItemView.findViewById(R.id.textViewAmount);
        textViewAmount.setText(estoque.getQuant().toString());

        TextView textViewValue = (TextView)estoqueListItemView.findViewById(R.id.textViewValue);
        textViewValue.setText(estoque.getValue().toString());


        return estoqueListItemView;
    }
}
