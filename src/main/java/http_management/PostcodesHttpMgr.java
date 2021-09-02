package http_management;

import config_management.ConfigManager;
import http_management.basic_managers.HttpGetManager;

public class PostcodesHttpMgr extends HttpGetManager {

    public PostcodesHttpMgr(String postcode) {
        super(ConfigManager.postcodesBaserUrl() +
                ConfigManager.postcodesEndpoint() + "/" + postcode);

    }


    }






