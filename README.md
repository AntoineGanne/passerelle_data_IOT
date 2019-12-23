passerelle_data_IOT



http://192.168.20.104/api/xdevices.json?cmd=10

 https://www.hivemq.com/blog/mqtt-client-library-enyclopedia-hivemq-mqtt-client/



##xommandes utiles de tests

insert compteur_id 

grafana login: admin admin

docker exec -it mosquitto sh 

mosquitto_pub -t 'data' -m '1256 12 200'



docker exec -it influxdb sh

influx -databse compteur

shows SERIES on compteur

