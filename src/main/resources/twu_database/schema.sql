--------------------------------------------------------
--  File created - Wednesday-August-29-2012   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ACTIVITIES
--------------------------------------------------------

  CREATE TABLE ACTIVITIES (ID DECIMAL(38,0) NOT NULL, CLIENT VARCHAR(15) NOT NULL, CLIENT_NAME VARCHAR(40) DEFAULT NULL, PROJECT VARCHAR(15) NOT NULL, PROJECT_NAME VARCHAR(40) DEFAULT NULL, SUB_PROJECT VARCHAR(15) NOT NULL, SUB_PROJECT_NAME VARCHAR(30) DEFAULT NULL, BILLABLE DECIMAL(1,0) DEFAULT NULL)
--------------------------------------------------------
--  DDL for Table ACTIVITY_CLASSIFICATIONS
--------------------------------------------------------

  CREATE TABLE ACTIVITY_CLASSIFICATIONS (ID DECIMAL(38,0), CLIENT VARCHAR(15), PROJECT VARCHAR(15), SUB_PROJECT VARCHAR(15), CLASSIFICATION VARCHAR(15))
--------------------------------------------------------
--  DDL for Table CATEGORIES
--------------------------------------------------------

  CREATE TABLE CATEGORIES (ID DECIMAL(38,0), CODE VARCHAR(15), NAME VARCHAR(50), VENDOR_REQUIRED DECIMAL(1,0) DEFAULT NULL, ATTENDEES_REQUIRED DECIMAL(1,0) DEFAULT NULL)
--------------------------------------------------------
--  DDL for Table COUNTRIES
--------------------------------------------------------

  CREATE TABLE COUNTRIES (COUNTRY_CODE VARCHAR(3), COUNTRY_NAME VARCHAR(100), ID VARCHAR(20) PRIMARY KEY)
--------------------------------------------------------
--  DDL for Table CURRENCY_PRESENCES
--------------------------------------------------------

  CREATE TABLE CURRENCY_PRESENCES (ID DECIMAL(38,0), CURRENCY VARCHAR(3 CHAR), THOUGHTWORKS_PRESENCE DECIMAL(1,0) DEFAULT 0)
--------------------------------------------------------
--  DDL for Table EMPLOYEES
--------------------------------------------------------

  CREATE TABLE EMPLOYEES (ID DECIMAL(38,0), LOGIN VARCHAR(15), NAME VARCHAR(100), EMPLOYEE_DECIMAL VARCHAR(11), GROUPS CLOB)
--------------------------------------------------------
--  DDL for Table EXPENSE_ACTIVITIES
--------------------------------------------------------

  CREATE TABLE EXPENSE_ACTIVITIES (ID DECIMAL(38,0))
--------------------------------------------------------
--  DDL for Table EXPENSE_ITEMS
--------------------------------------------------------

  CREATE TABLE EXPENSE_ITEMS (ID DECIMAL(38,0), EXPENSE_REPORT_ID DECIMAL(38,0), CLIENT VARCHAR(10), PROJECT VARCHAR(20), SUB_PROJECT VARCHAR(50), ITEM_DATE DATE DEFAULT NULL, CATEGORY VARCHAR(15) DEFAULT NULL, CURRENCY VARCHAR(3) DEFAULT NULL, AMOUNT DECIMAL(16,2) DEFAULT NULL, DESCRIPTION VARCHAR(255) DEFAULT NULL, VENDOR VARCHAR(100) DEFAULT NULL, PAYMENT VARCHAR(15) DEFAULT NULL, ATTENDEES VARCHAR(255) DEFAULT NULL, PERSONAL DECIMAL(1,0) DEFAULT NULL, LOCK_VERSION DECIMAL(38,0) DEFAULT 0)
--------------------------------------------------------
--  DDL for Table EXPENSE_REPORTS
--------------------------------------------------------

  CREATE TABLE EXPENSE_REPORTS (ID DECIMAL(38,0), EMPLOYEE_DECIMAL VARCHAR(11), STATUS VARCHAR(30), SUBMITTED_BY VARCHAR(30) DEFAULT NULL, CREATED_BY VARCHAR(30), CREATED_AT DATE, UPDATED_BY VARCHAR(30), UPDATED_AT DATE, LOCK_VERSION DECIMAL(38,0) DEFAULT 0, SUBMITTED_AT DATE)
