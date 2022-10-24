package com.example.myevcharger.presentation.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myevcharger.R
import com.example.myevcharger.data.local.database.EvChargerDatabase
import com.example.myevcharger.data.local.datasource.LocalEvChargerDataSourceImpl
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL

class ChargerApiTest: AppCompatActivity() {
    lateinit var testViewModel : RepoTestViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val chargerRepositoryImpl = LocalEvChargerDataSourceImpl(EvChargerDatabase(this))
        val viewModelProviderFactory = ChargerViewModelProviderFactory(chargerRepositoryImpl)
        testViewModel = ViewModelProvider(this, viewModelProviderFactory).get(RepoTestViewModel::class.java)

        System.out.println(testViewModel.getChargers().toString())*/
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