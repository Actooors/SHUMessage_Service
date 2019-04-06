package models

import "github.com/go-pg/pg"

type TblNewsAndLabel struct {
	tableName struct{} `sql:"tbl_news_and_label,alias:t" pg:",discard_unknown_columns"`

	ID         string      `sql:"id,pk"`
	CreateTime pg.NullTime `sql:"create_time"`
	DeleteTime pg.NullTime `sql:"delete_time"`
	LabelID    string      `sql:"label_id,notnull"`
	LabelName  string      `sql:"label_name,notnull"`
	NewsID     string      `sql:"news_id,notnull"`
}
