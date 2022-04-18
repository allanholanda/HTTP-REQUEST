package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class getRequest {
    
    public static final String URL_GET = "https://jsonplaceholder.typicode.com/posts";
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        //Cliente Http
        HttpClient client = HttpClient.newHttpClient();
        
        //Requsição
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_GET))
                .build();
        
        //Enviando uma solicitação
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        //Imprimir o conteúdo recebido
        System.out.println(response.statusCode());
        System.out.println(response.body());
    }
}
