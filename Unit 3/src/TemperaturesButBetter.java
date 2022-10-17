import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TemperaturesButBetter {
    public static void main(String[] args) {
        String url = "https://api.weather.gov/gridpoints/PSR/158,57/forecast";
        String response = getResponse(url);
        System.out.println(response);
    }

    private static String getResponse(String url) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            return client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            throw new RuntimeException("Error getting response.");
        }
    }
}
