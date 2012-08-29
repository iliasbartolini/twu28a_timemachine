--------------------------------------------------------
--  File created - Wednesday-August-29-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACTIVITIES
--------------------------------------------------------

  CREATE TABLE "ACTIVITIES" 
   (	"ID" NUMBER(38,0), 
	"CLIENT" VARCHAR2(15), 
	"CLIENT_NAME" VARCHAR2(40) DEFAULT NULL, 
	"PROJECT" VARCHAR2(15), 
	"PROJECT_NAME" VARCHAR2(40) DEFAULT NULL, 
	"SUB_PROJECT" VARCHAR2(15), 
	"SUB_PROJECT_NAME" VARCHAR2(30) DEFAULT NULL, 
	"BILLABLE" NUMBER(1,0) DEFAULT NULL
   )
--------------------------------------------------------
--  DDL for Table ACTIVITY_CLASSIFICATIONS
--------------------------------------------------------

  CREATE TABLE "ACTIVITY_CLASSIFICATIONS" 
   (	"ID" NUMBER(38,0), 
	"CLIENT" VARCHAR2(15), 
	"PROJECT" VARCHAR2(15), 
	"SUB_PROJECT" VARCHAR2(15), 
	"CLASSIFICATION" VARCHAR2(15)
   )
--------------------------------------------------------
--  DDL for Table CATEGORIES
--------------------------------------------------------

  CREATE TABLE "CATEGORIES" 
   (	"ID" NUMBER(38,0), 
	"CODE" VARCHAR2(15), 
	"NAME" VARCHAR2(50), 
	"VENDOR_REQUIRED" NUMBER(1,0) DEFAULT NULL, 
	"ATTENDEES_REQUIRED" NUMBER(1,0) DEFAULT NULL
   )
--------------------------------------------------------
--  DDL for Table COUNTRIES
--------------------------------------------------------

  CREATE TABLE "COUNTRIES" 
   (	"COUNTRY_CODE" VARCHAR2(3), 
	"COUNTRY_NAME" VARCHAR2(100), 
	"ID" VARCHAR2(20)
   )
--------------------------------------------------------
--  DDL for Table CURRENCY_PRESENCES
--------------------------------------------------------

  CREATE TABLE "CURRENCY_PRESENCES" 
   (	"ID" NUMBER(38,0), 
	"CURRENCY" VARCHAR2(3 CHAR), 
	"THOUGHTWORKS_PRESENCE" NUMBER(1,0) DEFAULT 0
   )
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE "EMPLOYEES" 
   (	"ID" NUMBER(38,0), 
	"LOGIN" VARCHAR2(15), 
	"NAME" VARCHAR2(100), 
	"EMPLOYEE_NUMBER" VARCHAR2(11), 
	"GROUPS" CLOB
   )
--------------------------------------------------------
--  DDL for Table EXPENSE_ACTIVITIES
--------------------------------------------------------

  CREATE TABLE "EXPENSE_ACTIVITIES" 
   (	"ID" NUMBER(38,0)
   )
--------------------------------------------------------
--  DDL for Table EXPENSE_ITEMS
--------------------------------------------------------

  CREATE TABLE "EXPENSE_ITEMS" 
   (	"ID" NUMBER(38,0), 
	"EXPENSE_REPORT_ID" NUMBER(38,0), 
	"CLIENT" VARCHAR2(10), 
	"PROJECT" VARCHAR2(20), 
	"SUB_PROJECT" VARCHAR2(50), 
	"ITEM_DATE" DATE DEFAULT NULL, 
	"CATEGORY" VARCHAR2(15) DEFAULT NULL, 
	"CURRENCY" VARCHAR2(3) DEFAULT NULL, 
	"AMOUNT" NUMBER(16,2) DEFAULT NULL, 
	"DESCRIPTION" VARCHAR2(255) DEFAULT NULL, 
	"VENDOR" VARCHAR2(100) DEFAULT NULL, 
	"PAYMENT" VARCHAR2(15) DEFAULT NULL, 
	"ATTENDEES" VARCHAR2(255) DEFAULT NULL, 
	"PERSONAL" NUMBER(1,0) DEFAULT NULL, 
	"LOCK_VERSION" NUMBER(38,0) DEFAULT 0
   )
