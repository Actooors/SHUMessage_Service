package com.shu.message.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NewsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMd5IdIsNull() {
            addCriterion("md5_id is null");
            return (Criteria) this;
        }

        public Criteria andMd5IdIsNotNull() {
            addCriterion("md5_id is not null");
            return (Criteria) this;
        }

        public Criteria andMd5IdEqualTo(String value) {
            addCriterion("md5_id =", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdNotEqualTo(String value) {
            addCriterion("md5_id <>", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdGreaterThan(String value) {
            addCriterion("md5_id >", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdGreaterThanOrEqualTo(String value) {
            addCriterion("md5_id >=", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdLessThan(String value) {
            addCriterion("md5_id <", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdLessThanOrEqualTo(String value) {
            addCriterion("md5_id <=", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdLike(String value) {
            addCriterion("md5_id like", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdNotLike(String value) {
            addCriterion("md5_id not like", value, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdIn(List<String> values) {
            addCriterion("md5_id in", values, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdNotIn(List<String> values) {
            addCriterion("md5_id not in", values, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdBetween(String value1, String value2) {
            addCriterion("md5_id between", value1, value2, "md5Id");
            return (Criteria) this;
        }

        public Criteria andMd5IdNotBetween(String value1, String value2) {
            addCriterion("md5_id not between", value1, value2, "md5Id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNull() {
            addCriterion("web_name is null");
            return (Criteria) this;
        }

        public Criteria andWebNameIsNotNull() {
            addCriterion("web_name is not null");
            return (Criteria) this;
        }

        public Criteria andWebNameEqualTo(String value) {
            addCriterion("web_name =", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotEqualTo(String value) {
            addCriterion("web_name <>", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThan(String value) {
            addCriterion("web_name >", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameGreaterThanOrEqualTo(String value) {
            addCriterion("web_name >=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThan(String value) {
            addCriterion("web_name <", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLessThanOrEqualTo(String value) {
            addCriterion("web_name <=", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameLike(String value) {
            addCriterion("web_name like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotLike(String value) {
            addCriterion("web_name not like", value, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameIn(List<String> values) {
            addCriterion("web_name in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotIn(List<String> values) {
            addCriterion("web_name not in", values, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameBetween(String value1, String value2) {
            addCriterion("web_name between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andWebNameNotBetween(String value1, String value2) {
            addCriterion("web_name not between", value1, value2, "webName");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andApartmentIsNull() {
            addCriterion("apartment is null");
            return (Criteria) this;
        }

        public Criteria andApartmentIsNotNull() {
            addCriterion("apartment is not null");
            return (Criteria) this;
        }

        public Criteria andApartmentEqualTo(String value) {
            addCriterion("apartment =", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotEqualTo(String value) {
            addCriterion("apartment <>", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentGreaterThan(String value) {
            addCriterion("apartment >", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentGreaterThanOrEqualTo(String value) {
            addCriterion("apartment >=", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLessThan(String value) {
            addCriterion("apartment <", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLessThanOrEqualTo(String value) {
            addCriterion("apartment <=", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentLike(String value) {
            addCriterion("apartment like", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotLike(String value) {
            addCriterion("apartment not like", value, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentIn(List<String> values) {
            addCriterion("apartment in", values, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotIn(List<String> values) {
            addCriterion("apartment not in", values, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentBetween(String value1, String value2) {
            addCriterion("apartment between", value1, value2, "apartment");
            return (Criteria) this;
        }

        public Criteria andApartmentNotBetween(String value1, String value2) {
            addCriterion("apartment not between", value1, value2, "apartment");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andImageUrlListIsNull() {
            addCriterion("image_url_list is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlListIsNotNull() {
            addCriterion("image_url_list is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlListEqualTo(String value) {
            addCriterion("image_url_list =", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListNotEqualTo(String value) {
            addCriterion("image_url_list <>", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListGreaterThan(String value) {
            addCriterion("image_url_list >", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListGreaterThanOrEqualTo(String value) {
            addCriterion("image_url_list >=", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListLessThan(String value) {
            addCriterion("image_url_list <", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListLessThanOrEqualTo(String value) {
            addCriterion("image_url_list <=", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListLike(String value) {
            addCriterion("image_url_list like", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListNotLike(String value) {
            addCriterion("image_url_list not like", value, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListIn(List<String> values) {
            addCriterion("image_url_list in", values, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListNotIn(List<String> values) {
            addCriterion("image_url_list not in", values, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListBetween(String value1, String value2) {
            addCriterion("image_url_list between", value1, value2, "imageUrlList");
            return (Criteria) this;
        }

        public Criteria andImageUrlListNotBetween(String value1, String value2) {
            addCriterion("image_url_list not between", value1, value2, "imageUrlList");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}