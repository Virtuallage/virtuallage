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



