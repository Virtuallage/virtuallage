ALTER TABLE vipro.project_inventory 
 ADD COLUMN net_price DEC(11,2) NOT NULL AFTER discount_amount;
 
ALTER TABLE vipro.account change spa_ref_no spa_ref_no VARCHAR(50);

ALTER TABLE vipro.account change financier_ref financier_ref VARCHAR(50);

ALTER TABLE vipro.account change la_ref_no la_ref_no VARCHAR(50);