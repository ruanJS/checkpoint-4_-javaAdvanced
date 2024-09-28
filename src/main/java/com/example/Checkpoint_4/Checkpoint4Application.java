package com.example.Checkpoint_4;

import ch.qos.logback.core.net.server.Client;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import server.Server;

@SpringBootApplication
public class Checkpoint4Application {

	public static void main(String[] args) {
		SpringApplication.run(Checkpoint4Application.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			// Iniciar o servidor em uma thread
			new Thread(() -> {
				try {
					new Server().startServer();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}).start();

			// Iniciar o cliente após um breve atraso
			try {
				Thread.sleep(1000); // Aguarda o servidor iniciar
				new Client() {
					public void startClient() {
					}

					@Override
					public void run() {

					}

					@Override
					public void close() {
						
					}
				}.startClient();
			} catch (Exception e) {
				e.printStackTrace();
			}
		};
	}
}
