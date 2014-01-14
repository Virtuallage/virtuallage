
-- Progressive Billing Status Code
INSERT INTO code_header VALUES ('PB', 'Progressive Billing Status');
INSERT INTO code_det VALUES ('PB', 'PBACT', 'Active', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCLS', 'Closed - Refunded', 'SSACT');
INSERT INTO code_det VALUES ('PB', 'PBCXN', 'Cancelled', 'SSACT');

insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
     values (  '500001',  'Progressive Billing',  'DR',  NULL,  'SSACT' );
INSERT INTO `vipro`.`transaction_code` (`transaction_code`, `name`, `code_type`, `accounting_group`, `status`) 
    VALUES ('510001', 'Progressive Billing Reversal', 'CR', NULL, 'SSACT'); 
insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
     values (  '500002',  'Renotice',  'DR',  NULL,  'SSACT' );
insert into `vipro`.`transaction_code` ( `transaction_code`, `name`, `code_type`, `accounting_group`, `status` ) 
     values (  '110002',  'Payment Reversal',  'DR',  NULL,  'SSACT' );    

INSERT INTO vipro.user_group VALUES ('PIC_ADM', 'Admin to Sales PIC Group', 'SSACT');

-- load new business partner for new project
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'DEVP', 'B & G SUPERB PROPERTY SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'LAND', 'B & G SUPERB PROPERTY SDN BHD', 'SSACT');
     
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'DEVP', 'DPRISTINE MEDINI SDN BHD', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'LAND', 'DPRISTINE MEDINI SDN BHD', 'SSACT');
     
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSOF', 'SOFO', 'SSACT');

-- load business partner address for Law & Lee
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('SUITE A-5-7, SKY PARK ONE CITY,', 'JALAN USJ 25/1,', '', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);

-- Dpristine Address
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('C-07-01 TO 08, BLOCK C,', 'SKY PARK ONE CITY,', 'JALAN USJ25/1A,', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);

-- Superb Property
INSERT INTO vipro.address (address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES ('C-07-01 TO 08, BLOCK C,', 'SKY PARK ONE CITY,', 'JALAN USJ25/1A,', '',
			'47650', 'SUBANG JAYA', 'STSEL', 'CTMAS', 20131206, NULL, NULL);
			

			
