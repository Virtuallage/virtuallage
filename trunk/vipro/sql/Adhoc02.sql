DROP TABLE IF EXISTS vipro.letter;
DROP TABLE IF EXISTS vipro.letter_history;

CREATE TABLE vipro.letter (
	  letter_id BIGINT NOT NULL AUTO_INCREMENT
    , project_id BIGINT NOT NULL
    , letter_code VARCHAR(5)
    , jasper_name VARCHAR(30)
    , date_created DATE
    , created_by BIGINT 
	, date_changed DATE
	, changed_by BIGINT
	, status VARCHAR(5)
	, PRIMARY KEY (letter_id)
);

ALTER TABLE vipro.letter
  ADD CONSTRAINT FK_letter_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);
      
INSERT INTO vipro.letter (project_id, letter_code, jasper_name, status, date_created, created_by)
value (1, 'LECAN', 'Sales_SalesCancellation.jasper', 'SSACT', 20140704, 2);

CREATE TABLE vipro.letter_history (
	  letter_history_id BIGINT NOT NULL AUTO_INCREMENT
	, account_id BIGINT
	, letter_id VARCHAR(20) NOT NULL
    , status VARCHAR(5)
    , date_created DATE
    , created_by BIGINT
	, PRIMARY KEY (letter_history_id)
);

ALTER TABLE vipro.letter_history
  ADD CONSTRAINT FK_letter_history_1
      FOREIGN KEY (account_id)
      REFERENCES vipro.account (account_id);


-- Load New Code Data (Letter Type)
INSERT INTO code_header VALUES ('LE', 'LETTER TYPE MODULE');
INSERT INTO code_det VALUES ( 'LE', 'LECAN', 'SALES CANCELLATION LETTER' , 'SSACT');

-- Load for Redemption Bank Information Enhancement
INSERT INTO code_det VALUES ( 'PR', 'PRBID', 'COMMON BANK USAGES' , 'SSACT');
UPDATE code_det SET description = "BILLING BANK" where code = "PRBNK";

