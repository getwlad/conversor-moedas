/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wladmir.conversor.moedas.model.Moeda;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Wladmir Rodrigues
 */
public class Api {
    public static List<Moeda> moedas = new ArrayList<>();
    public Api() {
        //Url da api
        String urlApi = "https://economia.awesomeapi.com.br/last/BRL-USD,BRL-EUR,BRL-GBP,BRL-JPY,BRL-KRW,USD-BRL,EUR-BRL,GBP-BRL,JPY-BRL";
        try {
            // Criar a URL da API
            URL url = new URL(urlApi);

            // Abrir uma conexão HTTP
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Configurar o método da requisição (GET neste caso)
            connection.setRequestMethod("GET");

            // Ler a resposta da requisição
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Fechar a conexão
            connection.disconnect();
            
             // Converter a resposta JSON 
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response.toString());

            // Iterar sobre os pares chave-valor do objeto JSON
             Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> entry = fields.next();
                    String code = entry.getKey();
                    JsonNode node = entry.getValue();
                    Moeda objeto = new Moeda(code, node.get("name").asText(), node.get("bid").asDouble());
                    moedas.add(objeto);
                }
                
//            for (Moeda objeto : moedas) {
//                System.out.println(objeto); // Imprime cada objeto
//            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     
}
