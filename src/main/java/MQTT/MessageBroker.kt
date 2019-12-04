package MQTT

import java.util.UUID
import com.hivemq.client.mqtt.MqttClient
import com.hivemq.client.mqtt.mqtt3.Mqtt3AsyncClient
import com.hivemq.client.mqtt.datatypes.MqttQos





class MessageBroker {
    var client = MqttClient.builder()
        .useMqttVersion3()
        .identifier(UUID.randomUUID().toString())
        .serverHost("192.168.99.100")
        .serverPort(1883)
        .buildAsync()

    init {
        println("iot")
        client.connectWith()
            .send()
        println("2222222222222")
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

    fun sendMessageToServer(msg: String){
        client.publishWith()
            .topic("data")
            .payload("rr".toByteArray())
            .send()
    }
}