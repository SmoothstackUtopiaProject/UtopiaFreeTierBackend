package com.ss.utopia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.stripe.Stripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtopiaFreeTierBackend {

  private static final String STRIPE_API_KEY = "stripe.apiKey";

  public static void main(String[] args) {
    // aapplication.properties
    try (BufferedReader bufferedReader = new BufferedReader(
      new FileReader("src/main/resources/application.properties")
    )) {
      String lineText;
      while ((lineText = bufferedReader.readLine()) != null) {

        // Stripe
        if(lineText.startsWith(STRIPE_API_KEY)) {
          Stripe.apiKey = lineText.split("=")[1];
        }

      }
    } 
    catch (IOException error) {
      System.err.println("[ERROR] Unable to find application.properties, shutting down . . .");
      System.exit(0);
    }

    // Run
    SpringApplication.run(UtopiaFreeTierBackend.class, args);
  }
}