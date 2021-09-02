package http_management.basic_managers;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public abstract class HttpPostManager extends HttpManager {

    private JSONObject body;

    public HttpPostManager(String urlString) {
        super(urlString);
    }

    public void setBody(JSONObject body) {
        this.body = body;
    }

    public void makeUrlCall() {
        HttpPost httpPost = new HttpPost(buildUrl());

        StringEntity entity = null;
        try {
            entity = new StringEntity(body.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        try {
            httpResponse = client.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}