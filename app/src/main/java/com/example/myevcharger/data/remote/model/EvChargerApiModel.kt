package com.example.myevcharger.data.remote.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@kotlinx.serialization.Serializable
@Entity(
    tableName = "evChargerEntity"
)
data class EvChargerApiModel(
    val statNum: String? = "unkown",    // 충전소명
    @PrimaryKey(autoGenerate = true)
    val statId: Int? = null,            // 충전소 ID
    val chgerId: Int?,                  // 충전기 ID
    var chgerType: Int?,                // 충전기 타입
    val addr: String? = "unkown",       // 주소
    val location: String?,              // 상세위치
    val lat: Int?,                      // 위도
    val lng: Int?,                      // 경도
    var useTime: Int?,                  // 이용가능시간
    val busild: String?,                // 기관 아이디
    val bnm: String?,                   // 기관명
    val busiNm: String?,                // 운영기관명
    val busiCall: String?,              // 운영기관 연락처
    var stat: Int?,                     // 충전기 상태
    var statUpdDt: String?,             // 상태갱신일시
    var lastTsdt: String?,              // 마지막 충전시작일시
    var lastTedt: String?,              // 마지막 충전종료일시
    var nowTsdt: String?,               // 충전 중 시작일시
    val output: Int?,                   // 충전용량
    val method: String?,                // 충전방식
    val zcode: Int?,                    // 지역코드
    val zscode: Int?,                   // 지역구분 상세코드
    val kind: String?,                  // 충전소 구분코드
    val kindDetail: String?,            // 충전소 구분 상세코드
    val parkingFree: String?,           // 주차료무료
    var note: String?,                  // 충전소 안내
    var limitYn: String?,               // 이용자 제한
    var limitDetail: String?,           // 이용자제한 사유
    var delYn: String?,                 // 삭제 여부
    var delDetail: String?,             // 삭제 사유
    var saved: Boolean = false          // 즐겨찾기
)
