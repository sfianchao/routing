// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.4.22 <0.9.0;

contract Proxy {

    bridgeNode[] public bridgeNodeList;

    constructor () {
        bridgeNodeList.push(setBridgeNode("229400e1-e22c-4a6e-a7eb-a786941d19d4", "src", "http://140.118.9.225"));
        bridgeNodeList.push(setBridgeNode("97009229-bab6-4513-ba2c-77e393f79547", "relay", "http://140.118.9.226"));
        bridgeNodeList.push(setBridgeNode("65e56d58-e710-40fb-80e5-36405b0d9f77", "dest", "http://140.118.9.227"));
    }

    event registerBridgeNode(string id, string chainName, string ip, string message);

    struct bridgeNode {
        string id;
        string chainName;
        string ip;
    }

    mapping (string => string) chainNameToId;
    mapping (string => bridgeNode) idToBridgeNode;

    function setBridgeNode(string memory _id, string memory _chainName, string memory _ip) public returns (bridgeNode memory) {

        bridgeNode storage node = idToBridgeNode[_id];
        node.id = _id;
        node.chainName = _chainName;
        node.ip = _ip;
        idToBridgeNode[_id] = node;

        chainNameToId[_chainName] = _id;

        emit registerBridgeNode(_id, _chainName, _ip, "set bridge node.");

        return node;
    }

    function getBridgeNodeWithChainName(string memory _chainName) public view returns (string memory id, string memory chainName, string memory ip) {

        bridgeNode memory node = idToBridgeNode[chainNameToId[_chainName]];

        return (node.id, node.chainName, node.ip);
    }

}