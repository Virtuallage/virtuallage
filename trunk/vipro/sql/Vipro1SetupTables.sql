--  Last done : v1210

-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Step 1: This SQL will perform the following: -                          |
-- | a. Create Vipro Tables                                                  | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- | Tables are not sorted because:                                          |
-- | Circular dependency between table vipro.project and table               |
-- | vipro.project_inventory: both have foreign keys that reference the other|
-- | table.                                                                  |
-- | Try generating Foreign Keys with ALTER TABLE statements.                |
-- +-------------------------------------------------------------------------+

DROP TABLE IF EXISTS vipro.unit_mapping;
DROP TABLE IF EXISTS vipro.bank_account;
DROP TABLE IF EXISTS vipro.billing_model_header;
DROP TABLE IF EXISTS vipro.billing_model;
DROP TABLE IF EXISTS vipro.adj_header;
DROP TABLE IF EXISTS vipro.adj_log;
DROP TABLE IF EXISTS vipro.sales_cancellation_history;
DROP TABLE IF EXISTS vipro.sales_commission_history;
DROP TABLE IF EXISTS vipro.case_route;
DROP TABLE IF EXISTS vipro.case_link;
DROP TABLE IF EXISTS vipro.case_activity;
DROP TABLE IF EXISTS vipro.case;
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
     , mon_off VARCHAR(1)
     , tue_off VARCHAR(1)
     , wed_off VARCHAR(1)
     , thu_off VARCHAR(1)
     , fri_off VARCHAR(1)
     , sat_off VARCHAR(1)
     , sun_off VARCHAR(1)
     , status VARCHAR(5)
     , PRIMARY KEY (institution_id)
);

--                                                                   Audit Log Tables
CREATE TABLE vipro.audit_log_header (
       hdr_id BIGINT NOT NULL AUTO_INCREMENT
     , PRIMARY KEY (hdr_id)
);

CREATE TABLE vipro.audit_log_det (
       det_id BIGINT NOT NULL AUTO_INCREMENT
     , hdr_id BIGINT NOT NULL
     , PRIMARY KEY (det_id)
);

ALTER TABLE vipro.audit_log_det
  ADD CONSTRAINT FK_audit_log_det_1
      FOREIGN KEY (hdr_id)
      REFERENCES vipro.audit_log_header (hdr_id);

--                                                                     Holiday Table
CREATE TABLE vipro.holiday (
       holiday_id BIGINT NOT NULL AUTO_INCREMENT
     , date DATE
     , description VARCHAR(30)
     , institution_id BIGINT NOT NULL
     , PRIMARY KEY (holiday_id)
);

ALTER TABLE vipro.holiday
  ADD CONSTRAINT FK_holiday_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

--                                                               User Profile Tables
CREATE TABLE vipro.user_profile (
       user_id BIGINT NOT NULL AUTO_INCREMENT
     , institution_id BIGINT NOT NULL
     , group_id VARCHAR(10) NOT NULL
     , username VARCHAR(20)
     , password VARCHAR(50)
     , name VARCHAR(30)
     , address VARCHAR(60)
     , staff_no VARCHAR(20)
     , department VARCHAR(10)
     , email CHAR(40)
     , mobile_no CHAR(20)
     , office_no CHAR(20)
     , invalid_password_count INT
     , special_handling CHAR(1)
     , last_login_datetime DATETIME
     , status VARCHAR(5)
     , PRIMARY KEY (user_id)
);

CREATE TABLE vipro.user_group (
       group_id VARCHAR(10) NOT NULL
     , group_name VARCHAR(30)
     , status VARCHAR(5)
     , PRIMARY KEY (group_id)
);

ALTER TABLE vipro.user_profile
  ADD CONSTRAINT FK_user_profile_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

ALTER TABLE vipro.user_profile
  ADD CONSTRAINT FK_user_profile_2
      FOREIGN KEY (group_id)
      REFERENCES vipro.user_group (group_id);

--                                                             User Permission Table
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

ALTER TABLE vipro.user_permission
  ADD CONSTRAINT FK_user_permission_1
      FOREIGN KEY (group_id)
      REFERENCES vipro.user_group (group_id);

