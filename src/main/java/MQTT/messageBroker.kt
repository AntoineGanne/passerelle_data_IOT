package MQTT

import java.util.UUID
import com.hivemq.client.mqtt.MqttClient
import com.hivemq.client.mqtt.mqtt3.Mqtt3AsyncClient
import com.hivemq.client.mqtt.datatypes.MqttQos





class messageBroker {
    var client = MqttClient.builder()
        .useMqttVersion3()
        .identifier(UUID.randomUUID().toString())
        .serverHost("broker.hivemq.com")
        .serverPort(8086)
        .buildAsync()

    var username="root"
    var password="root"

    fun authenticate(){
        client.connectWith()
            .simpleAuth()
            .username(username)
            .password(password.toByteArray())
            .applySimpleAuth()
            .send()
            .whenComplete { connAck, throwable ->
                // Handle connection complete

                if (throwable != null) {
                    // Handle failure to publish*
                    throwable.printStackTrace()
                } else {
                    // Handle successful publish, e.g. logging or incrementing a metric
                }
            }
    }

    fun sendMessageToServer(msg: String){
        client.publishWith()
            .topic("my/topic")
            .payload(msg.toByteArray())
            .qos(MqttQos.EXACTLY_ONCE)
            .send()
            .whenComplete { mqtt3Publish, throwable ->
                if (throwable != null) {
                    // Handle failure to publish*
                    throwable.printStackTrace()
                } else {
                    // Handle successful publish, e.g. logging or incrementing a metric
                }
            }
    }
}