#!/bin/bash
set -e

echo "Building project"
mvn clean package -DskipTests

echo "Building docker image"
docker build -t banking-ms:local .

echo "Stopping previous containers"
docker-compose down

echo "Starting stack"
docker-compose up -d --build

echo "CD local completed"
