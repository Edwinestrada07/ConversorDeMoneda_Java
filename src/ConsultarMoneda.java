import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {

    private static final String API_KEY = "e4edf09d16ff02660ab9b429";

    public Moneda buscarMoneda(String monedaBase, String monedaTarget) {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + monedaBase + "/" + monedaTarget;

        URI directionApi = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(directionApi)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar la moneda: " + e.getMessage(), e);
        }
    }
}