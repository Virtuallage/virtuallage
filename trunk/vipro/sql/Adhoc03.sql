-- Load for Redemption Bank Information Enhancement
UPDATE vipro.code_det SET description = "REDEMPTION BANK" where code = "PRBID" AND code_header_id = "PR";
UPDATE vipro.code_det SET description = "PENDING" where code = "TSPEN" AND code_header_id = "TS";  

-- Add Transaction Type into Transaction History Table (DR/CR)
ALTER TABLE vipro.transaction_history ADD code_type VARCHAR(2) after amount;

UPDATE vipro.transaction_history set code_type = "CR" where transaction_code in 
	("100001","100002","100003","110001","120001","120002","300001","300002","300003","310001","510001","510011");

UPDATE vipro.transaction_history set code_type = "DR" where transaction_code in 
	("110002","200001","200002","200003","210001","220001","220002","400001","400002","400003","400004","500001","500002");
