package br.com.cast.turmaformacao.estoque.sync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import br.com.cast.turmaformacao.estoque.model.services.EstoqueBusinessService;

public class GetEstoques extends AsyncTask<Void, Void, Void> {
    private Context context;
    @Override
    protected Void doInBackground(Void... params) {
        EstoqueBusinessService.synchronize();
        return null;
    }
}