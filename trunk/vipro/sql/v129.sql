-- Add field in Transaction History Table to support split billing
ALTER TABLE vipro.transaction_history add financier_portion DEC(9,2) after amount;
ALTER TABLE vipro.transaction_history add financier_invoice_no VARCHAR(10) after financier_portion;

ALTER TABLE vipro.progressive_billing change purchaser_portion financier_portion DEC(9,2);
ALTER TABLE vipro.progressive_billing change purchaser_invoice_no financier_invoice_no VARCHAR(10);

-- Create Bank Account Information by Project. Support up to 2 bank account
DROP TABLE IF EXISTS vipro.bank_account;

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
      
INSERT INTO vipro.bank_account 
			(project_id, bill_to, top_text, bottom_text,holder_name, holder_address_id,
			bank1_name, bank1_account_no, bank1_swift_code, bank1_branch_address,
			bank2_name, bank2_account_no, bank2_swift_code, bank2_branch_address, status)
	VALUES (5, "P","For Telegraphic Transfer (TT):-", "Please email your transaction slip to alvin@mct.com.my & mei@mct.com.my", "D Pristine Medini Sdn Bhd", 123,
			"Affin Bank Berhad", "10063-0017-910", "PHBMMYKL", "USJ 10, Subang Jaya, Malaysia",
			"United Overseas Bank (Malaysia) Bhd", "165-301-4843", "UOVBMYKL", "USJ 10, Subang Jaya, Malaysia", "SSACT");
		
INSERT INTO vipro.bank_account 
			(project_id, bill_to, top_text, bottom_text,holder_name, holder_address_id,
			bank1_name, bank1_account_no, bank1_swift_code, bank1_branch_address, status)
	VALUES (5, "F","Developer Account Particulars:-", "Please email your transaction slip to alvin@mct.com.my & mei@mct.com.my", "D Pristine Medini Sdn Bhd", 123,
			"Affin Bank Berhad", "10063-0017-910", "PHBMMYKL", "USJ 10, Subang Jaya, Malaysia", "SSACT");


-- Create Mapping Unit No for VRSH
DROP TABLE IF EXISTS vipro.unit_mapping;

CREATE TABLE vipro.unit_mapping (
       unit_no_bef VARCHAR(12)
     , unit_no_aft VARCHAR(12)
     , PRIMARY KEY (unit_no_bef)
);

load data local infile 'admin\\Desktop\\UnitMapping.csv' 
 into table vipro.unit_mapping
 fields terminated by ','
 enclosed by '"'
 lines terminated by '\n'
 (unit_no_bef,unit_no_aft);