--------------------------------------------------------
--  DDL for Table EXPENSE_REPORTS
--------------------------------------------------------

  CREATE TABLE "EXPENSE_REPORTS" 
   (	"ID" NUMBER(38,0), 
	"EMPLOYEE_NUMBER" VARCHAR2(11), 
	"STATUS" VARCHAR2(30), 
	"SUBMITTED_BY" VARCHAR2(30) DEFAULT NULL, 
	"CREATED_BY" VARCHAR2(30), 
	"CREATED_AT" DATE, 
	"UPDATED_BY" VARCHAR2(30), 
	"UPDATED_AT" DATE, 
	"LOCK_VERSION" NUMBER(38,0) DEFAULT 0, 
	"SUBMITTED_AT" DATE
   )
--------------------------------------------------------
--  DDL for Table FAVORITETIMESHEET
--------------------------------------------------------

  CREATE TABLE "FAVORITETIMESHEET" 
   (	"ID" NUMBER(10,0), 
	"NAME" VARCHAR2(255 CHAR), 
	"USERID" VARCHAR2(255 CHAR)
   )
--------------------------------------------------------
--  DDL for Table LOCATION_PRESENCES
--------------------------------------------------------

  CREATE TABLE "LOCATION_PRESENCES" 
   (	"ID" NUMBER(38,0), 
	"COUNTRY_CODE" VARCHAR2(3 CHAR), 
	"STATE" VARCHAR2(2 CHAR), 
	"THOUGHTWORKS_PRESENCE" NUMBER(1,0) DEFAULT 0
   )
--------------------------------------------------------
--  DDL for Table MISSING_DATES
--------------------------------------------------------

  CREATE TABLE "MISSING_DATES" 
   (	"ID" NUMBER(38,0), 
	"MISSING_ON" DATE
   )
--------------------------------------------------------
--  DDL for Table PAYMENTS
--------------------------------------------------------

  CREATE TABLE "PAYMENTS" 
   (	"ID" NUMBER(38,0), 
	"CODE" VARCHAR2(15), 
	"NAME" VARCHAR2(50), 
	"REIMBURSABLE" NUMBER(1,0), 
	"ACTIVE" NUMBER(1,0) DEFAULT 1
   )
--------------------------------------------------------
--  DDL for Table PLAN_TABLE
--------------------------------------------------------

  CREATE TABLE "PLAN_TABLE" 
   (	"STATEMENT_ID" VARCHAR2(30), 
	"TIMESTAMP" DATE, 
	"REMARKS" VARCHAR2(80), 
	"OPERATION" VARCHAR2(30), 
	"OPTIONS" VARCHAR2(30), 
	"OBJECT_NODE" VARCHAR2(128), 
	"OBJECT_OWNER" VARCHAR2(30), 
	"OBJECT_NAME" VARCHAR2(30), 
	"OBJECT_INSTANCE" NUMBER, 
	"OBJECT_TYPE" VARCHAR2(30), 
	"OPTIMIZER" VARCHAR2(255), 
	"SEARCH_COLUMNS" NUMBER, 
	"ID" NUMBER, 
	"PARENT_ID" NUMBER, 
	"POSITION" NUMBER, 
	"COST" NUMBER, 
	"CARDINALITY" NUMBER, 
	"BYTES" NUMBER, 
	"OTHER_TAG" VARCHAR2(255), 
	"PARTITION_START" VARCHAR2(255), 
	"PARTITION_STOP" VARCHAR2(255), 
	"PARTITION_ID" NUMBER, 
	"OTHER" LONG, 
	"DISTRIBUTION" VARCHAR2(30)
   )
--------------------------------------------------------
--  DDL for Table PREFERENCES
--------------------------------------------------------

  CREATE TABLE "PREFERENCES" 
   (	"ID" NUMBER(38,0), 
	"EMPLOYEE_ID" NUMBER(38,0), 
	"CURRENCY" VARCHAR2(3), 
	"COUNTRY" VARCHAR2(3), 
	"STATE" VARCHAR2(2), 
	"HOURS_PER_DAY" NUMBER(8,2)
   )
--------------------------------------------------------
--  DDL for Table PS_TW_AD_USERS
--------------------------------------------------------

  CREATE TABLE "PS_TW_AD_USERS" 
   (	"EMPLID" VARCHAR2(11), 
	"TW_LOGON" VARCHAR2(9), 
	"EMAIL_ADDR" VARCHAR2(26), 
	"FIRST_NAME" VARCHAR2(50), 
	"MIDDLE_NAME" VARCHAR2(50), 
	"LAST_NAME" VARCHAR2(50), 
	"HIRE_DT" DATE
   )
