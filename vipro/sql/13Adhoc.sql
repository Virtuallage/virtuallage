ALTER TABLE vipro.account change sales_person sales_person VARCHAR(40);
ALTER TABLE vipro.project CHANGE COLUMN billing_model_code billing_model_code VARCHAR(10);
ALTER TABLE vipro.project_inventory CHANGE COLUMN discount_rate discount_rate DEC(5,2);

UPDATE vipro.project_inventory set net_price = purchase_price - discount_amount where project_id = 1;
UPDATE vipro.project_inventory set net_price = purchase_price - discount_amount where project_id = 2;
UPDATE vipro.project_inventory set net_price = purchase_price - discount_amount where project_id = 3;

ALTER TABLE vipro.billing_model CHANGE COLUMN stage stage VARCHAR(10);
ALTER TABLE vipro.billing_model CHANGE COLUMN billing_model_code billing_model_code VARCHAR(10);

-- Modale B Create Billing Model Parameter Data
INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 1, '1', 'Upon signing of Sale & Purchase Agreement.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 2, '2(a)', 'Earthworks.',
             10.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 3, '2(b)', 'Piling works.',
             15.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 4, '2(c)(i)', 'Reinforced concrete slab - Ground Floor.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 5, '2(c)(ii)', 'Reinforced concrete slab - First & Second Floor.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 6, '2(c)(iii)', 'Reinforced concrete slab - Third & Fourth Floor.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 7, '2(c)(iv)', 'Reinforced concrete slab - Fifth & Sixth Floor.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 8, '2(c)(v)', 'Reinforced concrete slab - Seventh & Eighth Floor.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 9, '2(d)', 'Reinforced concrete framework of the Parcel.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 10, '2(e)', 'Walls with door & window frames.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 11, '2(f)', 'Electrical wiring & plumbing.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 12, '2(g)', 'Internal plastering.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 13, '2(h)', 'External plastering.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 14, '2(i)', 'Drains & sewerage works',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 15, '2(j)', 'Road works.',
             5.00, null, null, 'SSACT');

INSERT INTO vipro.billing_model (billing_model_code, billing_seq, stage, description,
            billing_percentage, changed_by, date_changed, status)
     VALUES ('DPMJ', 16, '3', 'Vacant Possession.',
             5.00, null, null, 'SSACT');

-- 2014/03/03 BY SEAN --
INSERT INTO `vipro`.`code_header` (`code_header_id`, `name`) VALUES ('PR', 'Partner Type');

INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRBNK', 'Bank', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRDEV', 'Developer', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRLND', 'Land Owner', 'SSACT');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('PR', 'PRSOL', 'Solicitor', 'SSACT');

             
