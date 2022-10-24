import org.json.*;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;

//WARNING: READ BEFORE RUNNING!!!!!!
//This code requires the org.json dependancy to be available. 
//To run this program, set up a project with org.json as a dependancy. 
//Then, copy/paste this code into the editor of your choice.

public class Main {
    public static void main(String[] args) {
        double lat;
        double lon;
        JTextField latInput = new JTextField(5);
        JTextField lonInput = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Longitude: "));
        myPanel.add(latInput);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Latitude: "));
        myPanel.add(lonInput);
        int result = JOptionPane.showConfirmDialog(null, myPanel, "Enter current location.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                lat = Double.parseDouble(latInput.getText());
                lon = Double.parseDouble(lonInput.getText());
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input.");
                return;
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Cancelled.");
            return;
        }
        String url = "https://api.weather.gov/points/" + lat + "," + lon;
        String response = getResponse(url);
        JSONObject json = new JSONObject(response);
        if (!Objects.equals(json.getString("type"), "Feature")) {
            if (json.getInt("status") / 100 == 5) System.out.println("There was an issue with the weather data. This is not a bug, please try again later.");
            else System.out.println(json.getString("detail"));
            return;
        }
        url = json.getJSONObject("properties").getString("forecast");

        response = getResponse(url);
        json = new JSONObject(response);
        JSONArray periods = json.getJSONObject("properties").getJSONArray("periods");
        int temp1 = periods.getJSONObject(0).getInt("temperature");
        int temp2 = periods.getJSONObject(1).getInt("temperature");
        int highTemp = Math.max(temp1, temp2);
        int lowTemp = Math.min(temp1, temp2);
        String output = "High: " + highTemp + "°F. Low: " + lowTemp + "°F.\n";
        if (highTemp >= 90) output += "Heat warning!\n";
        if (lowTemp <= 32) output += "Freeze warning!\n";
        if (highTemp - lowTemp > 40) output += "Large temperature swing!\n";
        JOptionPane.showMessageDialog(null, output);
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