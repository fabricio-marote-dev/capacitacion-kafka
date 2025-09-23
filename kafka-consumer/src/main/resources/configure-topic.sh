#!/bin/bash

# Configurar el tópico "ordenes" con 3 particiones
~/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic ordenes --partitions 3

# Mostrar info del tópico
~/kafka/bin/kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic ordenes