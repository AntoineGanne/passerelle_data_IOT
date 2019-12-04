import MQTT.MessageBroker

fun main(args: Array<String>) {
    println("Hello World!")
    val infosCompteur = Client_compteur().getInfosMock()
    println("infos compteur: $infosCompteur")

    val mqtt=MessageBroker()
    print("yoooo")
    mqtt.sendMessageToServer(infosCompteur.toString())
    print("it's ok")
}