--------------------------------------------------------
--  DDL for Table PS_TW_AD_USERS_BAD
--------------------------------------------------------

  CREATE TABLE "PS_TW_AD_USERS_BAD" 
   (	"EMPLID" VARCHAR2(11), 
	"TW_LOGON" VARCHAR2(9), 
	"EMAIL_ADDR" VARCHAR2(26), 
	"FIRST_NAME" VARCHAR2(50), 
	"MIDDLE_NAME" VARCHAR2(50), 
	"LAST_NAME" VARCHAR2(50), 
	"HIRE_DT" DATE
   )
--------------------------------------------------------
--  DDL for Table SCHEMA_MIGRATIONS
--------------------------------------------------------

  CREATE TABLE "SCHEMA_MIGRATIONS" 
   (	"VERSION" VARCHAR2(255 CHAR)
   )
--------------------------------------------------------
--  DDL for Table TIME_RECORDS
--------------------------------------------------------

  CREATE TABLE "TIME_RECORDS" 
   (	"ID" NUMBER(38,0), 
	"TIME_SHEET_ID" NUMBER(38,0), 
	"PROJECT" VARCHAR2(20), 
	"SUB_PROJECT" VARCHAR2(50), 
	"BILLABLE" NUMBER(1,0), 
	"TASK_COMMENT" VARCHAR2(255) DEFAULT NULL, 
	"CLIENT" VARCHAR2(10), 
	"COUNTRY" VARCHAR2(3) DEFAULT NULL, 
	"STATE" VARCHAR2(2) DEFAULT NULL
   )
--------------------------------------------------------
--  DDL for Table TIME_RECORD_DAYS
--------------------------------------------------------

  CREATE TABLE "TIME_RECORD_DAYS" 
   (	"ID" NUMBER(38,0), 
	"TIME_RECORD_ID" NUMBER(38,0), 
	"RECORD_DATE" DATE, 
	"HOURS" NUMBER(8,2)
   )
--------------------------------------------------------
--  DDL for Table TIME_SHEETS
--------------------------------------------------------

  CREATE TABLE "TIME_SHEETS" 
   (	"ID" NUMBER(38,0), 
	"EMPLOYEE_NUMBER" VARCHAR2(11), 
	"WEEK_ENDING_DATE" DATE, 
	"CREATED_BY" VARCHAR2(30), 
	"CREATED_AT" DATE, 
	"UPDATED_BY" VARCHAR2(30), 
	"UPDATED_AT" DATE, 
	"STATUS" VARCHAR2(30), 
	"EXPENSES" NUMBER(1,0) DEFAULT NULL, 
	"SUBMITTED_BY" VARCHAR2(30) DEFAULT NULL, 
	"LOCK_VERSION" NUMBER(38,0) DEFAULT 0, 
	"SUBMITTED_AT" DATE DEFAULT NULL
   )
--------------------------------------------------------
--  DDL for View CURRENCIES
--------------------------------------------------------

  CREATE OR REPLACE VIEW "CURRENCIES" ("ID", "CURRENCY", "CURRENCY_NAME") AS 
  select '1' AS ID, CURRENCY_CD AS CURRENCY, DESCR AS CURRENCY_NAME from ps_currency_cd_tbl a where a.effdt = (select max(a_ed.effdt)  from ps_currency_cd_tbl a_ed  where a.currency_cd = a_ed.currency_cd  and a_ed.effdt <= SYSDATE) and a.eff_status = 'A'
--------------------------------------------------------
--  DDL for View LOCATIONS
--------------------------------------------------------

  CREATE OR REPLACE VIEW "LOCATIONS" ("ID", "COUNTRY", "COUNTRY_NAME", "STATE", "STATE_NAME") AS 
  SELECT 1 AS ID, A.COUNTRY AS COUNTRY, A.DESCRSHORT AS COUNTRY_NAME, B.STATE as STATE, B.DESCR AS STATE_NAME FROM PS_COUNTRY_TBL A, PS_STATE_TBL B WHERE A.COUNTRY = B.COUNTRY AND A.COUNTRY = 'USA' UNION ALL SELECT 1 AS ID, A.COUNTRY AS COUNTRY, A.DESCRSHORT AS COUNTRY_NAME, null AS STATE, null AS STATE_NAME FROM PS_COUNTRY_TBL A WHERE A.COUNTRY <> 'USA'
--------------------------------------------------------
--  DDL for Index EXPENSE_REPORTS_IDX
--------------------------------------------------------

  CREATE INDEX "EXPENSE_REPORTS_IDX" ON "EXPENSE_REPORTS" ("ID", "EMPLOYEE_NUMBER", "STATUS", "SUBMITTED_AT")
