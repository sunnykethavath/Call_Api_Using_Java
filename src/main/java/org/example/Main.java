package org.example;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        String myurl = "https://api.nationalize.io/?name=nathaniel";
        URL url = new URL(myurl);
        HttpURLConnection connect = (HttpURLConnection)url.openConnection();
        int resopnseCode = connect.getResponseCode();

        if(resopnseCode == 200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            StringBuilder apiData = new StringBuilder();
            String str = null;

            while((str = in.readLine()) != null){
                apiData.append(str);
            }
            in.close();
            JSONObject jsonResponse = new JSONObject(apiData.toString());
            System.out.println(jsonResponse);
        }else
            System.out.println("Api could not be made");
    }
}