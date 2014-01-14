INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBREV', 'Reversal', 'SSACT'); 
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBPAI', 'Full Payment', 'SSACT'); 
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PB', 'PBPAR', 'Partial Payment', 'SSACT'); 
ALTER TABLE `vipro`.`progressive_billing` ADD COLUMN `txn_reversal_id` BIGINT(20) NULL AFTER `status`; 

ALTER TABLE `vipro`.`progressive_billing` ADD COLUMN `partial_paid_amount` DECIMAL(11,2) NULL AFTER `txn_reversal_id`;