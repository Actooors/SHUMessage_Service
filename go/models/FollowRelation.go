package models

import "github.com/go-pg/pg"

type TblFollowRelation struct {
	tableName struct{} `sql:"tbl_follow_relation,alias:t" pg:",discard_unknown_columns"`

	ID             string      `sql:"id,pk"`
	CreateTime     pg.NullTime `sql:"create_time"`
	DeleteTime     pg.NullTime `sql:"delete_time"`
	TargetAvatar   string      `sql:"target_avatar,notnull"`
	TargetID       string      `sql:"target_id,notnull"`
	TargetNickname string      `sql:"target_nickname,notnull"`
	UserID         string      `sql:"user_id,notnull"`
}
