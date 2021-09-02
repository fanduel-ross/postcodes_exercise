package http_management.basic_managers;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public abstract class HttpGetManager extends HttpManager {

    public HttpGetManager(String urlString) {
        super(urlString);
    }

    public void makeUrlCall() {
        HttpGet httpGet = new HttpGet(buildUrl());

        try {
            httpResponse = client.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}