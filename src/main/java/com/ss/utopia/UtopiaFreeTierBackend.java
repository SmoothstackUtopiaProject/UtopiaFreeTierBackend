package com.ss.utopia;

import java.util.Map;

import com.stripe.Stripe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtopiaFreeTierBackend {

  private static final String STRIPE_API_KEY = "STRIPE_API_KEY";

  public static void main(String[] args) {
    
    // Environment Variables
    Map<String, String> env = System.getenv();
    for (String envName : env.keySet()) {
      
      // Stripe
      if(envName.equals(STRIPE_API_KEY)) {
        Stripe.apiKey = env.get(STRIPE_API_KEY);
      }
    }

    // Run
    SpringApplication.run(UtopiaFreeTierBackend.class, args);
  }
}