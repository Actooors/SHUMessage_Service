package router

import (
	"github.com/gin-gonic/gin"
	"github.com/gin-contrib/cors"
	"github.com/Actooors/SHUMessage_Service_Go/go/config"
	"github.com/Actooors/SHUMessage_Service_Go/go/handlers"
	"fmt"
	"log"
)

func Run() {
	app := config.App()
	engine := gin.New()
	engine.Use(gin.Recovery())
	corsConfig := cors.DefaultConfig()
	corsConfig.AllowOrigins = []string{
		"http://localhost:8688",
		"http://0.0.0.0:8688",
		"https://www.shumsg.cn",
		"http://" + app.Address,
		"https://" + app.Address,
	}
	engine.Use(cors.New(corsConfig))
	g := engine.Group("api/go")
	{
		g.GET("version", handlers.Version)
	}
	log.Fatal(engine.Run(fmt.Sprintf("%v:%v", app.Address, app.Port)))
}
