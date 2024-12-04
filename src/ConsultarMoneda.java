import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    // Clave API utilizada para autenticar las solicitudes hacia el servicio externo.
    private static final String API_KEY = "e4edf09d16ff02660ab9b429";

    // Método que busca información de una moneda específica a través de una API de intercambio de divisas.
    // Recibe como parámetros la moneda base (monedaBase) y la moneda objetivo (monedaTarget).
    // Construye una URL para realizar la solicitud a la API usando la clave de acceso (API_KEY).
    // Utiliza HttpClient para enviar la solicitud GET y procesa la respuesta con Gson para mapearla al objeto Moneda.
    // Si ocurre un error en el proceso, lanza una RuntimeException con un mensaje detallado.
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