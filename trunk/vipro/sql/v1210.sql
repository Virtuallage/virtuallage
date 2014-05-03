CREATE TABLE vipro.billing_model_header (
       billing_header_id BIGINT NOT NULL AUTO_INCREMENT
     , billing_model_code VARCHAR(10)
     , description VARCHAR(30)
     , changed_by BIGINT
     , date_changed DATE   
     , status VARCHAR(5)
     , PRIMARY KEY (billing_header_id)
);

-- 2014/03/03 BY SEAN --
INSERT INTO `vipro`.`code_header` (`code_header_id`, `name`) VALUES ('PR', 'PARTNER TYPE');

INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRBNK', 'BANK', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRDEV', 'DEVELOPER', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRLND', 'LAND OWNER', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRSOL', 'SOLICITOR', 'SSACT');

INSERT INTO vipro.billing_model_header (billing_model_code,description,status)
     VALUES ("A", "V-RESIDENSI PROJECTS", "SSACT");
     
INSERT INTO vipro.billing_model_header (billing_model_code,description,status)
     VALUES ("DPMJ", "DPRISTINE PROJECT", "SSACT");
     
UPDATE business_partner set partner_type = "PRBNK" where partner_type = "BANK";
UPDATE business_partner set partner_type = "PRSOL" where partner_type = "SOLI";
UPDATE business_partner set partner_type = "PRDEV" where partner_type = "DEVP";
UPDATE business_partner set partner_type = "PRLND" where partner_type = "LAND";

