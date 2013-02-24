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
alter table project modify institution_id bigint;
alter table project modify account_id bigint;

alter table discount modify discount_rate decimal(5,2);

      
alter table project_inventory add discount_rate decimal(9,5);
alter table project_inventory add dnc_date date;






alter table account add customer_id2 bigint;
alter table account add customer_id3 bigint;
alter table account add customer_id4 bigint;
alter table account add customer_id5 bigint;

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_200
      FOREIGN KEY (customer_id2)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_300
      FOREIGN KEY (customer_id3)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_400
      FOREIGN KEY (customer_id4)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_500
      FOREIGN KEY (customer_id5)
      REFERENCES vipro.customer (customer_id);
      
alter table account add account_balance decimal(9,2);

alter table account add remark varchar(300);

alter table customer drop mobile_id;
alter table customer drop email_id;

alter table customer add mobile_no varchar(20);
alter table customer add email varchar(40);


alter table customer modify institution_id bigint;
alter table address modify customer_id bigint;
alter table customer add contact_Person varchar(30);
alter table transaction_history add amount decimal(9,2);


alter table transaction_history add payment_method varchar(110);
alter table transaction_history add bank varchar(10);
alter table transaction_history add card_cheque_no varchar(30);