--------------------------------------------------------
--  DDL for Table FAVORITETIMESHEET
--------------------------------------------------------

  CREATE TABLE FAVORITETIMESHEET (ID DECIMAL(10,0), NAME VARCHAR(255 CHAR), USERID VARCHAR(255 CHAR))
--------------------------------------------------------
--  DDL for Table LOCATION_PRESENCES
--------------------------------------------------------

  CREATE TABLE LOCATION_PRESENCES (ID DECIMAL(38,0), COUNTRY_CODE VARCHAR(3 CHAR), STATE VARCHAR(2 CHAR), THOUGHTWORKS_PRESENCE DECIMAL(1,0) DEFAULT 0)
--------------------------------------------------------
--  DDL for Table MISSING_DATES
--------------------------------------------------------

  CREATE TABLE MISSING_DATES (ID DECIMAL(38,0), MISSING_ON DATE)
--------------------------------------------------------
--  DDL for Table PAYMENTS
--------------------------------------------------------

  CREATE TABLE PAYMENTS (ID DECIMAL(38,0), CODE VARCHAR(15), NAME VARCHAR(50), REIMBURSABLE DECIMAL(1,0), ACTIVE DECIMAL(1,0) DEFAULT 1)
--------------------------------------------------------
--  DDL for Table PLAN_TABLE
--------------------------------------------------------

  CREATE TABLE PLAN_TABLE (STATEMENT_ID VARCHAR(30), TIMESTAMP DATE, REMARKS VARCHAR(80), OPERATION VARCHAR(30), OPTIONS VARCHAR(30), OBJECT_NODE VARCHAR(128), OBJECT_OWNER VARCHAR(30), OBJECT_NAME VARCHAR(30), OBJECT_INSTANCE DECIMAL, OBJECT_TYPE VARCHAR(30), OPTIMIZER VARCHAR(255), SEARCH_COLUMNS DECIMAL, ID DECIMAL, PARENT_ID DECIMAL, POSITION DECIMAL, COST DECIMAL, CARDINALITY DECIMAL, BYTES DECIMAL, OTHER_TAG VARCHAR(255), PARTITION_START VARCHAR(255), PARTITION_STOP VARCHAR(255), PARTITION_ID DECIMAL, OTHER LONG, DISTRIBUTION VARCHAR(30))
--------------------------------------------------------
--  DDL for Table PREFERENCES
--------------------------------------------------------

  CREATE TABLE PREFERENCES (ID DECIMAL(38,0), EMPLOYEE_ID DECIMAL(38,0), CURRENCY VARCHAR(3), COUNTRY VARCHAR(3), STATE VARCHAR(2), HOURS_PER_DAY DECIMAL(8,2))
--------------------------------------------------------
--  DDL for Table PS_TW_AD_USERS
--------------------------------------------------------

  CREATE TABLE PS_TW_AD_USERS (EMPLID VARCHAR(11), TW_LOGON VARCHAR(9), EMAIL_ADDR VARCHAR(26), FIRST_NAME VARCHAR(50), MIDDLE_NAME VARCHAR(50), LAST_NAME VARCHAR(50), HIRE_DT DATE)
--------------------------------------------------------
--  DDL for Table PS_TW_AD_USERS_BAD
--------------------------------------------------------

  CREATE TABLE PS_TW_AD_USERS_BAD (EMPLID VARCHAR(11), TW_LOGON VARCHAR(9), EMAIL_ADDR VARCHAR(26), FIRST_NAME VARCHAR(50), MIDDLE_NAME VARCHAR(50), LAST_NAME VARCHAR(50), HIRE_DT DATE)
--------------------------------------------------------
--  DDL for Table SCHEMA_MIGRATIONS
--------------------------------------------------------

  CREATE TABLE SCHEMA_MIGRATIONS (VERSION VARCHAR(255 CHAR))
