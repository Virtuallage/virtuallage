-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Step 3: This SQL will perform the following: -                          |
-- | a. Loading of initial paremeters data into tables                       | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+

-- Create Institution Information Record
INSERT INTO vipro.institution (institution_id, institution_name, status) 
     VALUES (1000000001, 'B&G Concept Engineering Sdn Bhd', 'ACTV');

-- Create Holiday Table Data
INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20130601, 'Agong Birthday', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20130808, 'Hari Raya Puasa', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20130809, 'Hari Raya Puasa', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20130831, 'Hari Merdeka', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20130916, 'Hari Malaysia', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20131015, 'Hari Raya Haji', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20131103, 'Deepavali', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20131105, 'Awal Muharram', 1000000001);

INSERT INTO vipro.holiday (date, description, institution_id)
     VALUES (20131224, 'Chrismas Day', 1000000001);

-- Create Default User Group and Username
INSERT INTO vipro.user_group VALUES('ADMIN', 'System Administrator Group', 'ACTV');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) 
     VALUES ('sysadm', '5f4dcc3b5aa765d61d8327deb882cf99', 'System Administrator', 1000000001,'000', 'ACTV', 'ADMIN');

INSERT INTO vipro.user_group VALUES ('SALES', 'Sales Staff Group', 'ACTV');

INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, status, group_id) 
     VALUES ('sales', '5f4dcc3b5aa765d61d8327deb882cf99', 'Sales Staff Default User', 1000000001,'000', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('stevenoh', '5f4dcc3b5aa765d61d8327deb882cf99', 'Steven Oh Chan Yen', 1000000001,'stevenoh@mct.com.my', '60146183348', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('daren', '5f4dcc3b5aa765d61d8327deb882cf99', 'Daren Tiong Chee Wei', 1000000001,'daren@mct.com.my', '60167229771', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('ykwan', '5f4dcc3b5aa765d61d8327deb882cf99', 'Wan Yew Khuan', 1000000001,'ykwan@mct.com.my', '60165540606', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('stevenchow', '5f4dcc3b5aa765d61d8327deb882cf99', 'Steven Chow Kah Seng', 1000000001,'steven@mct.com.my', '60129313853', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('joelim', '5f4dcc3b5aa765d61d8327deb882cf99', 'Joe Lim Kheng Shen', 1000000001,'joe.lim@mct.com.my', '60193393596', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('sally', '5f4dcc3b5aa765d61d8327deb882cf99', 'Salina Binti Kassim', 1000000001,'salina@mct.com.my', '60173648087', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('jess', '5f4dcc3b5aa765d61d8327deb882cf99', 'Hadijah Binti Maming (Jess)', 1000000001,'jess@mct.com.my', '60137027593', 'ACTV', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, status, group_id) 
     VALUES ('yan', '5f4dcc3b5aa765d61d8327deb882cf99', 'Hazri Yanti Binti Mohd Yasim', 1000000001,'yan@mct.com.my', '60122361577', 'ACTV', 'SALES');


INSERT INTO vipro.user_group VALUES ('SALES_PIC', 'Sales Person-in-Charge Group', 'ACTV');

INSERT INTO vipro.user_profile (username, password, name, staff_no, status, institution_id, group_id)
     VALUES ('salespic', '5f4dcc3b5aa765d61d8327deb882cf99', 'Sales Person-In-Charge', 000, 'ACTV', 1000000001, 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, email, mobile_no, status, institution_id, group_id)
     VALUES ('adrian', '5f4dcc3b5aa765d61d8327deb882cf99', 'Adrian Soon Yee Jer', 'adrian@mct.com.my', '60122241717', 'ACTV', 1000000001, 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, email, mobile_no, status, institution_id, group_id)
     VALUES ('hasrina', '5f4dcc3b5aa765d61d8327deb882cf99', 'Noor Hasrina', 'hasrina@mct.com.my', '60192326080', 'ACTV', 1000000001, 'SALES_PIC');

-- For Future Used
-- Other valid group in the system are 'SALES_ADM', 'CUST_SERV', 'ACCT', 'PROP_DEV'

-- Create General Code Initial Data

INSERT INTO vipro.code_header (code_header_id, name) VALUES ( 'CY', 'Case Type / Category');
INSERT INTO vipro.code_det VALUES ('CY', 'CAREM', 'Reminder', 'ACTV');
INSERT INTO vipro.code_det VALUES('CY', 'CAINQ', 'Inquiry', 'ACTV');
INSERT INTO vipro.code_det VALUES ('CY', 'CAAPP', 'Approval', 'ACTV');
INSERT INTO vipro.code_det VALUES ('CY', 'CAVER', 'Verify', 'ACTV');

INSERT INTO vipro.code_header VALUES ('AC', 'Action Taken on Case');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKREA', 'Reassigned' , 'ACTV');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKEML', 'Emailed', 'ACTV');

-- Case Management (My Work Queue)
INSERT INTO code_header VALUES ('CS', 'Case Status');
INSERT INTO code_det VALUES ( 'CS', 'CSNEW', 'New Case' , 'ACTV');
INSERT INTO code_det VALUES ( 'CS', 'CSOPN', 'Work in Progress' , 'ACTV');
INSERT INTO code_det VALUES ( 'CS', 'CSCLS', 'Closed Case' , 'ACTV');
INSERT INTO code_det VALUES ( 'CS', 'CSCOM', 'Completed' , 'ACTV');

-- Purchaser Title
INSERT INTO vipro.code_header VALUES ('TT', 'Customer Title');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMST', 'Mr.', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMIS', 'Ms.', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDAT', 'Dato', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTTSR', 'Tan Sri', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDOT', 'Dr.', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMDM', 'Madam', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTENC', 'En.', 'ACTV');
INSERT INTO vipro.code_det VALUES ('TT', 'TTCIK', 'Cik', 'ACTV');

-- State
INSERT INTO vipro.code_header VALUES ('ST', 'The list of States in Malaysia');
INSERT INTO vipro.code_det VALUES('ST', 'STSEL', 'Selangor', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STKUL', 'Kuala Lumpur', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STJOH', 'Johor', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STMEL', 'Melaka', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STSEM', 'Negeri Sembilan', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STPAH', 'Pahang', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STPER', 'Perak', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STTER', 'Terrenganu', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STKEL', 'Kelantan', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STPEN', 'Penang', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STPEL', 'Perlis', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STKED', 'Kedah', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STSAR', 'Sarawak', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STSAB', 'Sabah', 'ACTV');
INSERT INTO vipro.code_det VALUES('ST', 'STLAB', 'Labuan', 'ACTV');

-- Country
INSERT INTO vipro.code_header VALUES ('CT', 'Country');
INSERT INTO vipro.code_det VALUES ('CT', 'CTMAS', 'Malaysia', 'ACTV');
INSERT INTO vipro.code_det VALUES ('CT', 'CTIND', 'Indonesia', 'ACTV');
INSERT INTO vipro.code_det VALUES ('CT', 'CTSIN', 'Singapore', 'ACTV');

-- Customer Category
INSERT INTO vipro.code_header VALUES ('CC', 'Customer Category/Type');
INSERT INTO vipro.code_det VALUES ('CC', 'CCIND', 'Individual', 'ACTV');
INSERT INTO vipro.code_det VALUES ('CC', 'CCCOM', 'Company', 'ACTV');

-- Type of Property 
INSERT INTO vipro.code_header VALUES ('PT', 'Property Type');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTCON', 'Condominium', 'ACTV');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTBGL', 'Bungalow', 'ACTV');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSEM', 'Semi-Detached', 'ACTV');

-- Type of Property Title
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('PE', 'Property Title Type');
INSERT INTO vipro.code_det VALUES ('PE', 'PESTR', 'Strata Title', 'ACTV');
INSERT INTO vipro.code_det VALUES ('PE', 'PEIND', 'Individual Title', 'ACTV');

-- Customer Sex
INSERT INTO code_header VALUES ('SX', 'Sex of the customer');
INSERT INTO code_det VALUES ('SX', 'SXMAL', 'Male', 'ACTV');
INSERT INTO code_det VALUES ('SX', 'SXFEM', 'Female', 'ACTV');

-- Preferred Language
INSERT INTO code_header VALUES ('LG', 'Customer Preferred Language');
INSERT INTO code_det VALUES ('LG', 'LGCHI', 'Chinese', 'ACTV');
INSERT INTO code_det VALUES ('LG', 'LGENG', 'English', 'ACTV');
INSERT INTO code_det VALUES ('LG', 'LGMLY', 'Malay', 'ACTV');

-- Marital Status of the purchaser
INSERT INTO code_header VALUES ('MS', 'Marital Status of the Customer');
INSERT INTO code_det VALUES ('MS', 'MSMAR', 'Married', 'ACTV');
INSERT INTO code_det VALUES ('MS', 'MSSIN', 'Single', 'ACTV');
INSERT INTO code_det VALUES ('MS', 'MSOTH', 'Other', 'ACTV');

-- Bumi or Non Bumi
INSERT INTO code_header VALUES ('BM', 'Bumi or Non-Bumi Indicator');
INSERT INTO code_det VALUES ('BM', 'BMNON', 'Non-Bumi', 'ACTV');
INSERT INTO code_det VALUES ('BM', 'BMBUM', 'Bumi', 'ACTV');

-- Race of the purchaser
INSERT INTO code_header VALUES ('RC', 'Race of the Customer');
INSERT INTO code_det VALUES ('RC', 'RCCHI', 'Chinese', 'ACTV');
INSERT INTO code_det VALUES ('RC', 'RCMLY', 'Malay', 'ACTV');
INSERT INTO code_det VALUES ('RC', 'RCIND', 'Indian', 'ACTV');
INSERT INTO code_det VALUES ('RC', 'RCOTH', 'Other', 'ACTV');

-- The Purchaser Type of ID
INSERT INTO code_header VALUES ('ID', 'Type of the ID used');
INSERT INTO code_det VALUES ('ID', 'IDNIC', 'Identity Card', 'ACTV');
INSERT INTO code_det VALUES ('ID', 'IDPAS', 'Passport', 'ACTV');
INSERT INTO code_det VALUES ('ID', 'IDBRE', 'Business Registration', 'ACTV');
INSERT INTO code_det VALUES ('ID', 'IDOTH', 'Other', 'ACTV');

-- Payment Method
INSERT INTO code_header VALUES ('PM', 'Payment Method');
INSERT INTO code_det VALUES ('PM', 'PMCAS', 'Cash', 'ACTV');
INSERT INTO code_det VALUES ('PM', 'PMCRD', 'Credit Card', 'ACTV');
INSERT INTO code_det VALUES ('PM', 'PMCHQ', 'Personal Cheque', 'ACTV');
INSERT INTO code_det VALUES ('PM', 'PMDRF', 'Bank Draft', 'ACTV');
INSERT INTO code_det VALUES ('PM', 'PMCCQ', 'Company Cheque', 'ACTV');

-- Name of Banks
INSERT INTO code_header VALUES ('BK', 'Bank Name');
INSERT INTO code_det VALUES ('BK', 'BKMBB', 'Maybank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKCIM', 'CIMB Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKPBB', 'Public Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKRHB', 'RHB Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKHLB', 'Hong Leong Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKAFB', 'Affin Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKABB', 'Alliance Bank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKAMB', 'AmBank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKHSBC', 'HSBC', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKCTB', 'Citibank', 'ACTV');
INSERT INTO code_det VALUES ('BK', 'BKSCB', 'Standard Charted Bank', 'ACTV');

-- Cancellation Reason
INSERT INTO code_header VALUES ('CR', 'Cancel Reason');
INSERT INTO code_det VALUES ( 'CR', 'CRNPY', 'Non Payment' , 'ACTV');
INSERT INTO code_det VALUES ( 'CR', 'CRBRJ', 'Loan Rejected By Bank' , 'ACTV');

-- Record Status Definition
INSERT INTO code_header VALUES ('SS', 'Commonly Used Status Code');
INSERT INTO code_det VALUES ( 'SS', 'SSACT', 'Active' , 'ACTV');
INSERT INTO code_det VALUES ( 'SS', 'SSDIS', 'Disabled' , 'ACTV');

-- Property Status
INSERT INTO vipro.code_header VALUES ('PS', 'Property Status');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSSLD', 'Sold', 'ACTV');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSAVL', 'Available', 'ACTV');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSNAV', 'Not Available', 'ACTV');
INSERT INTO vipro.code_det VALUES ('PS','PSPRG','In Progress','ACTV');
INSERT INTO vipro.code_det VALUES ('PS','PSBOK','Booked','ACTV');

-- Unit Status
INSERT INTO code_header (code_header_id, name) VALUES ('BS', 'Booking Status');
INSERT INTO code_det VALUES ('BS', 'BSAVL', 'Available', 'ACTV');
INSERT INTO code_det VALUES ('BS', 'BSPRC', 'Processing', 'ACTV');
INSERT INTO code_det VALUES ('BS', 'BSBOK', 'Booked', 'ACTV');
INSERT INTO code_det VALUES ('BS', 'BSRSV', 'Reserved', 'ACTV');
INSERT INTO code_det VALUES ('BS', 'BSSLD', 'Sold', 'ACTV');

-- Transaction Status
INSERT INTO code_header (code_header_id, name) VALUES ('TS', 'Transaction Status Code');
INSERT INTO code_det VALUES ('TS', 'TSPEN', 'Pending Posting', 'ACTV');
INSERT INTO code_det VALUES ('TS', 'TSCOM', 'Completed', 'ACTV');
INSERT INTO code_det VALUES ('TS', 'TSPOS', 'Posted', 'ACTV');
INSERT INTO code_det VALUES ('TS', 'TSREJ', 'Rejected', 'ACTV');

-- Application Source
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('ME', 'Media Source');
INSERT INTO vipro.code_det VALUES ('ME', 'MEFRD', 'Friend', 'ACTV');
INSERT INTO vipro.code_det VALUES ('ME', 'MENEW', 'Newspaper', 'ACTV');
INSERT INTO vipro.code_det VALUES ('ME', 'METLV', 'Television', 'ACTV');
INSERT INTO vipro.code_det VALUES ('ME', 'MERAD', 'Radio', 'ACTV');
INSERT INTO vipro.code_det VALUES ('ME', 'MEBRD', 'Bill Board', 'ACTV');
INSERT INTO vipro.code_det VALUES ('ME', 'MEOTH', 'Other', 'ACTV');

-- Reporting Group
INSERT INTO vipro.code_header VALUES ('RG', 'Report Group');
INSERT INTO vipro.code_det VALUES ('RG', 'RGVRS', 'V-Residensi Report', 'ACTV');

-- Orientation
INSERT INTO vipro.code_header VALUES ('OR', 'Orientation of the property');
INSERT INTO vipro.code_det VALUES ('OR', 'OREND', 'End Lot', 'ACTV');
INSERT INTO vipro.code_det VALUES ('OR', 'ORINT', 'Intermediate', 'ACTV');
INSERT INTO vipro.code_det VALUES ('OR', 'ORCOR', 'Corner', 'ACTV');

-- Department (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('DM', 'Department in the Company');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSMA', 'Sales & Marketing', 'ACTV');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSAD', 'Sales Admin', 'ACTV');
INSERT INTO vipro.code_det VALUES ('DM', 'DMACT', 'Accounting', 'ACTV');
INSERT INTO vipro.code_det VALUES ('DM', 'DMMGR', 'Management', 'ACTV');

-- Purchase Type (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('PU', 'Purchase Type');
INSERT INTO vipro.code_det VALUES ('PU', 'PUBLN', 'Bank Loan', 'ACTV');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCLN', 'Company Loan', 'ACTV');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCSH', 'Cash', 'ACTV');

-- Solicitor (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('SL', 'Name of Panel Solicitors');
INSERT INTO vipro.code_det VALUES ('SL', 'SLLLA', 'Low & Lee', 'ACTV');

-- Account Type (Bill 19/6)
INSERT INTO vipro.code_header VALUES ('AT', 'Account Type');
INSERT INTO vipro.code_det VALUES ('AT', 'ATCOM', 'Company Account', 'ACTV');
INSERT INTO vipro.code_det VALUES ('AT', 'ATIND', 'Individual / Personal Account', 'ACTV');

-- Transaction Code Loading
INSERT INTO vipro.transaction_code VALUES ('100001', 'Booking Fee', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('100002', 'Payment from Purchaser', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('100003', 'Payment from Bank', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('110001', 'Commission Fee Reversal', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('120001', 'Progressive Billing Reversal - Purchaser', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('120002', 'Progressive Billing Reversal - Bank', 'CR', null, 'ACTV');

INSERT INTO vipro.transaction_code VALUES ('200001', 'Booking Fee Reversal', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('200002', 'Payment from Purchaser Reversal', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('200003', 'Payment from Bank Reversal', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('210001', 'Commission Fee', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('220001', 'Progressive Billing - Purchaser', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('220002', 'Progressive Billing - Bank', 'DR', null, 'ACTV');

INSERT INTO vipro.transaction_code VALUES ('300001', 'Cancellation Fee Reversal - Booking', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('300002', 'Cancellation Fee Reversal - Purchaser', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('300003', 'Cancellation Fee Reversal - Bank', 'CR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('310001', 'Cancellation Tax Reversal', 'CR', null, 'ACTV');

INSERT INTO vipro.transaction_code VALUES ('400001', 'Cancellation Fee - Booking', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('400002', 'Cancellation Fee - Purchaser', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('400003', 'Cancellation Fee - Bank', 'DR', null, 'ACTV');
INSERT INTO vipro.transaction_code VALUES ('400004', 'Cancellation Tax', 'DR', null, 'ACTV');

-- Business Partner Parameters
INSERT INTO business_partner (partner_id, institution_id) 
     VALUES (0, 1000000001);
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'DEVP', 'B&G Development Sdn Bhd', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'LAND', 'Multi Bina Sdn Bhd', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'SOLI', 'Low & Lee', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'RHB - Paradigm Mall', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'RHB - Jinjang Utara Branch', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Affin Bank - Affin HQ (Central)', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'CIMB - Taman Sri Selayang', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Ambank - Menara Ambank', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'UOB - Medan Putra Business Centre', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Public Bank - Bandar Sunway', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'HLB - Taman Selayang Jaya', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'HSBC - Bandar Puchong Jaya', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'MBSB - Damansara Branch', 'ACTV');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Alliance Bank - UEP Subang Jaya', 'ACTV');