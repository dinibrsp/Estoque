package br.com.cast.turmaformacao.estoque.sync;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import br.com.cast.turmaformacao.estoque.R;
import br.com.cast.turmaformacao.estoque.model.entities.Estoque;
import br.com.cast.turmaformacao.estoque.model.http.EstoqueService;

public class SalvaEstoque extends AsyncTask<Estoque, Void, Void> {
    private Context context;
    private Estoque estoque;

    ProgressDialog progressDialog;


    @Override
    protected Void doInBackground(Estoque... estoque) {
        EstoqueService.saveEstoque(estoque[0]);
        return null;
    }
}


