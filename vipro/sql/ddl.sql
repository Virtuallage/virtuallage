alter table user_profile add department varchar(10);


alter table customer add address_id bigint;
alter table customer add mobile_id bigint;
alter table customer add email_id bigint;


alter table email modify account_id bigint;
alter table address modify account_id bigint;
alter table mobile_phone modify account_id bigint;


alter table vipro.case_activity add note varchar(300);


alter table discount add project_id bigint;
alter table sales_commission add project_id bigint;

ALTER TABLE vipro.discount
  ADD CONSTRAINT FK_discount_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

ALTER TABLE vipro.sales_commission
  ADD CONSTRAINT FK_sales_commission_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);
      
alter table project add status varchar(10);


alter table project add postcode varchar(10);


      
      