package models

import "github.com/go-pg/pg"

type TblGroup struct {
	tableName struct{} `sql:"tbl_group,alias:t" pg:",discard_unknown_columns"`

	ID          string      `sql:"id,pk"`
	Avatar      *string     `sql:"avatar"`
	Background  *string     `sql:"background"`
	CreateTime  pg.NullTime `sql:"create_time"`
	CreatorID   string      `sql:"creator_id,notnull"`
	DeleteTime  pg.NullTime `sql:"delete_time"`
	Description *string     `sql:"description"`
	MemberNum   *int        `sql:"member_num"`
	Name        *string     `sql:"name"`
}