--------------------------------------------------------
--  DDL for Index TIME_RECORD_DAYS_FK
--------------------------------------------------------

  CREATE INDEX "TIME_RECORD_DAYS_FK" ON "TIME_RECORD_DAYS" ("TIME_RECORD_ID", "ID")
--------------------------------------------------------
--  DDL for Index TIME_SHEETS_EMPLID
--------------------------------------------------------

  CREATE INDEX "TIME_SHEETS_EMPLID" ON "TIME_SHEETS" ("EMPLOYEE_NUMBER", "ID", "WEEK_ENDING_DATE")
--------------------------------------------------------
--  DDL for Index UNIQUE_SCHEMA_MIGRATIONS
--------------------------------------------------------

  CREATE UNIQUE INDEX "UNIQUE_SCHEMA_MIGRATIONS" ON "SCHEMA_MIGRATIONS" ("VERSION")
--------------------------------------------------------
--  DDL for Index TIME_RECORDS_ACTIVITY
--------------------------------------------------------

  CREATE INDEX "TIME_RECORDS_ACTIVITY" ON "TIME_RECORDS" ("CLIENT", "PROJECT", "SUB_PROJECT", "BILLABLE")
--------------------------------------------------------
--  DDL for Index COUNTRIES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "COUNTRIES_PK" ON "COUNTRIES" ("ID")
--------------------------------------------------------
--  DDL for Index EXPENSE_ITEMS_FK
--------------------------------------------------------

  CREATE INDEX "EXPENSE_ITEMS_FK" ON "EXPENSE_ITEMS" ("EXPENSE_REPORT_ID", "ID")
--------------------------------------------------------
--  DDL for Index ACTIVITIES_CLIENT_PROJ_SUB
--------------------------------------------------------

  CREATE INDEX "ACTIVITIES_CLIENT_PROJ_SUB" ON "ACTIVITIES" ("CLIENT", "PROJECT", "SUB_PROJECT")
--------------------------------------------------------
--  DDL for Index TIME_RECORDS_FK
--------------------------------------------------------

  CREATE INDEX "TIME_RECORDS_FK" ON "TIME_RECORDS" ("TIME_SHEET_ID", "ID", "STATE")
--------------------------------------------------------
--  Constraints for Table PAYMENTS
--------------------------------------------------------

  ALTER TABLE "PAYMENTS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PAYMENTS" MODIFY ("ACTIVE" NOT NULL ENABLE)
  ALTER TABLE "PAYMENTS" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "PAYMENTS" MODIFY ("CODE" NOT NULL ENABLE)
  ALTER TABLE "PAYMENTS" MODIFY ("ID" NOT NULL ENABLE)

--------------------------------------------------------
--  Constraints for Table EXPENSE_REPORTS
--------------------------------------------------------

  ALTER TABLE "EXPENSE_REPORTS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("UPDATED_AT" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("UPDATED_BY" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("CREATED_AT" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("CREATED_BY" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("STATUS" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("EMPLOYEE_NUMBER" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_REPORTS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table EXPENSE_ITEMS
