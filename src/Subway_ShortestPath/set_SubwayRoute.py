import pandas as pd

file_station = pd.read_excel("./SeoulMetro_StationSpacing(202003).xlsx")
#station_Dataframe = file_station[['호선', '역명', '역간거리(km)', '누계(km)']]
file_transfer = pd.read_excel("./SeoulMetro_TransferStation_Distance_and_NecessaryTime(2019).xlsx")

#print(file_station.loc[0]['역명'])
station_dic = {}

for i in range(1, len(file_station)-1):
    station = file_station.loc[i]['역명']
    previous_station = file_station.loc[i-1]['역명']
    if station not in station_dic.keys() and previous_station not in station_dic.keys():
        print(station_dic.keys())
        station_dic[previous_station] = {station : file_station.loc[i]['역간거리(km)']}
    elif previous_station in station_dic.keys():
        station_dic[previous_station][station] =  file_station.loc[i]['역간거리(km)']

print(station_dic)


"""
class Station():
    def __init__(self, name):
        self._line = ''
        self._name = name
        self._neighbor_station = ''

    def setLine(self, name):
        if name in file_station['역명']:
            self._line = file_station['호선']
"""

