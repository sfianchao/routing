package idsl.crosschain.routing.service;

import idsl.crosschain.routing.model.RoutingInfo;

public interface RoutingService {

    /**
     * get routing info with chain name
     *
     * @param chainName
     * @return
     */
    RoutingInfo getRoutingInfo(String chainName);

}
