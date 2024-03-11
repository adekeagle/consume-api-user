package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UserApiHandler {

    private final static String USER_API = "https://jsonplaceholder.typicode.com/users";

    private final HttpClient httpClient = HttpClient.newHttpClient();

    public HttpResponse<String> getUserApiById(int userId) {
        HttpRequest request = HttpRequest.newBuilder(URI.create(USER_API + "/" + userId)).GET().build();

        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