ALTER TABLE vipro.user_permission
  ADD CONSTRAINT FK_user_permission_2
      FOREIGN KEY (permission_id)
      REFERENCES vipro.group_permission (permission_id);

--                                                            Document Reference Table
CREATE TABLE vipro.document_reference (
       id BIGINT NOT NULL AUTO_INCREMENT
     , doc_type CHAR(10)
     , filename VARCHAR(50)
     , file_content LONGBLOB
     , created_on DATETIME
     , created_by VARCHAR(100)
     , PRIMARY KEY (id)
);

--                                                                         Code Table
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

ALTER TABLE vipro.code_det
  ADD CONSTRAINT FK_code_det_1
      FOREIGN KEY (code_header_id)
      REFERENCES vipro.code_header (code_header_id);

--                                                                     Discount Table
CREATE TABLE vipro.discount (
       discount_id BIGINT NOT NULL  AUTO_INCREMENT
     , project_id BIGINT
     , description VARCHAR(30)
     , effective_date DATE
     , expiry_date DATE
     , discount_rate DEC(5, 2)
     , created_on DATETIME
     , status VARCHAR(5)
     , PRIMARY KEY (discount_id)
);

--                                                              Business Partner Table
CREATE TABLE vipro.business_partner (
       partner_id BIGINT NOT NULL AUTO_INCREMENT
     , institution_id BIGINT NOT NULL
     , partner_type VARCHAR(10)
     , business_registration_no VARCHAR(30)
     , registration_date DATE
     , company_code VARCHAR(10) 
     , company_name VARCHAR(60)
     , address_id BIGINT NULL
     , contact_person_title VARCHAR(10)
     , contact_person_name VARCHAR(50)
     , office_tel VARCHAR(20)
     , fax_no VARCHAR(20)
     , mobile_no VARCHAR(20)
     , email_address VARCHAR(30)
     , status VARCHAR(5)
     , PRIMARY KEY (partner_id)
);

--                                                                       Project Table
CREATE TABLE vipro.project (
       project_id BIGINT NOT NULL AUTO_INCREMENT
     , institution_id BIGINT NOT NULL
     , account_id BIGINT
     , project_name VARCHAR(40)
     , project_code VARCHAR(10)
     , property_type VARCHAR(20)
     , developer_id BIGINT null DEFAULT 0
     , due_days INTEGER
     , days_to_bill INTEGER
     , include_off_day VARCHAR(1)
     , land_proprietor_id BIGINT null DEFAULT 0
     , person_in_charge VARCHAR(30)
     , pic_id BIGINT
     , pic_mobile_no VARCHAR(20)
     , report_group VARCHAR(20)
     , address1 VARCHAR(40)
     , address2 VARCHAR(40)
     , address3 VARCHAR(40)
     , address4 VARCHAR(40)
     , postcode VARCHAR(10)
     , city VARCHAR(20)
     , state VARCHAR(5)
     , country VARCHAR(5)
     , project_office_tel_no VARCHAR(20)
     , project_office_fax_no VARCHAR(20)
     , location_longtitude VARCHAR(15)
     , location_latitude VARCHAR(15)
     , location_city VARCHAR(20)
     , location_state VARCHAR(20)
     , location_country VARCHAR(5)
     , collection_interest_rate NUMERIC(5, 2)
     , staff_booking_fee DEC(7, 2)
     , public_booking_fee NUMERIC(7, 2)
     , discount_rate DEC(11,2)
     , sales_commission DEC(11,2)
     , late_pymt_int_rate DEC(5, 2)
     , late_pymt_fee DEC(7, 2)
     , maintenance_fee_rate NUMERIC(5, 2)
     , start_date DATE
     , launch_date DATE
     , end_date DATE
     , tax_percentage DEC(5, 2)
     , billing_model_code VARCHAR(10)
     , changed_by BIGINT
     , date_changed DATE
     , status VARCHAR(10)
     , PRIMARY KEY (project_id)
);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

