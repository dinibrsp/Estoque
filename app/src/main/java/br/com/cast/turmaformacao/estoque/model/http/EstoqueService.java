package br.com.cast.turmaformacao.estoque.model.http;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import br.com.cast.turmaformacao.estoque.model.entities.Estoque;

public class EstoqueService {

    private static final String URL = "http://10.11.21.193:4000/api/v1/products/";

    private EstoqueService(){
        super();
    }

        public static List<Estoque> getWebIds(){
            List<Estoque> estoques = new ArrayList<>();


        try {
            java.net.URL url = new URL(URL);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            int responseCode = conn.getResponseCode();
            Log.i("getWebId", "Código de retorno da requisicao de Id: " + responseCode);
            if(responseCode == HttpURLConnection.HTTP_OK){
                InputStream inputStream = conn.getInputStream();

                ObjectMapper objectMapper = new ObjectMapper();
                CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Estoque.class);
                estoques = objectMapper.readValue(inputStream, collectionType);

            }

        } catch (Exception e) {
            Log.e(EstoqueService.class.getName(), "" + e.getMessage());
        }
        return estoques;
    }

    public static void saveEstoque(Estoque estoque){

        try {
            java.net.URL url = new URL(URL);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");

            OutputStream os= conn.getOutputStream();

            new ObjectMapper().writeValue(os, estoque);

            os.flush();
            os.close();

            int responseCode = conn.getResponseCode();
            if(responseCode != HttpURLConnection.HTTP_OK){
                throw new RuntimeException("Error code: "+responseCode);
            }
            conn.disconnect();

            }
        catch (IOException e) {
            Log.e(EstoqueService.class.getName(), "" + e.getMessage());
        }
    }



}
