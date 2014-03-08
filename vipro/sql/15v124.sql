-- Progressive Billing Project Status
INSERT INTO code_header VALUES ('PJ', 'THE STATUS OF THE PROJECT');
INSERT INTO code_det VALUES ('PJ', 'PJACT', 'ACTIVE', 'SSACT');
INSERT INTO code_det VALUES ('PJ', 'PJCOM', 'COMPLETED', 'SSACT');
INSERT INTO code_det VALUES ('PJ', 'PJCAN', 'CANCELLED', 'SSACT');

UPDATE vipro.project set status = "PJACT" where project_id > 0;

-- Booking fee usage
INSERT INTO code_header VALUES ('BU', 'DENOTE THE USAGES OF BOOKING FEE');
INSERT INTO code_det VALUES ('BU', 'BUMAI', 'TO PAY MAINTENANCE FEE', 'SSACT');
INSERT INTO code_det VALUES ('BU', 'BURFD', 'REFUND CASH AFTER LAST BILLING IS PAID', 'SSACT');

INSERT INTO code_det VALUES ('PU', 'PUPEN', 'PENDING LOAN APPROVAL', 'SSACT');

-- Add new fields Sales Person Id in Account Table
ALTER TABLE vipro.account add sales_person_id BIGINT(20) after attended_by;
ALTER TABLE vipro.account CHANGE COLUMN sales_person sales_person VARCHAR(40);



