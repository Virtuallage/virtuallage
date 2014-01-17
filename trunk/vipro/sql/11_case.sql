ALTER TABLE vipro.case 
CHANGE COLUMN name project_id BIGINT(20) NULL DEFAULT NULL ,
CHANGE COLUMN mobile_no unit_id BIGINT(20) NULL DEFAULT NULL ,
CHANGE COLUMN email assignee_group_id VARCHAR(10) NULL DEFAULT NULL ;

ALTER TABLE vipro.case_activity 
 ADD COLUMN action VARCHAR(5) NOT NULL AFTER note;

ALTER TABLE vipro.case 
 ADD COLUMN message VARCHAR(300) after notification;

DROP TABLE IF EXISTS vipro.case_route;
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

DROP TABLE IF EXISTS vipro.case_link;
CREATE TABLE vipro.case_link (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , case_type VARCHAR(10)
     , case_link VARCHAR(100)
     , case_status VARCHAR(5) NULL
     , PRIMARY KEY (case_id)
);

ALTER TABLE vipro.case 
CHANGE COLUMN unit_id account_id BIGINT(20) NULL DEFAULT NULL ;

ALTER TABLE vipro.case 
DROP FOREIGN KEY FK_case_2;
ALTER TABLE vipro.case 
CHANGE COLUMN assignee_id assignee_id BIGINT(20) NULL ;
ALTER TABLE vipro.case 
ADD CONSTRAINT FK_case_2
  FOREIGN KEY (assignee_id)
  REFERENCES vipro.user_profile (user_id);
  
  
----2014----
UPDATE vipro.project SET pic_id='14' WHERE project_id='1';

UPDATE vipro.code_det SET description='Opened' WHERE code_header_id='CS' and code='CSOPN';

INSERT INTO vipro.case_route (case_type, case_status, target_group_id, next_action) 
     VALUES ('CYCOM', 'CSVER', 'PIC_ADM', 'CSAPP');
INSERT INTO vipro.case_route (case_type, case_status, target_group_id, next_action) 
     VALUES ('CYCOM', 'CSAPP', 'ACCT', 'CSPRO');
INSERT INTO vipro.case_route (case_type, case_status) 
     VALUES ('CYCOM', 'CSREJ');
INSERT INTO case_route (case_type, case_status, target_group_id, next_action)
     values ('CYPAY', 'CSSMT', 'ACCT', 'CSPRO');
INSERT INTO case_route (case_type, case_status, target_group_id, next_action)
     values ('CYCAN', 'CSAPP', 'ACCT', 'CSPRO');


-- Data Loading
DELETE FROM code_det where code_header_id = 'CY'; 

INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYPAY', 'Pay Booking Fee', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYCAN', 'Sales Cancellation', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CY', 'CYCOM', 'Sales Commission Claim', 'SSACT');

INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CS', 'CSSMT', 'Case Submitted', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CS', 'CSCAN', 'Cancelled', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CS', 'CSAPP', 'Approved', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CS', 'CSREJ', 'Rejected', 'SSACT');
INSERT INTO code_det (code_header_id, code, description, status)
	 VALUES ('CS', 'CSVER', 'Verified', 'SSACT');

INSERT INTO user_group (group_id, group_name, status)
	 VALUES ('ACCT', 'Account Department', 'SSACT');

INSERT INTO case_link 
      value (1, 'CYPAY', '/secured/sales/cancel/cancelPropertyListApproval.xhtml');
INSERT INTO case_link 
      value (2, 'CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml');
INSERT INTO case_link 
      value (3, 'CYCOM', '/secured/sales/commission/salesCommissionApproval.xhtml');
      
      
----2014 Jan 17 AnnAnn----
INSERT INTO vipro.code_det (code_header_id, code, description, status) VALUES ('CS', 'CSCAN', 'Cancelled', 'SSACT');
INSERT INTO vipro.code_det (code_header_id, code, description, status) VALUES ('CS', 'CSCIP', 'Cancelling', 'SSACT');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCAN', '/secured/sales/cancel/cancelPropertyListApproval.xhtml', 'CSAPP');
INSERT INTO vipro.case_link (case_type, case_status) VALUES ('CYPAY', 'CSCIP');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionVerification.xhtml', 'CSOPN');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionVerification.xhtml', 'CSSMT');
INSERT INTO vipro.case_link (case_type, case_link, case_status) VALUES ('CYCOM', '/secured/sales/commission/salesCommissionApproval.xhtml', 'CSVER');


