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

-- create foreign key in billing model table for access from account table
ALTER TABLE vipro.billing_model
  ADD CONSTRAINT FK_billing_model_1
      FOREIGN KEY (billing_model_code)
      REFERENCES vipro.account (billing_model_code);

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


alter table vipro.business_partner add company_code VARCHAR(10) after registration_date;


CREATE TABLE vipro.seq_no (
       seq_type VARCHAR(5)
     , next_seq BIGINT
     , PRIMARY KEY (seq_type)
);
