import MQTT.MessageBroker

fun main(args: Array<String>) {
    println("Hello World!")
//    val infosCompteur = Client_compteur().getInfosMock()
    var compteur=Client_compteur()
    val infosCompteur = compteur.getInfos()
    println("infos compteur: $infosCompteur")

    val mqtt=MessageBroker()
    mqtt.sendMessageToServer(infosCompteur.toString(),compteur.getID())
    println("message sent")
}