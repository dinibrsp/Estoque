package br.com.cast.turmaformacao.estoque.controllers.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


import java.util.List;
import java.util.concurrent.ExecutionException;

import br.com.cast.turmaformacao.estoque.R;
import br.com.cast.turmaformacao.estoque.controllers.adapters.EstoqueListAdapter;
import br.com.cast.turmaformacao.estoque.model.entities.Estoque;
import br.com.cast.turmaformacao.estoque.model.http.EstoqueService;
import br.com.cast.turmaformacao.estoque.model.services.EstoqueBusinessService;

public class EstoqueListActivity extends AppCompatActivity {

    private ListView listViewEstoqueList;
    private Estoque selectedEstoque;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque_list);

        bindEstoqueList();

    }

    private void onMenuUpdateClick() throws ExecutionException, InterruptedException {
        new getEstoques().execute();
    }

    private void bindEstoqueList(){
        listViewEstoqueList = (ListView) findViewById(R.id.listViewEstoqueList);
        registerForContextMenu(listViewEstoqueList);
        listViewEstoqueList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                EstoqueListAdapter adapter = (EstoqueListAdapter) listViewEstoqueList.getAdapter();
                selectedEstoque = adapter.getItem(position);
                return false;
            }
        });
    }

    protected  void onResume(){
        updateEstoqueList();
        super.onResume();
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_estoque_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context_estoque_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menu_add:
                onMenuAddClick();
                break;

            case R.id.menu_update:
                try {
                    onMenuUpdateClick();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onMenuAddClick() {
        Intent goToEstoqueFormActivity = new Intent(EstoqueListActivity.this, EstoqueFormActivity.class);
        startActivity(goToEstoqueFormActivity);
    }


    public void updateEstoqueList() {
        List<Estoque> values = EstoqueBusinessService.findAll();
        listViewEstoqueList.setAdapter(new EstoqueListAdapter(this, values));
        EstoqueListAdapter adapter = (EstoqueListAdapter) listViewEstoqueList.getAdapter();
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_delete:
                onMenuDeleteClick();
                break;
            case R.id.menu_edit:
                onMenuEditClick();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void onMenuDeleteClick(){
        new AlertDialog.Builder(EstoqueListActivity.this).setTitle("Certeza?").setMessage("Deletar").setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EstoqueBusinessService.delete(selectedEstoque);
                selectedEstoque = null;
                updateEstoqueList();
                Toast.makeText(EstoqueListActivity.this, "Deletado", Toast.LENGTH_SHORT).show();
            }
        })
                .setNeutralButton("Nao", null).create().show();

    }




    private class getEstoques extends AsyncTask<Void, Void, Void> {

        ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(EstoqueListActivity.this);
            progressDialog.setMessage("Carregando");
            progressDialog.show();

        }

        @Override
        protected Void doInBackground(Void... params) {
            EstoqueBusinessService.synchronize();
            return null;
        }

        @Override
        protected void onPostExecute(Void avoid) {
            super.onPostExecute(avoid);
            progressDialog.dismiss();
            updateEstoqueList();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }

    private void onMenuEditClick(){
        Intent goToEstoqueForm = new Intent(EstoqueListActivity.this, EstoqueFormActivity.class);
        goToEstoqueForm.putExtra(EstoqueFormActivity.PARAM_ESTOQUE, selectedEstoque);
        startActivity(goToEstoqueForm);
    }



}
