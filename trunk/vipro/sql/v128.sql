-- Add fields in Progressive Billing Table to support split billing
ALTER TABLE vipro.progressive_billing add purchaser_portion Dec(9,2) after overdue_interest;
ALTER TABLE vipro.progressive_billing add purchaser_invoice_no Varchar(10) after purchaser_portion;




