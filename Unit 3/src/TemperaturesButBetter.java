import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TemperaturesButBetter {
    public static void main(String[] args) {
        String url = "https://api.weather.gov/gridpoints/PSR/158,57/forecast";
        String response = getResponse(url);
        System.out.println(response);




        /*
        Goal:
        ✅ Get the response from the API in url variable;
        ❌ Parse response from api to json object;
        ❌ And gather the temperature from the json object;

        I've seen some people use the JSONObject from javax.json library, but that doesn't seem to be packaged with Java since Java 7 (I think).
        Some people also use external libraries like GSON or org.json, but I'm not sure how to add it without creating a package. Also not something I particularly want to deal with.
         */
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