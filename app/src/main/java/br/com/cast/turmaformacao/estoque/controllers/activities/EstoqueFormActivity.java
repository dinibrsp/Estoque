package br.com.cast.turmaformacao.estoque.controllers.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import br.com.cast.turmaformacao.estoque.R;
import br.com.cast.turmaformacao.estoque.Util.FormHelper;
import br.com.cast.turmaformacao.estoque.model.entities.Estoque;
import br.com.cast.turmaformacao.estoque.model.http.EstoqueService;
import br.com.cast.turmaformacao.estoque.model.services.EstoqueBusinessService;
import br.com.cast.turmaformacao.estoque.sync.SalvaEstoque;

public class EstoqueFormActivity extends AppCompatActivity {
    public static final String PARAM_ESTOQUE = "PARAM_ESTOQUE";
    private EditText editTextName;
    private EditText editTextDescription;
    private EditText editTextQnt;
    private EditText editTextValue;
    private Estoque estoque;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estoque);

        initEstoque();
        bindEditTextName();
        bindEditTextDescription();
        bindEditTextQnt();
        bindEditTextValue();

    }

    private void initEstoque() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.estoque = (Estoque) getIntent().getExtras().getParcelable(PARAM_ESTOQUE);
        } else {
            this.estoque = this.estoque == null ? new Estoque() : estoque;
        }
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                onMenuSaveClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onMenuSaveClick() {
        String required = EstoqueFormActivity.this.getString(R.string.lbl_required);
        if (!FormHelper.validateRequired(required, editTextName, editTextDescription, editTextQnt, editTextValue)) {
            binEstoque();
            EstoqueBusinessService.save(estoque);
            new SalvaEstoque().execute(estoque);
            //Toast.makeText(EstoqueFormActivity.this, R.string.lbl_saved, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private void binEstoque() {
        estoque.setName(editTextName.getText().toString());
        estoque.setDescription(editTextDescription.getText().toString());
        estoque.setQuant(Long.valueOf(editTextQnt.getText().toString()));
        estoque.setValue(Double.parseDouble(editTextValue.getText().toString()));
    }


    public void bindEditTextName() {
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setText(estoque.getName() == null ? "" : estoque.getName());
    }

    public void bindEditTextDescription() {
        editTextDescription = (EditText) findViewById(R.id.editTextDescription);
        editTextDescription.setText(estoque.getDescription() == null ? "" : estoque.getDescription());
    }

    public void bindEditTextQnt() {
        editTextQnt = (EditText) findViewById(R.id.editTextQnt);
        editTextQnt.setText(estoque.getQuant() == null ? "" : estoque.getQuant().toString());
    }

    public void bindEditTextValue() {
        editTextValue = (EditText) findViewById(R.id.editTextValue);
        editTextValue.setText(estoque.getValue() == null ? "" : estoque.getValue().toString());
    }

}
