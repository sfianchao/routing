package idsl.crosschain.routing.controller;

import idsl.crosschain.routing.service.DeployService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deploy")
public class DeployController {
    public final DeployService deployService;

    public DeployController(DeployService deployService) {
        this.deployService = deployService;
    }

    @PostMapping(value = "/contract/proxy")
    public ResponseEntity<?> deployContract() {
        return new ResponseEntity<>(deployService.deployContract("Relay"), HttpStatus.CREATED);
    }

}
