--3 feb 2013
insert into vipro.user_group values('ADMIN', 'Administrator', 'ACTV');
insert into institution (institution_name) values( 'B&E Engineering Sdn Bhd');
insert into vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) values('root', '5f4dcc3b5aa765d61d8327deb882cf99', 'Administrator', 1,'000', 'ACTV', 'ADMIN');