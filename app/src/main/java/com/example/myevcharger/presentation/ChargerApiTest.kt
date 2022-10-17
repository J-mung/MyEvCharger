package com.example.myevcharger.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myevcharger.R
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import kotlin.concurrent.thread

class ChargerApiTest: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var text: TextView = findViewById(R.id.tv)


        // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
        val subThread = thread() {
            // 객체 안에 있는 item이라는 이름의 리스트를 가져옴
            val item = getApiResponse()

            // 화면에 출력
            runOnUiThread {

                // 페이지 수만큼 반복하여 데이터를 불러옴
                for (i in 0 until item.length()) {

                    // 쪽수 별로 데이터를 읽는다.
                    val jObject = item.getJSONObject(i)

                    text.append("${i + 1}번 충전소\n")
                    text.append("${JSON_parse(jObject, "statId")}\n")
                    text.append("${JSON_parse(jObject, "chgerId")}\n")
                    text.append("${JSON_parse(jObject, "stat")}\n")
                }
            }
        }
        subThread.join()

    }

    private fun getApiResponse(): JSONArray {
        // 키 값
        val key =
            "?serviceKey=S3oMKMheftHOUnPv8Nt5eJGUvyQ66YYSWxOoCCrGUxABrzjUy1DBMm2s%2BbZnVE39b%2Bk0thTJX2GzoG%2FTs4ZdUw%3D%3D"

        // 현재 페이지 번호
        val pageNo = "&pageNo=1"

        // 한 페이지 결과 수
        val numOfRows = "&numOfRows=10"

        // 상태갱신 조회 범위(분)
        val period = "&5"

        // 시도 코드 (행정구역코드 앞 2자리)
        val zcode = "&MobileApp=AppTest"

        // data type
        val dataType = "&dataType=JSON"

        // API 정보를 가지고 있는 주소
        // http://apis.data.go.kr/B552584/EvCharger/getChargerInfo?serviceKey=인증키(URL Encode)&numOfRows=10&pageNo=1&dataType=XML
        val site =
            "http://apis.data.go.kr/B552584/EvCharger/getChargerInfo" + key + numOfRows + pageNo + dataType

        val url = URL(site)
        val conn = url.openConnection()
        val input = conn.getInputStream()
        val isr = InputStreamReader(input)

        // br: 라인 단위로 데이터를 읽어오기 위해서 사용
        var br = BufferedReader(isr)

        // json 문서
        var str: String? = null
        val buf = StringBuffer()

        do {
            str = br.readLine()

            if (str != null) {
                buf.append(str)
            }
        } while (str != null)

        // 전체가 객체로 묶여있기 때문에 객체형태로 가져옴
        val root = JSONObject(buf.toString())
        val response = root.getJSONObject("items")
        // 객체 안에 있는 item이라는 이름의 리스트를 가져옴
        val item = response.getJSONArray("item")

        return item
    }

    // 함수를 통해 데이터를 불러옴
    fun JSON_parse(obj: JSONObject, data: String): String {

        // 원하는 정보를 불러와 리턴받고 없는 정보는 캐치하여 "없습니다"로 리턴
        return try {
            obj.getString(data)
        } catch (e: Exception) {
            "없습니다."
        }
    }
}