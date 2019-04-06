package models

import "github.com/go-pg/pg"

type TblMoment struct {
	tableName struct{} `sql:"tbl_moment,alias:t" pg:",discard_unknown_columns"`

	ID            string      `sql:"id,pk"`
	CommentNum    *int        `sql:"comment_num"`
	Content       string      `sql:"content,notnull"`
	CreateTime    pg.NullTime `sql:"create_time"`
	DeleteTime    pg.NullTime `sql:"delete_time"`
	GroupID       *string     `sql:"group_id"`
	LikeNum       *int        `sql:"like_num"`
	Location      interface{} `sql:"-"` // type point not supported
	LocationPlace *string     `sql:"location_place"`
	MediaImgs     []string    `sql:"media_imgs,array"`
	Precontent    string      `sql:"precontent,notnull"`
	RepostNum     *int        `sql:"repost_num"`
	UserID        string      `sql:"user_id,notnull"`
}
