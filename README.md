Comando para visualizar mensajes publicados en tópico "ordenes".

docker exec -it capacitacion-kafka-kafka-1 kafka-console-consumer --bootstrap-server localhost:9092 --topic ordenes --from-beginning