--------------------------------------------------------

  ALTER TABLE "EXPENSE_ITEMS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "EXPENSE_ITEMS" MODIFY ("SUB_PROJECT" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_ITEMS" MODIFY ("PROJECT" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_ITEMS" MODIFY ("CLIENT" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_ITEMS" MODIFY ("EXPENSE_REPORT_ID" NOT NULL ENABLE)
  ALTER TABLE "EXPENSE_ITEMS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table EMPLOYEES
--------------------------------------------------------

  ALTER TABLE "EMPLOYEES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "EMPLOYEES" MODIFY ("GROUPS" NOT NULL ENABLE)
  ALTER TABLE "EMPLOYEES" MODIFY ("EMPLOYEE_NUMBER" NOT NULL ENABLE)
  ALTER TABLE "EMPLOYEES" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "EMPLOYEES" MODIFY ("LOGIN" NOT NULL ENABLE)
  ALTER TABLE "EMPLOYEES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ACTIVITIES
--------------------------------------------------------

  ALTER TABLE "ACTIVITIES" MODIFY ("SUB_PROJECT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITIES" MODIFY ("PROJECT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITIES" MODIFY ("CLIENT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITIES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PREFERENCES
--------------------------------------------------------

  ALTER TABLE "PREFERENCES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "PREFERENCES" MODIFY ("EMPLOYEE_ID" NOT NULL ENABLE)
  ALTER TABLE "PREFERENCES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table COUNTRIES
--------------------------------------------------------

  ALTER TABLE "COUNTRIES" ADD CONSTRAINT "COUNTRIES_PK" PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "COUNTRIES" MODIFY ("ID" NOT NULL ENABLE)
  ALTER TABLE "COUNTRIES" MODIFY ("COUNTRY_NAME" NOT NULL ENABLE)
  ALTER TABLE "COUNTRIES" MODIFY ("COUNTRY_CODE" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table SCHEMA_MIGRATIONS
--------------------------------------------------------

  ALTER TABLE "SCHEMA_MIGRATIONS" MODIFY ("VERSION" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PS_TW_AD_USERS
--------------------------------------------------------

  ALTER TABLE "PS_TW_AD_USERS" MODIFY ("TW_LOGON" NOT NULL ENABLE)
  ALTER TABLE "PS_TW_AD_USERS" MODIFY ("EMPLID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table TIME_RECORDS
--------------------------------------------------------

  ALTER TABLE "TIME_RECORDS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "TIME_RECORDS" MODIFY ("CLIENT" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORDS" MODIFY ("BILLABLE" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORDS" MODIFY ("SUB_PROJECT" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORDS" MODIFY ("PROJECT" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORDS" MODIFY ("TIME_SHEET_ID" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORDS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table LOCATION_PRESENCES
--------------------------------------------------------

  ALTER TABLE "LOCATION_PRESENCES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "LOCATION_PRESENCES" MODIFY ("COUNTRY_CODE" NOT NULL ENABLE)
  ALTER TABLE "LOCATION_PRESENCES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table TIME_RECORD_DAYS
--------------------------------------------------------

  ALTER TABLE "TIME_RECORD_DAYS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "TIME_RECORD_DAYS" MODIFY ("HOURS" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORD_DAYS" MODIFY ("RECORD_DATE" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORD_DAYS" MODIFY ("TIME_RECORD_ID" NOT NULL ENABLE)
  ALTER TABLE "TIME_RECORD_DAYS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table CATEGORIES
--------------------------------------------------------

  ALTER TABLE "CATEGORIES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "CATEGORIES" MODIFY ("NAME" NOT NULL ENABLE)
  ALTER TABLE "CATEGORIES" MODIFY ("CODE" NOT NULL ENABLE)
  ALTER TABLE "CATEGORIES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table PS_TW_AD_USERS_BAD
--------------------------------------------------------

  ALTER TABLE "PS_TW_AD_USERS_BAD" MODIFY ("TW_LOGON" NOT NULL ENABLE)
  ALTER TABLE "PS_TW_AD_USERS_BAD" MODIFY ("EMPLID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table CURRENCY_PRESENCES
--------------------------------------------------------

  ALTER TABLE "CURRENCY_PRESENCES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "CURRENCY_PRESENCES" MODIFY ("CURRENCY" NOT NULL ENABLE)
  ALTER TABLE "CURRENCY_PRESENCES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table ACTIVITY_CLASSIFICATIONS
--------------------------------------------------------

  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" MODIFY ("CLASSIFICATION" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" MODIFY ("SUB_PROJECT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" MODIFY ("PROJECT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" MODIFY ("CLIENT" NOT NULL ENABLE)
  ALTER TABLE "ACTIVITY_CLASSIFICATIONS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table MISSING_DATES
--------------------------------------------------------

  ALTER TABLE "MISSING_DATES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "MISSING_DATES" MODIFY ("MISSING_ON" NOT NULL ENABLE)
  ALTER TABLE "MISSING_DATES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table EXPENSE_ACTIVITIES
--------------------------------------------------------

  ALTER TABLE "EXPENSE_ACTIVITIES" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "EXPENSE_ACTIVITIES" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table TIME_SHEETS
--------------------------------------------------------

  ALTER TABLE "TIME_SHEETS" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "TIME_SHEETS" MODIFY ("STATUS" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("UPDATED_AT" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("UPDATED_BY" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("CREATED_AT" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("CREATED_BY" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("WEEK_ENDING_DATE" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("EMPLOYEE_NUMBER" NOT NULL ENABLE)
  ALTER TABLE "TIME_SHEETS" MODIFY ("ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Constraints for Table FAVORITETIMESHEET
--------------------------------------------------------

  ALTER TABLE "FAVORITETIMESHEET" ADD PRIMARY KEY ("ID") ENABLE
  ALTER TABLE "FAVORITETIMESHEET" MODIFY ("ID" NOT NULL ENABLE)





















