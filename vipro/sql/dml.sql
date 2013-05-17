--3 feb 2013
insert into vipro.user_group values('ADMIN', 'Administrator', 'ACTV');
insert into institution (institution_name, status) values( 'B&E Engineering Sdn Bhd', 'ACTV');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('root', '5f4dcc3b5aa765d61d8327deb882cf99', 'Administrator', 1,'000', 'ACTV', 'ADMIN');

insert into code_header (code_header_id, name) values ('DEPARTMENT', 'deparments');
insert into code_det values ('DEPARTMENT', 'ACC', 'Account', 'ACTV');
insert into code_det values ('DEPARTMENT', 'DEV', 'Developer', 'ACTV');



insert into user_group values ('SETUP', 'Setup', 'ACTV');
insert into user_group values ('SALES', 'Sales', 'ACTV');
insert into user_group values ('SALES_ADM', 'Sales Admin', 'ACTV');
insert into user_group values ('CUST_SERV', 'Customer Service', 'ACTV');
insert into user_group values ('ACCT', 'Account', 'ACTV');
insert into user_group values ('PROP_DEV', 'Property Development', 'ACTV');


insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('setup', '5f4dcc3b5aa765d61d8327deb882cf99', 'setup user', 1,'000', 'ACTV', 'SETUP');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('sales', '5f4dcc3b5aa765d61d8327deb882cf99', 'sales user', 1,'000', 'ACTV', 'SALES');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('salesadmin', '5f4dcc3b5aa765d61d8327deb882cf99', 'sales admin user', 1,'000', 'ACTV', 'SALES_ADM');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('customerservice', '5f4dcc3b5aa765d61d8327deb882cf99', 'customer service user', 1,'000', 'ACTV', 'CUST_SERV');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('account', '5f4dcc3b5aa765d61d8327deb882cf99', 'account', 1,'000', 'ACTV', 'ACCT');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('developer', '5f4dcc3b5aa765d61d8327deb882cf99', 'developer', 1,'000', 'ACTV', 'PROP_DEV');



insert into code_header (code_header_id, name) values ( 'CASE_TYPE', 'Case Type / Category');
insert into code_det values ('CASE_TYPE', 'REMIND', 'Reminder', 'ACTV');
insert into code_det values('CASE_TYPE', 'INQ', 'Inquiry', 'ACTV');
insert into code_det values ('CASE_TYPE', 'APPR', 'Approval', 'ACTV');
insert into code_det values ('CASE_TYPE', 'VERI', 'Verify', 'ACTV');




insert into code_header values ('ACTION', 'Action taken');
insert into code_det values ( 'ACTION', 'REASS', 'Reassigned' , 'ACTV');
insert into code_det values ( 'ACTION', 'EMAIL', 'Emailed', 'ACTV');

-- Contact Title
INSERT INTO code_header VALUES ('CONTACT_TITLE', 'Contact Title');
INSERT INTO code_det VALUES ('CONTACT_TITLE', 'MR', 'Mr', 'ACTV');
INSERT INTO code_det VALUES ('CONTACT_TITLE', 'MS', 'Ms', 'ACTV');

-- City
INSERT INTO code_header VALUES ('CITY', 'City');
INSERT INTO code_det VALUES ('CITY', 'SMY', 'Bandar Semenyih', 'ACTV');
INSERT INTO code_det VALUES ('CITY', 'BK1', 'Bandar Kinrara 1', 'ACTV');
INSERT INTO code_det VALUES ('CITY', 'BK2', 'Bandar Kinrara 2', 'ACTV');
INSERT INTO code_det VALUES ('CITY', 'BK3', 'Bandar Kinrara 3', 'ACTV');
INSERT INTO code_det VALUES ('CITY', 'SUN', 'Sunway', 'ACTV');

