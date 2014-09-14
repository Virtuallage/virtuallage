-- Create New Field in Transaction Code, Transaction History & Account Tables
ALTER TABLE vipro.transaction_code ADD manual_entry VARCHAR(1) after code_type; 
ALTER TABLE vipro.transaction_history ADD user_id BIGINT(20) after txn_reversal_id; 
ALTER TABLE vipro.account ADD billing_amount_todate DEC(11, 2) after account_balance; 
ALTER TABLE vipro.account ADD billing_payment_todate DEC(11, 2) after total_payment_todate; 

INSERT INTO vipro.transaction_code VALUES ("800001", "DEBIT ADJUSTMENT", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800002", "ACCESS CARD", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800003", "ASSESSMENT", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800004", "MAINTENANCE FEE", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800005", "SYABAS", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800006", "QUIT RENT", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800007", "ELECTRICITY DEPOSIT", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800008", "WATER DEPOSIT", "DR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("800009", "TNB", "DR", "Y", NULL, "SSACT");

INSERT INTO vipro.transaction_code VALUES ("900001", "CREDIT ADJUSTMENT", "CR", "Y", NULL, "SSACT");
INSERT INTO vipro.transaction_code VALUES ("900002", "DISCOUNT", "CR", "Y", NULL, "SSACT");

INSERT INTO vipro.user_group VALUES ("ACCT_STF", "ACCOUNT STAFF","SSACT");

INSERT INTO vipro.code_det VALUES ( 'TS', 'TSSAV', 'SAVED' , 'SSACT');
