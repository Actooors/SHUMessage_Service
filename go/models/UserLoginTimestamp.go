package models

import "github.com/go-pg/pg"

type TblUserLoginTimestamp struct {
	tableName struct{} `sql:"tbl_user_login_timestamp,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	UserID     string      `sql:"user_id,notnull"`
}
