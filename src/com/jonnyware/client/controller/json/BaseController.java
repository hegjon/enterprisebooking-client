package com.jonnyware.client.controller.json;

import com.jonnyware.client.Connection;
import com.jonnyware.model.BaseModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseController<T extends BaseModel> {

    protected Connection connection;

    public BaseController(Connection connection) {
        this.connection = connection;
    }

    protected abstract String getURI();

    protected abstract String getEntityName();

    protected abstract T fromJSONObject(JSONObject json) throws JSONException;

    protected T fromJSONString(String json) throws JSONException {
        return fromJSONObject(new JSONObject(json));
    }

    protected JSONObject toJSONObject(T entity) {
        JSONObject result = new JSONObject(entity);
        result.remove("class");
        return result;
    }

    protected List<T> list(String uri) throws JSONException, IOException{
        JSONArray array = new JSONArray(connection.GET(uri));

        List<T> records = new ArrayList<T>(array.length());
        for (int i = 0; i < array.length(); i++) {
            T entity = fromJSONObject(array.getJSONObject(i));
            records.add(entity);
        }
        
        return records;
    }

    public List<T> list() throws JSONException, IOException {
        return list(getURI());
    }

    public T show(int id) throws IOException, JSONException {
        JSONObject object = new JSONObject(connection.GET(getURI() + id));
        T entity = fromJSONObject(object);

        return entity;
    }

    public T create(T entity) throws IOException, JSONException {
        JSONObject object = new JSONObject();
        object.put(getEntityName(), toJSONObject(entity));
        String httpResult = connection.POST(getURI(), object.toString());
        entity = fromJSONString(httpResult);
        
        return entity;
    }
    
    public T update(T entity) throws IOException, JSONException, JSONException {
        JSONObject values = toJSONObject(entity);
        int id = (Integer) values.remove("id");
        JSONObject object = new JSONObject();
        object.put(getEntityName(), values);
        
        String httpResult = connection.PUT(getURI() + id, object.toString());

        return fromJSONString(httpResult);
    }

    public void destroy(int id) throws IOException {
        connection.DELETE(getURI() + id);
    }    
}
