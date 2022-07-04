#!/bin/bash
set -e

# download & install java 8
echo "step 1. download & install java 8\n"
sudo apt install openjdk-8-jdk
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
export PATH=$PATH:$JAVA_HOME/bin
sudo java -version
sudo javac -version

# download & install solc
echo "step 2. download & install solidity compiler\n"
sudo add-apt-repository ppa:ethereum/ethereum
sudo apt-get update
sudo apt-get install solc
sudo solc --version

# download & install web3j
echo "step 3. download & install web3j\n"
sudo curl -L get.web3j.io | sh
source $HOME/.web3j/source.sh
sudo web3j -version