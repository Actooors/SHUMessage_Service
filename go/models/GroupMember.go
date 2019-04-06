package models

import "github.com/go-pg/pg"

type TblGroupMember struct {
	tableName struct{} `sql:"tbl_group_member,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	GroupID    string      `sql:"group_id,notnull"`
	UserID     string      `sql:"user_id,notnull"`
}
