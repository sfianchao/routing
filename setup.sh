#!/bin/bash
set -e

# download & install java 8
echo "step 1. download & install java 8"
sudo apt install openjdk-8-jdk
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin
sudo java -version
sudo javac -version

# download & install web3j
echo "step 2. download & install web3j"
sudo curl -L get.web3j.io | sh
sudo web3j -version

# setup smart contract
echo "step 3. compile solidity file"
sudo web3j generate solidity -b .\Proxy.bin -a .\Proxy.abi -o ./src/main/java -p idsl.crosschain.routing.contract
