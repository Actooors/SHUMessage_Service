package models

import "github.com/go-pg/pg"

type TblNews struct {
	tableName struct{} `sql:"tbl_news,alias:t" pg:",discard_unknown_columns"`

	ID                string      `sql:"id,pk"`
	Content           string      `sql:"content,notnull"`
	ContentFromScrapy *string     `sql:"content_from_scrapy"`
	CreateTime        pg.NullTime `sql:"create_time"`
	DeleteTime        pg.NullTime `sql:"delete_time"`
	DiscussNum        *int        `sql:"discuss_num"`
	LikedNum          *int        `sql:"liked_num"`
	Md5               *string     `sql:"md5"`
	MediaImgs         []string    `sql:"media_imgs,array"`
	MediaTitle        string      `sql:"media_title,notnull"`
	MediaType         *string     `sql:"media_type"`
	NewsUrl           *string     `sql:"news_url"`
	Precontent        string      `sql:"precontent,notnull"`
	RepostdNum        *int        `sql:"repostd_num"`
	UserID            string      `sql:"user_id,notnull"`
}
