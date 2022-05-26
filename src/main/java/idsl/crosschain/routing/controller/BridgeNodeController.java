package idsl.crosschain.routing.controller;

import idsl.crosschain.routing.model.BridgeNode;
import idsl.crosschain.routing.service.BridgeNodeService;
import idsl.crosschain.routing.service.RoutingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/bridge-node")
public class BridgeNodeController {

    @Autowired
    private BridgeNodeService bridgeNodeService;

    @Autowired
    private RoutingService routingService;

    @Autowired
    private RestTemplate restTemplate;

    public BridgeNodeController() {

    }

    @PostMapping("/set")
    public ResponseEntity<?> setBridgeNode(@RequestBody BridgeNode bridgeNode) {
        return new ResponseEntity<>(bridgeNodeService.setBridgeNode(bridgeNode), HttpStatus.CREATED);
    }

    @GetMapping("/get/{chainName}")
    public ResponseEntity<?> getBridgeNode(@PathVariable String chainName) {
        return new ResponseEntity<>(bridgeNodeService.getBridgeNode(chainName), HttpStatus.OK);
    }

}
