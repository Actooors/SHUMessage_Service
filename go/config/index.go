package config

import (
	"sync"
	"io/ioutil"
	"encoding/json"
)

type AppConfig struct {
	Address string `json:"address"`
	Port    int    `json:"port"`
	Secret  string `json:"secret"`
	Qiniu struct {
		AccessKey string `json:"accessKey"`
		SecretKey string `json:"secretKey"`
		Bucket    string `json:"bucket"`
	} `json:"qiniu"`
	DataSource struct {
		Host     string `json:"host"`
		Port     int    `json:"port"`
		Database string `json:"database"`
		Username string `json:"username"`
		Password string `json:"password"`
	} `json:"dataSource"`
	AmapKey       string `json:"amapKey"`
	TencentMapKey string `json:"tencentMapKey"`
}

var app struct {
	conf AppConfig
	once sync.Once
}

func appInit() {
	b, err := ioutil.ReadFile("config/app.json")
	if err != nil {
		panic(err)
	}
	err = json.Unmarshal(b, &app.conf)
	if err != nil {
		panic(err)
	}
}

func App() *AppConfig {
	app.once.Do(appInit)
	return &app.conf
}
