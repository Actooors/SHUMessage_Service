package models

import "github.com/go-pg/pg"

type TblLike struct {
	tableName struct{} `sql:"tbl_like,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	Liked      *bool       `sql:"liked"`
	OperatorID string      `sql:"operator_id,notnull"`
	TargetID   string      `sql:"target_id,notnull"`
	TargetType string      `sql:"target_type,notnull"`
}
