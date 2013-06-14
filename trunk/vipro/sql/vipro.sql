-- Tables are not sorted because: 
-- Circular dependency between table vipro.project and table vipro.project_inventory: both have foreign keys that reference the other table.
-- Try generating Foreign Keys with ALTER TABLE statements.

DROP TABLE IF EXISTS vipro.contact;
DROP TABLE IF EXISTS vipro.contact_list;
DROP TABLE IF EXISTS vipro.transaction_code;
DROP TABLE IF EXISTS vipro.voucher;
DROP TABLE IF EXISTS vipro.water_billing;
DROP TABLE IF EXISTS vipro.join_account;
DROP TABLE IF EXISTS vipro.transaction_group;
DROP TABLE IF EXISTS vipro.transaction_history;
DROP TABLE IF EXISTS vipro.account_aging;
DROP TABLE IF EXISTS vipro.mobile_phone;
DROP TABLE IF EXISTS vipro.email;
DROP TABLE IF EXISTS vipro.address;
DROP TABLE IF EXISTS vipro.customer;
DROP TABLE IF EXISTS vipro.account;
DROP TABLE IF EXISTS vipro.postdated_cheque;
DROP TABLE IF EXISTS vipro.progressive_billing;
DROP TABLE IF EXISTS vipro.project_inventory;
DROP TABLE IF EXISTS vipro.project;
DROP TABLE IF EXISTS vipro.business_partner;
DROP TABLE IF EXISTS vipro.sales_commission;
DROP TABLE IF EXISTS vipro.discount;
DROP TABLE IF EXISTS vipro.code_det;
DROP TABLE IF EXISTS vipro.code_header;
DROP TABLE IF EXISTS vipro.document_reference;
DROP TABLE IF EXISTS vipro.user_permission;
DROP TABLE IF EXISTS vipro.group_permission;
DROP TABLE IF EXISTS vipro.user_group;
DROP TABLE IF EXISTS vipro.user_profile;
DROP TABLE IF EXISTS vipro.holiday;
DROP TABLE IF EXISTS vipro.audit_log_det;
DROP TABLE IF EXISTS vipro.audit_log_header;
DROP TABLE IF EXISTS vipro.institution;

CREATE TABLE vipro.institution (
       institution_id BIGINT NOT NULL AUTO_INCREMENT
     , institution_name VARCHAR(60)
     , initial VARCHAR(6)
     , office_tel VARCHAR(20)
     , contact_person VARCHAR(60)
     , contact_person_title VARCHAR(10)
     , contact_person_mobile VARCHAR(20)
     , contact_person_email VARCHAR(50)
     , currency_symbol VARCHAR(4)
     , decimal_points DECIMAL(2)
     , status VARCHAR(5)
     , PRIMARY KEY (institution_id)
);

CREATE TABLE vipro.audit_log_header (
       hdr_id BIGINT NOT NULL AUTO_INCREMENT
     , PRIMARY KEY (hdr_id)
);

CREATE TABLE vipro.audit_log_det (
       det_id BIGINT NOT NULL AUTO_INCREMENT
     , hdr_id BIGINT NOT NULL
     , PRIMARY KEY (det_id)
);

CREATE TABLE vipro.holiday (
       holiday_id BIGINT NOT NULL AUTO_INCREMENT
     , date DATE
     , description VARCHAR(30)
     , institution_id BIGINT NOT NULL
     , PRIMARY KEY (holiday_id)
);

CREATE TABLE vipro.user_profile (
       user_id BIGINT NOT NULL AUTO_INCREMENT
     , username VARCHAR(20)
     , password VARCHAR(50)
     , name VARCHAR(30)
     , address VARCHAR(60)
     , staff_no VARCHAR(20)
     , email CHAR(40)
     , mobile_no CHAR(20)
     , office_no CHAR(20)
     , invalid_password_count INT
     , special_handling CHAR(1)
     , status VARCHAR(5)
     , institution_id BIGINT NOT NULL
     , group_id VARCHAR(10) NOT NULL
     , PRIMARY KEY (user_id)
);

