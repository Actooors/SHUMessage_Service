package com.shu.message.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupExample() {
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

        public Criteria andGroupsIdIsNull() {
            addCriterion("groups_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupsIdIsNotNull() {
            addCriterion("groups_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsIdEqualTo(Integer value) {
            addCriterion("groups_id =", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotEqualTo(Integer value) {
            addCriterion("groups_id <>", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdGreaterThan(Integer value) {
            addCriterion("groups_id >", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("groups_id >=", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdLessThan(Integer value) {
            addCriterion("groups_id <", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdLessThanOrEqualTo(Integer value) {
            addCriterion("groups_id <=", value, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdIn(List<Integer> values) {
            addCriterion("groups_id in", values, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotIn(List<Integer> values) {
            addCriterion("groups_id not in", values, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdBetween(Integer value1, Integer value2) {
            addCriterion("groups_id between", value1, value2, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("groups_id not between", value1, value2, "groupsId");
            return (Criteria) this;
        }

        public Criteria andGroupsNameIsNull() {
            addCriterion("groups_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupsNameIsNotNull() {
            addCriterion("groups_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsNameEqualTo(String value) {
            addCriterion("groups_name =", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameNotEqualTo(String value) {
            addCriterion("groups_name <>", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameGreaterThan(String value) {
            addCriterion("groups_name >", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameGreaterThanOrEqualTo(String value) {
            addCriterion("groups_name >=", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameLessThan(String value) {
            addCriterion("groups_name <", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameLessThanOrEqualTo(String value) {
            addCriterion("groups_name <=", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameLike(String value) {
            addCriterion("groups_name like", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameNotLike(String value) {
            addCriterion("groups_name not like", value, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameIn(List<String> values) {
            addCriterion("groups_name in", values, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameNotIn(List<String> values) {
            addCriterion("groups_name not in", values, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameBetween(String value1, String value2) {
            addCriterion("groups_name between", value1, value2, "groupsName");
            return (Criteria) this;
        }

        public Criteria andGroupsNameNotBetween(String value1, String value2) {
            addCriterion("groups_name not between", value1, value2, "groupsName");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelIsNull() {
            addCriterion("groups_label is null");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelIsNotNull() {
            addCriterion("groups_label is not null");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelEqualTo(Integer value) {
            addCriterion("groups_label =", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelNotEqualTo(Integer value) {
            addCriterion("groups_label <>", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelGreaterThan(Integer value) {
            addCriterion("groups_label >", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelGreaterThanOrEqualTo(Integer value) {
            addCriterion("groups_label >=", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelLessThan(Integer value) {
            addCriterion("groups_label <", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelLessThanOrEqualTo(Integer value) {
            addCriterion("groups_label <=", value, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelIn(List<Integer> values) {
            addCriterion("groups_label in", values, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelNotIn(List<Integer> values) {
            addCriterion("groups_label not in", values, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelBetween(Integer value1, Integer value2) {
            addCriterion("groups_label between", value1, value2, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andGroupsLabelNotBetween(Integer value1, Integer value2) {
            addCriterion("groups_label not between", value1, value2, "groupsLabel");
            return (Criteria) this;
        }

        public Criteria andUsersIdIsNull() {
            addCriterion("users_id is null");
            return (Criteria) this;
        }

        public Criteria andUsersIdIsNotNull() {
            addCriterion("users_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsersIdEqualTo(Integer value) {
            addCriterion("users_id =", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotEqualTo(Integer value) {
            addCriterion("users_id <>", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThan(Integer value) {
            addCriterion("users_id >", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("users_id >=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThan(Integer value) {
            addCriterion("users_id <", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdLessThanOrEqualTo(Integer value) {
            addCriterion("users_id <=", value, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdIn(List<Integer> values) {
            addCriterion("users_id in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotIn(List<Integer> values) {
            addCriterion("users_id not in", values, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdBetween(Integer value1, Integer value2) {
            addCriterion("users_id between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andUsersIdNotBetween(Integer value1, Integer value2) {
            addCriterion("users_id not between", value1, value2, "usersId");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNull() {
            addCriterion("people_num is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIsNotNull() {
            addCriterion("people_num is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumEqualTo(Integer value) {
            addCriterion("people_num =", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotEqualTo(Integer value) {
            addCriterion("people_num <>", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThan(Integer value) {
            addCriterion("people_num >", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_num >=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThan(Integer value) {
            addCriterion("people_num <", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumLessThanOrEqualTo(Integer value) {
            addCriterion("people_num <=", value, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumIn(List<Integer> values) {
            addCriterion("people_num in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotIn(List<Integer> values) {
            addCriterion("people_num not in", values, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumBetween(Integer value1, Integer value2) {
            addCriterion("people_num between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andPeopleNumNotBetween(Integer value1, Integer value2) {
            addCriterion("people_num not between", value1, value2, "peopleNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumIsNull() {
            addCriterion("message_num is null");
            return (Criteria) this;
        }

        public Criteria andMessageNumIsNotNull() {
            addCriterion("message_num is not null");
            return (Criteria) this;
        }

        public Criteria andMessageNumEqualTo(Integer value) {
            addCriterion("message_num =", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotEqualTo(Integer value) {
            addCriterion("message_num <>", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumGreaterThan(Integer value) {
            addCriterion("message_num >", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_num >=", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumLessThan(Integer value) {
            addCriterion("message_num <", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumLessThanOrEqualTo(Integer value) {
            addCriterion("message_num <=", value, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumIn(List<Integer> values) {
            addCriterion("message_num in", values, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotIn(List<Integer> values) {
            addCriterion("message_num not in", values, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumBetween(Integer value1, Integer value2) {
            addCriterion("message_num between", value1, value2, "messageNum");
            return (Criteria) this;
        }

        public Criteria andMessageNumNotBetween(Integer value1, Integer value2) {
            addCriterion("message_num not between", value1, value2, "messageNum");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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