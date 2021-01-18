import pandas as pd

file_station = pd.read_excel("./SeoulMetro_StationSpacing(202003).xlsx")
file_transfer = pd.read_excel("./SeoulMetro_TransferStation_Distance_and_NecessaryTime(2019).xlsx")

station_dic = {}

for i in range(0, len(file_station)-1):
station = file_station.loc[i]
    #첫역/마지막 역이 아닌 경우
    if station['누계(km)'] != 0 and file_station.loc[i+1]['누계(km)'] != None and file_station.loc[i+1]['누계(km)'] != 0:
        # 같은 호선일 경우 이전역 설정
        if station['호선'] == file_station.loc[i - 1]['호선']:
            previous_station = file_station.loc[i - 1]
            previous_name = previous_station['호선'][:1] + previous_station['역명']

        # 같은 호선일 경우 다음역 설정
        if station['호선'] == file_station.loc[i + 1]['호선']:
            next_station = file_station.loc[i + 1]
            next_name = next_station['호선'][:1] + next_station['역명']
    #첫역인 경우
    elif station['누계(km)'] == 0:
        # 같은 호선일 경우 다음역 설정
        if station['호선'] == file_station.loc[i + 1]['호선']:
            next_station = file_station.loc[i + 1]
            next_name = next_station['호선'][:1] + next_station['역명']
    #마지막 역인 경우
    elif file_station.loc[i+1]['누계(km)'] != 0:
        # 같은 호선일 경우 이전역 설정
        if station['호선'] == file_station.loc[i - 1]['호선']:
            previous_station = file_station.loc[i - 1]
            previous_name = previous_station['호선'][:1] + previous_station['역명']

    station_name = station['호선'][:1]+station['역명']

    #해당 역이 역딕셔너리 키 값이 아니고, 호선의 첫역/마지막역이 아닐때 (==>누계가 0km가 아닐 때)
    if station_name not in station_dic.keys() and station['누계(km)'] != 0:
        station_dic[station_name] = {previous_name : station['역간거리(km)']}
        station_dic[station_name][next_name] = next_station['역간거리(km)']
    #해당 역이 역딕셔너리 키 값이 아니고, 호선의 첫역일 때
    elif station_name not in station_dic.keys() and station['누계(km)'] == 0:
        station_dic[station_name] = {next_name: next_station['역간거리(km)']}
    #해당 역이 역 딕셔너리 키 값이 아니고, 호선의 마지막 역일 때
    elif station_name not in station_dic.keys() and file_station.loc[i+1]['누계(km)'] == 0:
        station_dic[station_name] = {previous_name: station['역간거리(km)']}
        
        
#print(station_dic)

