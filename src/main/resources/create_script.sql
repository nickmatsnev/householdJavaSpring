/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 14.1 		*/
/*  Created On : 17-Apr-2021 4:11:40 PM 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS "Assingment" CASCADE
;

DROP TABLE IF EXISTS "Category" CASCADE
;

DROP TABLE IF EXISTS "Household" CASCADE
;

DROP TABLE IF EXISTS "InventoryItem" CASCADE
;

DROP TABLE IF EXISTS "ItemInstance" CASCADE
;

DROP TABLE IF EXISTS "Location" CASCADE
;

DROP TABLE IF EXISTS "Member" CASCADE
;

DROP TABLE IF EXISTS "StockTag" CASCADE
;

DROP TABLE IF EXISTS "Task" CASCADE
;

DROP TABLE IF EXISTS "TaskAction" CASCADE
;

DROP TABLE IF EXISTS "TrackingCategory" CASCADE
;

DROP TABLE IF EXISTS "TrackingEntry" CASCADE
;

/* Create Tables */

CREATE TABLE "Assingment"
(
	"StockTagID" numeric(20) NOT NULL,
	"InventoryItemID" numeric(20) NOT NULL
)
;

CREATE TABLE "Category"
(
	"Name" varchar(50) NOT NULL,
	"CategoryID" numeric(20) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL
)
;

CREATE TABLE "Household"
(
	"Address" varchar(100) NOT NULL,
	"Name" varchar(50) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL
)
;

CREATE TABLE "InventoryItem"
(
	"Description" text NULL,
	"Title" varchar(50) NOT NULL,
	"InventoryItemID" numeric(20) NOT NULL,
	"CategoryID" numeric(20) NULL
)
;

CREATE TABLE "ItemInstance"
(
	"BOUGHT DATE" timestamp without time zone NOT NULL,
	"ExpirationDate" timestamp without time zone NOT NULL,
	"PercentLeft" numeric(8,2) NULL,
	"QuantityType" varchar(50) NULL,
	"ItemInstanceID" numeric(20) NOT NULL,
	"InventoryItemID" numeric(20) NOT NULL,
	"LocationID" numeric(20) NULL
)
;

CREATE TABLE "Location"
(
	"Name" varchar(50) NOT NULL,
	"LocationID" numeric(20) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL
)
;

CREATE TABLE "Member"
(
	"MembershipType" varchar(50) NOT NULL,
	"MemberID" numeric(20) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL,
	"UserID" numeric(20) NOT NULL
)
;

CREATE TABLE "StockTag"
(
	"Colour" varchar(50) NOT NULL,
	"Name" varchar(50) NOT NULL,
	"StockTagID" numeric(20) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL
)
;

CREATE TABLE "Task"
(
	"Deadline" timestamp without time zone NULL,
	"Description" text NULL,
	"Priority" varchar(20) NULL,
	"State" varchar(20) NOT NULL,
	"Title" varchar(50) NOT NULL,
	"Type" varchar(50) NOT NULL,
	"TaskID" numeric(20) NOT NULL,
	"AUTHORID" numeric(20) NOT NULL,
	"ASSIGNEEID" numeric(20) NULL
)
;

CREATE TABLE "TaskAction"
(
	"DateTime" timestamp without time zone NOT NULL,
	"Description" time(6) without time zone NULL,
	"PerformedBy" varchar(50) NULL,
	"TaskActionID" numeric(20) NOT NULL,
	"TaskID" numeric(20) NOT NULL
)
;

CREATE TABLE "TrackingCategory"
(
	"Category" varchar(50) NOT NULL,
	"StartDate" timestamp without time zone NOT NULL,
	"TimePeriod" varchar(50) NOT NULL,
	"TrackingCategoryID" numeric(20) NOT NULL,
	"HouseholdID" numeric(20) NOT NULL
)
;