-- State
INSERT INTO code_header VALUES ('STATE', 'State');
insert into code_det values('STATE', 'SEL', 'Selangor', 'ACTV');
insert into code_det values('STATE', 'KUL', 'Kuala Lumpur', 'ACTV');
insert into code_det values('STATE', 'JOH', 'Johor', 'ACTV');
insert into code_det values('STATE', 'MEL', 'Melaka', 'ACTV');
insert into code_det values('STATE', 'SEM', 'Sembilan', 'ACTV');
insert into code_det values('STATE', 'PAH', 'Pahang', 'ACTV');
insert into code_det values('STATE', 'PER', 'Perak', 'ACTV');
insert into code_det values('STATE', 'TER', 'Terrenganu', 'ACTV');
insert into code_det values('STATE', 'KEL', 'Kelantan', 'ACTV');
insert into code_det values('STATE', 'PEN', 'Penang', 'ACTV');
insert into code_det values('STATE', 'PEL', 'Perlis', 'ACTV');
insert into code_det values('STATE', 'KED', 'Kedah', 'ACTV');
insert into code_det values('STATE', 'SAR', 'Sarawak', 'ACTV');
insert into code_det values('STATE', 'SAB', 'Sabah', 'ACTV');
insert into code_det values('STATE', 'LAB', 'Labuan', 'ACTV');

-- Country
INSERT INTO code_header VALUES ('COUNTRY', 'Country');
INSERT INTO code_det VALUES ('COUNTRY', 'MAS', 'Malaysia', 'ACTV');
INSERT INTO code_det VALUES ('COUNTRY', 'IND', 'Indonesia', 'ACTV');

-- Status
-- INSERT INTO code_header VALUES ('STATUS', 'Status');
-- INSERT INTO code_det VALUES ('STATUS', 'ACTV', 'Active', 'ACTV');
-- INSERT INTO code_det VALUES ('STATUS', 'INACT', 'Inactive', 'ACTV');




insert into code_header values ('PROP_TYPE', 'Property types');
insert into code_det values( 'PROP_TYPE', 'CON', 'Condo/Service Residential', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'APT', 'Apartment/Flat', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'TER', 'Terrence/Townhouse', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'BGL', 'Semi-D/Bungalow', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'SHP', 'Shop/Office', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'HTL', 'Hotel/Resort', 'ACTV');
insert into code_det values( 'PROP_TYPE', 'FTR', 'Warehouse/Factory', 'ACTV');



insert into code_header (code_header_id, name) values ('TITLE_TYPE', 'Property title type');
insert into code_det values ('TITLE_TYPE', 'STR', 'Strata', 'ACTV');
insert into code_det values ('TITLE_TYPE', 'MST', 'Master', 'ACTV');


INSERT INTO code_header VALUES ('SEX', 'Sex');
INSERT INTO code_det VALUES ('SEX', 'M', 'Male', 'ACTV');
INSERT INTO code_det VALUES ('SEX', 'F', 'Female', 'ACTV');

INSERT INTO code_header VALUES ('LANGUAGE', 'Language');
INSERT INTO code_det VALUES ('LANGUAGE', 'CHI', 'Chinese', 'ACTV');
INSERT INTO code_det VALUES ('LANGUAGE', 'MLY', 'Malay', 'ACTV');
INSERT INTO code_det VALUES ('LANGUAGE', 'TML', 'Tamil', 'ACTV');

INSERT INTO code_header VALUES ('MARITAL', 'Marital');
INSERT INTO code_det VALUES ('MARITAL', 'M', 'Married', 'ACTV');
INSERT INTO code_det VALUES ('MARITAL', 'S', 'Single', 'ACTV');

INSERT INTO code_header VALUES ('BUMI', 'Bumi or not');
INSERT INTO code_det VALUES ('BUMI', 'NB', 'Non Bumi', 'ACTV');
INSERT INTO code_det VALUES ('BUMI', 'B', 'Bumi', 'ACTV');



INSERT INTO code_header VALUES ('RACE', 'Race');
INSERT INTO code_det VALUES ('RACE', 'CHI', 'Chinese', 'ACTV');
INSERT INTO code_det VALUES ('RACE', 'MLY', 'Malay', 'ACTV');
INSERT INTO code_det VALUES ('RACE', 'IND', 'Indian', 'ACTV');

INSERT INTO code_header VALUES ('IDTYPE', 'id type');
INSERT INTO code_det VALUES ('IDTYPE', 'ID', 'Identity Card', 'ACTV');
INSERT INTO code_det VALUES ('IDTYPE', 'PP', 'Passport', 'ACTV');

