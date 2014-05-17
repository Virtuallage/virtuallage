INSERT INTO vipro.user_group VALUES ('SADM_STF', 'SALES ADMIN STAFF', 'SSACT');

ALTER TABLE `vipro`.`account` 
CHANGE COLUMN `panel_bank_id` `panel_bank_id` VARCHAR(5) NULL DEFAULT NULL ;

-- Development Mapping
UPDATE vipro.account SET panel_bank_in = "BKRHB" WHERE panel_bank_id = "5";
UPDATE vipro.account SET panel_bank_in = "BKAFB" WHERE panel_bank_id = "6";
UPDATE vipro.account SET panel_bank_in = "BKCIM" WHERE panel_bank_id = "7";
UPDATE vipro.account SET panel_bank_in = "BKAMB" WHERE panel_bank_id = "8";
UPDATE vipro.account SET panel_bank_in = "BKPBB" WHERE panel_bank_id = "10";
UPDATE vipro.account SET panel_bank_in = "BKHLB" WHERE panel_bank_id = "11";
UPDATE vipro.account SET panel_bank_in = "BKHSB" WHERE panel_bank_id = "12";
UPDATE vipro.account SET panel_bank_in = "BKMBS" WHERE panel_bank_id = "13";
UPDATE vipro.account SET panel_bank_in = "BKABB" WHERE panel_bank_id = "14";
UPDATE vipro.account SET panel_bank_in = "BKMBB" WHERE panel_bank_id = "15";

-- Production Mapping
-- INSERT INTO vipro.code_det (code_header_id, code, description, status) 
--     VALUES ('BK', 'BKRHI', 'RHB ISLAMIC', 'SSACT'); 

-- INSERT INTO vipro.code_det (code_header_id, code, description, status) 
--     VALUES ('BK', 'BKAMI', 'AMBANK ISLAMIC', 'SSACT'); 

-- UPDATE vipro.account SET panel_bank_in = "BKRHB" WHERE panel_bank_id = "5";
-- UPDATE vipro.account SET panel_bank_in = "BKRHI" WHERE panel_bank_id = "6";
-- UPDATE vipro.account SET panel_bank_in = "BKAMB" WHERE panel_bank_id in ("7", "24");
-- UPDATE vipro.account SET panel_bank_in = "BKAMI" WHERE panel_bank_id in ("8", "25");
