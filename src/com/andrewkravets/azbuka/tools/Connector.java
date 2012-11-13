/*
 * Copyright (c) 2012. Andrew Kravets
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

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
                content = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
