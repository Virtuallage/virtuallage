DROP TABLE IF EXISTS vipro.billing_model_header;

CREATE TABLE vipro.billing_model_header (
       billing_header_id BIGINT NOT NULL AUTO_INCREMENT
     , billing_model_code VARCHAR(10)
     , description VARCHAR(30)
     , changed_by BIGINT
     , date_changed DATE   
     , status VARCHAR(5)
     , PRIMARY KEY (billing_header_id)
);