--                                                             Project Inventory Table
CREATE TABLE vipro.project_inventory (
       inventory_id BIGINT NOT NULL AUTO_INCREMENT
     , project_id BIGINT NOT NULL
     , unit_no VARCHAR(12)
     , pt_no VARCHAR(20)
     , hsd_no VARCHAR(20)
     , block_no VARCHAR(8)
     , level VARCHAR(5)
     , layout_type VARCHAR(5)
     , orientation VARCHAR(5)
     , facing VARCHAR(5)
     , view VARCHAR(5)
     , land_area INT
     , built_up_area INT
     , purchase_price DEC(11, 2)
     , discount_amount NUMERIC(11, 2)
     , net_price DEC(11,2) NOT NULL
     , discount_rate DEC(5,2)
     , redemption_amount DEC(11, 2)
     , redemption_paid_todate DATE
     , assessment DEC(7, 2)
     , quit_rent DEC(7, 2)
     , legal_fee DEC(7, 2)
     , disbursement_fee DEC(9, 2)
     , address_id BIGINT
     , property_title_type VARCHAR(10)
     , strata_title_obtained_date DATE
     , key_handover_date DATE
     , dnc_date DATE
     , development_stage DEC(3)
     , change_user_id BIGINT
     , status_change_date DATE
     , property_status VARCHAR(5)
     , PRIMARY KEY (inventory_id)
);

ALTER TABLE vipro.project_inventory
  ADD CONSTRAINT FK_project_inventory_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

--                                                           Progressive Billing Table

CREATE TABLE vipro.progressive_billing (
       schedule_id BIGINT NOT NULL AUTO_INCREMENT
     , account_id BIGINT NOT NULL
     , seq_no DECIMAL(2)
     , stage_no VARCHAR(10)
     , stage_description VARCHAR(120)
     , invoice_no VARCHAR(10)
     , percentage DEC(5, 2)
     , due_date DATE
     , interest_rate DEC(5, 2)
     , amount_billed DEC(9, 2)
     , date_billed DATE
     , payment_due_date DATE
     , date_paid DATE
     , overdue_interest DEC(7, 2)
     , financier_portion DEC(9,2)
     , financier_invoice_no VARCHAR(10)
     , status VARCHAR(5)
     , txn_reversal_id BIGINT(20)
     , partial_paid_amount DECIMAL(11,2)
     , PRIMARY KEY (schedule_id)
);

--                                                                        Accont Table
CREATE TABLE vipro.account (
       account_id BIGINT NOT NULL AUTO_INCREMENT
     , customer_id BIGINT NOT NULL
     , inventory_id BIGINT NOT NULL
     , account_type VARCHAR(5)
     , attended_by BIGINT
     , sales_person_id BIGINT(20)
     , sales_person VARCHAR(40)
     , corr_addr_cust_id BIGINT
     , registration_fee DEC(9, 2)
     , registration_no VARCHAR(20)
     , date_purchased DATE
     , purchase_price DEC(11, 2)
     , discounted_amount DEC(11, 2)
     , net_price DEC(11, 2)
     , commission_amount DEC(7, 2)
     , commission_paid_date DATE
     , source VARCHAR(5)
     , purchase_type VARCHAR(5)
     , panel_bank_id VARCHAR(5) 
     , loan_amount DEC(11, 2)
     , total_payment_todate DEC(11, 2)
     , account_balance DEC(11, 2)
     , late_pymt_int_rate DEC(5 ,2)
     , late_pymt_fee DEC(7 ,2)
     , accrual_interest DEC(7 ,2)
     , redemption_bank_id BIGINT
     , bank_redemption_sum DEC(11, 2)
     , bank_redemption_todate DEC(11, 2)
     , cancel_fee DEC(9,2)
     , cancel_tax DEC(9,2)
     , cancel_refund_net_amt DEC(9,2)
     , cancel_doc_id BIGINT
     , cancelled_reason VARCHAR(5)
     , spa_signed_date DATE
     , spa_stamped_date DATE
     , spa_verified_by BIGINT
     , spa_verified_date DATE
     , spa_solicitor_id BIGINT
     , spa_ref_no VARCHAR(50)
     , LO_signed_date DATE
     , LO_verified_date DATE
     , LO_verified_by BIGINT
     , financier_id BIGINT
     , financier_ref VARCHAR(50)
     , LA_signed_date DATE
     , LA_stamped_date DATE
     , LA_verified_by BIGINT
     , LA_verified_date DATE
     , LA_solicitor_id BIGINT
     , la_ref_no VARCHAR(50)
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
     , book_pymt_amount DEC(9,2)
     , book_pymt_method VARCHAR(5)
     , book_pymt_card_chq_no VARCHAR(20)
     , book_pymt_bank VARCHAR(5)
     , customer_id2 BIGINT
     , customer_id3 BIGINT
     , customer_id4 BIGINT
     , customer_id5 BIGINT
     , borrower_id1 BIGINT 
     , borrower_id2 BIGINT
     , campaign_code VARCHAR(5) 
     , debtor_account VARCHAR(12)
     , remark VARCHAR(300)
     , changed_by BIGINT
     , date_changed DATE
     , account_status VARCHAR(5)
     , PRIMARY KEY (account_id)
);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_3
      FOREIGN KEY (inventory_id)
      REFERENCES vipro.project_inventory (inventory_id);

