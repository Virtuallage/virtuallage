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