CREATE TABLE "TrackingEntry"
(
	"Bill" varchar(50) NOT NULL,
	"Consumption" varchar(50) NOT NULL,
	"EntryDate" timestamp without time zone NOT NULL,
	"TrackingEntryID" numeric(20) NOT NULL,
	"TrackingCategoryID" numeric(20) NOT NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE "Category" ADD CONSTRAINT "PK_Category"
	PRIMARY KEY ("CategoryID")
;

ALTER TABLE "Household" ADD CONSTRAINT "PK_Household"
	PRIMARY KEY ("HouseholdID")
;

ALTER TABLE "InventoryItem" ADD CONSTRAINT "PK_InventoryItem"
	PRIMARY KEY ("InventoryItemID")
;

ALTER TABLE "ItemInstance" ADD CONSTRAINT "PK_Item_instance"
	PRIMARY KEY ("ItemInstanceID")
;

ALTER TABLE "Location" ADD CONSTRAINT "PK_Location"
	PRIMARY KEY ("LocationID")
;

ALTER TABLE "Member" ADD CONSTRAINT "PK_Member"
	PRIMARY KEY ("MemberID")
;

ALTER TABLE "StockTag" ADD CONSTRAINT "PK_StockTag"
	PRIMARY KEY ("StockTagID")
;

ALTER TABLE "Task" ADD CONSTRAINT "PK_Task"
	PRIMARY KEY ("TaskID")
;

CREATE INDEX "IXFK_TASK_ASSIGNEE" ON "Task" ("ASSIGNEEID" ASC)
;

ALTER TABLE "TaskAction" ADD CONSTRAINT "PK_TaskAction"
	PRIMARY KEY ("TaskActionID")
;

ALTER TABLE "TrackingCategory" ADD CONSTRAINT "PK_TrackingCategory"
	PRIMARY KEY ("TrackingCategoryID")
;

ALTER TABLE "TrackingCategory" ADD CONSTRAINT "CHECK_TIMEPERIOD_ENUM" CHECK (TIME_PERIOD IN ("WEEKLY", "MONTHLY", "DAILY"))
;

ALTER TABLE "TrackingEntry" ADD CONSTRAINT "PK_TrackingEntry"
	PRIMARY KEY ("TrackingEntryID","TrackingCategoryID")
;

/* Create Foreign Key Constraints */

ALTER TABLE "Assingment" ADD CONSTRAINT "FK_has_Stock Tag"
	FOREIGN KEY ("StockTagID") REFERENCES "StockTag" ("StockTagID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Assingment" ADD CONSTRAINT "FK_has_Inventory Item "
	FOREIGN KEY ("InventoryItemID") REFERENCES "InventoryItem" ("InventoryItemID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Category" ADD CONSTRAINT "FK_Category_Subcategory of "
	FOREIGN KEY ("CategoryID") REFERENCES "Category" ("CategoryID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Category" ADD CONSTRAINT "FK_Category_created by"
	FOREIGN KEY ("HouseholdID") REFERENCES "Household" ("HouseholdID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "InventoryItem" ADD CONSTRAINT "FK_Inventory Item _belongs to "
	FOREIGN KEY ("CategoryID") REFERENCES "Category" ("CategoryID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "ItemInstance" ADD CONSTRAINT "FK_Item_Instance_of"
	FOREIGN KEY ("InventoryItemID") REFERENCES "InventoryItem" ("InventoryItemID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "ItemInstance" ADD CONSTRAINT "FK_Item_Instance_stored at "
	FOREIGN KEY ("LocationID") REFERENCES "Location" ("LocationID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Location" ADD CONSTRAINT "FK_Location_has"
	FOREIGN KEY ("HouseholdID") REFERENCES "Household" ("HouseholdID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Location" ADD CONSTRAINT "FK_Location_located at"
	FOREIGN KEY ("LocationID") REFERENCES "Location" ("LocationID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Member" ADD CONSTRAINT "FK_Member_access to "
	FOREIGN KEY ("HouseholdID") REFERENCES "Household" ("HouseholdID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Member" ADD CONSTRAINT "FK_Member_can be "
	FOREIGN KEY ("UserID") REFERENCES "User" ("UserID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "StockTag" ADD CONSTRAINT "FK_Stock Tag_created by"
	FOREIGN KEY ("HouseholdID") REFERENCES "Household" ("HouseholdID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Task" ADD CONSTRAINT "FK_TASK_ASSIGNEE"
	FOREIGN KEY ("ASSIGNEEID") REFERENCES "User" ("UserID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "Task" ADD CONSTRAINT "FK_TASK_AUTHOR"
	FOREIGN KEY ("AUTHORID") REFERENCES "User" ("UserID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "TaskAction" ADD CONSTRAINT "FK_Task Action_done for"
	FOREIGN KEY ("TaskID") REFERENCES "Task" ("TaskID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "TrackingCategory" ADD CONSTRAINT "FK_Tracking Category _has"
	FOREIGN KEY ("HouseholdID") REFERENCES "Household" ("HouseholdID") ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE "TrackingEntry" ADD CONSTRAINT "FK_Tracking Entry_of"
	FOREIGN KEY ("TrackingCategoryID") REFERENCES "TrackingCategory" ("TrackingCategoryID") ON DELETE No Action ON UPDATE No Action
;

/* Create Table Comments, Sequences for Autonumber Columns */

COMMENT ON TABLE "Category"
	IS 'Some category of the inventory items. Can have a hierarchy of categories.'
;

COMMENT ON TABLE "Household"
	IS 'Household, for which all the tracking and management is done.'
;

COMMENT ON TABLE "InventoryItem"
	IS 'Some item that user keeps track of in the inventory. Represents a group of same items. For example, rice.'
;

COMMENT ON TABLE "ItemInstance"
	IS 'Represents a single piece of Inventory Item entity. For example, 1 bag of rice.'
;

COMMENT ON TABLE "Location"
	IS 'A location in the household, in which some inventory items can be stored.  Can have a hierarchy of locations.'
;

COMMENT ON TABLE "Member"
	IS 'Type of the membership of user in the household. Could be Leader, Member, Audience Member. '
;

COMMENT ON TABLE "StockTag"
	IS 'A tag that can be assigned to an inventory item. Has a name and a color as attributes.'
;

COMMENT ON TABLE "Task"
	IS 'Tasks can be though of similar to tickets in a ticketing system.
Each HouseHold Member can create and assign task to other members in the Household. 
The task have Deadline, Priority and Type attributes which help define the task type.'
;

COMMENT ON TABLE "TaskAction"
	IS 'An action associated with the task, for example task assigned, task deadline changed, task finished and so on. Contains a textual description of the task in the attribute.'
;

COMMENT ON TABLE "TrackingCategory"
	IS 'Category of consumption tracking. Possible categories are electricity, gas, water etc.'
;

COMMENT ON TABLE "TrackingEntry"
	IS 'Single entry of consumption for some period of time.'
;