CREATE TABLE vipro.user_group (
       group_id VARCHAR(10) NOT NULL
     , group_name VARCHAR(30)
     , status VARCHAR(5)
     , PRIMARY KEY (group_id)
);

CREATE TABLE vipro.group_permission (
       permission_id VARCHAR(20) NOT NULL
     , name VARCHAR(30)
     , PRIMARY KEY (permission_id)
);

CREATE TABLE vipro.user_permission (
       group_id VARCHAR(10) NOT NULL
     , permission_id VARCHAR(20) NOT NULL
     , PRIMARY KEY (group_id, permission_id)
);

CREATE TABLE vipro.document_reference (
       id BIGINT NOT NULL AUTO_INCREMENT
     , doc_type CHAR(10)
     , file_content LONGBLOB
     , created_on DATETIME
     , created_by VARCHAR(20)
     , PRIMARY KEY (id)
);

CREATE TABLE vipro.code_header (
       code_header_id VARCHAR(20) NOT NULL
     , name VARCHAR(30)
     , PRIMARY KEY (code_header_id)
);

CREATE TABLE vipro.code_det (
       code_header_id VARCHAR(20) NOT NULL
     , code VARCHAR(20) NOT NULL
     , description VARCHAR(30)
     , status VARCHAR(5)
     , PRIMARY KEY (code_header_id, code)
);

CREATE TABLE vipro.discount (
       discount_id BIGINT NOT NULL  AUTO_INCREMENT
     , description VARCHAR(30)
     , effective_date DATE
     , expiry_date DATE
     , discount_rate DEC(3, 2)
     , created_on DATETIME
     , status VARCHAR(5)
     , PRIMARY KEY (discount_id)
);

CREATE TABLE vipro.sales_commission (
       commission_id BIGINT NOT NULL AUTO_INCREMENT
     , description VARCHAR(30)
     , effective_date DATETIME
     , type VARCHAR(5)
     , amount_or_rate DEC(6, 2)
     , created_on DATETIME
     , status VARCHAR(5)
     , PRIMARY KEY (commission_id)
);

CREATE TABLE vipro.business_partner (
       partner_id CHAR(10)
     , partner_type VARCHAR(10)
     , business_registration_no VARCHAR(30)
     , registration_date DATE
     , company_name VARCHAR(60)
     , address VARCHAR(100)
     , contact_person_title VARCHAR(10)
     , contact_person_name VARCHAR(50)
     , office_tel VARCHAR(20)
     , fax_no VARCHAR(20)
     , mobile_no VARCHAR(20)
     , email_address VARCHAR(30)
     , status VARCHAR(5)
     , institution_id BIGINT NOT NULL
);

CREATE TABLE vipro.project (
       project_id BIGINT NOT NULL AUTO_INCREMENT
     , project_name VARCHAR(40)
     , project_code VARCHAR(10)
     , property_type VARCHAR(20)
     , report_group VARCHAR(20)
     , address VARCHAR(80)
     , project_office_tel_no VARCHAR(20)
     , project_office_fax_no VARCHAR(20)
     , person_in_charge VARCHAR(30)
     , pic_mobile_no VARCHAR(20)
     , location_longtitude VARCHAR(15)
     , location_latitude VARCHAR(15)
     , location_city VARCHAR(20)
     , location_state VARCHAR(20)
     , location_country VARCHAR(5)
     , collection_interest_rate NUMERIC(3, 2)
     , staff_booking_fee DEC(7, 2)
     , public_booking_fee NUMERIC(7, 2)
     , maintenance_fee_rate NUMERIC(3, 2)
     , launch_date DATE
     , tax_percentage DEC(3, 2)
     , institution_id BIGINT NOT NULL
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (project_id)
);

