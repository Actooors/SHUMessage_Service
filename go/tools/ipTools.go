package tools

import (
	"net/http"
	"io/ioutil"
	"encoding/json"
)

type amapIPLocateResult struct {
	Status    string `json:"status"`
	Info      string `json:"info"`
	Infocode  string `json:"infocode"`
	Province  string `json:"province"`
	City      string `json:"city"`
	Adcode    string `json:"adcode"`
	Rectangle string `json:"rectangle"`
}
type tencentMapIPLocateResult struct {
	Status  int    `json:"status"`
	Message string `json:"message"`
	Result struct {
		IP string `json:"ip"`
		Location struct {
			Lat float64 `json:"lat"`
			Lng float64 `json:"lng"`
		} `json:"location"`
		AdInfo struct {
			Nation   string `json:"nation"`
			Province string `json:"province"`
			City     string `json:"city"`
			District string `json:"district"`
			Adcode   int    `json:"adcode"`
		} `json:"ad_info"`
	} `json:"result"`
}

func getLocationFromIP(ip string) (location string) {
	resp, err := http.Get("https://restapi.amap.com/v3/ip?key=" + amapKey + "&ip=" + ip)
	if err == nil {
		defer resp.Body.Close()
		b, _ := ioutil.ReadAll(resp.Body)
		var r amapIPLocateResult
		err := json.Unmarshal(b, &r)
		if err == nil && r.Status == "1" {
			location = r.Province + r.City
		}
	}
	//amap没有成功，换tencentMap
	if location == "" {
		resp, err := http.Get("https://apis.map.qq.com/ws/location/v1/ip?&key=" + tencentMapKey + "&ip=" + ip)
		if err == nil {
			defer resp.Body.Close()
			b, _ := ioutil.ReadAll(resp.Body)
			var r tencentMapIPLocateResult
			err := json.Unmarshal(b, &r)
			if err == nil && r.Status == 0 {
				location = r.Result.AdInfo.Province + r.Result.AdInfo.City + r.Result.AdInfo.District
			}
		}
	}
	return
}
