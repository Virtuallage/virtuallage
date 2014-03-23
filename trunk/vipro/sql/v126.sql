-- Expand Stage No field from 5 to 10.
ALTER TABLE vipro.progressive_billing CHANGE stage_no stage_no VARCHAR(10);

-- Add fields in Project file
ALTER TABLE vipro.project add days_to_bill INT after due_days;
ALTER TABLE vipro.project add include_off_day VARCHAR(1) after days_to_bill;

INSERT INTO vipro.code_det (code_header_id, code, description, status) VALUES ('ST', '     ', 'BLANK (NA)', 'SSACT'); 



