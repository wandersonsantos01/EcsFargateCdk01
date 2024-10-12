package br.com.binsolution.ecs_fargate_cdk_01.controller;

import br.com.binsolution.ecs_fargate_cdk_01.domain.Name;
import br.com.binsolution.ecs_fargate_cdk_01.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/test")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping("/dog/{name}")
    public ResponseEntity<?> dogTest(@PathVariable String name) {
        LOG.info("Test controller - name: {}", name);
        return ResponseEntity.ok("Name: " + name);
    }

    @GetMapping("/dog/random")
    public ResponseEntity<?> DogNameRandom() {
        String randomUserApiUrl = "https://randomuser.me/api/";
        LOG.info("Calling external API: {}", randomUserApiUrl);
        String response = restTemplate.getForObject(randomUserApiUrl, String.class);
        LOG.info("Response from external API: {}", response);

        try {
            User user = objectMapper.readValue(response, User.class);
            Name res = user.getResults().get(0).getName();
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            LOG.error("Error parsing response from external API: {}", e.getMessage());
            return ResponseEntity.status(500).body("Error parsing response");
        }
    }

}
