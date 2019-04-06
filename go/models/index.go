package models

var Columns = struct {
	TblDiscuss struct {
		ID, AncestorID, Content, CreateTime, DeleteTime, DiscussNum, Img, LikedNum, OperatorID, TargetID, TargetType string
	}
	TblFollowRelation struct {
		ID, CreateTime, DeleteTime, TargetAvatar, TargetID, TargetNickname, UserID string
	}
	TblGroup struct {
		ID, Avatar, Background, CreateTime, CreatorID, DeleteTime, Description, MemberNum, Name string
	}
	TblGroupMember struct {
		ID, CreateTime, DeleteTime, GroupID, UserID string
	}
	TblRepost struct {
		ID, Content, CreateTime, DeleteTime, OperatorID, Precontent, TargetID, TargetType string
	}
	TblUser struct {
		ID, About, Avatar, Background, Birthday, ConsequentLoginDays, CreateTime, DeleteTime, Department, FollowerNum, FollowingNum, Gender, Identity, Invalid, Job, LastLoginTime, Location, Mail, MyGroupsNum, Nickname, Password, Phone, Realname, RegisterWay, School, SocialGroupNum, StudentCardID string
	}
	TblUserLoginTimestamp struct {
		ID, CreateTime, DeleteTime, UserID string
	}
	TblLabel struct {
		ID, CreateTime, DeleteTime, Name string
	}
	TblLike struct {
		ID, CreateTime, DeleteTime, Liked, OperatorID, TargetID, TargetType string
	}
	TblMoment struct {
		ID, CommentNum, Content, CreateTime, DeleteTime, GroupID, LikeNum, Location, LocationPlace, MediaImgs, Precontent, RepostNum, UserID string
	}
	TblNews struct {
		ID, Content, ContentFromScrapy, CreateTime, DeleteTime, DiscussNum, LikedNum, Md5, MediaImgs, MediaTitle, MediaType, NewsUrl, Precontent, RepostdNum, UserID string
	}
	TblNewsAndLabel struct {
		ID, CreateTime, DeleteTime, LabelID, LabelName, NewsID string
	}
}{
	TblDiscuss: struct {
		ID, AncestorID, Content, CreateTime, DeleteTime, DiscussNum, Img, LikedNum, OperatorID, TargetID, TargetType string
	}{
		ID:         "id",
		AncestorID: "ancestor_id",
		Content:    "content",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		DiscussNum: "discuss_num",
		Img:        "img",
		LikedNum:   "liked_num",
		OperatorID: "operator_id",
		TargetID:   "target_id",
		TargetType: "target_type",
	},
	TblFollowRelation: struct {
		ID, CreateTime, DeleteTime, TargetAvatar, TargetID, TargetNickname, UserID string
	}{
		ID:             "id",
		CreateTime:     "create_time",
		DeleteTime:     "delete_time",
		TargetAvatar:   "target_avatar",
		TargetID:       "target_id",
		TargetNickname: "target_nickname",
		UserID:         "user_id",
	},
	TblGroup: struct {
		ID, Avatar, Background, CreateTime, CreatorID, DeleteTime, Description, MemberNum, Name string
	}{
		ID:          "id",
		Avatar:      "avatar",
		Background:  "background",
		CreateTime:  "create_time",
		CreatorID:   "creator_id",
		DeleteTime:  "delete_time",
		Description: "description",
		MemberNum:   "member_num",
		Name:        "name",
	},
	TblGroupMember: struct {
		ID, CreateTime, DeleteTime, GroupID, UserID string
	}{
		ID:         "id",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		GroupID:    "group_id",
		UserID:     "user_id",
	},
	TblRepost: struct {
		ID, Content, CreateTime, DeleteTime, OperatorID, Precontent, TargetID, TargetType string
	}{
		ID:         "id",
		Content:    "content",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		OperatorID: "operator_id",
		Precontent: "precontent",
		TargetID:   "target_id",
		TargetType: "target_type",
	},
	TblUser: struct {
		ID, About, Avatar, Background, Birthday, ConsequentLoginDays, CreateTime, DeleteTime, Department, FollowerNum, FollowingNum, Gender, Identity, Invalid, Job, LastLoginTime, Location, Mail, MyGroupsNum, Nickname, Password, Phone, Realname, RegisterWay, School, SocialGroupNum, StudentCardID string
	}{
		ID:                  "id",
		About:               "about",
		Avatar:              "avatar",
		Background:          "background",
		Birthday:            "birthday",
		ConsequentLoginDays: "consequent_login_days",
		CreateTime:          "create_time",
		DeleteTime:          "delete_time",
		Department:          "department",
		FollowerNum:         "follower_num",
		FollowingNum:        "following_num",
		Gender:              "gender",
		Identity:            "identity",
		Invalid:             "invalid",
		Job:                 "job",
		LastLoginTime:       "last_login_time",
		Location:            "location",
		Mail:                "mail",
		MyGroupsNum:         "my_groups_num",
		Nickname:            "nickname",
		Password:            "password",
		Phone:               "phone",
		Realname:            "realname",
		RegisterWay:         "register_way",
		School:              "school",
		SocialGroupNum:      "social_group_num",
		StudentCardID:       "student_card_id",
	},
	TblUserLoginTimestamp: struct {
		ID, CreateTime, DeleteTime, UserID string
	}{
		ID:         "id",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		UserID:     "user_id",
	},
	TblLabel: struct {
		ID, CreateTime, DeleteTime, Name string
	}{
		ID:         "id",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		Name:       "name",
	},
	TblLike: struct {
		ID, CreateTime, DeleteTime, Liked, OperatorID, TargetID, TargetType string
	}{
		ID:         "id",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		Liked:      "liked",
		OperatorID: "operator_id",
		TargetID:   "target_id",
		TargetType: "target_type",
	},
	TblMoment: struct {
		ID, CommentNum, Content, CreateTime, DeleteTime, GroupID, LikeNum, Location, LocationPlace, MediaImgs, Precontent, RepostNum, UserID string
	}{
		ID:            "id",
		CommentNum:    "comment_num",
		Content:       "content",
		CreateTime:    "create_time",
		DeleteTime:    "delete_time",
		GroupID:       "group_id",
		LikeNum:       "like_num",
		Location:      "location",
		LocationPlace: "location_place",
		MediaImgs:     "media_imgs",
		Precontent:    "precontent",
		RepostNum:     "repost_num",
		UserID:        "user_id",
	},
	TblNews: struct {
		ID, Content, ContentFromScrapy, CreateTime, DeleteTime, DiscussNum, LikedNum, Md5, MediaImgs, MediaTitle, MediaType, NewsUrl, Precontent, RepostdNum, UserID string
	}{
		ID:                "id",
		Content:           "content",
		ContentFromScrapy: "content_from_scrapy",
		CreateTime:        "create_time",
		DeleteTime:        "delete_time",
		DiscussNum:        "discuss_num",
		LikedNum:          "liked_num",
		Md5:               "md5",
		MediaImgs:         "media_imgs",
		MediaTitle:        "media_title",
		MediaType:         "media_type",
		NewsUrl:           "news_url",
		Precontent:        "precontent",
		RepostdNum:        "repostd_num",
		UserID:            "user_id",
	},
	TblNewsAndLabel: struct {
		ID, CreateTime, DeleteTime, LabelID, LabelName, NewsID string
	}{
		ID:         "id",
		CreateTime: "create_time",
		DeleteTime: "delete_time",
		LabelID:    "label_id",
		LabelName:  "label_name",
		NewsID:     "news_id",
	},
}

