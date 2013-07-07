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
     VALUES (1000000001, 'B&G Concept Engineering Sdn Bhd', 'SSACT');

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
INSERT INTO vipro.user_group VALUES('ADMIN', 'System Administrator Group', 'SSACT');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, department, status, group_id) 
     VALUES ('sysadm', '5f4dcc3b5aa765d61d8327deb882cf99', 'System Administrator', 1000000001,'000', 'DMSYS', 'SSACT', 'ADMIN');

INSERT INTO vipro.user_group VALUES ('SALES', 'Sales Staff Group', 'SSACT');

INSERT INTO vipro.user_profile (username, password, name, institution_id,  staff_no, department, status, group_id) 
     VALUES ('sales', '5f4dcc3b5aa765d61d8327deb882cf99', 'Sales Administrator', 1000000001,'000', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('stevenoh', '5f4dcc3b5aa765d61d8327deb882cf99', 'Steven Oh Chan Yen', 1000000001,'stevenoh@mct.com.my', '0146183348', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('daren', '5f4dcc3b5aa765d61d8327deb882cf99', 'Daren Tiong Chee Wei', 1000000001,'daren@mct.com.my', '0167229771', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('ykwan', '5f4dcc3b5aa765d61d8327deb882cf99', 'Wan Yew Khuan', 1000000001,'ykwan@mct.com.my', '0165540606', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('stevenchow', '5f4dcc3b5aa765d61d8327deb882cf99', 'Steven Chow Kah Seng', 1000000001,'steven@mct.com.my', '0129313853', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('joelim', '5f4dcc3b5aa765d61d8327deb882cf99', 'Joe Lim Kheng Shen', 1000000001,'joe.lim@mct.com.my', '0193393596', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('sally', '5f4dcc3b5aa765d61d8327deb882cf99', 'Salina Binti Kassim', 1000000001,'salina@mct.com.my', '0173648087', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('jess', '5f4dcc3b5aa765d61d8327deb882cf99', 'Hadijah Binti Maming (Jess)', 1000000001,'jess@mct.com.my', '0137027593', 'DMSMA', 'SSACT', 'SALES');
INSERT INTO vipro.user_profile (username, password, name, institution_id,  email, mobile_no, department, status, group_id) 
     VALUES ('yan', '5f4dcc3b5aa765d61d8327deb882cf99', 'Hazri Yanti Binti Mohd Yasim', 1000000001,'yan@mct.com.my', '0122361577', 'DMSMA', 'SSACT', 'SALES');


INSERT INTO vipro.user_group VALUES ('SALES_PIC', 'Sales Person-in-Charge Group', 'SSACT');

INSERT INTO vipro.user_profile (username, password, name, staff_no, department, status, institution_id, group_id)
     VALUES ('salespic', '5f4dcc3b5aa765d61d8327deb882cf99', 'PIC Administrator', 000, 'DMSMA', 'SSACT', 1000000001, 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, email, mobile_no, department, status, institution_id, group_id)
     VALUES ('adrian', '5f4dcc3b5aa765d61d8327deb882cf99', 'Adrian Soon Yee Jer', 'adrian@mct.com.my', '0122241717', 'DMSMA', 'SSACT', 1000000001, 'SALES_PIC');
INSERT INTO vipro.user_profile (username, password, name, email, mobile_no, department, status, institution_id, group_id)
     VALUES ('hasrina', '5f4dcc3b5aa765d61d8327deb882cf99', 'Noor Hasrina', 'hasrina@mct.com.my', '0192326080', 'DMSMA', 'SSACT', 1000000001, 'SALES_PIC');

-- For Future Used
-- Other valid group in the system are 'SALES_ADM', 'CUST_SERV', 'ACCT', 'PROP_DEV'

-- Create General Code Initial Data

INSERT INTO vipro.code_header (code_header_id, name) VALUES ( 'CY', 'Case Type / Category');
INSERT INTO vipro.code_det VALUES ('CY', 'CAREM', 'Reminder', 'SSACT');
INSERT INTO vipro.code_det VALUES('CY', 'CAINQ', 'Inquiry', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CY', 'CAAPP', 'Approval', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CY', 'CAVER', 'Verify', 'SSACT');

INSERT INTO vipro.code_header VALUES ('AC', 'Action Taken on Case');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKREA', 'Reassigned' , 'SSACT');
INSERT INTO vipro.code_det VALUES ( 'AC', 'AKEML', 'Emailed', 'SSACT');

-- Case Management (My Work Queue)
INSERT INTO code_header VALUES ('CS', 'Case Status');
INSERT INTO code_det VALUES ( 'CS', 'CSNEW', 'New Case' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSOPN', 'Work in Progress' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSCLS', 'Closed Case' , 'SSACT');
INSERT INTO code_det VALUES ( 'CS', 'CSCOM', 'Completed' , 'SSACT');

-- Purchaser Title
INSERT INTO vipro.code_header VALUES ('TT', 'Customer Title');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMST', 'Mr.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMIS', 'Ms.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDAT', 'Dato', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTTSR', 'Tan Sri', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTDOT', 'Dr.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTMDM', 'Madam', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTENC', 'En.', 'SSACT');
INSERT INTO vipro.code_det VALUES ('TT', 'TTCIK', 'Cik', 'SSACT');

-- State
INSERT INTO vipro.code_header VALUES ('ST', 'The list of States in Malaysia');
INSERT INTO vipro.code_det VALUES('ST', 'STSEL', 'Selangor', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKUL', 'W.P.', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STJOH', 'Johor', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STMEL', 'Melaka', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSEM', 'Negeri Sembilan', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPAH', 'Pahang', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPER', 'Perak', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STTER', 'Terrenganu', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKEL', 'Kelantan', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPEN', 'Penang', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STPEL', 'Perlis', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STKED', 'Kedah', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSAR', 'Sarawak', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STSAB', 'Sabah', 'SSACT');
INSERT INTO vipro.code_det VALUES('ST', 'STLAB', 'Labuan', 'SSACT');

-- Country
INSERT INTO vipro.code_header VALUES ('CT', 'Country');
INSERT INTO vipro.code_det VALUES ('CT', 'CTMAS', 'Malaysia', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTIND', 'Indonesia', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTSIN', 'Singapore', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CT', 'CTOTH', 'Other', 'SSACT');

-- Customer Category
INSERT INTO vipro.code_header VALUES ('CC', 'Customer Category/Type');
INSERT INTO vipro.code_det VALUES ('CC', 'CCIND', 'Individual', 'SSACT');
INSERT INTO vipro.code_det VALUES ('CC', 'CCCOM', 'Company', 'SSACT');

-- Type of Property 
INSERT INTO vipro.code_header VALUES ('PT', 'Property Type');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTCON', 'Condominium', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTBGL', 'Bungalow', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PT', 'PTSEM', 'Semi-Detached', 'SSACT');

-- Type of Property Title
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('PE', 'Property Title Type');
INSERT INTO vipro.code_det VALUES ('PE', 'PESTR', 'Strata Title', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PE', 'PEIND', 'Individual Title', 'SSACT');

-- Customer Sex
INSERT INTO code_header VALUES ('SX', 'Sex of the customer');
INSERT INTO code_det VALUES ('SX', 'SXMAL', 'Male', 'SSACT');
INSERT INTO code_det VALUES ('SX', 'SXFEM', 'Female', 'SSACT');

-- Preferred Language
INSERT INTO code_header VALUES ('LG', 'Customer Preferred Language');
INSERT INTO code_det VALUES ('LG', 'LGCHI', 'Chinese', 'SSACT');
INSERT INTO code_det VALUES ('LG', 'LGENG', 'English', 'SSACT');
INSERT INTO code_det VALUES ('LG', 'LGMLY', 'Malay', 'SSACT');

-- Marital Status of the purchaser
INSERT INTO code_header VALUES ('MS', 'Marital Status of the Customer');
INSERT INTO code_det VALUES ('MS', 'MSMAR', 'Married', 'SSACT');
INSERT INTO code_det VALUES ('MS', 'MSSIN', 'Single', 'SSACT');
INSERT INTO code_det VALUES ('MS', 'MSOTH', 'Other', 'SSACT');

-- Bumi or Non Bumi
INSERT INTO code_header VALUES ('BM', 'Bumi or Non-Bumi Indicator');
INSERT INTO code_det VALUES ('BM', 'BMNON', 'Non-Bumi', 'SSACT');
INSERT INTO code_det VALUES ('BM', 'BMBUM', 'Bumi', 'SSACT');

-- Race of the purchaser
INSERT INTO code_header VALUES ('RC', 'Race of the Customer');
INSERT INTO code_det VALUES ('RC', 'RCCHI', 'Chinese', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCMLY', 'Malay', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCIND', 'Indian', 'SSACT');
INSERT INTO code_det VALUES ('RC', 'RCOTH', 'Other', 'SSACT');

-- The Purchaser Type of ID
INSERT INTO code_header VALUES ('ID', 'Type of the ID used');
INSERT INTO code_det VALUES ('ID', 'IDNIC', 'Identity Card', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDPAS', 'Passport', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDBRE', 'Business Registration', 'SSACT');
INSERT INTO code_det VALUES ('ID', 'IDOTH', 'Other', 'SSACT');

-- Payment Method
INSERT INTO code_header VALUES ('PM', 'Payment Method');
INSERT INTO code_det VALUES ('PM', 'PMCAS', 'Cash', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCRD', 'Credit Card', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCHQ', 'Personal Cheque', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMDRF', 'Bank Draft', 'SSACT');
INSERT INTO code_det VALUES ('PM', 'PMCCQ', 'Company Cheque', 'SSACT');

-- Name of Banks
INSERT INTO code_header VALUES ('BK', 'Bank Name');
INSERT INTO code_det VALUES ('BK', 'BKMBB', 'Maybank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKCIM', 'CIMB Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKPBB', 'Public Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKRHB', 'RHB Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKHLB', 'Hong Leong Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKAFB', 'Affin Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKABB', 'Alliance Bank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKAMB', 'AmBank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKHSB', 'HSBC', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKCTB', 'Citibank', 'SSACT');
INSERT INTO code_det VALUES ('BK', 'BKSCB', 'Standard Charted Bank', 'SSACT');

-- Cancellation Reason
INSERT INTO code_header VALUES ('CR', 'Cancel Reason');
INSERT INTO code_det VALUES ( 'CR', 'CRNPY', 'Non Payment' , 'SSACT');
INSERT INTO code_det VALUES ( 'CR', 'CRBRJ', 'Loan Rejected By Bank' , 'SSACT');

-- Record Status Definition
INSERT INTO code_header VALUES ('SS', 'Commonly Used Status Code');
INSERT INTO code_det VALUES ( 'SS', 'SSACT', 'Active' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSDIS', 'Disabled' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSCAN', 'Cancelled' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSCLS', 'Closed' , 'SSACT');
INSERT INTO code_det VALUES ( 'SS', 'SSNEW', 'New' , 'SSACT');

-- Sales Commission Payout Status
INSERT INTO code_header VALUES ('CO', 'Commission Payout Status Code');
INSERT INTO code_det VALUES ( 'CO', 'COSUB', 'Submitted' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COAPP', 'Approved' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COREJ', 'Rejected' , 'SSACT');
INSERT INTO code_det VALUES ( 'CO', 'COPAI', 'Paid' , 'SSACT');

-- Sales Cancellation Status
INSERT INTO code_header VALUES ('CX', 'Sales Cancellation Status Code');
INSERT INTO code_det VALUES ( 'CX', 'CXSUB', 'Submitted' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXAPP', 'Approved' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXREJ', 'Rejected' , 'SSACT');
INSERT INTO code_det VALUES ( 'CX', 'CXCAN', 'Cancelled' , 'SSACT');

-- Property Status
INSERT INTO vipro.code_header VALUES ('PS', 'Property Status');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSSLD', 'Sold', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSAVL', 'Available', 'SSACT');
INSERT INTO vipro.code_det VALUES( 'PS', 'PSNAV', 'Not Available', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSPRG','In Progress','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSBOK','Booked','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSCAN','Cancelling','SSACT');
INSERT INTO vipro.code_det VALUES ('PS','PSRSV','Reserved','SSACT');

-- Unit Status
INSERT INTO code_header (code_header_id, name) VALUES ('BS', 'Booking Status');
INSERT INTO code_det VALUES ('BS', 'BSAVL', 'Available', 'SSACT');
INSERT INTO code_det VALUES ('BS', 'BSPRC', 'Processing', 'SSACT');
INSERT INTO code_det VALUES ('BS', 'BSBOK', 'Booked', 'SSACT');
INSERT INTO code_det VALUES ('BS', 'BSRSV', 'Reserved', 'SSACT');
INSERT INTO code_det VALUES ('BS', 'BSSLD', 'Sold', 'SSACT');

-- Transaction Status
INSERT INTO code_header (code_header_id, name) VALUES ('TS', 'Transaction Status Code');
INSERT INTO code_det VALUES ('TS', 'TSPEN', 'Pending Posting', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSCOM', 'Completed', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSPOS', 'Posted', 'SSACT');
INSERT INTO code_det VALUES ('TS', 'TSREJ', 'Rejected', 'SSACT');

-- Application Source
INSERT INTO vipro.code_header (code_header_id, name) VALUES ('ME', 'Media Source');
INSERT INTO vipro.code_det VALUES ('ME', 'MEFRD', 'Friend', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MENEW', 'Newspaper', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'METLV', 'Television', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MERAD', 'Radio', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MEBRD', 'Bill Board', 'SSACT');
INSERT INTO vipro.code_det VALUES ('ME', 'MEOTH', 'Other', 'SSACT');

-- Reporting Group
INSERT INTO vipro.code_header VALUES ('RG', 'Report Group');
INSERT INTO vipro.code_det VALUES ('RG', 'RGVRS', 'V-Residensi Report', 'SSACT');

-- Orientation
INSERT INTO vipro.code_header VALUES ('OR', 'Orientation of the property');
INSERT INTO vipro.code_det VALUES ('OR', 'OREND', 'End Lot', 'SSACT');
INSERT INTO vipro.code_det VALUES ('OR', 'ORINT', 'Intermediate', 'SSACT');
INSERT INTO vipro.code_det VALUES ('OR', 'ORCOR', 'Corner', 'SSACT');

-- Department (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('DM', 'Department in the Company');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSMA', 'Sales & Marketing', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSAD', 'Sales Admin', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMACT', 'Accounting', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMMGR', 'Management', 'SSACT');
INSERT INTO vipro.code_det VALUES ('DM', 'DMSYS', 'System Support', 'SSACT');

-- Purchase Type (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('PU', 'Purchase Type');
INSERT INTO vipro.code_det VALUES ('PU', 'PUBLN', 'Bank Loan', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCLN', 'Company Loan', 'SSACT');
INSERT INTO vipro.code_det VALUES ('PU', 'PUCSH', 'Cash', 'SSACT');

-- Solicitor (Bill 14/6)
INSERT INTO vipro.code_header VALUES ('SL', 'Name of Panel Solicitors');
INSERT INTO vipro.code_det VALUES ('SL', 'SLLLA', 'Low & Lee', 'SSACT');

-- Account Type (Bill 19/6)
INSERT INTO vipro.code_header VALUES ('AT', 'Account Type');
INSERT INTO vipro.code_det VALUES ('AT', 'ATCOM', 'Company Account', 'SSACT');
INSERT INTO vipro.code_det VALUES ('AT', 'ATIND', 'Individual / Personal Account', 'SSACT');

-- Transaction Code Loading
INSERT INTO vipro.transaction_code VALUES ('100001', 'Booking Fee', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('100002', 'Payment from Purchaser', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('100003', 'Payment from Bank', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('110001', 'Commission Fee Reversal', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('120001', 'Progressive Billing Reversal - Purchaser', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('120002', 'Progressive Billing Reversal - Bank', 'CR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('200001', 'Booking Fee Reversal', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('200002', 'Payment from Purchaser Reversal', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('200003', 'Payment from Bank Reversal', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('210001', 'Commission Fee', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('220001', 'Progressive Billing - Purchaser', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('220002', 'Progressive Billing - Bank', 'DR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('300001', 'Cancellation Fee Reversal - Booking', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('300002', 'Cancellation Fee Reversal - Purchaser', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('300003', 'Cancellation Fee Reversal - Bank', 'CR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('310001', 'Cancellation Tax Reversal', 'CR', null, 'SSACT');

INSERT INTO vipro.transaction_code VALUES ('400001', 'Cancellation Fee - Booking', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400002', 'Cancellation Fee - Purchaser', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400003', 'Cancellation Fee - Bank', 'DR', null, 'SSACT');
INSERT INTO vipro.transaction_code VALUES ('400004', 'Cancellation Tax', 'DR', null, 'SSACT');

-- Business Partner Parameters
INSERT INTO business_partner (partner_id, institution_id) 
     VALUES (0, 1000000001);
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'DEVP', 'B&G Development Sdn Bhd', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'LAND', 'Multi Bina Sdn Bhd', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'SOLI', 'Low & Lee', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'RHB - Paradigm Mall', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'RHB - Jinjang Utara Branch', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Affin Bank - Affin HQ (Central)', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'CIMB - Taman Sri Selayang', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Ambank - Menara Ambank', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'UOB - Medan Putra Business Centre', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Public Bank - Bandar Sunway', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'HLB - Taman Selayang Jaya', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'HSBC - Bandar Puchong Jaya', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'MBSB - Damansara Branch', 'SSACT');
INSERT INTO vipro.business_partner (institution_id, partner_type, company_name, status) 
     VALUES (1000000001, 'BANK', 'Alliance Bank - UEP Subang Jaya', 'SSACT');
     
-- 290613 Max  
INSERT INTO `vipro`.`code_header` (`code_header_id`, `name`) VALUES ('CI', 'City');
INSERT INTO `vipro`.`code_det` (`code_header_id`, `code`, `description`, `status`) VALUES ('CI', 'CIKUL', 'Kuala Lumpur', 'SSACT');