CREATE TABLE vipro.project_inventory (
       inventory_id BIGINT NOT NULL AUTO_INCREMENT
     , unit_no VARCHAR(12)
     , pt_no VARCHAR(8)
     , hsd_no VARCHAR(8)
     , block_no VARCHAR(8)
     , level VARCHAR(5)
     , layout_type VARCHAR(5)
     , orientation VARCHAR(5)
     , land_area INT
     , built_up_area INT
     , property_status VARCHAR(5)
     , status_change_date DATE
     , purchase_price DEC(9, 2)
     , discount_amount NUMERIC(9, 2)
     , redemption_amount NUMERIC(9, 2)
     , redemption_paid_todate DATE
     , assessment DEC(7, 2)
     , quit_rent DEC(7, 2)
     , legal_fee DEC(7, 2)
     , disbursement_fee DEC(9, 2)
     , property_address VARCHAR(60)
     , property_title_type VARCHAR(10)
     , strata_title_obtained_date DATE
     , key_handover_date DATE
     , development_stage DEC(3)
     , project_id BIGINT NOT NULL
     , PRIMARY KEY (inventory_id)
);

CREATE TABLE vipro.progressive_billing (
       schedule_id BIGINT NOT NULL AUTO_INCREMENT
     , inventory_id BIGINT NOT NULL
     , seq_no DECIMAL(2)
     , stage_no VARCHAR(5)
     , stage_description VARCHAR(120)
     , percentage DEC(3, 2)
     , due_date DATE
     , interest_rate DEC(3, 2)
     , amount_billed DEC(9, 2)
     , date_billed DATE
     , payment_due_date DATE
     , date_paid DATE
     , overdue_interest DEC(7, 2)
     , status VARCHAR(5)
     , PRIMARY KEY (schedule_id)
);

CREATE TABLE vipro.postdated_cheque (
       cheque_id BIGINT NOT NULL AUTO_INCREMENT
     , transaction_date DATE
     , cheque_valid_date DATE
     , cheque_amount DEC(9, 2)
     , cheque_no VARCHAR(20)
     , bank_name VARCHAR(10)
     , transaction_code VARCHAR(10)
     , cheque_status VARCHAR(5)
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (cheque_id)
);

CREATE TABLE vipro.account (
       account_id BIGINT NOT NULL AUTO_INCREMENT
     , customer_id BIGINT NOT NULL
     , inventory_id BIGINT NOT NULL
     , account_type VARCHAR(5)
     , account_status VARCHAR(5)
     , attended_by BIGINT
     , registration_fee DEC(7, 2)
     , registration_no VARCHAR(20)
     , date_purchased DATE
     , purchase_price DEC(9, 2)
     , discounted_amount DEC(7, 2)
     , commission_amount DEC(7, 2)
     , commission_paid_date DATE
     , net_price DEC(9, 2)
     , purchase_type VARCHAR(5)
     , panel_bank_id BIGINT
     , loan_amount DEC(9, 2)
     , total_payment_todate DEC(9, 2)
     , redemption_bank_id BIGINT
     , bank_redemption_sum DEC(9, 2)
     , bank_redemption_todate DEC(9, 2)
     , spa_signed_date DATE
     , spa_stamped_date DATE
     , spa_verified_by BIGINT
     , spa_verified_date DATE
     , spa_solicitor_id BIGINT
     , LO_signed_date DATE
     , LO_verified_date DATE
     , LO_verified_by BIGINT
     , LA_signed_date DATE
     , LA_stamped_date DATE
     , LA_verified_by BIGINT
     , LA_verified_date DATE
     , LA_solicitor_id BIGINT
     , advise_signed_date DATE
     , advise_stamped_date DATE
     , advise_verified_by BIGINT
     , advise_verified_date DATE
     , maintenance_start_date DATE
     , maintenance_end_date DATE
     , maintenance_fee DEC(7, 2)
     , maintenance_biling_address CHAR
     , maintenance_fee_freq VARCHAR(2)
     , fire_insurance_due_date DATE
     , fire_insurance_amount DEC(7, 2)
     , fire_insurance_company_id BIGINT
     , last_Payment_made_date DATE
     , maintenance_biling_cycle VARCHAR(2)
     , cancelled_reason VARCHAR(5)
     , PRIMARY KEY (account_id)
);

