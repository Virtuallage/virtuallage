ALTER TABLE vipro.project_inventory 
 ADD COLUMN net_price DEC(11,2) NOT NULL AFTER discount_amount;