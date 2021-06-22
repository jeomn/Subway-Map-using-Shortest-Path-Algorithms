# Subway-Map-using-Shortest_Path-Algorithms

최소경로 알고리즘을 활용한 지하철 노선도 프로그램
(2021/01/11~02/02)
<Br>
<Br>
<Br>
## 설명
최단경로 알고리즘을 활용하여 지하철 경로 탐색 웹 사이트를 제작하였습니다.<br>
하나의 공통 알고리즘, 각자의 알고리즘을 선택하여 총 두 개의 알고리즘을 활용하였습니다.<BR>
  
#### 기능
  * 출발지, 도착지 입력
  * 개발자, 각 개발자의 알고리즘 선택
  * 입력한 데이터에 맞는 지하철 탑승 최단 경로 결과(경로, 이동거리, 환승역) 출력

#### 설계
  실제 Private, DMZ, Public 구조로 분리되지 않지만, 보안을 고려한 구조로 설계
  <img width=600 src=https://user-images.githubusercontent.com/46081831/122927211-9ce02f80-d3a3-11eb-9a27-ee783ea198fa.JPG>

#### 사용 기술
  * Java
  * Python
  * Spring Boot
  * Jsp

#### 사용 데이터
  * [서울 지하철 역간 거리 공공데이터](http://data.seoul.go.kr/dataList/OA-12034/S/1/datasetView.do)
  * [서울 지하철 환승 구간 정보 공공데이터](http://data.seoul.go.kr/dataList/OA-13290/F/1/datasetView.do)


<Br>
<Br>
  
## 📌Task Lists
#### Data Settings   
- [X] 지하철 노선도 그래프 생성
- [X] 기본역 그래프 생성(환승역 고려X) - 2021/01/15~01/18
- [X] 환승역 그래프 데이터 업데이트 - 2021/01/19
- [X] 이전역 그래프 데이터 업데이트 - 2021/01/18

#### Algorithms   
- [X] 다익스트라 알고리즘 구현 - 2021/01/19~01/20
- [X] SPFA 알고리즘 구현 - 2021/01/20

#### SpringBoot & UI(jsp)     
- [X] Web UI 구현(Spring Boot) - 2021/01/28~29
- [X] 팀원 알고리즘 코드 삽입 - 2021/02/01

#### 
<Br>
<Br>
<Br>

## Warnings
Developer1's codes are work only Anaconda Python environment. <Br>
So if you don't want Anaconda, you can only use Developer2's function. <Br>
<Br>
<Br>

## Run
### Dijkstra
<img src="https://user-images.githubusercontent.com/46081831/106315187-3e100180-62ae-11eb-9851-f42051bfbd63.gif">

### SPFA
<img src="https://user-images.githubusercontent.com/46081831/106315196-410af200-62ae-11eb-91ae-388e4629206f.gif">

<Br>
 
#### 향후 계획
  * 경유지
  * 노선도 이미지 제공
  * 각 역마다의 출발, 도착 시간 정보 제공
  * 환승구간에서의 소요시간 등을 고려한 경로 제공
  * 총 소요 시간 제공
  * 배포
