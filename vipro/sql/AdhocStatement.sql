DROP TABLE IF EXISTS vipro.statement;

CREATE TABLE vipro.statement (
	  statement_id BIGINT NOT NULL AUTO_INCREMENT
    , project_id BIGINT NOT NULL
    , jasper_name VARCHAR(30)
    , date_created DATE
    , created_by BIGINT 
	, status VARCHAR(5)
	, PRIMARY KEY (statement_id)
);

ALTER TABLE vipro.statement
  ADD CONSTRAINT FK_statement_1
      FOREIGN KEY (project_id)
      REFERENCES vipro.project (project_id);

ALTER TABLE vipro.transaction_history ADD statement_id BIGINT after statement_date;

ALTER TABLE vipro.transaction_history
  ADD CONSTRAINT FK_transaction_history_3
      FOREIGN KEY (statement_id)
      REFERENCES vipro.statement (statement_id);
      
