package com.example.myevcharger.data.mapper

import com.example.myevcharger.data.remote.model.EvChargerApiModel
import com.example.myevcharger.domain.model.EvCharger

object RemoteMapper {
    fun mapToDomainEvCharger(evChargerApiModel: EvChargerApiModel): EvCharger {
        with(evChargerApiModel) {
            return EvCharger(
                statNum = this.statNum,         // 충전소명
                statId = this.statId,           // 충전소 ID
                chgerId = this.chgerId,         // 충전기 ID
                chgerType = this.chgerType,     // 충전기 타입
                addr = this.addr,               // 주소
                location = this.location,       // 상세위치
                lat = this.lat,                 // 위도
                lng = this.lng,                 // 경도
                useTime = this.useTime,         // 이용가능시간
                saved = false                   // 즐겨찾기
            )
        }
    }
}