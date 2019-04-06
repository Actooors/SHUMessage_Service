package models

import "github.com/go-pg/pg"

type TblRepost struct {
	tableName struct{} `sql:"tbl_repost,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	Content    *string     `sql:"content"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	OperatorID string      `sql:"operator_id,notnull"`
	Precontent string      `sql:"precontent,notnull"`
	TargetID   string      `sql:"target_id,notnull"`
	TargetType string      `sql:"target_type,notnull"`
}
