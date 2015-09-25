package br.com.cast.turmaformacao.estoque.Util;

import android.widget.EditText;

public final class FormHelper {

    private FormHelper(){
        super();
    }

    public static boolean validateRequired(String required, EditText... editTexts){
        boolean hasRequired = false;

        for(EditText editText:editTexts){
            String textValue = editText.getText().toString();
            if(textValue.trim().isEmpty()){
                editText.setError(required);
                hasRequired = true;
            }
        }
        return hasRequired;
    }


}
