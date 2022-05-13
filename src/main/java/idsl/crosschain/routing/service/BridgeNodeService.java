package idsl.crosschain.routing.service;

import idsl.crosschain.routing.model.BridgeNode;

public interface BridgeNodeService {

    String setBridgeNode(BridgeNode bridgeNode);

    BridgeNode getBridgeNode(String chainName);

}
