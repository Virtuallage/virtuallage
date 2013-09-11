-- +-------------------------------------------------------------------------+
-- | Date Created   : 07/09/2013                                             |
-- | Add new fields                                     |
-- +-------------------------------------------------------------------------+

-- Add new field in project table to link to billing model table (ie A, B, C etc...)
alter table vipro.project add billing_model_code VARCHAR(1) after tax_percentage;
alter table vipro.project add start_date DATE after maintenance_fee_rate;
alter table vipro.project add end_date DATE after launch_date;

-- Progressing Billing to add new field for batch/invoice no for grouping
alter table vipro.progressive_billing add invoice_no VARCHAR(10) after stage_description;

-- Add Business Partner Id to Customer to link to the partner information
alter table vipro.customer add business_partner BIGINT after special_handling;

ALTER TABLE vipro.customer
  ADD CONSTRAINT FK_customer_2
      FOREIGN KEY (business_partner)
      REFERENCES vipro.business_partner (partner_id);

-- Add Campaign Code into Account Table
alter table vipro.account add campaign_code VARCHAR(5) after customer_id5;
alter table vipro.account add financier_ref VARCHAR(20) after lo_doc_id;


