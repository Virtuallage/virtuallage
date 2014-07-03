ALTER TABLE vipro.customer ADD age_group VARCHAR(5) after date_of_birth;
ALTER TABLE vipro.customer ADD income_group VARCHAR(5) after employer_name;
ALTER TABLE vipro.customer ADD marketing_code VARCHAR(5) after age_group;
ALTER TABLE vipro.customer ADD pdpa_disclaimer VARCHAR(1) after marketing_code;

-- Load New Code Data (Age Group)
INSERT INTO code_header VALUES ('AG', 'AGE GROUP');
INSERT INTO code_det VALUES ( 'AG', 'AG2T3', '20 TO 30 YEARS OLD' , 'SSACT');
INSERT INTO code_det VALUES ( 'AG', 'AG3T4', '31 TO 40 YEARS OLD' , 'SSACT');
INSERT INTO code_det VALUES ( 'AG', 'AG4T5', '41 TO 50 YEARS OLD' , 'SSACT');
INSERT INTO code_det VALUES ( 'AG', 'AG50A', '51 YEARS OLD AND ABOVE' , 'SSACT');

-- Load New Code Data (Monthly Income Group)
INSERT INTO code_header VALUES ('IG', 'MONTHLY INCOME GROUP');
INSERT INTO code_det VALUES ( 'IG', 'IG13K', 'BELOW RM3,000' , 'SSACT');
INSERT INTO code_det VALUES ( 'IG', 'IG235', 'RM3,001 TO RM5,000' , 'SSACT');
INSERT INTO code_det VALUES ( 'IG', 'IG351', 'RM5,001 TO RM10,000' , 'SSACT');
INSERT INTO code_det VALUES ( 'IG', 'IG410', 'ABOVE RM10,00' , 'SSACT');

-- Load New Code Data (Marketing Program)
INSERT INTO code_header VALUES ('MC', 'MARKETING PROGRAM');
INSERT INTO code_det VALUES ( 'MC', 'MC001', 'CARNIVAL OF LIVING COLORS' , 'SSACT');

-- Add New Property Types
INSERT INTO vipro.code_det VALUES ('PT', 'PTSSL', 'SINGLE STOREY LINK', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTDSL', 'DOUBLE STOREY LINK', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTTWN', 'TOWNHOUSE', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTZRL', 'ZERO-LOT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTVIL', 'VILLA', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTART', 'APARTMENT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTSHL', 'SHOP LOT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTFAL', 'FACTORY LOT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTRTL', 'RETAIL LOT', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTSOH', 'SOHO', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PT', 'PTOFS', 'OFFICE SUITE', 'SSACT');

-- Add New Customer Category
INSERT INTO vipro.code_det VALUES ('CC', 'CCPOT', 'POTENTIAL BUYER', 'SSACT');