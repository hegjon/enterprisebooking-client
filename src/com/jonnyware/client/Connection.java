package com.jonnyware.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;

public class Connection {

    private String MESSAGE_FORMAT = "application/json";
    
    private HttpClient client;
    private String url;

    public Connection(String url, String username, String password) {
        this.url = url;
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, password);
        client = new HttpClient();
        client.getParams().setAuthenticationPreemptive(true);
        client.getState().setCredentials(AuthScope.ANY, creds);
    }

    public String GET(String uri) throws IOException {
        GetMethod method = new GetMethod(url + uri);
        method.setRequestHeader("Accept", MESSAGE_FORMAT);
        client.executeMethod(method);
        return method.getResponseBodyAsString();
    }

    public String POST(String uri, String content) throws IOException {
        PostMethod method = new PostMethod(url + uri);
        method.setRequestHeader("Accept", MESSAGE_FORMAT);
        RequestEntity body = new StringRequestEntity(content, MESSAGE_FORMAT, "UTF-8");
        method.setRequestEntity(body);
        client.executeMethod(method);
        return method.getResponseBodyAsString();
    }

    public void DELETE(String uri) throws IOException {
        DeleteMethod method = new DeleteMethod(url + uri);
        client.executeMethod(method);
    }

    public String PUT(String uri,String content) throws UnsupportedEncodingException, IOException {
        PutMethod method = new PutMethod(url + uri);
        method.setRequestHeader("Accept", MESSAGE_FORMAT);
        RequestEntity body = new StringRequestEntity(content, MESSAGE_FORMAT, "UTF-8");
        method.setRequestEntity(body);
        client.executeMethod(method);
        return method.getResponseBodyAsString();
    }
}
