package com.jonnyware.client.controller.json;

import com.jonnyware.client.Connection;
import com.jonnyware.model.Camp;
import org.json.JSONException;
import org.json.JSONObject;

public class CampController extends BaseController<Camp> {

    private static String uri = "/camp/";
    private static String entityName = "camp";

    public CampController(Connection connection) {
        super(connection);
    }

    @Override
    protected Camp fromJSONObject(JSONObject json) throws JSONException {
        Camp camp = new Camp();
        camp.setId(json.getInt("id"));
        camp.setCode(json.getString("code"));
        camp.setName(json.getString("name"));

        return camp;
    }

    @Override
    protected String getURI() {
        return uri;
    }

    @Override
    protected String getEntityName() {
        return entityName;
    }
}
