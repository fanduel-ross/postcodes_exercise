package http_management.basic_managers;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;

public abstract class HttpManager {

    protected final HttpClient client;
    protected HttpResponse httpResponse;
    protected final String urlString;
    private final HashMap<String, String> queryParams;

    public HttpManager(String urlString) {
        this.urlString = urlString;
        queryParams = new HashMap<>();
        client = HttpClientBuilder.create().build();
    }

    protected String buildUrl() {
        if (queryParams.size() == 0) {
            return urlString;
        }

        StringBuilder queryString = new StringBuilder();
        queryParams.forEach((key, value) -> {
            queryString.append(key).append("=").append(value).append("&");
        });
        queryString.setLength(queryString.length() - 1);

        return urlString + "?" + queryString;
    }

    public abstract void makeUrlCall();

    public String getResponseBody() {
        try {
            return EntityUtils.toString(httpResponse.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Header[] getResponseHeaders() {
        return httpResponse.getAllHeaders();
    }

    public void addQueryParam(String key, String value) {
        queryParams.put(key, value);
    }
}