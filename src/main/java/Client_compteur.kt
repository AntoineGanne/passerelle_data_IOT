import org.json.JSONObject
import java.net.URL

class Client_compteur {
    private val host = "192.168.20.104"
    private val API_URL_XML = "http://$host/protect/settings/teleinfo2.xml"
    private val API_URL_JSON = "http://$host/api/xdevices.json?cmd=10"

    // valeurs mocked
    var mock_puissance_apparente= 90
    var mock_compteur_conso_totale=1876152
    var mock_json = JSONObject("{\"product\":\"Eco-devices\",\"T1_PTEC\":\"TH..\",\"T1_PAPP\":90,\"T1_BASE\":1876058,\"T2_PTEC\":\"----\",\"T2_PAPP\":0,\"T2_BASE\":0,\"INDEX_C1\":784659,\"INDEX_C2\":11280}")


    fun getInfosMock(): Pair<Long, Long>{
        return Pair(mock_puissance_apparente.toLong(),mock_compteur_conso_totale.toLong())

    }


    fun getInfos(): Pair<Long, Long> {
        var infos = JSONObject(URL(API_URL_JSON).readText())
        var  puissance_apparente=infos.get("T1_PAPP").toString() //en watt

        var compteur_conso_totale=infos.get("T1_BASE").toString() // en watt/h
        println(puissance_apparente)
        println(compteur_conso_totale)



        return Pair(puissance_apparente.toLong(),compteur_conso_totale.toLong())
    }
}