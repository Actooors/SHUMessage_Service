package models

import "github.com/go-pg/pg"

type TblDiscuss struct {
	tableName struct{} `sql:"tbl_discuss,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	AncestorID *string     `sql:"ancestor_id"`
	Content    *string     `sql:"content"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	DiscussNum *int        `sql:"discuss_num"`
	Img        *string     `sql:"img"`
	LikedNum   *int        `sql:"liked_num"`
	OperatorID string      `sql:"operator_id,notnull"`
	TargetID   string      `sql:"target_id,notnull"`
	TargetType string      `sql:"target_type,notnull"`
}
