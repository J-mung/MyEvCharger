# MyEvCharger
전기자동차 충전소 위치 표시 및 안내하는 app 실습

--------------------------------------------

## ToDo List
- 종속 항목 삽입 다시 공부하기
- TMAP fragment 만들어서 지도 띄우기
- Api로부터 받은 데이터 하나로 지도에 marker 띄우기


## Done
(10.xx)
- 공공데이터 포털 API가 올바르게 작동하는지 결과 값 출력해보기

(10.23)
- duplicate class found javax.inject 고치기
: implementation files('libs\\javax-inject.jar') 삭제로 해결

(10.24)
- 종속 항목을 적용해서 repository를 local과 remote로 나누기

(10.25)
- BaseActivity & MainActivity의 "should be subtype of 'ViewDataBinding'" 에러 해결하기
: activity_main.xml의 코드를 <layout></layout>으로 감쌈으로써 해결
