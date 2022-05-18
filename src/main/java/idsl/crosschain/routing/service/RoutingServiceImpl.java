package idsl.crosschain.routing.service;

import idsl.crosschain.routing.model.RoutingInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class RoutingServiceImpl implements RoutingService {

    private final RestTemplate restTemplate;

    public RoutingServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RoutingInfo getRoutingInfo(String chainName) {

        String url = "http://localhost:8081/bridge-node/get" + "?chainName=" + chainName;
        RoutingInfo routingInfo = restTemplate.getForObject(url, RoutingInfo.class);
        log.info("routing info: {}", routingInfo.getIp());

        return routingInfo;
    }

}
