package com.example.myevcharger.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

// view에 보여줄 데이터로만 구성되도록 정리
@Entity(
    tableName = "evChargers"
)
data class EvCharger(
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
    var saved: Boolean = false          // 즐겨찾기
): Serializable
