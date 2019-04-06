package models

import "github.com/go-pg/pg"

type TblLabel struct {
	tableName struct{} `sql:"tbl_label,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	Name       *string     `sql:"name"`
}