CREATE TABLE vipro.customer (
       customer_id BIGINT NOT NULL AUTO_INCREMENT
     , customer_category VARCHAR(5)
     , identity_type VARCHAR(5)
     , identity_no VARCHAR(15)
     , title VARCHAR(10)
     , full_name VARCHAR(60)
     , special_handling VARCHAR(5)
     , race VARCHAR(5)
     , bumi_indicator VARCHAR(1)
     , sex VARCHAR(4)
     , marital_status VARCHAR(4)
     , employer_name VARCHAR(60)
     , house_tel_no VARCHAR(15)
     , office_tel_no VARCHAR(15)
     , fax_no VARCHAR(15)
     , communication_type VARCHAR(5)
     , language VARCHAR(5)
     , date_of_birth DATE
     , created_by VARCHAR(20)
     , date_created DATE
     , institution_id BIGINT NOT NULL
     , PRIMARY KEY (customer_id)
);

CREATE TABLE vipro.address (
       address_id BIGINT NOT NULL AUTO_INCREMENT
     , address_type VARCHAR(5)
     , address_line_1 VARCHAR(40)
     , address_line_2 VARCHAR(40)
     , address_line_3 VARCHAR(40)
     , postcode VARCHAR(10)
     , city VARCHAR(20)
     , state VARCHAR(20)
     , country VARCHAR(5)
     , created_on DATE
     , created_by VARCHAR(20)
     , customer_id BIGINT NOT NULL
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (address_id)
);

CREATE TABLE vipro.email (
       email_id BIGINT NOT NULL AUTO_INCREMENT
     , email_address VARCHAR(50)
     , created_on DATE
     , created_by VARCHAR(20)
     , customer_id BIGINT NOT NULL
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (email_id)
);

CREATE TABLE vipro.mobile_phone (
       mobile_id BIGINT NOT NULL AUTO_INCREMENT
     , mobile_no VARCHAR(20)
     , created_on DATE
     , created_by VARCHAR(20)
     , customer_id BIGINT NOT NULL
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (mobile_id)
);

CREATE TABLE vipro.account_aging (
       account_aging_id BIGINT NOT NULL AUTO_INCREMENT
     , account_id BIGINT NOT NULL
     , aging_type VARCHAR(5)
     , aging_start_date DATE
     , delinquent_level_1 DEC(9, 2)
     , delinquent_level_2 DEC(9, 2)
     , delinquent_level_3 DEC(9, 2)
     , delinquent_level_4 DEC(9, 2)
     , delinquent_level_5 DEC(9, 2)
     , delinquent_level_6 DEC(9, 2)
     , delinquent_level_7 DEC(9, 2)
     , delinquent_level_8 DEC(9, 2)
     , delinquent_level_9 DEC(9, 2)
     , delinquent_level_10 DEC(9, 2)
     , delinquent_level_11 DEC(9, 2)
     , delinquent_level_12 DEC(9, 2)
     , PRIMARY KEY (account_aging_id)
);

CREATE TABLE vipro.transaction_history (
       transaction_id BIGINT NOT NULL AUTO_INCREMENT
     , transaction_code VARCHAR(6) NOT NULL
     , transaction_date DATETIME
     , transaction_description VARCHAR(40)
     , ref_no VARCHAR(20)
     , posting_date DATE
     , statement_date DATE
     , status VARCHAR(5)
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (transaction_id)
);

CREATE TABLE vipro.transaction_group (
       transaction_group_id BIGINT NOT NULL AUTO_INCREMENT
     , transaction_code VARCHAR(6) NOT NULL
     , transaction_date DATE
     , group_type VARCHAR(5)
     , total_amount DEC(9, 2)
     , total_transaction NUMERIC(9, 2)
     , PRIMARY KEY (transaction_group_id)
);

CREATE TABLE vipro.join_account (
       account_id BIGINT NOT NULL
     , customer_id BIGINT NOT NULL
);

CREATE TABLE vipro.water_billing (
       water_id BIGINT NOT NULL AUTO_INCREMENT
     , date DATE
     , start_reading INT
     , end_reading INT
     , rate DEC(3, 2)
     , amount DEC(7, 2)
     , transaction_code VARCHAR(6)
     , invoice_no VARCHAR(12)
     , account_id BIGINT NOT NULL
     , PRIMARY KEY (water_id)
);

