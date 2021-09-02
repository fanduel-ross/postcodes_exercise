package http_management;

import config_management.ConfigManager;

public class PostcodesHttpMgr extends HttpManager{

    public PostcodesHttpMgr(String postcode) {
        super(ConfigManager.postcodesBaserUrl() +
                ConfigManager.postcodesEndpoint() + "/" + postcode);

    }




}