--                                                                      Customer Table

CREATE TABLE vipro.customer (
       customer_id BIGINT NOT NULL AUTO_INCREMENT
     , institution_id BIGINT 
     , title VARCHAR(10)
     , full_name VARCHAR(60)
     , customer_category VARCHAR(5)
     , identity_type VARCHAR(5)
     , identity_no VARCHAR(15)
     , address_id BIGINT
     , special_handling VARCHAR(5)
     , business_partner BIGINT
     , race VARCHAR(5)
     , citizenship VARCHAR(5)
     , bumi_indicator VARCHAR(5)
     , sex VARCHAR(5)
     , marital_status VARCHAR(5)
     , employer_name VARCHAR(60)
     , contact_Person VARCHAR(30)
     , mobile_no VARCHAR(20)
     , house_tel_no VARCHAR(15)
     , office_tel_no VARCHAR(15)
     , fax_no VARCHAR(15)
     , email VARCHAR(40)
     , communication_type VARCHAR(5)
     , language VARCHAR(5)
     , date_of_birth DATE
     , remarks VARCHAR(300)
     , created_by BIGINT(20) NULL
     , date_created DATE
     , customer_status VARCHAR(5)
     , PRIMARY KEY (customer_id)
);

ALTER TABLE vipro.customer
  ADD CONSTRAINT FK_customer_1
      FOREIGN KEY (institution_id)
      REFERENCES vipro.institution (institution_id);

--                                                                       Address Table

CREATE TABLE vipro.address (
       address_id BIGINT NOT NULL AUTO_INCREMENT
     , address_type VARCHAR(5)
     , address_line_1 VARCHAR(40)
     , address_line_2 VARCHAR(40)
     , address_line_3 VARCHAR(40)
     , address_line_4 VARCHAR(40)
     , postcode VARCHAR(10)
     , city VARCHAR(20)
     , state VARCHAR(20)
     , country VARCHAR(5)
     , created_on DATE
     , created_by VARCHAR(20)
     , customer_id BIGINT(20) 
     , account_id BIGINT
     , PRIMARY KEY (address_id)
);

ALTER TABLE vipro.address
  ADD CONSTRAINT FK_address_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.address
  ADD CONSTRAINT FK_address_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

--                                                           Transaction History Table
CREATE TABLE vipro.transaction_history (
       transaction_id BIGINT NOT NULL AUTO_INCREMENT
     , account_id BIGINT NOT NULL
     , transaction_code VARCHAR(6) NOT NULL
     , transaction_date DATETIME
     , amount DEC(9,2)
     , financier_portion DEC(9,2)
     , financier_invoice_no VARCHAR(10)
     , transaction_description VARCHAR(40)
     , ref_no VARCHAR(50)
     , invoice_no VARCHAR(10)
     , posting_date DATE
     , posted_by BIGINT(20)
     , statement_date DATE
     , payment_method varchar(5)
     , bank varchar(5)
     , card_cheque_no varchar(20)
     , chq_date DATE
     , txn_reversal_id BIGINT
     , status VARCHAR(5)
     , PRIMARY KEY (transaction_id)
);

