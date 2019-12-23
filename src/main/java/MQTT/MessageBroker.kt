package MQTT

import java.util.UUID
import com.hivemq.client.mqtt.MqttClient
import java.sql.Time
import java.sql.Timestamp
import java.time.Instant


class MessageBroker {
    var serverIP = "192.168.99.100"
    var port = 1883

    var client = MqttClient.builder()
        .useMqttVersion3()
        .identifier(UUID.randomUUID().toString())
        .serverHost(serverIP)
        .serverPort(port)
        .buildAsync()

    init {
        println("iot")
        client.connectWith()
            .send()
    }

    var username="root"
    var password="root"

    fun authenticate(){
        client.connectWith()
            .simpleAuth()
            .username(username)
            .password(password.toByteArray())
            .applySimpleAuth()
            .send()

    }

    fun sendMessageToServer(msg: String, id: Int){
        val timeStamp=Time.from(Instant.now()).time
        val data=timeStamp.toString()+" "+id.toString()+" "+msg; // timestamp + id_compteur + puissance apparente + consommation totale
        client.publishWith()
            .topic("data")
            .payload(data.toByteArray())
            .send()
    }
}