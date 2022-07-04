#!/bin/bash
set -e

# setup smart contract
echo "step 1. compile solidity file\n"
sudo solc Proxy.sol --bin --abi --optimize --overwrite -o ./

echo "step 2. web3j convert to java class\n"
sudo web3j generate solidity -b ./Proxy.bin -a ./Proxy.abi -o ./src/main/java -p idsl.crosschain.routing.contract