insert into transaction_code values ('BOOK', 'Booking Fee', null, null, 'ACTV');


INSERT INTO code_header VALUES ('PAYM', 'Payment Method');
INSERT INTO code_det VALUES ('PAYM', 'CD', 'Card', 'ACTV');
INSERT INTO code_det VALUES ('PAYM', 'CQ', 'Cheque', 'ACTV');
INSERT INTO code_det VALUES ('PAYM', 'BD', 'Bank Draft', 'ACTV');

INSERT INTO code_header VALUES ('BANK', 'Bank');
INSERT INTO code_det VALUES ('BANK', 'HSBC', 'HSBC', 'ACTV');
INSERT INTO code_det VALUES ('BANK', 'HLB', 'Hong Leong', 'ACTV');
INSERT INTO code_det VALUES ('BANK', 'MBB', 'Maybank', 'ACTV');
INSERT INTO code_det VALUES ('BANK', 'AFF', 'Affin', 'ACTV');
INSERT INTO code_det VALUES ('BANK', 'AM', 'Am', 'ACTV');
INSERT INTO code_det VALUES ('BANK', 'CTB', 'Citibank', 'ACTV');


insert into code_header values ('CANCEL_R', 'Cancel Reason');
insert into code_det values ( 'CANCEL_R', 'BRK', 'I am broke' , 'ACTV');

insert into transaction_code values ('CANCEL', 'Cancellation Fee', null, null, 'ACTV');



insert into code_header values ('CASE_STATUS', 'Case Status');
insert into code_det values ( 'CASE_STATUS', 'NEW', 'New' , 'ACTV');
insert into code_det values ( 'CASE_STATUS', 'OPEN', 'New' , 'ACTV');
insert into code_det values ( 'CASE_STATUS', 'CLOSED', 'New' , 'ACTV');
insert into code_det values ( 'CASE_STATUS', 'COMPLETED', 'New' , 'ACTV');

insert into code_header values ('STATUS', 'Case Status');
insert into code_det values ( 'STATUS', 'ACTV', 'Active' , 'ACTV');
insert into code_det values ( 'STATUS', 'DISB', 'Disabled' , 'ACTV');

insert into code_header values ('PROP_STATUS', 'Property status');
insert into code_det values( 'PROP_STATUS', 'SOLD', 'Sold', 'ACTV');
insert into code_det values( 'PROP_STATUS', 'ACTV', 'Available', 'ACTV');
insert into code_det values( 'PROP_STATUS', 'DISB', 'Not Available', 'ACTV');

-- 20130324
insert into code_header (code_header_id, name) values ('BOOK_STATUS', 'Booking Status');
insert into code_det values ('BOOK_STATUS', 'AVLB', 'Available', 'ACTV');
insert into code_det values ('BOOK_STATUS', 'PROC', 'Processing', 'ACTV');
insert into code_det values ('BOOK_STATUS', 'BOOK', 'Book', 'ACTV');
insert into code_det values ('BOOK_STATUS', 'RESV', 'Reserved', 'ACTV');
insert into code_det values ('BOOK_STATUS', 'SOLD', 'Sold', 'ACTV');

-- 20130405
insert into code_header (code_header_id, name) values ('MEDIA_SOURCE', 'Media Source');
insert into code_det values ('MEDIA_SOURCE', 'NEWS', 'Newspaper', 'ACTV');
insert into code_det values ('MEDIA_SOURCE', 'TV', 'Television', 'ACTV');
insert into code_det values ('MEDIA_SOURCE', 'RAD', 'Radio', 'ACTV');

-- 20130505
insert into vipro.code_det values ('PROP_STATUS','PROG','In Progress','ACTV');
insert into vipro.code_det values ('PROP_STATUS','BOOK','Booked','ACTV');

-- 20130516
insert into vipro.user_group values ('SALES_PIC', 'Sales Person-in-Charge', 'ACTV');
insert into vipro.user_profile (username, password, name, staff_no, status, institution_id, group_id)
values ('salespic', '5f4dcc3b5aa765d61d8327deb882cf99', 'sales person-in-charge', 000, 'ACTV', 1, 'SALES_PIC');