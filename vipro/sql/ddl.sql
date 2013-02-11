alter table user_profile add department varchar(10);


alter table customer add address_id bigint;
alter table customer add mobile_id bigint;
alter table customer add email_id bigint;


alter table email modify account_id bigint;
alter table address modify account_id bigint;
alter table mobile_phone modify account_id bigint;


alter table vipro.case_activity add note varchar(300);

