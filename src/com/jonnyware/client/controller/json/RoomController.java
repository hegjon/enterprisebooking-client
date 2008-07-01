package com.jonnyware.client.controller.json;

import com.jonnyware.client.Connection;
import com.jonnyware.model.Room;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RoomController extends BaseController<Room> {
    private static String uri = "/room/";
    private static String entityName = "room";

    public RoomController(Connection connection) {
        super(connection);
    }

    @Override
    protected Room fromJSONObject(JSONObject json) throws JSONException {
        Room room = new Room();
        room.setId(json.getInt("id"));
        room.setCode(json.getString("code"));
        room.setBarrack_id(json.getInt("barrack_id"));
        
        return room;
    }

    @Override
    protected String getURI() {
        return uri;
    }

    @Override
    protected String getEntityName() {
        return entityName;
    }
    
    public List<Room> listByBarrack(int barrackId) throws JSONException, IOException{
        return list("/barrack/" + barrackId + "/room/");
    }
}
