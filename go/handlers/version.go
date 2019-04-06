package handlers

import (
	"github.com/gin-gonic/gin"
	"github.com/Actooors/SHUMessage_Service/go/tools"
)

func Version(ctx *gin.Context) {
	tools.ResponseSuccess(ctx, "1.00")
}
