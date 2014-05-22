-- Step 1 to load parameters data
-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Step 3: This SQL will perform the following: -                          |
-- | a. Loading of initial paremeters data into tables                       | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+

-- Create Institution Information Record
INSERT INTO vipro.institution (institution_id, institution_name, mon_off, tue_off, wed_off, thu_off, fri_off, sat_off, sun_off, status)
     VALUES (1000000001, 'B&G CONCEPT ENGINEERING SDN BHD', 'N', 'N', 'N', 'N', 'N', 'Y', 'Y', 'SSACT');

-- Create Holiday Table Data
INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140501, 'LABOUR DAY');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140513, 'WESAK DAY');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140607, 'AGONG BIRTHDAY');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140715, 'NUZUL AL-QURAN');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140728, 'HARI RAYA PUASA');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140729, 'HARI RAYA PUASA');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140901, 'NATIONAL DAY');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20140916, 'MALAYSIA DAY');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20141006, 'HARI RAYA HAJI');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20141023, 'DEEPAVALI');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20141025, 'AWAL MUHARAM');

INSERT INTO vipro.holiday (institution_id, date, description)
     VALUES (1000000001, 20141225, 'CHRISTMAS');
     
-- Create Default User Group and Username
INSERT INTO vipro.user_group VALUES ('ADMIN', 'SYSTEM ADMIN', 'SSACT');
INSERT INTO vipro.user_group VALUES ('SALES', 'SALES STAFF', 'SSACT');
INSERT INTO vipro.user_group VALUES ('SALES_PIC', 'SALES PERSON-IN-CHARGE', 'SSACT');
INSERT INTO vipro.user_group VALUES ('SALES_ADM', 'BACK OFFICE ADMIN', 'SSACT');
INSERT INTO vipro.user_group VALUES ('CUST_SERV', 'CUSTOMER SERVICE', 'SSACT');
INSERT INTO vipro.user_group VALUES ('PIC_ADM', 'PIC MANAGER', 'SSACT');
INSERT INTO vipro.user_group VALUES ('ACCT', 'ACCOUNT STAFF', 'SSACT');
INSERT INTO vipro.user_group VALUES ('SADM_STF', 'SALES ADMIN STAFF', 'SSACT');

INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('salespic1', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES PIC 1 NAME', 1000000001,'joe.lim@mct.com.my', '0193393596', 'DMSMA', 'SSACT', 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('salespic2', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES PIC 2 NAME', 1000000001,'salina@mct.com.my', '0173648087', 'DMSMA', 'SSACT', 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, department, status, group_id) 
     VALUES ('sysadm', '5f4dcc3b5aa765d61d8327deb882cf99', 'SYSTEM ADMIN NAME', 1000000001,'000', 'DMSYS', 'SSACT', 'ADMIN');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, department, status, group_id) 
     VALUES ('sales1', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES STAFF 1 NAME', 1000000001,'000', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('sales2', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES STAFF 2 NAME', 1000000001,'stevenoh@mct.com.my', '0146183348', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('sales3', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES STAFF 3 NAME', 1000000001,'daren@mct.com.my', '0167229771', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('salesadm1', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES ADMIN 1 NAME', 1000000001,'ykwan@mct.com.my', '0165540606', 'DMSMA', 'SSACT', 'SALES_ADM');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('salesadm2', '5f4dcc3b5aa765d61d8327deb882cf99', 'SALES ADMIN 2 NAME', 1000000001,'steven@mct.com.my', '0129313853', 'DMSMA', 'SSACT', 'SALES_ADM');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('picadm1', '5f4dcc3b5aa765d61d8327deb882cf99', 'PIC ADMIN 1 NAME)', 1000000001,'jess@mct.com.my', '0137027593', 'DMSMA', 'SSACT', 'PIC_ADM');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('picadm2', '5f4dcc3b5aa765d61d8327deb882cf99', 'PIC ADMIN 2 NAME', 1000000001,'slchua@mct.com.my', '0193112190', 'DMSMA', 'SSACT', 'PIC_ADM');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('acct1', '5f4dcc3b5aa765d61d8327deb882cf99', 'ACCOUNT STAFF 1 NAME', 1000000001,'slchua@mct.com.my', '0193112190', 'DMSMA', 'SSACT', 'PIC_ADM');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('cust1', '5f4dcc3b5aa765d61d8327deb882cf99', 'CUSTOMER SERVICE STAFF 1 NAME', 1000000001,'slchua@mct.com.my', '0193112190', 'DMSMA', 'SSACT', 'PIC_ADM');

-- Create General Code Initial Data

INSERT INTO vipro.code_header (code_header_id, name) VALUES ( 'CY', 'CASE TYPE / CATEGORY');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYPAY', 'PAY BOOKING FEE', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYCAN', 'SALES CANCELLATION', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYCOM', 'SALES COMMISSION CLAIM', 'SSACT');

-- Action Taken
INSERT INTO vipro.code_header VALUES ('AC', 'ACTION TAKEN');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKREA', 'REASSIGNED' , 'SSACT');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKEML', 'EMAILED', 'SSACT');

-- Case Management (My Work Queue)
INSERT INTO code_header VALUES ('CS', 'CASE STATUS');
INSERT INTO code_det VALUES ( 'CS', 'CSNEW', 'NEW CASE' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSOPN', 'OPENED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSCLS', 'CLOSED CASE' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSCOM', 'COMPLETED' , 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status) VALUES ('CS', 'CSSMT', 'CASE SUBMITTED', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status) VALUES ('CS', 'CSCAN', 'CANCELLED', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status) VALUES ('CS', 'CSAPP', 'APPROVED', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status) VALUES ('CS', 'CSREJ', 'REJECTED', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status) VALUES ('CS', 'CSVER', 'VERIFIED', 'SSACT');
INSERT INTO vipro.code_det (code_header_id, code, description, status) VALUES ('CS', 'CSCIP', 'CANCELLING', 'SSACT');

-- Purchaser Title
INSERT INTO vipro.code_header VALUES ('TT', 'PURCHASER TITLE');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMST', 'MR.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMIS', 'MS.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDAT', 'DATO', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTTSR', 'TAN SRI', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDOT', 'DR.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMDM', 'MADAM', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTENC', 'EN.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTCIK', 'CIK', 'SSACT');

-- State
INSERT INTO vipro.code_header VALUES ('ST', 'STATES OF MALAYSIA');
INSERT INTO vipro.code_det VALUES('ST', 'STSEL', 'SELANGOR', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKUL', 'W.P.', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STJOH', 'JOHOR', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STMEL', 'MELAKE', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSEM', 'NEGERI SEMBILAN', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPAH', 'PAHANG', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPER', 'PERAK', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STTER', 'TERENGGANU', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKEL', 'KELANTAN', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPEN', 'PENANG', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPEL', 'PERLIS', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKED', 'KEDAH', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSAR', 'SARAWAK', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSAB', 'SABAH', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STLAB', 'LABUAN', 'SSACT');

