package com.malcolmjh.slicerplotgen.net;

import com.malcolmjh.slicerplotgen.SlicerPlotGen;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;

public class API {
    public static String getXposByPlayerID(UUID UUID, SlicerPlotGen plugin) {
        String GETIP = plugin.getConfig().getString("GET-API");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + GETIP + ":8080/get_xpos_by_player_id?playerId=" + UUID))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> returnedxpos;
        try {
            returnedxpos = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException error) {
            System.out.println("IOException");
            throw new RuntimeException(error);
        } catch (InterruptedException error) {
            System.out.println("InterruptedException");
            throw new RuntimeException(error);
        } catch (IllegalArgumentException error) {
            System.out.println("IllegalArgumentException");
            throw new RuntimeException(error);
        } catch (SecurityException error) {
            System.out.println("SecurityException");
            throw new RuntimeException(error);
        }
        return returnedxpos.body();
    }
    public static String getPlayerIDByXpos(String xpos, SlicerPlotGen plugin) {
        String GETIP = plugin.getConfig().getString("GET-API");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + GETIP + ":8080/get_player_id_by_xpos?xpos=" + xpos))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> returnedplayerID;
        try {
            returnedplayerID = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException error) {
            System.out.println("IOException");
            throw new RuntimeException(error);
        } catch (InterruptedException error) {
            System.out.println("InterruptedException");
            throw new RuntimeException(error);
        } catch (IllegalArgumentException error) {
            System.out.println("IllegalArgumentException");
            throw new RuntimeException(error);
        } catch (SecurityException error) {
            System.out.println("SecurityException");
            throw new RuntimeException(error);
        }
        return returnedplayerID.body();
    }
    public static String setSliceOwnerByXpos(UUID UUID, int xpos, SlicerPlotGen plugin) {
        String POSTIP = plugin.getConfig().getString("POST-API");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://" + POSTIP + ":8181/set_slice_owner_by_xpos?xpos=" + xpos + "&playerId=" + UUID))
                .method("POST", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> returneddata;
        try {
            returneddata = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException error) {
            System.out.println("IOException");
            throw new RuntimeException(error);
        } catch (InterruptedException error) {
            System.out.println("InterruptedException");
            throw new RuntimeException(error);
        } catch (IllegalArgumentException error) {
            System.out.println("IllegalArgumentException");
            throw new RuntimeException(error);
        } catch (SecurityException error) {
            System.out.println("SecurityException");
            throw new RuntimeException(error);
        }
        return returneddata.body();
    }

}