CREATE TABLE vipro.voucher (
       voucher_id BIGINT NOT NULL AUTO_INCREMENT
     , issue_date DATE
     , voucher_no VARCHAR(12)
     , voucher_type VARCHAR(5)
     , voucher_amount DECIMAL(9, 2)
     , status VARCHAR(5)
     , customer_id BIGINT NOT NULL
     , PRIMARY KEY (voucher_id)
);

CREATE TABLE vipro.transaction_code (
       transaction_code VARCHAR(6) NOT NULL
     , name VARCHAR(40)
     , code_type VARCHAR(5)
     , accounting_group VARCHAR(5)
     , status VARCHAR(5)
     , PRIMARY KEY (transaction_code)
);

CREATE TABLE vipro.contact_list (
       list_id BIGINT NOT NULL AUTO_INCREMENT
     , type VARCHAR(5)
     , subject VARCHAR(80)
     , PRIMARY KEY (list_id)
);

CREATE TABLE vipro.contact (
       id BIGINT NOT NULL AUTO_INCREMENT
     , list_id BIGINT NOT NULL
     , customer_id BIGINT NOT NULL
     , contact_name VARCHAR(80)
     , contact_type VARCHAR(2)
     , email VARCHAR(40)
     , mobile_no VARCHAR(20)
     , doc_template_id VARCHAR(10)
     , PRIMARY KEY (id)
);

ALTER TABLE vipro.audit_log_det
  ADD CONSTRAINT FK_audit_log_det_1
      FOREIGN KEY (hdr_id)
      REFERENCES vipro.audit_log_header (hdr_id);

ALTER TABLE vipro.holiday
  ADD CONSTRAINT FK_holiday_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.user_profile
  ADD CONSTRAINT FK_user_profile_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.user_profile
  ADD CONSTRAINT FK_user_profile_2
      FOREIGN KEY (group_id)
      REFERENCES vipro.user_group (group_id);

ALTER TABLE vipro.user_permission
  ADD CONSTRAINT FK_user_permission_1
      FOREIGN KEY (group_id)
      REFERENCES vipro.user_group (group_id);

ALTER TABLE vipro.user_permission
  ADD CONSTRAINT FK_user_permission_2
      FOREIGN KEY (permission_id)
      REFERENCES vipro.group_permission (permission_id);

ALTER TABLE vipro.code_det
  ADD CONSTRAINT FK_code_det_1
      FOREIGN KEY (code_header_id)
      REFERENCES vipro.code_header (code_header_id);

ALTER TABLE vipro.business_partner
  ADD CONSTRAINT FK_business_partner_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.project_inventory
  ADD CONSTRAINT FK_project_inventory_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

ALTER TABLE vipro.progressive_billing
  ADD CONSTRAINT FK_progressive_billing_1
      FOREIGN KEY (inventory_id)
      REFERENCES vipro.project_inventory (inventory_id);

ALTER TABLE vipro.postdated_cheque
  ADD CONSTRAINT FK_postdated_cheque_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_3
      FOREIGN KEY (inventory_id)
      REFERENCES vipro.project_inventory (inventory_id);

ALTER TABLE vipro.customer
  ADD CONSTRAINT FK_customer_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.address
  ADD CONSTRAINT FK_address_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.address
  ADD CONSTRAINT FK_address_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.email
  ADD CONSTRAINT FK_email_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.email
  ADD CONSTRAINT FK_email_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.mobile_phone
  ADD CONSTRAINT FK_mobile_phone_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.mobile_phone
  ADD CONSTRAINT FK_mobile_phone_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.account_aging
  ADD CONSTRAINT FK_account_aging_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.transaction_history
  ADD CONSTRAINT FK_transaction_history_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.transaction_history
  ADD CONSTRAINT FK_transaction_history_2
      FOREIGN KEY (transaction_code)
      REFERENCES vipro.transaction_code (transaction_code);

ALTER TABLE vipro.transaction_group
  ADD CONSTRAINT FK_transaction_group_1
      FOREIGN KEY (transaction_code)
      REFERENCES vipro.transaction_code (transaction_code);

