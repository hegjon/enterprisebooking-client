package com.jonnyware.client.controller.json;

import com.jonnyware.client.Connection;
import com.jonnyware.model.Barrack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BarrackController extends BaseController<Barrack> {

    private static String uri = "/barrack/";
    private static String entityName = "barrack";

    public BarrackController(Connection connection) {
        super(connection);
    }

    @Override
    protected Barrack fromJSONObject(JSONObject json) throws JSONException {
        Barrack barrack = new Barrack();
        barrack.setId(json.getInt("id"));
        barrack.setCode(json.getString("code"));
        barrack.setName(json.getString("name"));
        barrack.setCamp_id(json.getInt("camp_id"));
        
        return barrack;
    }

    @Override
    protected String getURI() {
        return uri;
    }

    @Override
    protected String getEntityName() {
        return entityName;
    }
    
    public List<Barrack> listByCamp(int campId) throws JSONException, IOException{
        return list("/camp/" + campId + "/barrack/");
    }
}
