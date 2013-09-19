-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- + To create table for Price Adjustment History log                        +
-- +-------------------------------------------------------------------------+

DROP TABLE IF EXISTS vipro.adj_header;
DROP TABLE IF EXISTS vipro.adj_log;

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
      
-- Create the Available General Codes for adjustment type (adj_type of adj_header table)
INSERT INTO vipro.code_header (code_header_id, name) VALUES ( 'AD', 'Adjustment Type');
INSERT INTO vipro.code_det VALUES ('AD', 'ADAMT', 'Change By Fixed Amount', 'SSACT');
INSERT INTO vipro.code_det VALUES('AD', 'ADPER', 'Change By Percentage', 'SSACT');
INSERT INTO vipro.code_det VALUES ('AD', 'ADDIS', 'Change Discount Rate', 'SSACT');