ALTER TABLE vipro.join_account
  ADD CONSTRAINT FK_join_account_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.join_account
  ADD CONSTRAINT FK_join_account_2
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.water_billing
  ADD CONSTRAINT FK_water_billing_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.voucher
  ADD CONSTRAINT FK_voucher_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.contact
  ADD CONSTRAINT FK_contact_list_3
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.contact
  ADD CONSTRAINT FK_contact_list_4
      FOREIGN KEY (list_id)
      REFERENCES vipro.contact_list (list_id);

      
      
      

DROP TABLE IF EXISTS vipro.case_activity;
DROP TABLE IF EXISTS vipro.case;

CREATE TABLE vipro.case (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , creation_date DATE
     , case_type VARCHAR(10)
     , subject VARCHAR(60)
     , name VARCHAR(60)
     , mobile_no VARCHAR(20)
     , email VARCHAR(50)
     , due_date DATE
     , notification CHAR(1)
     , status VARCHAR(10)
     , sender_id BIGINT NOT NULL
     , assignee_id BIGINT NOT NULL
     , customer_id BIGINT NOT NULL
     , creator_id BIGINT NOT NULL
     , PRIMARY KEY (case_id)
);

CREATE TABLE vipro.case_activity (
       activity_id BIGINT NOT NULL AUTO_INCREMENT
     , action_by BIGINT
     , action_code VARCHAR(10)
     , action_time DATETIME
     , old_due_date DATE
     , case_id BIGINT NOT NULL
     , primary key (activity_id)
);



ALTER TABLE vipro.case
  ADD CONSTRAINT FK_case_1
      FOREIGN KEY (sender_id)
      REFERENCES vipro.user_profile (user_id);

ALTER TABLE vipro.case
  ADD CONSTRAINT FK_case_2
      FOREIGN KEY (assignee_id)
      REFERENCES vipro.user_profile (user_id);

ALTER TABLE vipro.case
  ADD CONSTRAINT FK_case_3
      FOREIGN KEY (creator_id)
      REFERENCES vipro.user_profile (user_id);

ALTER TABLE vipro.case
  ADD CONSTRAINT FK_case_4
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);


ALTER TABLE vipro.case_activity
  ADD CONSTRAINT FK_case_activity_1
      FOREIGN KEY (case_id)
      REFERENCES vipro.case (case_id);



alter table vipro.case add message varchar(300);


-- 100513 Max
CREATE  TABLE `vipro`.`sales_cancellation_history` (
  `cancellation_id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `inventory_id` BIGINT(20) NOT NULL ,
  `registration_fee` DECIMAL(7,2) NULL ,
  `cancelled_reason` VARCHAR(5) NULL DEFAULT NULL ,
  `cancel_fee` DECIMAL(9,2) NULL DEFAULT NULL ,
  `cancel_tax` DECIMAL(9,2) NULL DEFAULT NULL ,
  `cancel_refund_net_amt` DECIMAL(9,2) NULL DEFAULT NULL ,
  `cancel_doc_id` BIGINT(20) NULL DEFAULT NULL ,
  PRIMARY KEY (`cancellation_id`) ,
  INDEX `FK_sales_cancellation_history_1_idx` (`inventory_id` ASC) ,
  CONSTRAINT `FK_sales_cancellation_history_1`
    FOREIGN KEY (`inventory_id` )
    REFERENCES `vipro`.`project_inventory` (`inventory_id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
DEFAULT CHARACTER SET = utf8;


CREATE  TABLE `vipro`.`sales_commission_history` (
  `commission_id` BIGINT(20) NOT NULL AUTO_INCREMENT ,
  `account_id` BIGINT(20) NOT NULL ,
  PRIMARY KEY (`commission_id`) ,
  INDEX `FK_commission_1_idx` (`account_id` ASC) ,
  CONSTRAINT `FK_sales_commission_history_1`
    FOREIGN KEY (`account_id` )
    REFERENCES `vipro`.`account` (`account_id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);
      
      
      
