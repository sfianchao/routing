package idsl.crosschain.routing.service;

import idsl.crosschain.routing.model.RoutingInfo;

public interface RoutingService {

    RoutingInfo getRoutingInfo(String chainName);

}
