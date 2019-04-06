package models

import "github.com/go-pg/pg"

type TblUser struct {
	tableName struct{} `sql:"tbl_user,alias:t" pg:",discard_unknown_columns"`

	ID                  string      `sql:"id,pk"`
	About               *string     `sql:"about"`
	Avatar              *string     `sql:"avatar"`
	Background          *string     `sql:"background"`
	Birthday            pg.NullTime `sql:"birthday"`
	ConsequentLoginDays *int        `sql:"consequent_login_days"`
	CreateTime          pg.NullTime `sql:"create_time"`
	DeleteTime          pg.NullTime `sql:"delete_time"`
	Department          *string     `sql:"department"`
	FollowerNum         *int        `sql:"follower_num"`
	FollowingNum        *int        `sql:"following_num"`
	Gender              *string     `sql:"gender"`
	Identity            *int        `sql:"identity"`
	Invalid             *bool       `sql:"invalid"`
	Job                 *string     `sql:"job"`
	LastLoginTime       pg.NullTime `sql:"last_login_time"`
	Location            *string     `sql:"location"`
	Mail                *string     `sql:"mail"`
	MyGroupsNum         *int        `sql:"my_groups_num"`
	Nickname            *string     `sql:"nickname"`
	Password            string      `sql:"password,notnull"`
	Phone               *string     `sql:"phone"`
	Realname            *string     `sql:"realname"`
	RegisterWay         int         `sql:"register_way,notnull"`
	School              *string     `sql:"school"`
	SocialGroupNum      *int        `sql:"social_group_num"`
	StudentCardID       string      `sql:"student_card_id,notnull"`
}