-- Country
INSERT INTO vipro.code_header VALUES ('CT', 'COUNTRY');
INSERT INTO vipro.code_det VALUES ('CT', 'CTMAS', 'MALAYSIA', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTIND', 'INDONESIA', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTSIN', 'SINGAPORE', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTOTH', 'OTHER', 'SSACT');

-- Customer Category
INSERT INTO vipro.code_header VALUES ('CC', 'PURCHASER CATEGORY/TYPE');
INSERT INTO vipro.code_det VALUES ('CC', 'CCIND', 'INDIVIDUAL', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CC', 'CCCOM', 'COMPANY', 'SSACT');

-- Special Handling
INSERT INTO vipro.code_header VALUES ('SH', 'SPECIAL HANDLING');
INSERT INTO vipro.code_det VALUES ('SH', 'SHLND', 'LAND OWNER', 'SSACT');
INSERT INTO vipro.code_det VALUES ('SH', 'SHSTF', 'STAFF', 'SSACT');
INSERT INTO vipro.code_det VALUES ('SH', 'SHVIP', 'VIP', 'SSACT');

-- Type of Property 
INSERT INTO vipro.code_header VALUES ('PT', 'PROPERTY TYPE');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTCON', 'CONDOMINIUM', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTBGL', 'BUNGALOW', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSEM', 'SEMI-DETACHED', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSOF', 'SOFO', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSAP', 'SERVICE APARTMENT', 'SSACT');

-- Type of Property Title
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('PE', 'PROPERTY TITLE TYPE');
INSERT INTO vipro.code_det VALUES ('PE', 'PESTR', 'STRATA TITLE', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PE', 'PEIND', 'INDIVIDUAL TITLE', 'SSACT');

-- Customer Sex
INSERT INTO code_header VALUES ('SX', 'SEX OF THE PURCHASER');
INSERT INTO code_det VALUES ('SX', 'SXMAL', 'MALE', 'SSACT');
INSERT INTO code_det VALUES ('SX', 'SXFEM', 'FEMALE', 'SSACT');

-- Preferred Language
INSERT INTO code_header VALUES ('LG', 'PURCHASER PREFERRED LANGUAGE');
INSERT INTO code_det VALUES ('LG', 'LGCHI', 'CHINESE', 'SSACT');
INSERT INTO code_det VALUES ('LG', 'LGENG', 'ENGLISH', 'SSACT');
INSERT INTO code_det VALUES ('LG', 'LGMLY', 'MALAY', 'SSACT');

-- Marital Status of the purchaser
INSERT INTO code_header VALUES ('MS', 'PURCHASER MARITAL STATUS');
INSERT INTO code_det VALUES ('MS', 'MSMAR', 'MARRIED', 'SSACT');
INSERT INTO code_det VALUES ('MS', 'MSSIN', 'SINGLE', 'SSACT');
INSERT INTO code_det VALUES ('MS', 'MSOTH', 'OTHER', 'SSACT');

-- Bumi or Non Bumi
INSERT INTO code_header VALUES ('BM', 'BUMI OR NON-BUMI INDICATOR');
INSERT INTO code_det VALUES ('BM', 'BMNON', 'NON-BUMI', 'SSACT');
INSERT INTO code_det VALUES ('BM', 'BMBUM', 'BUMI', 'SSACT');

-- Race of the purchaser
INSERT INTO code_header VALUES ('RC', 'RACE OF THE PURCHASER');
INSERT INTO code_det VALUES ('RC', 'RCCHI', 'CHINESE', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCMLY', 'MALAY', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCIND', 'INDIAN', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCOTH', 'OTHER', 'SSACT');

-- The Purchaser Type of ID
INSERT INTO code_header VALUES ('ID', 'ID TYPE');
INSERT INTO code_det VALUES ('ID', 'IDNIC', 'IDENTITY CARD', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDPAS', 'PASSPORT', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDBRE', 'BUSINESS REGISTRATION', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDOTH', 'OTHER', 'SSACT');

-- Payment Method
INSERT INTO code_header VALUES ('PM', 'PAYMENT TYPE');
INSERT INTO code_det VALUES ('PM', 'PMCAS', 'CASH', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCRD', 'CREDIT CARD', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCHQ', 'PERSONAL CHEQUE', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMDRF', 'BANK DRAFT', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCCQ', 'COMPANY CHEQUE', 'SSACT');

-- Name of Banks
INSERT INTO code_header VALUES ('BK', 'COMMONLY USED BANK NAME');
INSERT INTO code_det VALUES ('BK', 'BKMBB', 'MAYBANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKCIM', 'CIMB', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKPBB', 'PUPLIC BANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKRHB', 'RHB', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKHLB', 'HONG LEONG BANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKAFB', 'AFFIN BANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKABB', 'ALLIANCE BANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKAMB', 'AMBANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKHSB', 'HSBC', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKCTB', 'CITIBANK', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKSCB', 'STANDARD CHARTED BANK', 'SSACT');

-- Cancellation Reason
INSERT INTO code_header VALUES ('CR', 'CANCELLATION REASON');
INSERT INTO code_det VALUES ( 'CR', 'CRNPY', 'NON PAYMENT' , 'SSACT');
INSERT INTO code_det VALUES ( 'CR', 'CRBRJ', 'LOAN REJECTED BY BANK' , 'SSACT');

-- Record Status Definition
INSERT INTO code_header VALUES ('SS', 'COMMONLY USED CODE');
INSERT INTO code_det VALUES ( 'SS', 'SSACT', 'ACTIVE' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSDIS', 'DISABLED' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSCXA', 'CANCELLED' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSCLS', 'CLOSED' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSNEW', 'NEW' , 'SSACT');

-- Sales Commission Payout Status
INSERT INTO code_header VALUES ('CO', 'SALES COMMISSION STATUS');
INSERT INTO code_det VALUES ( 'CO', 'COSUB', 'SUBMITTED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COAPP', 'APPROVED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COREJ', 'REJECTED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COPAI', 'PAID' , 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('CO', 'COVER', 'VERIFIED', 'SSACT');

-- Sales Cancellation Status
INSERT INTO code_header VALUES ('CX', 'SALES CANCELLATION CODE');
INSERT INTO code_det VALUES ( 'CX', 'CXSUB', 'SUBMITTED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXAPP', 'APPROVED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXREJ', 'REJECTED' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXRFD', 'REFUNDED' , 'SSACT');

-- Property Status
INSERT INTO vipro.code_header VALUES ('PS', 'PROPERTY STATUS');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSSLD', 'SOLD', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSAVL', 'AVAILABLE', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSNAV', 'NOT AVAILABLE', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSPRG','IN PROGRESS','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSBOK','BOOKED','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSCAN','CANCELLING','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSRSV','RESERVED','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSCXA','CANCELLED','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSLCK','LOCKED','SSACT');

-- Transaction Status
INSERT INTO code_header (code_header_id, name) VALUES ('TS', 'TRANSACTION STATUS CODE');
INSERT INTO code_det VALUES ('TS', 'TSPEN', 'PENDING POSTING', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSCOM', 'COMPLETED', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSPOS', 'POSTED', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSREJ', 'REJECTED', 'SSACT');

-- Application Source
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('ME', 'MEDIA SOURCE');
INSERT INTO vipro.code_det VALUES ('ME', 'MEFRD', 'FRIEND', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MENEW', 'NEWSPAPER', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'METLV', 'TELEVISION', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MERAD', 'RADIO', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MEBRD', 'BILL BOARD', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MEOTH', 'OTHER', 'SSACT');

-- Reporting Group
INSERT INTO vipro.code_header VALUES ('RG', 'REPORT GROUP');
INSERT INTO vipro.code_det VALUES ('RG', 'RGVRS', 'V-RESIDENSI REPORT', 'SSACT');

-- Orientation
INSERT INTO vipro.code_header VALUES ('OR', 'PROPERTY ORIENTATION');
INSERT INTO vipro.code_det VALUES ('OR', 'OREND', 'END LOT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('OR', 'ORINT', 'INTERMEDIATE', 'SSACT');
INSERT INTO vipro.code_det VALUES ('OR', 'ORCOR', 'CORNER', 'SSACT');

-- Department (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('DM', 'DEPARTMENT IN THE COMPANY');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSMA', 'SALES & MARKETING', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSAD', 'SALES ADMIN', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMACT', 'ACCOUNT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMMGR', 'MANAGEMENT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSYS', 'SYSTEM SUPPORT', 'SSACT');

-- Purchase Type (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('PU', 'PURCHASE TYPE');
INSERT INTO vipro.code_det VALUES ('PU', 'PUBLN', 'BANK LOAN', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCLN', 'COMPANY LOAN', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCSH', 'CASH', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUGOV', 'GOVERNMENT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUPEN', 'PENDING OAN APPROVAL', 'SSACT');

-- Account Type (Bill 19/6)
INSERT INTO vipro.code_header VALUES ('AT', 'ACCOUNT TYPE');
INSERT INTO vipro.code_det VALUES ('AT', 'ATCOM', 'COMPANY', 'SSACT');
INSERT INTO vipro.code_det VALUES ('AT', 'ATIND', 'INDIVIDUAL / PERSONAL', 'SSACT');

-- Create the Available General Codes for adjustment type (adj_type of adj_header table)
INSERT INTO vipro.code_header (code_header_id, name) VALUES ( 'AD', 'Adjustment Type');
INSERT INTO vipro.code_det VALUES ('AD', 'ADAMT', 'Change By Fixed Amount', 'SSACT');
INSERT INTO vipro.code_det VALUES('AD', 'ADPER', 'Change By Percentage', 'SSACT');

-- Price Adjustment
INSERT INTO code_header VALUES ('PA', 'Price Adjustment');
INSERT INTO code_det VALUES ('PA', 'PASUB', 'Submitted', 'SSACT');
INSERT INTO code_det VALUES ('PA', 'PAAPP', 'Approved', 'SSACT');
INSERT INTO code_det VALUES ('PA', 'PAREJ', 'Rejected', 'SSACT');

-- Progressive Billing Status Code
INSERT INTO code_header VALUES ('PB', 'Progressive Billing Status');
INSERT INTO code_det VALUES ('PB', 'PBACT', 'Active', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCLS', 'Closed - Refunded', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCXN', 'Cancelled', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBREV', 'REVERSAL', 'SSACT'); 
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBPAI', 'FULL PAYMENT', 'SSACT'); 
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBPAR', 'PARTIAL PAYMENT', 'SSACT'); 

-- Insert new code Layout Type
INSERT INTO code_header VALUES ('LT', 'PROPERTY LAYOUT TYPE');
INSERT INTO code_det VALUES ('LT', 'LTSDE', 'SOFO - DELUXE', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTSST', 'SOFO - STANDARD', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSA', 'PREMIUM SUITE A', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSB', 'PREMIUM SUITE B', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSC', 'PREMIUM SUITE C', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'A1', 'A1', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'A2', 'A2', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'B', 'B', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'D', 'D', 'SSACT');

INSERT INTO code_header VALUES ('FC', 'PROPERTY FACING DIRECTION');
INSERT INTO code_det VALUES ('FC', 'FCSOE', 'SOUTH EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOW', 'NORTH WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOE', 'NORTH EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCSOW', 'SOUTH WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCSOU', 'SOUTH', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCEAS', 'EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCWES', 'WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOR', 'NORTH', 'SSACT');

-- Partner Type
INSERT INTO `vipro`.`code_header` (`code_header_id`, `name`) VALUES ('PR', 'PARTNER TYPE');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRBNK', 'BANK', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRDEV', 'DEVELOPER', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRLND', 'LAND OWNER', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRSOL', 'SOLICITOR', 'SSACT');

-- Project Status
INSERT INTO code_header VALUES ('PJ', 'THE STATUS OF THE PROJECT');
INSERT INTO code_det VALUES ('PJ', 'PJACT', 'ACTIVE', 'SSACT');
INSERT INTO code_det VALUES ('PJ', 'PJCOM', 'COMPLETED', 'SSACT');
INSERT INTO code_det VALUES ('PJ', 'PJCAN', 'CANCELLED', 'SSACT');

-- Booking fee usage
INSERT INTO code_header VALUES ('BU', 'USAGES OF BOOKING FEE');
INSERT INTO code_det VALUES ('BU', 'BUMAI', 'PAY MAINTENANCE FEE', 'SSACT');
INSERT INTO code_det VALUES ('BU', 'BURFD', 'REFUND CASH ON FINAL PAYMENT', 'SSACT');

-- 290613 Max  
INSERT INTO `vipro`.`code_header` (`code_header_id`, `name`) VALUES ('CI', 'CITY');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('CI', 'CIKUL', 'KUALA LUMPUR', 'SSACT');

-- Transaction Code Loading
INSERT INTO vipro.transaction_code VALUES ('100001', 'BOOKING FEE', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('100002', 'PAYMENT 1 - THANK YOU', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('100003', 'PAYMENT 2 - THANK YOU', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('110001', 'COMMISSION FEE REVERSAL', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('120001', 'PROGRESSIVE BILLING 1 REVERSAL', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('120002', 'PROGRESSIVE BILLING 2 REVERSAL', 'CR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('200001', 'BOOKING FEE REVERSAL', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('200002', 'PAYMENT REVERSAL 1', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('200003', 'PAYMENT REVERSAL 2', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('210001', 'COMMISSION FEE', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('220001', 'PROGRESSIVE BILLING 1', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('220002', 'PROGRESSIVE BILLING 2', 'DR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('300001', 'CANCELLATION FEE REVERSAL - BOOKING', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('300002', 'CANCELLATION FEE REVERSAL - PURCHASER', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('300003', 'CANCELLATION FEE REVERSAL - BANK', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('310001', 'CANCELLATION TAX REVERSAL', 'CR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('400001', 'CANCELLATION FEE - BOOKING', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400002', 'CANCELLATION FEE - PURCHASER', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400003', 'CANCELLATION FEE - BANK', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400004', 'CANCELLATION TAX', 'DR', null, 'SSACT');

INSERT INTO `vipro`.`transaction_code` (`transaction_code`, `name`, `code_type`, `accounting_group`, `status`) 
	VALUES ('500001', 'PROGRESSIVE BILLING', 'DR', NULL, 'SSACT'); 
INSERT INTO `vipro`.`transaction_code` (`transaction_code`, `name`, `code_type`, `accounting_group`, `status`) 
	VALUES ('510001', 'PROGRESSIVE BILLING - REVERSAL', 'CR', NULL, 'SSACT'); 
insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
	values (  '500002',  'RENOTICE BILLING',  'DR',  NULL,  'SSACT' );
insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
	values (  '110002',  'PAYMENT REVERSAL',  'DR',  NULL,  'SSACT' ); 

-- Business Partner Parameters
INSERT INTO business_partner (partner_id, institution_id) VALUES (0, 1000000001);
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRDEV', 'BGGREEN','B&G GREENERY PROPERTY SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRLND', 'MULTIBINA','MULTI BINA SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRSOL', 'LOW&LEE', 'LOW & LEE', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'RHBBANK', 'RHB BANK BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'AFFIN', 'AFFIN BANK BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'CIMBBANK', 'CIMB CREDIT PROCESSING', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'AMBANK', 'AMBANK MORTGAGE', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'UOBBANK', 'UOB BANK BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'PUBLIC', 'PUBLIC BANK BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRBNK', 'MBSB', 'MBSB HOUSING LOAN', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRDEV', 'BGSUP', 'B & G SUPERB PROPERTY SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRLND', 'BGSUR2', 'B & G SUPERB PROPERTY SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRDEV', 'DP1', 'DPRISTINE MEDINI SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_code, company_name, status) VALUES (1000000001, 'PRLND', 'FP2', 'DPRISTINE MEDINI SDN BHD', 'SSACT');
          
-- Load Project Record
INSERT INTO vipro.project (project_id, project_name, project_code, property_type, report_group, address1, project_office_tel_no, project_office_fax_no, pic_id, person_in_charge, pic_mobile_no, city, state, country, staff_booking_fee, public_booking_fee, launch_date, institution_id, 
			status, postcode, discount_rate, sales_commission, developer_id, land_proprietor_id, due_days, billing_model_code, days_to_bill, include_off_day)
     VALUES (1, 'V-RESIDENSI @ SELAYANG HEIGHTS', 'VRSH', 'PTCON', 'RGVRS', '7th FL, ONECITY,', '0380239988', '0380249185', 1, 'salespic1', '0192326080', 'SUBANG JAYA', 'STSEL', 'CTMAS', 500.00, 5000.00, 20130601, 1000000001, 
     		'PJACT', '47630', 10.00, 800.00, 2, 3, 14, 'A', 3, 'N');
INSERT INTO vipro.project (project_id, project_name, project_code, property_type, report_group, address1, project_office_tel_no, project_office_fax_no, pic_id, person_in_charge, pic_mobile_no, city, state, country, staff_booking_fee, public_booking_fee, launch_date, institution_id, 
			status, postcode, discount_rate, sales_commission, developer_id, land_proprietor_id, due_days, billing_model_code, days_to_bill, include_off_day)
     VALUES (2, 'V-RESIDENSI 2 @ SHAH ALAM', 'VRSA', 'PTSAP', 'RGVRS', '7th FL, ONECITY,', '0380239999', '0380249185', 2, 'salespic2', '0192326080', 'SUBANG JAYA', 'STSEL', 'CTMAS', 500.00, 5000.00, 20130801, 1000000001, 
     		'PJACT', '47630', 7.00, 800.00, 2, 3, 14, 'A', 4, 'N');
INSERT INTO vipro.project (project_id, project_name, project_code, property_type, report_group, address1, project_office_tel_no, project_office_fax_no, pic_id, person_in_charge, pic_mobile_no, city, state, country, staff_booking_fee, public_booking_fee, launch_date, institution_id, 
			status, postcode, discount_rate, sales_commission, developer_id, land_proprietor_id, due_days, billing_model_code, days_to_bill, include_off_day)
     VALUES (3, 'DPRISTINE', 'DPMJ', 'PTSOF', 'RGVRS', '7th FL, ONECITY,', '0380239966', '0380249199', 1, 'salespic1', '0192326080', 'SUBANG JAYA', 'STSEL', 'CTMAS', 500.00, 5000.00, 20140101, 1000000001, 
     		'PJACT', '47630', 0.00, 800.00, 2, 3, 14, 'DPMJ', 5, 'Y');

INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNPRG', 0, 'VRSH');
INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNRNB', 0, 'VRSH');
INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNPRG', 0, 'VRSA');
INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNRNB', 0, 'VRSA');
INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNPRG', 0, 'DPMJ');
INSERT INTO vipro.seq_no (seq_type, next_seq, project_code) VALUES ('SNRNB', 0, 'DPMJ');

-- Case Management\Qorkflow Related Data
INSERT INTO vipro.case_route (case_type, case_status, target_group_id, next_action) VALUES ('CYCOM', 'CSVER', 'PIC_ADM', 'CSAPP');
INSERT INTO vipro.case_route (case_type, case_status, target_group_id, next_action) VALUES ('CYCOM', 'CSAPP', 'ACCT', 'CSPRO');
INSERT INTO vipro.case_route (case_type, case_status) VALUES ('CYCOM', 'CSREJ');
INSERT INTO case_route (case_type, case_status, target_group_id, next_action) values ('CYPAY', 'CSSMT', 'ACCT', 'CSPRO');
INSERT INTO case_route (case_type, case_status, target_group_id, next_action) values ('CYCAN', 'CSAPP', 'ACCT', 'CSPRO');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSAPP');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSCIP');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionVerification.xhtml', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionVerification.xhtml', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionApproval.xhtml', 'CSVER');

-- Modale DPMJ Create Billing Model Parameter Data
INSERT INTO vipro.billing_model_header (billing_model_code,description,status) VALUES ("DPMJ", "DPRISTINE PROJECT", "SSACT");

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 1, '1', 'Upon signing of Sale & Purchase Agreement.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 2, '2(a)', 'Earthworks.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 3, '2(b)', 'Piling works.', 15.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 4, '2(c)(i)', 'Reinforced concrete slab - Ground Floor.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 5, '2(c)(ii)', 'Reinforced concrete slab - First & Second Floor.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 6, '2(c)(iii)', 'Reinforced concrete slab - Third & Fourth Floor.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 7, '2(c)(iv)', 'Reinforced concrete slab - Fifth & Sixth Floor.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 8, '2(c)(v)', 'Reinforced concrete slab - Seventh & Eighth Floor.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 9, '2(d)', 'Reinforced concrete framework of the Parcel.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 10, '2(e)', 'Walls with door & window frames.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 11, '2(f)', 'Electrical wiring & plumbing.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 12, '2(g)', 'Internal plastering.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 13, '2(h)', 'External plastering.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 14, '2(i)', 'Drains & sewerage works', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 15, '2(j)', 'Road works.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 16, '3', 'Vacant Possession.', 5.00, null, null, 'SSACT');

-- Modale A Create Billing Model Parameter Data
INSERT INTO vipro.billing_model_header (billing_model_code,description,status) VALUES ("A", "V-RESIDENSI PROJECTS", "SSACT");

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 1, '1', 'Upon Signing of Sales & Purchase Agreement.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 2, '2(a)', 'Work below ground level.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 3, '2(b)', 'Structural framework.', 15.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 4, '2(c)', 'Walls with door and window frames.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 5, '2(d)', 'Roofing, electrical wiring, plumbing, internal telephone trunking & cabling works.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 6, '2(e)', 'Internal & external plastering.', 10.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 7, '2(f)', 'Sewerage works.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 8, '2(g)', 'Drains.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 9, '2(h)', 'Roads.', 5.00, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 10, '3', 'Vacant possession.', 12.50, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 11, '4', 'Application for subdivision of the Building/Land.', 2.50, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 12, '5(a)', 'Stakeholder sum.', 2.50, null, null, 'SSACT');
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description, billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 13, '5(b)', 'Stakeholder sum.', 2.50, null, null, 'SSACT');

--  Bank information for payment to be printed at billing letter
INSERT INTO vipro.bank_account 
			(project_id, bill_to, top_text, bottom_text,holder_name, holder_address_id,
			bank1_name, bank1_account_no, bank1_swift_code, bank1_branch_address,
			bank2_name, bank2_account_no, bank2_swift_code, bank2_branch_address, status)
	VALUES (3, "P","For Telegraphic Transfer (TT):-", "Please email your transaction slip to alvin@mct.com.my & mei@mct.com.my", "D Pristine Medini Sdn Bhd", 123,
			"Affin Bank Berhad", "10063-0017-910", "PHBMMYKL", "Subang Jaya, Malaysia",
			"United Overseas Bank (Malaysia) Bhd", "165-301-4843", "UOVBMYKL", "Subang Jaya, Malaysia", "SSACT");
INSERT INTO vipro.bank_account 
			(project_id, bill_to, top_text, bottom_text,holder_name, holder_address_id,
			bank1_name, bank1_account_no, bank1_swift_code, bank1_branch_address, status)
	VALUES (3, "F","Developer Account Particulars:-", "Please email your transaction slip to alvin@mct.com.my & mei@mct.com.my", "D Pristine Medini Sdn Bhd", 123,
			"Affin Bank Berhad", "10063-0017-910", "PHBMMYKL", "Subang Jaya, Malaysia", "SSACT");

-- load test purchaser info
-- >> 1
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (1, 1000000001, 'TTENC', 'AMIN BIN AHMAD', 'CCIND', 
			'IDNIC', '660614-08-6165', 1, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0132788004', '0322031219', '', 'MSOTH', 'amenmy@yahoo.com', 19660614,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (1, 'Malaysian Japan International', 'LORONG MOHD ALI,', 'Jalan Semarak,', '',
			'54100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 1);

-- >> 2
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (2, 1000000001, 'TTMST', 'ARAVI A/L NACHIMAN', 'CCIND', 
			'IDNIC', '870623-08-5637', 2, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'0166449694', '', '', 'MSOTH', 'ara_vin87@yahoo.com', 19870623,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (2, 'No 5, Jalan 15/3,', 'Taman Sri Sinar Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 2);

-- >> 3
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (3, 1000000001, 'TTMST', 'BONG KAM KAM', 'CCIND', 
			'IDNIC', '760422-13-6031', 3, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126180010', '', '', 'MSOTH', 'jakboon@gmail.com', 19760422,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (3, 'No. 99, Jalan Lang Peroi Putih,', 'Kepong Baru,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 3);

-- >> 4
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (4, 1000000001, 'TTMIS', 'CAM CAM MO', 'CCIND', 
			'IDNIC', '870731-56-5208', 4, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0176365110', '', '', 'MSOTH', 'cherriecham87@gmail.com', 19870731,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (4, 'No. 10, Jalan 9,', 'Taman Kepong Indah,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 4);

-- >> 5
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (5, 1000000001, 'TTMST', 'ZAN BENG HAM', 'CCIND', 
			'IDNIC', '810206-14-5139', 5, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810206,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (5, 'A2, Enggang Apartment,', 'Taman Bukit Idaman,', 'Jalan Bukit Idaman,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 5);

-- >> 6
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (6, 1000000001, 'TTMIS', 'CHNG LAY SENG', 'CCIND', 
			'IDNIC', '740616-06-5528', 6, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0126895376', '', '', 'MSOTH', 'wendy_cls@yahoo.com', 19740616,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (6, 'No 88, Jalan 2,', 'Bandar Baru Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 6);

-- >> 7
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (7, 1000000001, 'TTMIS', 'CHANG KU FA', 'CCIND', 
			'IDNIC', '771115-06-5310', 7, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19771115,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (7, 'No 888, Jalan BPPB 5,', 'Bandar Putra Permai,', '', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 3, 7);

-- >> 8
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (8, 1000000001, 'TTMST', 'CHANG YE CONG', 'CCIND', 
			'IDNIC', '870818-14-6049', 8, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870818,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (8, 'No 7788 Block Z,', 'Seksyen 2,', 'Bandar Baru Wangsa Maju,', 'Setapak,',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 8);

-- >> 9
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (9, 1000000001, 'TTMIS', 'CHIN HAI CHANG', 'CCIND', 
			'IDNIC', '821227-14-5422', 9, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19821227,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (9, '153, Menara Duta Condo,', 'Jalan Duta Mas Raya,', 'Segambut,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 9);

-- >> 10
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (10, 1000000001, 'TTMST', 'KAM KING KING', 'CCIND', 
			'IDNIC', '871214-12-5229', 10, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0149295724', '', '', 'MSOTH', 'chauss87@gmail.com', 19871224,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (10, '188, Jalan 18/18,', 'Taman Sri Sinar,', 'Segambut,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 10);

-- >> 11
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (11, 1000000001, 'TTENC', 'CHE MUTHIR BIN CHE WAWA', 'CCIND', 
			'IDNIC', '770404-11-5947', 11, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19770104,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (11, 'No 8899, Jalan 88,', 'Selayang Baru,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 11);

-- >> 12
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (12, 1000000001, 'TTMST', 'CHEAH HON KAM', 'CCIND', 
			'IDNIC', '850228-14-5497', 12, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123652282', '', '', 'MSOTH', 'uzura85@gmail.com', 19850224,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (12, 'No. 81, Jalan 81,', 'Taman Wilayah Selayang,', '', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 12);

-- >> 13
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (13, 1000000001, 'TTMIS', 'CHENG PIK TUN', 'CCIND', 
			'IDNIC', '780212-08-5700', 13, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19781111,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (13, 'DD-88-88, Paradesa Tropica,', 'Bandar Sri Damansara,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 13);

-- >> 14
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (14, 1000000001, 'TTMST', 'CHEE FAT CHOI', 'CCIND', 
			'IDNIC', '880818-58-6619', 14, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'01223288975', '', '', 'MSOTH', '', 19860610,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (14, 'No. 8, Jalan Teluki 88,', 'Seksyen 8 Bukit Sentosa,', '', '',
			'48300', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 3, 14);

-- >> 15
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (15, 1000000001, 'TTMIS', 'TZE LEE', 'CCIND', 
			'IDNIC', '790818-14-5654', 15, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19750518,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (15, 'No 898, Jalan Wangsa 8/8,', 'Taman Wangsa Permai,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 15);

-- >> 16
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (16, 1000000001, 'TTMST', 'CHING CHAI', 'CCIND', 
			'IDNIC', '830323-14-6359', 16, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192746354', '', '', 'MSOTH', '', 19830825,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (16, 'No. 33, Jalan 3/3,', 'Bukit Rahman Putra 3,', '', '',
			'47000', 'Sungai Buloh,', 'STSEL', 'CTMAS', 20130625, 3, 16);

-- >> 17
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (17, 1000000001, 'TTMIS', 'CHIN SIOU MIN', 'CCIND', 
			'IDNIC', '650920-10-6402', 17, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0163022288', '0362509335', '', 'MSOTH', 'cycnetworking@hotmail.com', 19650619,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (17, 'No 818, Jalan 18/18A,', 'Taman Mastiara Batu 8,', 'Jalan Ipoh,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 17);

-- >> 18
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (18, 1000000001, 'TTMST', 'THAM SURE WIN', 'CCIND', 
			'IDNIC', '7112-18-06-5067', 18, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193375226', '', '', 'MSOTH', 'erichonlt@yahoo.com.my', 19711013,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (18, '1 Jelutong Apartment,', 'Jalan SH 1,', 'Selayang Heights,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 18);

-- >> 19
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (19, 1000000001, 'TTMST', 'CHUNG BOO BOO', 'CCIND', 
			'IDNIC', '690831-02-5231', 19, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19711013,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (19, 'No 8, Jalan 8/8A,', 'Taman Kaya,', 'Off Jalan Ipoh,', '',
			'51100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 19);

-- >> 20
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (20, 1000000001, 'TTMST', 'KAM KA YA', 'CCIND', 
			'IDNIC', '780828-08-5383', 20, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126668960', '0361207360', '', 'MSOTH', 'c_yen_87@hotmail.com', 19730628,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (20, 'Block 88,', 'Jalan 8/8,', 'Taman Kepong Indah,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 20);

-- >> 21
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (21, 1000000001, 'TTMST', 'CHING MIN TONG', 'CCIND', 
			'IDNIC', '781118-14-5677', 21, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'016255539', '', '', 'MSOTH', '', 19791115,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (21, 'A08, Aman Puri Apartment,', 'Jalan Aman Desa UTE,', 'Aman Puri Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 21);

-- >> 22
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (22, 1000000001, 'TTMST', 'HOONG FAT FOOK', 'CCIND', 
			'IDNIC', '880808-108-8881', 22, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122679693', '', '', 'MSOTH', '', 19750703,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (22, 'No. 8888, Jalan Ulu Klang,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 22);

-- >> 23
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (23, 1000000001, 'TTMST', 'WEI NA ME', 'CCIND', 
			'IDNIC', '750818-14-5445', 23, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0102209966', '', '', 'MSOTH', '', 19750316,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (23, 'No 88, Jalan Residen 8,', 'Laman Residen,', 'Sri Utara off Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 23);

-- >> 24
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (24, 1000000001, 'TTMST', 'CNUNG NUG NUNG', 'CCIND', 
			'IDNIC', '641228-08-5323', 24, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122303050', '', '', 'MSOTH', '', 19641225,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (24, '40, Jalan 88/88,', 'Taman Sea Water,', '', '',
			'47400', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 3, 24);

-- >> 25
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (25, 1000000001, 'TTMST', 'YOON HEE HEE', 'CCIND', 
			'IDNIC', '760828-14-5205', 25, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760429,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (25, 'A-888, Jalan T.F.R.I,', 'Kepong Hulu,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 25);

-- >> 26
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (26, 1000000001, 'TTMST', 'CHOO YONG LIANG', 'CCIND', 
			'IDNIC', '781228-14-5131', 26, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123787999', '', '', 'MSOTH', '', 19741228,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (26, '88, Jalan Metro Perdana Barat 88,', 'Taman Usahawan Kepong,', 'Kepong Utara,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 26);

-- >> 27
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (27, 1000000001, 'TTMST', 'LOH LEE LEI', 'CCIND', 
			'IDNIC', '780808-08-8883', 27, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0129733682', '', '', 'MSOTH', '', 19790808,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (27, 'No.8, Jalan Wangsa Budi 8,', 'Wangsa Melawati,', '', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 27);

-- >> 28
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (28, 1000000001, 'TTMST', 'JIN TAI RU', 'CCIND', 
			'IDNIC', '881228-01-6121', 28, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831229,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (28, 'No 99, Jalan Ampang Jaya 99,', 'Taman Ampang Jaya,', '', '',
			'83000', 'Batu Pahat,', 'STJOH', 'CTMAS', 20130625, 3, 28);	

-- >> 29
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (29, 1000000001, 'TTMST', 'RAYMOND TOY', 'CCIND', 
			'IDNIC', '880828-08-5113', 29, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0165369059', '', '', 'MSOTH', 'cht9963@gmail.com', 19880820,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (29, 'No 898, Persiaran Buntong Jaya 8,', 'Taman Buntong Jaya Baru,', '', '',
			'30100', 'Ipoh,', 'STPER', 'CTMAS', 20130625, 3, 29);
	
-- >> 30
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (30, 1000000001, 'TTMST', 'CHOY NI TU SOI', 'CCIND', 
			'IDNIC', '780316-15-6327', 30, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122693399', '', '', 'MSOTH', 'ericchoy2003@hotmail.com', 19780313,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (30, 'No. 866 Jalan 6/6,', 'Bandar Baru Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 30);

-- >> 31
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (31, 1000000001, 'TTMST', 'CHAT YA HOO', 'CCIND', 
			'IDNIC', '880408-14-5613', 31, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163029833', '', '', 'MSOTH', '', 19820409,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (31, '87, Jalan 89/18A,', 'Taman Mastiara Batu 89,', 'Jalan Ipoh,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 31);

-- >> 32
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (32, 1000000001, 'TTMST', 'DARYSHI A/P MUNIAM', 'CCIND', 
			'IDNIC', '881208-18-6684', 32, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122238620', '', '', 'MSOTH', 'shinijk89@gmail.com', 19891202,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (32, '88B, Jalan Padang Belia 88,', 'Off Jalan Tun Sambanthan 8,', 'Brickfields,', '',
			'50470', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 32);

-- >> 33
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (33, 1000000001, 'TTMST', 'ECHO A/L SUMO', 'CCIND', 
			'IDNIC', '860818-23-8273', 33, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0167271743', '', '', 'MSOTH', 'elango86.2u@yahoo.com.my', 19860315,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (33, 'No. 88, Jalan Gangsa 8,', 'Taman Seri Puteri,', '', '',
			'81300', 'Skudai,', 'STJOH', 'CTMAS', 20130625, 3, 33);
			
-- >> 34
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (34, 1000000001, 'TTMST', 'KAU BOI BOI', 'CCIND', 
			'IDNIC', '781228-02-5167', 34, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192753760', '', '', 'MSOTH', '', 19721222,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (34, 'No. 8888, Jalan PSI 8/8,', 'Taman Prima Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 34);	
	
-- >> 35
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (35, 1000000001, 'TTMST', 'GOH CHUN TAT', 'CCIND', 
			'IDNIC', '881018-08-6251', 35, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851030,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (35, 'No 66, Jalan 66 Bidara,', 'Kepong Baru,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 35);	
	
-- >> 36
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (36, 1000000001, 'TTMST', 'GOH MUN MUN', 'CCIND', 
			'IDNIC', '881218-08-5419', 36, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162329405', '', '', 'MSOTH', 'goh_wk@hotmail.com', 19881214,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (36, 'No 88, Jalan 88/88,', 'Taman Petaling Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 36);	
			
-- >> 37
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (37, 1000000001, 'TTMST', 'ALAN THAM WEN LUM', 'CCIND', 
			'IDNIC', '771117-15-5985', 37, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841117,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (37, 'No. 18 Jalan Amansiara 181/18,', 'Taman Amansiara,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 3, 37);	

-- >> 38
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (38, 1000000001, 'TTMST', 'ANG MO LAN', 'CCIND', 
			'IDNIC', '830808-08-5455', 38, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19830107,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (38, 'Wisma Prima, 88, 8th Floor,', 'Jalan Sri Semantan 8,', 'Damansara Heights,', '',
			'50490', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 38);	

-- >> 39
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (39, 1000000001, 'TTENC', 'AMAM BIRU BIN ABU HITAM', 'CCIND', 
			'IDNIC', '660606-16-5509', 39, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0198847080', '085452359', '', 'MSOTH', 'awang.draup@gmail.com', 19551205,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (39, '66, Prima Villa 6,', 'Permijaya,', 'Damansara Heights,', '',
			'98100', 'Miri', 'STSAR', 'CTMAS', 20130625, 3, 39);	

-- >> 40
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (40, 1000000001, 'TTMST', 'BOH LI HAI', 'CCIND', 
			'IDNIC', '650228-10-7531', 40, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19650128,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (40, '808, Jalan Daya 8/9,', 'Taman Daya Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 40);

-- >> 41
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (41, 1000000001, 'TTMST', 'KEAT MIN LUM', 'CCIND', 
			'IDNIC', '880828-10-5119', 41, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850127,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (41, 'C8 Permata Fadason Park 8/18,', 'Off Jalan Kepong,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 41);

-- >> 42
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (42, 1000000001, 'TTMST', 'CHAN HOU REN', 'CCIND', 
			'IDNIC', '880828-14-5179', 42, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19900926,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (42, 'C4 Permata Fadason Park 8/8,', 'Off Jalan Kepong,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 42);

-- >> 43
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (43, 1000000001, 'TTMST', 'MIN TAK TAK', 'CCIND', 
			'IDNIC', '690315-08-6211', 43, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19690210,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (43, 'Lot 8888, Jalan 8/88,', '8 1/2 Miles, Kepong Industrial Area,', 'Jalan Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 43);

-- >> 44
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (44, 1000000001, 'TTMST', 'CHE HUN JOO', 'CCIND', 
			'IDNIC', '880808-58-5899', 44, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870803,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (44, 'Lot 88, Jalan 8/1,', 'Taman Ehsan,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 44);

-- >> 45
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (45, 1000000001, 'TTMIS', 'CHEE MEE MEE', 'CCIND', 
			'IDNIC', '772020-14-5340', 45, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19721110,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (45, '18-88-888, Prima Tiara 8,', 'No 8, Jalan 8/88A,', 'Taman Sri Sinar,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 45);

-- >> 46
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (46, 1000000001, 'TTMST', 'TAN TUN YUN', 'CCIND', 
			'IDNIC', '780808-14-5029', 46, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19730908,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (46, 'No. 8, Jalan Sengaring 8,', 'Taman Tenaga,', '', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 46);

-- >> 47
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (47, 1000000001, 'TTMIS', 'ZHIN WEE', 'CCIND', 
			'IDNIC', '861008-56-5680', 47, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0162101128', '', '', 'MSOTH', '', 19861107,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (47, '88, Jalan Nikmat 88,', 'Taman Bukit Aman,', '', '',
			'58200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 47);

-- >> 48
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (48, 1000000001, 'TTMIS', 'YEE RU RU', 'CCIND', 
			'IDNIC', '880208-14-5768', 48, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0163859142', '', '', 'MSOTH', '', 19850206,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (48, '1188, Jalan Nikmat 8,', 'Taman Bukit Aman,', '', '',
			'58200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 48);

-- >> 49
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (49, 1000000001, 'TTMIS', 'KAI HOU SI', 'CCIND', 
			'IDNIC', '880118-08-5834', 49, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820114,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (49, 'No 1881,', 'Taman Desa Minang 88,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 49);

-- >> 50
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (50, 1000000001, 'TTMIS', 'KIM BON BEE', 'CCIND', 
			'IDNIC', '800508-08-5818', 50, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0126737611', '', '', 'MSOTH', 'hbc3580@hotmail.com', 19800503,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (50, '88, Desa Damai 8,', 'Alam Damai 8,', 'Cheras,', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 50);


-- >> 51
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (51, 1000000001, 'TTMST', 'MENG KIT KAM', 'CCIND', 
			'IDNIC', '781030-14-6175', 51, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19771230,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (51, '8-88-888, Genting Court Condo,', 'Taman Setapak Indah Jaya,', 'Off Jalan Genting Kelang,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 51);

-- >> 52
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (52, 1000000001, 'TTMST', 'WEN JIA BAU', 'CCIND', 
			'IDNIC', '850818-06-5483', 52, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850301,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (52, 'B8, Drimba Apartment,', 'Jalan Kenyalang 18/18,', '', '',
			'47810', 'Kota Damansara,', 'STSEL', 'CTMAS', 20130625, 3, 52);

-- >> 53
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (53, 1000000001, 'TTMST', 'LIN DAN', 'CCIND', 
			'IDNIC', '841118-08-6103', 53, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841216,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (53, 'VV88, Jalan Wangsa VV88,', 'Vista Saujana,', 'Taman Wangsa Permai,', 'Kepong,',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 53);

-- >> 54
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (54, 1000000001, 'TTMST', 'LEE CHUN WEI', 'CCIND', 
			'IDNIC', '881212-10-5459', 54, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19681211,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (54, 'No 9999, West Street 8,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 54);
	
-- >> 55
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (55, 1000000001, 'TTMST', 'MA LONG', 'CCIND', 
			'IDNIC', '731218-18-5259', 55, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19731130,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (55, 'No 8888, West Street 9,', 'Jinjang Utara 8,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 55);

-- >> 56
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (56, 1000000001, 'TTMST', 'LONG TAI', 'CCIND', 
			'IDNIC', '700323-10-5259', 56, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19700722,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (56, 'B-18, Selayang Point 18,', 'Jalan SP 8,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 56);

-- >> 57
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (57, 1000000001, 'TTMIS', 'LIEW SHUI WEI', 'CCIND', 
			'IDNIC', '890508-08-6530', 57, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19890206,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (57, 'No. 88, Jalan SJL 8,', 'Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 57);

-- >> 58
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (58, 1000000001, 'TTMST', 'TAI JIANG', 'CCIND', 
			'IDNIC', '860828-43-6457', 58, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19860920,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (58, 'No. 88, Taman 8 City,', 'Jalan Kuching', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 58);	

-- >> 59
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (59, 1000000001, 'TTMIS', 'JEN JIAN MUM', 'CCIND', 
			'IDNIC', '880808-88-5204', 59, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19870406,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (59, '888, Kawasan 888,', 'Tepi 888', 'Lorong 888', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 3, 59);		

-- >> 60
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (60, 1000000001, 'TTMST', 'SOW SAU SING', 'CCIND', 
			'IDNIC', '690224-10-5357', 60, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19690422,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (60, '828, Jalan Indah 82/82,', 'Redi Ruby 82 Shop Apartment,', 'Taman University Indah,', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 3, 60);

-- >> 61
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (61, 1000000001, 'TTMST', 'JIA MAN', 'CCIND', 
			'IDNIC', '881018-07-5221', 61, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19881014,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (61, '888, Lorong 8,', 'Taman Jana Permai 8,', '', '',
			'34600', 'Kamunting,', 'STPER', 'CTMAS', 20130625, 3, 61);

-- >> 62
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (62, 1000000001, 'TTMST', 'NII YAU CHIEN', 'CCIND', 
			'IDNIC', '880818-58-5637', 62, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880811,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (62, 'No. 88, Jalan Flora Impian 8', 'Taman Flora Impian 8,', 'Segambut Tengah,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 62);

-- >> 63
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (63, 1000000001, 'TTMST', 'JUN TU TULY', 'CCIND', 
			'IDNIC', '880828-02-5263', 63, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880820,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (63, 'No. 88, Jalan 8/8,', 'Off Jalan Kepong,', 'Taman Fadason,', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 63);

-- >> 64
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (64, 1000000001, 'TTMIS', 'YONG TECK LEE', 'CCIND', 
			'IDNIC', '780818-08-5720', 64, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19780719,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (64, 'NO. 8, Selayang MesraI,', 'Jalan SJ 18A,', 'Taman Selayang Bahagia,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 64);

-- >> 65
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (65, 1000000001, 'TTMST', 'BOON CHEK KING', 'CCIND', 
			'IDNIC', '780818-14-5835', 65, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760713,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (65, '18 Block 18 Jalan 8/8,', 'Taman Setapak Indah Jaya,', 'Jalan Bukit Idaman 8,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 65);

-- >> 66
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (66, 1000000001, 'TTMST', 'SIU SING SING', 'CCIND', 
			'IDNIC', '881212-10-5201', 66, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851231,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (66, 'Block 88,', 'Jalan SHE 8/8,', 'Andari Townvilla 8', 'Selayang Height,',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 66);

-- >> 67
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (67, 1000000001, 'TTMIS', 'CHOO CHOO TRAIN', 'CCIND', 
			'IDNIC', '781128-05-5950', 67, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19761122,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (67, 'No. 8 Ground Floor,', 'Jalan 8/8A,', 'Bandar Menjalara,', 'Kepong,',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 67);

-- >> 68
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (68, 1000000001, 'TTMST', 'HONG MAI MAI', 'CCIND', 
			'IDNIC', '840521-10-5603', 68, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840629,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (68, 'A8 Villa Lagenda,', 'Jalan 88,	Taman Desa Bakti,', 'Bandar Baru Wangsa Maju,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 68);

-- >> 69
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (69, 1000000001, 'TTMIS', 'LIAU SU RON', 'CCIND', 
			'IDNIC', '850818-10-5106', 69, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0123325104', '', '', 'MSOTH', '', 19850613,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (69, 'No. 8, Jalan SS 22/88,', '', '', '',
			'47300', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 3, 69);

-- >> 70
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (70, 1000000001, 'TTMST', 'KWONG MIN TIM', 'CCIND', 
			'IDNIC', '681028-08-5461', 70, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19611022,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (70, '1998, Jalan Kampung Pisang,', 'TAMAN 1998', '', '',
			'11500', 'Air Itam,', 'STPEN', 'CTMAS', 20130625, 3, 70);

-- >> 71
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (71, 1000000001, 'TTMIS', 'TING TONG TONG', 'CCIND', 
			'IDNIC', '820828-18-5526', 71, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820922,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (71, 'No. 88 Jalan Melati 88,', 'Taman Sri Melati,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 71);

-- >> 72
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (72, 1000000001, 'TTDAT', 'ABDUL MOKTA BIN BAKAR', 'CCIND', 
			'IDNIC', '780808-10-6599', 72, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0192435082', '', '', 'MSOTH', '', 19580807,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (72, 'No. 99,	Jalan Taman Melati 99,', 'Setapak 9,', '', '',
			'53100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 72);

-- >> 73
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (73, 1000000001, 'TTDAT', 'AZMIN MOK BIN SEGI', 'CCIND', 
			'IDNIC', '660718-05-5437', 73, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0192435082', '', '', 'MSOTH', '', 19530818,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (73, 'No. 8, Jalan Mawar 8,', 'Prima Beruntung 88,', '', '',
			'48300', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 3, 73);

-- >> 74
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (74, 1000000001, 'TTENC', 'DARLIN BIN MOHD DARBI', 'CCIND', 
			'IDNIC', '781008-10-5973', 74, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19781205,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (74, 'No 99, Jalan Serampang 99/99,', '', '', '',
			'40100', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 3, 74);

-- >> 75
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (75, 1000000001, 'TTMIS', 'EK MA MI', 'CCIND', 
			'IDNIC', '620112-08-5266', 75, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0192435082', '', '', 'MSOTH', '', 19640111,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (75, '8, Jalan 22/22,', 'Taman Bukit Anggerik 22,', 'Cheras,', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 75);

-- >> 76
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (76, 1000000001, 'TTMST', 'ENG ENG CHAR', 'CCIND', 
			'IDNIC', '781018-10-5751', 76, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163221738', '', '', 'MSOTH', '', 19741028,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (76, 'No 88, Jalan U88/88,', 'Bukit Subang,', '', '',
			'40160', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 3, 76);

-- >> 77
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (77, 1000000001, 'TTMIS', 'ER SI KUM', 'CCIND', 
			'IDNIC', '881018-01-5725', 77, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19801029,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (77, '88 Taman Bakri Jaya 8,', '', '', '',
			'84200', 'Muar,', 'STJOH', 'CTMAS', 20130625, 3, 77);

-- >> 78
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (78, 1000000001, 'TTMST', 'XUAN VE RI', 'CCIND', 
			'IDNIC', '901128-01-5031', 78, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19901018,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (78, '99, Taman Bakri Jaya 9/9,', '', '', '',
			'84200', 'Muar,', 'STJOH', 'CTMAS', 20130625, 3, 78);

-- >> 79
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (79, 1000000001, 'TTMST', 'FOO PER SON', 'CCIND', 
			'IDNIC', '881209-14-5315', 79, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0176065580', '', '', 'MSOTH', 'likchungfoo@yahoo.com', 19871201,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (79, '88A, Casa Prima Condo 90,', 'Metro Prima 29,', 'Metro Prima Kepong,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 79);

-- >> 80
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (80, 1000000001, 'TTMIS', 'WEN PEK WEN', 'CCIND', 
			'IDNIC', '880818-18-5310', 80, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840811,
			'', 3, 20130625, 'CCACT');		
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (80, 'No. 18, Jalan Anggerik 18,', 'Taman Puchong Perdana,', '', '',
			'47100', 'Puchong,', 'STSEL', 'CTMAS', 20130625, 3, 80);

-- >> 81
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (81, 1000000001, 'TTMST', 'GAN HAN MING', 'CCIND', 
			'IDNIC', '770717-11-5615', 81, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19790715,
			'', 3, 20130625, 'CCACT');	
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (81, 'No 77, Lorong 77,', 'Site B 7,', '', '',
			'45400', 'Sekinchan,', 'STSEL', 'CTMAS', 20130625, 3, 81);

-- >> 82
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (82, 1000000001, 'TTMST', 'GOO GU CIN', 'CCIND', 
			'IDNIC', '880818-18-5527', 82, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19830616,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (82, '88, Jalan Wangsa 8/8,', 'Taman Wanga Permai,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 82);

-- >> 83
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (83, 1000000001, 'TTMIS', 'TIM CHEONG', 'CCIND', 
			'IDNIC', '780808-10-5258', 83, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0122181288', '', '', 'MSOTH', '', 19780405,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (83, '8, Jalan 8/8,', 'Taman Kaya,', 'ff Jalan Ipoh,', '',
			'51100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 83);

-- >> 84
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (84, 1000000001, 'TTMIS', 'LENG LUI LE', 'CCIND', 
			'IDNIC', '780828-18-5478', 84, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19760820,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (84, '8, Jalan Wangsa 8/8,', 'Taman Wanga Permai 8,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 84);

-- >> 85
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (85, 1000000001, 'TTENC', 'HASRUM BIN HARIM', 'CCIND', 
			'IDNIC', '850828-08-5001', 85, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850220,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (85, '82, Garden Ville,', 'Jalan 8/8,', 'Selayang Heights,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 85);

-- >> 86
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (86, 1000000001, 'TTMST', 'HEN KEE LIK', 'CCIND', 
			'IDNIC', '880808-14-5297', 86, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870504,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (86, 'No.8 Lorong 8,', 'Taman Indah Baiduri 8,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 86);

-- >> 87
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (87, 1000000001, 'TTMIS', 'HIM LIK HER', 'CCIND', 
			'IDNIC', '900808-14-5254', 87, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19900603,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (87, 'No.8 Lorong 8,', 'WTaman Indah Baiduri 8,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 87);

-- >> 88
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (88, 1000000001, 'TTMST', 'HENG MUM MUM', 'CCIND', 
			'IDNIC', '660606-06-5267', 88, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19630609,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (88, 'No.8 Lorong 8,', 'Taman Indah Baiduri 8,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 88);	

-- >> 89
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (89, 1000000001, 'TTMST', 'PIN PIG FAC', 'CCIND', 
			'IDNIC', '880628-08-6837', 89, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0177737082	', '', '', 'MSOTH', 'm', 19840620,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (89, 'No. 88/88, Jalan Cahaya 8,', 'Taman Bedena Jaya 8,', '', '',
			'45300', 'Sungai Besar,', 'STSEL', 'CTMAS', 20130625, 3, 89);
	
-- >> 90
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (90, 1000000001, 'TTMST', 'HOU TIM KAU', 'CCIND', 
			'IDNIC', '881128-08-5813', 90, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19821125,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (90, 'No 8888, Jalan Selingsing 8888,', 'Titian Waris Business Park,', 'Off Jalan Kuching,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 90);

-- >> 91
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (91, 1000000001, 'TTMST', 'KOK PIN KEE', 'CCIND', 
			'IDNIC', '730818-18-5375', 91, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19730316,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (91, 'No. 8888, Jalan Jinjang Murni 9,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 91);

-- >> 92
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (92, 1000000001, 'TTMIS', 'SZE JUN MI', 'CCIND', 
			'IDNIC', '850822-14-5994', 92, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'012626139', '', '', 'MSOTH', 'whei85@hotmail.com', 19850526,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (92, 'No 88, Jalan 8888,	Selayang Baru 8888,', '', '', '',
			'68100', 'Batu Caves', 'STSEL', 'CTMAS', 20130625, 3, 92);

-- >> 93
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (93, 1000000001, 'TTMST', 'HENG CHOI LIN', 'CCIND', 
			'IDNIC', '680828-10-6627', 93, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192305610', '', '', 'MSOTH', 'albertes_hong@gmail.com', 19620820,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (93, 'No 88, Jalan Safa 88,', 'Safa Terraces,', 'Desa Parkcity,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 93);
			
-- >> 94
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (94, 1000000001, 'TTMST', 'HOW TO DO', 'CCIND', 
			'IDNIC', '650505-10-5415', 94, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0', '', '', 'MSOTH', '', 19690905,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (94, 'No 898, Jalan Safa 8,', 'Safa Terraces,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 94);	
	
-- >> 95
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (95, 1000000001, 'TTMIS', 'HING CHIN CHUN', 'CCIND', 
			'IDNIC', '880708-16-5642', 95, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820705,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (95, 'Block H99,	Jalan SH 8/8,', 'Andari Townvilla,', 'Selayang Height,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 95);	
	
-- >> 96
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (96, 1000000001, 'TTMIS', 'SA TON KUA', 'CCIND', 
			'IDNIC', '880828-14-5928', 96, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19780922,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (96, 'B8, Damansara Mas Apartment 88,', 'Taman KIP 88,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 96);	
			
-- >> 97
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (97, 1000000001, 'TTMST', 'HU PIN PING', 'CCIND', 
			'IDNIC', '880708-14-5381', 97, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810702,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (97, 'No. 66, Jalan 8/8,', 'Taman Sri Sinar Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 97);	

-- >> 98
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (98, 1000000001, 'TTMST', 'TING TONG TIANG', 'CCIND', 
			'IDNIC', '880811-43-5129', 98, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19890918,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (98, '8, Jalan Bullion Mewah 88,', 'Taman Bullion Mewah,', 'Sentul,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 98);	

-- >> 99
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (99, 1000000001, 'TTENC', 'ISMAIL BIN AHMAD YOSOF', 'CCIND', 
			'IDNIC', '881110-08-5449', 99, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0122726574', '', '', 'MSOTH', 'ismadifaizal@muamalat.com.my', 19831210,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (99, 'No 9988, Jalan Templer Suasana 99', 'Templer Park Resort,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 3, 99);	

-- >> 100
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (100, 1000000001, 'TTMIS', 'JASPAL KAUR A/P BAJA SINGH', 'CCIND', 
			'IDNIC', '770727-07-5234', 100, 'RCIND', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19760925,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (100, '7 Tudor Court Apartment, Jalan Dedap 7', 'Taman Rasmi Jaya,', '', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 3, 100);

-- >> 101
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (101, 1000000001, 'TTMST', 'RUBI MAIN', 'CCIND', 
			'IDNIC', '999999-99-9999', 101, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19990909,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (101, '88 RUBI LEE', 'JALAN RUBI', 'TAMAN RUBI', '',
			'88888', '', 'STKUL', 'CTMAS', 20130625, 3, 101);

-- >> 102
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (102, 1000000001, 'TTMST', 'JUJU SINGH A/L MAGA SINGH', 'CCIND', 
			'IDNIC', '771127-14-5343', 102, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'0129190819', '', '', 'MSOTH', 'jujaarsingh25@yahoo.com', 19791123,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (102, 'No. 88, Jalan LPI 8,', 'Taman Laksamana Permai,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 3, 102);

-- >> 103
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (103, 1000000001, 'TTMST', 'KANAN A/L KIRI', 'CCIND', 
			'IDNIC', '831111-02-5461', 103, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831221,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (103, '11 Pangsapuri Bukit Segambut,', 'Taman Sri Bintang 1,', 'Jalan Seri Bintang 11,', 'Segambut,',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 103);

-- >> 104
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (104, 1000000001, 'TTMST', 'KEE HON PIAU', 'CCIND', 
			'IDNIC', '810803-06-5045', 104, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19910503,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (104, 'No. 88, Jalan Pandan Indah 88,', '', '', '',
			'55100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 104);

-- >> 105
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (105, 1000000001, 'TTMST', 'KESA A/L SUPERMAN', 'CCIND', 
			'IDNIC', '870808-56-5263', 105, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870406,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (105, '8 Jalan Sri Ehsan 18,', 'Taman Sri Ehsan 8,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 3, 105);

-- >> 106
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (106, 1000000001, 'TTMST', 'KAMAL BIN ALI', 'CCIND', 
			'IDNIC', '770809-09-5565', 106, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192806921', '', '', 'MSOTH', '', 19770906,
			'', 3, 20130625, 'CCACT');
INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (106, 'No. 88, Jalan Melor 88,	Desa Melor,', '', '', '',
			'48200', '', 'STSEL', 'CTMAS', 20130625, 3, 106);

UPDATE vipro.customer SET created_by = NULL WHERE customer_id <= 300;

-- load business partner address for Law & Lee
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('SUITE A-5-7, SKY PARK ONE CITY,', 'JALAN USJ 25/1,', '', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);

-- Dpristine Address
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('C-07-01 TO 08, BLOCK C,', 'SKY PARK ONE CITY,', 'JALAN USJ25/1A,', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);

-- Superb Property
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('C-07-01 TO 08, BLOCK C,', 'SKY PARK ONE CITY,', 'JALAN USJ25/1A,', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);
			
UPDATE vipro.address 
SET address_line_1 = UPPER(address_line_1),
	address_line_2 = UPPER(address_line_2),
	address_line_3 = UPPER(address_line_3),
	address_line_4 = UPPER(address_line_4),
	city = UPPER(city)
WHERE address_id > 0;