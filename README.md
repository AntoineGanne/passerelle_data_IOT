passerelle_data_IOT


infos a stocker en base:
* timestamp
* id_compteur



measurement: mesures

tags:
* id_compteur
* option_tarifaire?

fields:
* puissance apparente
* conso compteur totale
* politique tarifaire (Tarif en cours)




http://192.168.20.104/api/xdevices.json?cmd=10

 https://www.hivemq.com/blog/mqtt-client-library-enyclopedia-hivemq-mqtt-client/



insert compteur_id 

grafana login: admin admin

docker exec -it mosquitto sh 

mosquitto_pub -t 'data' -m '1256 12 200'



docker exec -it influxdb sh

shows SERIES on compteur

