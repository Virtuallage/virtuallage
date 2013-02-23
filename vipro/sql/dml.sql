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
INSERT INTO code_header VALUES ('STATUS', 'Status');
INSERT INTO code_det VALUES ('STATUS', 'ACTV', 'Active', 'ACTV');
INSERT INTO code_det VALUES ('STATUS', 'INACT', 'Inactive', 'ACTV');




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

