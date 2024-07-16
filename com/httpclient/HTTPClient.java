package com.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class HTTPClient {

    public static void main(String args[]) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:9000/Gowtham")).POST(HttpRequest.BodyPublishers.ofString("HTTPClient")).build();
        // Sends request and stores response in path.
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofFile(Path.of("C:\\Users\\gowth\\OneDrive\\Documents\\Json.json")));

        System.out.println(response.request().method());
        System.out.println(response.statusCode());
    }
}