var Tables = struct {
	TblDiscuss struct {
		Name string
	}
	TblFollowRelation struct {
		Name string
	}
	TblGroup struct {
		Name string
	}
	TblGroupMember struct {
		Name string
	}
	TblRepost struct {
		Name string
	}
	TblUser struct {
		Name string
	}
	TblUserLoginTimestamp struct {
		Name string
	}
	TblLabel struct {
		Name string
	}
	TblLike struct {
		Name string
	}
	TblMoment struct {
		Name string
	}
	TblNews struct {
		Name string
	}
	TblNewsAndLabel struct {
		Name string
	}
}{
	TblDiscuss: struct {
		Name string
	}{
		Name: "tbl_discuss",
	},
	TblFollowRelation: struct {
		Name string
	}{
		Name: "tbl_follow_relation",
	},
	TblGroup: struct {
		Name string
	}{
		Name: "tbl_group",
	},
	TblGroupMember: struct {
		Name string
	}{
		Name: "tbl_group_member",
	},
	TblRepost: struct {
		Name string
	}{
		Name: "tbl_repost",
	},
	TblUser: struct {
		Name string
	}{
		Name: "tbl_user",
	},
	TblUserLoginTimestamp: struct {
		Name string
	}{
		Name: "tbl_user_login_timestamp",
	},
	TblLabel: struct {
		Name string
	}{
		Name: "tbl_label",
	},
	TblLike: struct {
		Name string
	}{
		Name: "tbl_like",
	},
	TblMoment: struct {
		Name string
	}{
		Name: "tbl_moment",
	},
	TblNews: struct {
		Name string
	}{
		Name: "tbl_news",
	},
	TblNewsAndLabel: struct {
		Name string
	}{
		Name: "tbl_news_and_label",
	},
}
