package com.anthonyguthrie.zdailycode_004;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class Zdailycode004Application implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(Zdailycode004Application.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Application running...");

		HttpClient client = HttpClient.newBuilder().build();

		HttpRequest req = HttpRequest.newBuilder(URI.create("https://zoo-animal-api.herokuapp.com/")).build();

		HttpResponse<String> send = client.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(send.body());
	}
}
