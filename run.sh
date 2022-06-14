#!/bin/bash
set -e

# docker build
echo "Step 1. docker build"
sudo docker build -t routing:0.0.1 .

# docker run
echo "Step 1. docker run"
sudo docker run -d -p 9292:9292 routing:0.0.1
