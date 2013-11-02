-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- + To create & update tables for Sales Admin Module                        +
-- +-------------------------------------------------------------------------+

DROP TABLE IF EXISTS vipro.billing_model;

CREATE TABLE vipro.billing_model (
       model_id BIGINT NOT NULL AUTO_INCREMENT
     , billing_model_code VARCHAR(1)
     , billing_seq INT
     , stage VARCHAR(5)
     , description VARCHAR(120)
     , billing_percentage DECIMAL(5, 2)
     , changed_by BIGINT
     , date_changed DATE   
     , status VARCHAR(5)
     , PRIMARY KEY (model_id)
);

-- Modale A Create Billing Model Parameter Data
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 1, '1', 'Upon Signing of Sales & Purchase Agreement.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 2, '2(a)', 'Work below ground level.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 3, '2(b)', 'Structural framework.',
             15.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 4, '2(c)', 'Walls with door and window frames.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 5, '2(d)', 'Roofing, electrical wiring, plumbing, internal telephone trunking & cabling works.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 6, '2(e)', 'Internal & external plastering.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 7, '2(f)', 'Sewerage works.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 8, '2(g)', 'Drains.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 9, '2(h)', 'Roads.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 10, '3', 'Vacant possession.',
             12.50, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 11, '4', 'Application for subdivision of the Building/Land.',
             2.50, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 12, '5(a)', 'Stakeholder sum.',
             2.50, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('A', 13, '5(b)', 'Stakeholder sum.',
             2.50, null, null, 'SSACT');

UPDATE vipro.project
   SET billing_model_code = 'A'
 WHERE project_id = 1;


-- Create running sequence no to control the next sequence number
CREATE TABLE vipro.seq_no (
       seq_type VARCHAR(5)
     , next_seq BIGINT
     , PRIMARY KEY (seq_type)
);

INSERT INTO vipro.seq_no (seq_type, next_seq)
     VALUES ('SNPRG', 1);

INSERT INTO vipro.seq_no (seq_type, next_seq)
     VALUES ('SNRNB', 1);

-- Progressive Billing Status Code
INSERT INTO code_header VALUES ('PB', 'Progressive Billing Status');
INSERT INTO code_det VALUES ('PB', 'PBACT', 'Active', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCLS', 'Closed - Refunded', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCXN', 'Cancelled', 'SSACT');

-- Add due days into Project File
alter table vipro.project add due_days integer after developer_id;

-- Added on 31/10/13
alter table vipro.project add pic_id BIGINT after person_in_charge;
ALTER TABLE vipro.project
  ADD CONSTRAINT FK_project_pic_id
      FOREIGN KEY (pic_id)
      REFERENCES vipro.user_profile (user_id);

update `vipro`.`project` set `due_days`='14' where `project_id`='1';

insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
     values (  '500001',  'Add Progressive Billing',  'DR',  NULL,  'SSACT' )

ALTER TABLE `vipro`.`transaction_history` CHANGE `ref_no` `ref_no` VARCHAR(50) CHARSET latin1 COLLATE latin1_swedish_ci NULL;

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

