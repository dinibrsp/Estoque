package br.com.cast.turmaformacao.estoque;


import android.app.Application;

import br.com.cast.turmaformacao.estoque.Util.ApplicationUtil;

public class EstoqueManagerApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtil.setContext(getApplicationContext());


    }
}