ALTER TABLE vipro.transaction_history
  ADD CONSTRAINT FK_transaction_history_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

--                                                             Transaction Group Table
CREATE TABLE vipro.transaction_group (
       transaction_group_id BIGINT NOT NULL AUTO_INCREMENT
     , transaction_code VARCHAR(6) NOT NULL
     , transaction_date DATE
     , group_type VARCHAR(5)
     , total_amount DEC(9, 2)
     , total_transaction NUMERIC(9, 2)
     , PRIMARY KEY (transaction_group_id)
);

--                                                                   Transaction Code
CREATE TABLE vipro.transaction_code (
       transaction_code VARCHAR(6) NOT NULL
     , name VARCHAR(40)
     , code_type VARCHAR(5)
     , accounting_group VARCHAR(5)
     , status VARCHAR(5)
     , PRIMARY KEY (transaction_code)
);

--                                                         Contact Table
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

--                                                                        case table
CREATE TABLE vipro.case (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , creation_date DATE
     , case_type VARCHAR(10)
     , subject VARCHAR(60)
     , project_id BIGINT(20)
     , account_id BIGINT(20)
     , assignee_group_id VARCHAR(10) 
     , due_date DATE
     , notification CHAR(1)
     , message VARCHAR(300)
     , sender_id BIGINT NOT NULL
     , assignee_id BIGINT(20) NULL
     , customer_id BIGINT NOT NULL
     , creator_id BIGINT NOT NULL
     , status VARCHAR(5)
     , PRIMARY KEY (case_id)
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

--                                                                      case activity
CREATE TABLE vipro.case_activity (
       activity_id BIGINT NOT NULL AUTO_INCREMENT
     , action_by BIGINT
     , action_code VARCHAR(10)
     , action_time DATETIME
     , old_due_date DATE
     , case_id BIGINT NOT NULL
     , note VARCHAR(300)
     , action VARCHAR(5) NOT NULL
     , primary key (activity_id)
);

ALTER TABLE vipro.case_activity
  ADD CONSTRAINT FK_case_activity_1
      FOREIGN KEY (case_id)
      REFERENCES vipro.case (case_id);

--                                                                        case route
CREATE TABLE vipro.case_route (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , case_type VARCHAR(10)
     , case_status VARCHAR(10)
     , project_id BIGINT
     , group_id VARCHAR(10)
     , user_id BIGINT
     , due_day DECIMAL(3)
     , target_group_id VARCHAR(10)
     , target_user_id BIGINT
     , next_action VARCHAR(10)
     , changed_by BIGINT
     , last_changed DATE
     , PRIMARY KEY (case_id)
);

--                                                                        case link
CREATE TABLE vipro.case_link (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , case_type VARCHAR(10)
     , case_link VARCHAR(100)
     , case_status VARCHAR(5) NULL
     , PRIMARY KEY (case_id)
);

--                                                          Sales Cancellation History

CREATE TABLE vipro.sales_cancellation_history (
       cancellation_id BIGINT(20) NOT NULL AUTO_INCREMENT 
     , inventory_id BIGINT(20) NOT NULL 
     , account_id BIGINT(20)
     , registration_fee DECIMAL(7,2) NULL 
     , cancelled_reason VARCHAR(5) NULL DEFAULT NULL 
     , cancel_fee DECIMAL(9,2) NULL DEFAULT NULL 
     , cancel_tax DECIMAL(9,2) NULL DEFAULT NULL 
     , cancel_refund_net_amt DECIMAL(9,2) NULL DEFAULT NULL 
     , cancel_doc_id BIGINT(20) NULL DEFAULT NULL 
     , submitted_by BIGINT
     , date_submitted DATE
     , approved_by BIGINT
     , date_approved DATE
     , status VARCHAR(5)
     , PRIMARY KEY (cancellation_id) 
     , INDEX FK_sales_cancellation_history_1_idx (inventory_id ASC) 
     , CONSTRAINT FK_sales_cancellation_history_1
       FOREIGN KEY (inventory_id)
       REFERENCES vipro.project_inventory (inventory_id)
       ON DELETE RESTRICT
       ON UPDATE RESTRICT)
       DEFAULT CHARACTER SET = utf8;

--                                                           Sales Commission History
CREATE TABLE vipro.sales_commission (
       commission_id BIGINT NOT NULL AUTO_INCREMENT
     , project_id BIGINT
     , description VARCHAR(30)
     , effective_date DATETIME
     , type VARCHAR(5)
     , amount_or_rate DEC(6, 2)
     , created_on DATETIME
     , status VARCHAR(5)
     , PRIMARY KEY (commission_id)
);

CREATE TABLE vipro.sales_commission_history (
       commission_id BIGINT(20) NOT NULL AUTO_INCREMENT
     , account_id BIGINT(20) NOT NULL
     , project_id BIGINT(20) NULL
     , batch_no BIGINT (20)
     , purchase_price DECIMAL(9, 2)
     , claim_percent DEC(5,2) NULL
     , claim_amount DEC(9,2)
     , submitted_by BIGINT(20) NULL
     , date_submitted DATE NULL
     , verified_by BIGINT(20)
     , date_verified DATE 
     , approved_by BIGINT
     , date_approved DATE NULL
     , claim_status VARCHAR(5) NULL
     , changed_by BIGINT(20) NULL
     , date_changed DATE NULL
     , PRIMARY KEY (commission_id)
     , INDEX FK_commission_1_idx (account_id ASC)
     , CONSTRAINT FK_sales_commission_history_1
       FOREIGN KEY (account_id)
       REFERENCES vipro.account (account_id)
       ON DELETE RESTRICT
       ON UPDATE RESTRICT
);

--                                                             Price Adjustment Tables
CREATE TABLE vipro.adj_header (
       adj_header_id BIGINT(20) NOT NULL AUTO_INCREMENT
     , project_id BIGINT(20) NOT NULL
     , adj_type VARCHAR(5)
     , adj_amount DEC(11, 2)
     , adj_percent DEC(5,2)
     , total_unit_adj BIGINT
     , total_bef_adj DEC(15, 2)
     , total_aft_adj DEC(15, 2)
     , submitted_by BIGINT(20)
     , date_submitted DATE
     , approved_by BIGINT
     , date_approved DATE
     , status VARCHAR(5)
     , PRIMARY KEY (adj_header_id)
);

ALTER TABLE vipro.adj_header
  ADD CONSTRAINT FK_adj_header_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

CREATE TABLE vipro.adj_log (
      adj_log_id BIGINT(20) NOT NULL AUTO_INCREMENT
     , adj_header_id BIGINT (20) NOT NULL
     , inventory_id BIGINT(20) NOT NULL
     , purchase_price_bef DEC(11, 2)
     , discount_amount_bef DEC(5, 2)
     , net_adj_bef DEC(11, 2)
     , discount_rate_bef DEC(5, 2)
     , purchase_price_aft DEC(11, 2)
     , discount_amount_aft DEC(5, 2)
     , net_adj_aft DEC(11, 2)
     , discount_rate_aft DEC(5, 2)
     , status VARCHAR(5) NULL
     , PRIMARY KEY (adj_log_id)
);

ALTER TABLE vipro.adj_log
  ADD CONSTRAINT FK_adj_log_1
      FOREIGN KEY (adj_header_id)
      REFERENCES vipro.adj_header (adj_header_id);

--                                                                  Billing Model Table

CREATE TABLE vipro.billing_model (
       model_id BIGINT NOT NULL AUTO_INCREMENT
     , billing_model_code VARCHAR(10)
     , billing_seq INT
     , stage VARCHAR(10)
     , description VARCHAR(120)
     , billing_percentage DECIMAL(5, 2)
     , changed_by BIGINT
     , date_changed DATE   
     , status VARCHAR(5)
     , PRIMARY KEY (model_id)
);

--                                                                   Sequence No Table
CREATE TABLE vipro.seq_no (
       seq_type VARCHAR(5)
     , next_seq BIGINT
     , project_code VARCHAR(10) NOT NULL
     , seq_id BIGINT(20) NOT NULL AUTO_INCREMENT
     , PRIMARY KEY (seq_id)
);

--                                                                 billing model header
CREATE TABLE vipro.billing_model_header (
       billing_header_id BIGINT NOT NULL AUTO_INCREMENT
     , billing_model_code VARCHAR(10)
     , description VARCHAR(30)
     , changed_by BIGINT
     , date_changed DATE   
     , status VARCHAR(5)
     , PRIMARY KEY (billing_header_id)
);

--                                                                                                                Bank Account
CREATE TABLE vipro.bank_account (
       bank_account_id BIGINT NOT NULL  AUTO_INCREMENT
     , project_id BIGINT
     , bill_to VARCHAR(1)
     , top_text VARCHAR(120)
     , bottom_text VARCHAR(120)
     , holder_name VARCHAR (60)
     , holder_address_id BIGINT
     , bank1_name VARCHAR(40)
     , bank1_account_no VARCHAR (19)
     , bank1_swift_code VARCHAR (12)
     , bank1_branch_address VARCHAR (50)
     , bank2_name VARCHAR(40)
     , bank2_account_no VARCHAR (19)
     , bank2_swift_code VARCHAR (12)
     , bank2_branch_address VARCHAR (50)
     , changed_by BIGINT
     , date_changed DATE
     , status VARCHAR(5)
     , PRIMARY KEY (bank_account_id)
);

ALTER TABLE vipro.bank_account
  ADD CONSTRAINT FK_bank_account_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

--                                                                                                          Unit Mapping  
CREATE TABLE vipro.unit_mapping (
       unit_no_bef VARCHAR(12)
     , unit_no_aft VARCHAR(12)
     , PRIMARY KEY (unit_no_bef)
);


-- Other Key Creation

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

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_developer_id
      FOREIGN KEY (developer_id)
      REFERENCES vipro.business_partner (partner_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_land_proprietor_id
      FOREIGN KEY (land_proprietor_id)
      REFERENCES vipro.business_partner (partner_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_pic_id
      FOREIGN KEY (pic_id)
      REFERENCES vipro.user_profile (user_id);

alter table vipro.project_inventory add foreign key FK_project_inventory(address_id) references address (address_id);

ALTER TABLE `vipro`.`document_reference` ADD COLUMN `account_id` BIGINT(20) NULL DEFAULT NULL  AFTER `created_by` , 
  ADD CONSTRAINT `FK_document_reference_1`
  FOREIGN KEY (`account_id` )
  REFERENCES `vipro`.`account` (`account_id` )
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
, ADD INDEX `FK_document_reference_1_idx` (`account_id` ASC) ;

ALTER TABLE `vipro`.`business_partner` 
  ADD CONSTRAINT `FK_business_partner_2`
  FOREIGN KEY (`address_id` )
  REFERENCES `vipro`.`address` (`address_id` )
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
, ADD INDEX `FK_business_partner_2_idx` (`address_id` ASC) ;

ALTER TABLE vipro.customer
  ADD CONSTRAINT FK_customer_2
      FOREIGN KEY (business_partner)
      REFERENCES vipro.business_partner (partner_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_2
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.progressive_billing
  ADD CONSTRAINT FK_progressive_billing_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

ALTER TABLE vipro.account
  ADD CONSTRAINT FK_account_1
      FOREIGN KEY (customer_id)
      REFERENCES vipro.customer (customer_id);

ALTER TABLE vipro.transaction_history
  ADD CONSTRAINT FK_transaction_history_2
      FOREIGN KEY (transaction_code)
      REFERENCES vipro.transaction_code (transaction_code);

ALTER TABLE vipro.transaction_group
  ADD CONSTRAINT FK_transaction_group_1
      FOREIGN KEY (transaction_code)
      REFERENCES vipro.transaction_code (transaction_code);