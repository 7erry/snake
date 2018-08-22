package org.hazelcast.demo;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by terrywalters on 8/9/18.
 * @author Terry Walters
 */
public class Login {

    public static boolean authenticate(String username, String password) throws IOException {
/**
 * Future use:
 * This would be enabled in order to facilitate user name and password
 *
        // attempt to use hazelcast rest for authentication
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(hzURL+"maps/snake-game-users/"+username);
        HttpResponse response = client.execute(request);
        BufferedReader rd = new BufferedReader (new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        while ((line = rd.readLine()) != null) {
            if(!line.equals("")) {
                if (line.equalsIgnoreCase(username))
                    return true;
                //else
                    //register(username, password);
            }
        }
*/
        return true;
    }


}