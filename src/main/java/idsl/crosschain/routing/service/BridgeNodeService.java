package idsl.crosschain.routing.service;

import idsl.crosschain.routing.model.BridgeNode;
import idsl.crosschain.routing.model.RoutingInfo;

public interface BridgeNodeService {

    String setBridgeNode(BridgeNode bridgeNode);

    RoutingInfo getBridgeNode(String chainName);

}
