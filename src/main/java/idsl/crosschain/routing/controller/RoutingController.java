package idsl.crosschain.routing.controller;

import idsl.crosschain.routing.model.RoutingInfo;
import idsl.crosschain.routing.service.RoutingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/routing")
public class RoutingController {

    private final RoutingService routingService;
    private final RestTemplate restTemplate;

    public RoutingController(RoutingService routingService,
                             RestTemplate restTemplate) {
        this.routingService = routingService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("/response")
    public ResponseEntity<?> responseRoutingInfo() {
        RoutingInfo routingInfo = new RoutingInfo();
        routingInfo.setChainID("relay Chain Id");
        return new ResponseEntity<>(routingInfo, HttpStatus.CREATED);
    }

    @GetMapping("/request")
    public ResponseEntity<?> requestRoutingInfo() {
        RoutingInfo routingInfo = restTemplate.postForObject("http://localhost:8081/routing/response", null, RoutingInfo.class);
        System.out.println(routingInfo.getChainID());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