--------------------------------------------------------
--  DDL for Table TIME_RECORDS
--------------------------------------------------------

  CREATE TABLE TIME_RECORDS (ID DECIMAL(38,0) PRIMARY KEY, TIME_SHEET_ID DECIMAL(38,0), PROJECT VARCHAR(20), SUB_PROJECT VARCHAR(50), BILLABLE DECIMAL(1,0), TASK_COMMENT VARCHAR(255) DEFAULT NULL, CLIENT VARCHAR(10), COUNTRY VARCHAR(3) DEFAULT NULL, STATE VARCHAR(2) DEFAULT NULL)
--------------------------------------------------------
--  DDL for Table TIME_RECORD_DAYS
--------------------------------------------------------

  CREATE TABLE TIME_RECORD_DAYS (ID DECIMAL(38,0), TIME_RECORD_ID DECIMAL(38,0), RECORD_DATE DATE, HOURS DECIMAL(8,2))
--------------------------------------------------------
--  DDL for Table TIME_SHEETS
--------------------------------------------------------

  CREATE TABLE TIME_SHEETS (ID DECIMAL(38,0), EMPLOYEE_DECIMAL VARCHAR(11), WEEK_ENDING_DATE DATE, CREATED_BY VARCHAR(30), CREATED_AT DATE, UPDATED_BY VARCHAR(30), UPDATED_AT DATE, STATUS VARCHAR(30), EXPENSES DECIMAL(1,0) DEFAULT NULL, SUBMITTED_BY VARCHAR(30) DEFAULT NULL, LOCK_VERSION DECIMAL(38,0) DEFAULT 0, SUBMITTED_AT DATE DEFAULT NULL)
--------------------------------------------------------
--  DDL for Index EXPENSE_REPORTS_IDX
--------------------------------------------------------

  CREATE INDEX EXPENSE_REPORTS_IDX ON EXPENSE_REPORTS (ID, EMPLOYEE_DECIMAL, STATUS, SUBMITTED_AT)
--------------------------------------------------------
--  DDL for Index TIME_RECORD_DAYS_FK
--------------------------------------------------------

  CREATE INDEX TIME_RECORD_DAYS_FK ON TIME_RECORD_DAYS (TIME_RECORD_ID, ID)
--------------------------------------------------------
--  DDL for Index TIME_SHEETS_EMPLID
--------------------------------------------------------

  CREATE INDEX TIME_SHEETS_EMPLID ON TIME_SHEETS (EMPLOYEE_DECIMAL, ID, WEEK_ENDING_DATE)
--------------------------------------------------------
--  DDL for Index UNIQUE_SCHEMA_MIGRATIONS
--------------------------------------------------------

  CREATE UNIQUE INDEX UNIQUE_SCHEMA_MIGRATIONS ON SCHEMA_MIGRATIONS (VERSION)
--------------------------------------------------------
--  DDL for Index TIME_RECORDS_ACTIVITY
--------------------------------------------------------

  CREATE INDEX TIME_RECORDS_ACTIVITY ON TIME_RECORDS (CLIENT, PROJECT, SUB_PROJECT, BILLABLE)
--------------------------------------------------------
--  DDL for Index COUNTRIES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX COUNTRIES_PK ON COUNTRIES (ID)
--------------------------------------------------------
--  DDL for Index EXPENSE_ITEMS_FK
--------------------------------------------------------

  CREATE INDEX EXPENSE_ITEMS_FK ON EXPENSE_ITEMS (EXPENSE_REPORT_ID, ID)
--------------------------------------------------------
--  DDL for Index ACTIVITIES_CLIENT_PROJ_SUB
--------------------------------------------------------

  CREATE INDEX ACTIVITIES_CLIENT_PROJ_SUB ON ACTIVITIES (CLIENT, PROJECT, SUB_PROJECT)
--------------------------------------------------------
--  DDL for Index TIME_RECORDS_FK
--------------------------------------------------------

  CREATE INDEX TIME_RECORDS_FK ON TIME_RECORDS (TIME_SHEET_ID, ID, STATE)

  -----------------------------
  CREATE TABLE FAVORITE_TIMESHEET (ID DECIMAL(38,0) PRIMARY KEY, NAME VARCHAR(200),USERID VARCHAR(100))















