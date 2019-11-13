import org.json.JSONObject
import java.net.URL

class Client_compteur {
    private val host = "192.168.20.104"
    private val API_URL_XML = "http://$host/protect/settings/teleinfo2.xml"
    private val API_URL_JSON = "http://$host/api/xdevices.json?cmd=10"


    fun getInfos(): Pair<Long, Long> {
        var infos = JSONObject(URL(API_URL_JSON).readText())
        var  puissance_apparente=infos.get("T1_PAPP").toString() //en watt

        var compteur_conso_totale=infos.get("T1_BASE").toString() // en watt/h
        println(puissance_apparente)
        println(compteur_conso_totale)
        return Pair(puissance_apparente.toLong(),compteur_conso_totale.toLong())
    }
}