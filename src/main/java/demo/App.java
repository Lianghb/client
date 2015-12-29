package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.security.Principal;

/**
 * Created by boxfish on 15/12/29.
 */


@SpringBootApplication
@EnableOAuth2Client
//@EnableOAuth2Sso
@RestController
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    RestOperations restOperations;

    @RequestMapping("/")
    public String home(Principal principal) {
        String result = null;
 result = getFrom("http://localhost:8082/server/me", String.class);
        return "Hello, " + principal.getName() + " !" + "<p> result:" + result + "</p>";
    }


    public <T> T getFrom(String url, Class<T> t) {
        return restOperations.getForObject(URI.create(url), t);
    }
}