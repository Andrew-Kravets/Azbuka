package com.andrewkravets.azbuka.tools;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew Kravets - SteelKiwi
 * Date: 05.10.12
 * Time: 17:06
 */
public class Connector {

    private  static final String BASE_LIB_URL = "http://azbyka.ru/otechnik/json/";

    private static DefaultHttpClient getDefaultHttpClient() {
        return new DefaultHttpClient();
    }

    public static String getEntities(String url){
        String content = null;
        DefaultHttpClient dhc = getDefaultHttpClient();
        HttpGet get;
        if(url==null) {
            get = new HttpGet(BASE_LIB_URL);
        } else {
            get = new HttpGet(url);
        }
        try {
            HttpResponse response = dhc.execute(get);
            if (response != null) {
                content = EntityUtils.toString(response.getEntity(), "utf8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
