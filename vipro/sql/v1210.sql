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



