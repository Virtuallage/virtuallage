-- Change existing table fields
alter table vipro.business_partner add company_code VARCHAR(10) after registration_date;
alter table vipro.business_partner change address address_id BIGINT;

alter table vipro.transaction_history add txn_reversal_id BIGINT after card_cheque_no;
alter table vipro.transaction_history add invoice_no VARCHAR(10) after ref_no;

alter table vipro.account change spa_doc_id spa_ref_no VARCHAR(20);
alter table vipro.account change lo_doc_id financier_id BIGINT;
alter table vipro.account change la_doc_id la_ref_no VARCHAR(20);

alter table vipro.sales_commission_history 
        add purchase_price DECIMAL(9, 2) NULL after batch_no;

-- Changed by Imran 29-Sep-2013
alter table vipro.address Modify customer_id bigint (20);
alter table vipro.project_inventory change property_address address_id BIGINT;
alter table vipro.project_inventory add foreign key FK_project_inventory(address_id) references address (address_id);