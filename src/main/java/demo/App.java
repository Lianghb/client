package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by boxfish on 15/12/29.
 */


@SpringBootApplication
@EnableOAuth2Client
@EnableOAuth2Sso
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


    @RequestMapping("/")
    public String home(Principal principal) {
        return "Hello, " + principal.getName() + " !";
    }
}
