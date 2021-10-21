import ctypes
import win32com.client
import pandas as pd
import time

t = time.localtime()
if 9 <= t.tm_hour <= 16:
	sleep_time = 7 / (10 - 2)
else:
	sleep_time = 15 / (20 - 2)
	
codeMgr = win32com.client.Dispatch('CpUtil.CpCodeMgr')


def codeToName(code):
	codeName = win32com.client.Dispatch('CpUtil.CpStockCode')
	return codeName.CodeToName(code)


def get_Chart(code):
	codeChart = win32com.client.Dispatch('CpSysDib.StockChart')
	
	codeChart.setInputValue(0, code)
	codeChart.setInputValue(1, ord('2'))
	codeChart.setInputValue(4, 100)
	codeChart.setInputValue(5, [0, 5])
	codeChart.setInputValue(6, ord('D'))
	
	codeChart.BlockRequest()
	chart_num = codeChart.GetHeaderValue(3)
	
	chart = []
	for i in range(chart_num):
		data = (codeChart.GetDataValue(0, i), codeChart.GetDataValue(1, i))  # DATE - Price
		chart.append(data)
	
	return chart


kospi = pd.DataFrame()
kospi.index.name = 'DATE'

kosdaq = pd.DataFrame()
kosdaq.index.name = 'DATE'
# KOSPI 코스피 종목

kospi_Codes = codeMgr.GetStockListByMarket(1)

for code in kospi_Codes:
	name = codeToName(code)
	print(code, name)
	chart = get_Chart(code)
	
	for date, price in chart:
		kospi.at[date, name] = price
	time.sleep(sleep_time)

# KOSDAQ 코스닥 종목

kosdaq_Codes = codeMgr.GetStockListByMarket(2)

for code in kosdaq_Codes:
	name = codeToName(code)
	print(code, name)
	chart = get_Chart(code)
	
	for date, price in chart:
		kosdaq.at[date, name] = price
	time.sleep(0.1)

kospi.to_csv('./KOSPI.csv', encoding='utf-8-sig', index=False)
kosdaq.to_csv('./KOSDAQ.csv', encoding='utf-8-sig', index=False)
