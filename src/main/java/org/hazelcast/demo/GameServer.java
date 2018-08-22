package org.hazelcast.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.InetAddress;

/**
 * Created by terrywalters on 8/10/18.
 *
 * SnakeGame has been enhanced to be multiplayer
 * A Hazelcast cluster is used for local matches while
 * A remote Hazelcast cluster is used to store scoreboards
 *
 * @author Terry Walters
 */
public class GameServer {

    public static String hzURL="http://35.207.0.219/hazelcast/rest/";

    public static boolean registerGame() {
        /**
         * Register Users IPv4 Address with Hazelcast
         */
        boolean ret = false;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            CloseableHttpClient client = HttpClients.createMinimal();
            HttpPost httpPost = new HttpPost(hzURL + "maps/snake-game-users/" + "terry");//inetAddress.getHostAddress());
            httpPost.setEntity(new StringEntity(inetAddress.getHostName()));
            HttpResponse response = client.execute(httpPost);
            System.out.println(response.getStatusLine());
            ret = (response.getStatusLine().getStatusCode()==200);
        } catch (IOException e ){
            System.out.println(e.getCause());
        }

        return (ret);
    }

    public static boolean putLastScore(int lastScore) {
        /**
         * Register Users IPv4 Address with Hazelcast
         */
        boolean ret = false;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();

            CloseableHttpClient client = HttpClients.createMinimal();
            HttpPost httpPost = new HttpPost(hzURL + "maps/snake-game-scoreboard/" + "terry"); //inetAddress.getHostAddress());
            httpPost.setEntity(new StringEntity(String.valueOf(lastScore)));
            HttpResponse response = client.execute(httpPost);
        }catch (IOException e){
            System.out.println("putLastScore("+lastScore+")");
            System.out.println(e.getCause());
        }

        return (ret);
    }

    public static int getLastScore() {
        /**
         * Register Users IPv4 Address with Hazelcast
         */
        int ret = 0;
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            Content content = Request.Get(hzURL + "maps/snake-game-scoreboard/" + "terry").execute().returnContent();
            ret = Integer.valueOf(content.toString());
        } catch (IOException e) {
            System.out.println("getLastScore(terry)");
            System.out.println(e.getCause());
        }

        return (ret);
    }

}
