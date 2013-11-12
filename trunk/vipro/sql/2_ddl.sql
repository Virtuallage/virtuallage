-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Step 2: This SQL will perform the following: -                          |
-- | a. Alter Vipro Tables and Assign Keys                                   | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+

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
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);

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











-- **

ALTER TABLE vipro.discount
  ADD CONSTRAINT FK_discount_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

ALTER TABLE vipro.sales_commission
  ADD CONSTRAINT FK_sales_commission_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

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
      
-- 20130525
ALTER TABLE `vipro`.`document_reference` ADD COLUMN `account_id` BIGINT(20) NULL DEFAULT NULL  AFTER `created_by` , 
  ADD CONSTRAINT `FK_document_reference_1`
  FOREIGN KEY (`account_id` )
  REFERENCES `vipro`.`account` (`account_id` )
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
, ADD INDEX `FK_document_reference_1_idx` (`account_id` ASC) ;

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_developer_id
      FOREIGN KEY (developer_id)
      REFERENCES vipro.business_partner (partner_id);

ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_land_proprietor_id
      FOREIGN KEY (land_proprietor_id)
      REFERENCES vipro.business_partner (partner_id);


-- 290613 by MAX
ALTER TABLE `vipro`.`document_reference` CHANGE COLUMN `created_by` `created_by` VARCHAR(100) NULL DEFAULT NULL  ;


-- 121013 by MAX
ALTER TABLE `vipro`.`business_partner` CHANGE COLUMN `address` `address_id` BIGINT NULL  ;

ALTER TABLE `vipro`.`business_partner` 
  ADD CONSTRAINT `FK_business_partner_2`
  FOREIGN KEY (`address_id` )
  REFERENCES `vipro`.`address` (`address_id` )
  ON DELETE RESTRICT
  ON UPDATE RESTRICT
, ADD INDEX `FK_business_partner_2_idx` (`address_id` ASC) ;

ALTER TABLE `vipro`.`address` CHANGE COLUMN `customer_id` `customer_id` BIGINT(20) NULL  ;

-- 101113 by MAX
ALTER TABLE `vipro`.`sales_commission_history` ADD COLUMN `project_id` BIGINT(20) NULL  AFTER `account_id` ;
ALTER TABLE `vipro`.`sales_commission_history` CHANGE COLUMN `date_approved` `date_approved` DATE NULL  , ADD COLUMN `changed_by` BIGINT(20) NULL DEFAULT NULL  AFTER `claim_status` , ADD COLUMN `date_changed` DATE NULL  AFTER `changed_by` ;

-- 121113 by Bill
alter table vipro.account add borrower_id1 BIGINT after customer_id5;
alter table vipro.account add borrower_id2 BIGINT after borrower_id1;


