package http_management;

import config_management.ConfigManager;
import http_management.basic_managers.HttpPostManager;
import org.json.JSONObject;

public class BulkPostcodesHttpManager extends HttpPostManager {

    public BulkPostcodesHttpManager(String[] postcodes) {
        super(ConfigManager.postcodesBaserUrl() + ConfigManager.postcodesEndpoint());

        JSONObject body = new JSONObject();
        body.put("postcodes", postcodes);
        setBody(body);
    }

}