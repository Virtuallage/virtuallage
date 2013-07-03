-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | This SQL will perform the following: -                                  |
-- | a. Create 300 existing purchasers info & address.                       | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/07/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+

-- >> 1
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (1, 1000000001, 'TTENC', 'Aminudin Bin Abu', 'CCIND', 
			'IDNIC', '660614-08-6165', 1, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0132788004', '0322031219', '', 'MSOTH', 'amenmy@yahoo.com', 19660614,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (1, 'Malaysian Japan International', 'Institute of Tech (MJIIT),', 'UTM Jalan Semarak,', '',
			'54100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 1);

-- >> 2
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (2, 1000000001, 'TTMST', 'Aravindan A/L Nachimuthoo', 'CCIND', 
			'IDNIC', '870623-08-5637', 2, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'0166449694', '', '', 'MSOTH', 'ara_vin87@yahoo.com', 19870623,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (2, 'No 5, Jalan 15/38E,', 'Taman Sri Sinar Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 2);

-- >> 3
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (3, 1000000001, 'TTMST', 'Bong Jak Boon', 'CCIND', 
			'IDNIC', '760422-13-6031', 3, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126180010', '', '', 'MSOTH', 'jakboon@gmail.com', 19760422,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (3, 'No. 19, Jalan Lang Peroi Putih 3,', 'Kepong Baru,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 3);

-- >> 4
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (4, 1000000001, 'TTMIS', 'Cham Chen Lea', 'CCIND', 
			'IDNIC', '870731-56-5208', 4, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0176365110', '', '', 'MSOTH', 'cherriecham87@gmail.com', 19870731,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (4, 'No. 10, Jalan 9/1A,', 'Taman Kepong Indah,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 4);

-- >> 5
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (5, 1000000001, 'TTMST', 'Chan Beng Hon', 'CCIND', 
			'IDNIC', '810206-14-5139', 5, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810206,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (5, 'A2-302, Enggang Apartment,', 'Taman Bukit Idaman,', 'Jalan Bukit Idaman 6,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 5);

-- >> 6
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (6, 1000000001, 'TTMIS', 'Chan Lay Sen', 'CCIND', 
			'IDNIC', '740616-06-5528', 6, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0126895376', '', '', 'MSOTH', 'wendy_cls@yahoo.com', 19740616,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (6, 'No 71, Jalan 2/3A,', 'Bandar Baru Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 6);

-- >> 7
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (7, 1000000001, 'TTMIS', 'Chang Kuai Fan', 'CCIND', 
			'IDNIC', '771115-06-5310', 7, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19771115,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (7, 'No 12, Jalan BPP 4/5,', 'Bandar Putra Permai,', '', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 7);

-- >> 8
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (8, 1000000001, 'TTMST', 'Chang Yew Cheong', 'CCIND', 
			'IDNIC', '870818-14-6049', 8, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870818,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (8, 'No 106 Block D1,', 'Seksyen 2,', 'Bandar Baru Wangsa Maju,', 'Setapak,',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 8);

-- >> 9
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (9, 1000000001, 'TTMIS', 'Chau Hui Ching', 'CCIND', 
			'IDNIC', '821227-14-5422', 9, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19821227,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (9, '153-14-4, Menara Duta Condo,', 'Jalan Duta Mas Raya,', 'Segambut,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 9);

-- >> 10
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (10, 1000000001, 'TTMST', 'Chau Shen Shung', 'CCIND', 
			'IDNIC', '871224-12-5229', 10, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0149295724', '', '', 'MSOTH', 'chauss87@gmail.com', 19871224,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (10, '39, Jalan 34B/38A,', 'Taman Sri Sinar,', 'Segambut,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 10);

-- >> 11
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (11, 1000000001, 'TTENC', 'Che Mustaffa Kamal B Che Wel', 'CCIND', 
			'IDNIC', '770104-11-5947', 11, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19770104,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (11, 'No 4A Jalan 33,', 'Selayang Baru,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 11);

-- >> 12
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (12, 1000000001, 'TTMST', 'Cheah Chee Kok', 'CCIND', 
			'IDNIC', '850224-14-5497', 12, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123652282', '', '', 'MSOTH', 'uzura85@gmail.com', 19850224,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (12, 'No. 4, Jalan 11/2A,', 'Taman Wilayah Selayang,', '', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 12);

-- >> 13
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (13, 1000000001, 'TTMIS', 'Cheang Pek Tan', 'CCIND', 
			'IDNIC', '781111-08-5700', 13, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19781111,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (13, 'B415, Paradesa Tropica,', 'Bandar Sri Damansara,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 13);

-- >> 14
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (14, 1000000001, 'TTMST', 'Chee Fook Sang', 'CCIND', 
			'IDNIC', '860610-56-6619', 14, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'01223288975', '', '', 'MSOTH', '', 19860610,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (14, 'No.5, Jalan Teluki 6 B,', 'Seksyen 2 Bukit Sentosa,', '', '',
			'48300', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 14);

-- >> 15
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (15, 1000000001, 'TTMIS', 'Chen Chooi Yoon', 'CCIND', 
			'IDNIC', '750518-14-5654', 15, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19750518,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (15, 'No 20, Jalan Wangsa 1/7,', 'Taman Wangsa Permai,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 15);

-- >> 16
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (16, 1000000001, 'TTMST', 'Cheo Kah Wai', 'CCIND', 
			'IDNIC', '830825-14-6059', 16, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192746354', '', '', 'MSOTH', '', 19830825,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (16, 'No. 54, Jalan 4/8,', 'Bukit Rahman Putra,', '', '',
			'47000', 'Sungai Buloh,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 16);

-- >> 17
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (17, 1000000001, 'TTMIS', 'Chin Siew Yin', 'CCIND', 
			'IDNIC', '650619-10-6402', 17, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0163022288', '0362509335', '', 'MSOTH', 'cycnetworking@hotmail.com', 19650619,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (17, 'No 54, Jalan 13/18A,', 'Taman Mastiara Batu 5,', 'Jalan Ipoh,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 17);

-- >> 18
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (18, 1000000001, 'TTMST', 'Chin Soo Ming', 'CCIND', 
			'IDNIC', '711013-06-5067', 18, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193375226', '', '', 'MSOTH', 'erichonlt@yahoo.com.my', 19711013,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (18, '13-07-15 Jelutong Apartment,', 'Jalan SH 1/2,', 'Selayang Heights,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 18);

-- >> 19
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (19, 1000000001, 'TTMST', 'Chong Boon Hai', 'CCIND', 
			'IDNIC', '680930-02-5231', 19, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19711013,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (19, 'No 7, Jalan 6/58A,', 'Taman Kaya,', 'Off Jalan Ipoh,', '',
			'51100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 19);

-- >> 20
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (20, 1000000001, 'TTMST', 'Chong Keam Meng', 'CCIND', 
			'IDNIC', '730628-08-5383', 20, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126668960', '0361207360', '', 'MSOTH', 'c_yen_87@hotmail.com', 19730628,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (20, 'Block 8-2-8,', 'Jalan 1/1A,', 'Taman Kepong Indah,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 20);

-- >> 21
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (21, 1000000001, 'TTMST', 'Chong Kian Shiong', 'CCIND', 
			'IDNIC', '791115-14-5677', 21, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'016255539', '', '', 'MSOTH', '', 19791115,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (21, 'A-06-03, Aman Puri Apartment,', 'Jalan Aman Desa,', 'Aman Puri Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 21);

-- >> 22
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (22, 1000000001, 'TTMST', 'Chong Teck Hoong', 'CCIND', 
			'IDNIC', '750703-14-5111', 22, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122679693', '', '', 'MSOTH', '', 19750703,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (22, 'No. 1250, Jalan Ulu Klang,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 22);

-- >> 23
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (23, 1000000001, 'TTMST', 'Chong Wei Sheong', 'CCIND', 
			'IDNIC', '750316-14-5445', 23, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0102209966', '', '', 'MSOTH', '', 19750316,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (23, 'No 12A, Jalan Residen 7,', 'Laman Residen,', 'Sri Utara off Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 23);

-- >> 24
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (24, 1000000001, 'TTMST', 'Chong Yong Cheng', 'CCIND', 
			'IDNIC', '641225-04-5323', 24, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122303050', '', '', 'MSOTH', '', 19641225,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (24, '40, Jalan SS23/21,', 'Taman Sea,', '', '',
			'47400', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 24);

-- >> 25
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (25, 1000000001, 'TTMST', 'Chong Yoon Hee', 'CCIND', 
			'IDNIC', '760429-14-5205', 25, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760429,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (25, 'A-325, Jalan F.R.I,', 'Kepong Hulu,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 25);

-- >> 26
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (26, 1000000001, 'TTMST', 'Choo Yu Leong', 'CCIND', 
			'IDNIC', '741228-14-5731', 26, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123787999', '', '', 'MSOTH', '', 19741228,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (26, '33, Jalan Metro Perdana Barat 15,', 'Taman Usahawan Kepong,', 'Kepong Utara,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 26);

-- >> 27
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (27, 1000000001, 'TTMST', 'Choong Li Loh', 'CCIND', 
			'IDNIC', '790808-07-5283', 27, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0129733682', '', '', 'MSOTH', '', 19790808,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (27, 'No.1, Jalan Wangsa Budi 2,', 'Wangsa Melawati,', '', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 27);

-- >> 28
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (28, 1000000001, 'TTMST', 'Choong Wee Jin', 'CCIND', 
			'IDNIC', '831229-01-6121', 28, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831229,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (28, 'No 3, Jalan Ampang Jaya 4,', 'Taman Ampang Jaya,', '', '',
			'83000', 'Batu Pahat,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 28);	

-- >> 29
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (29, 1000000001, 'TTMST', 'Chow Horng Tzong', 'CCIND', 
			'IDNIC', '880820-08-5213', 29, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0165369059', '', '', 'MSOTH', 'cht9963@gmail.com', 19880820,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (29, 'No 55, Persiaran Buntong Jaya 16,', 'Taman Buntong Jaya Baru,', '', '',
			'30100', 'Ipoh,', 'STPER', 'CTMAS', 20130625, 'sysadm', 29);
	
-- >> 30
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (30, 1000000001, 'TTMST', 'Choy Mun Wei', 'CCIND', 
			'IDNIC', '780313-14-6327', 30, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122693399', '', '', 'MSOTH', 'ericchoy2003@hotmail.com', 19780313,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (30, 'No. 15 Jalan 2/20C,', 'Bandar Baru Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 30);

-- >> 31
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (31, 1000000001, 'TTMST', 'Cong Yoon Chet', 'CCIND', 
			'IDNIC', '820409-14-5613', 31, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163029833', '', '', 'MSOTH', '', 19820409,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (31, '54, Jalan 13/18A,', 'Taman Mastiara Batu 5,', 'Jalan Ipoh,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 31);

-- >> 32
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (32, 1000000001, 'TTMST', 'Daryshini A/P Jeya Kumar', 'CCIND', 
			'IDNIC', '891202-14-6684', 32, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122238620', '', '', 'MSOTH', 'shinijk89@gmail.com', 19891202,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (32, '54B, Jalan Padang Belia,', 'Off Jalan Tun Sambanthan 4,', 'Brickfields,', '',
			'50470', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 32);

-- >> 33
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (33, 1000000001, 'TTMST', 'Elango A/L S. Gopal', 'CCIND', 
			'IDNIC', '860315-23-7273', 33, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0167271743', '', '', 'MSOTH', 'elango86.2u@yahoo.com.my', 19860315,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (33, 'No. 42, Jalan Gangsa 2,', 'Taman Seri Puteri,', '', '',
			'81300', 'Skudai,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 33);
			
-- >> 34
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (34, 1000000001, 'TTMST', 'Gan Lee Boon', 'CCIND', 
			'IDNIC', '721222-02-5167', 34, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192753760', '', '', 'MSOTH', '', 19721222,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (34, 'No. 3, Jalan PS 4/2,', 'Taman Prima Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 34);	
	
-- >> 35
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (35, 1000000001, 'TTMST', 'Goh Hwa Pin', 'CCIND', 
			'IDNIC', '851030-08-6251', 35, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851030,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (35, 'No 37, Jalan 46 Bidara,', 'Kepong Baru,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 35);	
	
-- >> 36
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (36, 1000000001, 'TTMST', 'Goh Wee Kai', 'CCIND', 
			'IDNIC', '881214-04-5419', 36, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162329405', '', '', 'MSOTH', 'goh_wk@hotmail.com', 19881214,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (36, 'No 21, Jalan 10/39,', 'Taman Petaling Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 36);	
			
-- >> 37
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (37, 1000000001, 'TTMST', 'Alan Ling Yee Sen', 'CCIND', 
			'IDNIC', '841117-13-5985', 37, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841117,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (37, 'No.17-3 Jalan Amansiara 3/3,', 'Taman Amansiara,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 37);	

-- >> 38
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (38, 1000000001, 'TTMST', 'Ang Chee Mon', 'CCIND', 
			'IDNIC', '830107-02-5455', 38, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19830107,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (38, 'Wisma Prima, 17, 3rd Floor,', 'Jalan Sri Semantan 1,', 'Damansara Heights,', '',
			'50490', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 38);	

-- >> 39
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (39, 1000000001, 'TTENC', 'Awang Draup bin Pengiran Die', 'CCIND', 
			'IDNIC', '551205-13-5509', 39, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0198847080', '085452359', '', 'MSOTH', 'awang.draup@gmail.com', 19551205,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (39, '89, Prima Villa,', 'Permyjaya,', 'Damansara Heights,', '',
			'98100', 'Miri', 'STSAR', 'CTMAS', 20130625, 'sysadm', 39);	

-- >> 40
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (40, 1000000001, 'TTMST', 'Boh Ah Seng', 'CCIND', 
			'IDNIC', '650128-10-7531', 40, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19650128,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (40, '14, Jalan Daya 5/1,', 'Taman Daya Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 40);

-- >> 41
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (41, 1000000001, 'TTMST', 'Chan Gar Keat', 'CCIND', 
			'IDNIC', '850127-10-5119', 41, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850127,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (41, 'C-4-8 Permata Fadason Park 2/17,', 'Off Jalan Kepong,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 41);

-- >> 42
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (42, 1000000001, 'TTMST', 'Chan Gar Lei', 'CCIND', 
			'IDNIC', '900926-14-5179', 42, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19900926,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (42, 'C-4-8 Permata Fadason Park 2/17,', 'Off Jalan Kepong,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 42);

-- >> 43
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (43, 1000000001, 'TTMST', 'Chan Seong Hoi', 'CCIND', 
			'IDNIC', '690210-08-6211', 43, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19690210,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (43, 'Lot 1013-B, Jalan 2/32A,', '6 1/2 Miles, Kepong Industrial Area,', 'Jalan Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 43);

-- >> 44
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (44, 1000000001, 'TTMST', 'Cheang Han Joe', 'CCIND', 
			'IDNIC', '870803-56-5099', 44, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870803,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (44, 'Lot 523, Jalan E2/1,', 'Taman Ehsan,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 44);

-- >> 45
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (45, 1000000001, 'TTMIS', 'Chee May May', 'CCIND', 
			'IDNIC', '721110-14-5340', 45, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19721110,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (45, '14-2, Prima Tiara 2,', 'No 2, Jalan 6/38A,', 'Taman Sri Sinar,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 45);

-- >> 46
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (46, 1000000001, 'TTMST', 'Chen Tuck Yeong', 'CCIND', 
			'IDNIC', '730908-14-5029', 46, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19730908,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (46, 'No. 4, Jalan Sengaring,', 'Taman Tenaga,', '', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 46);

-- >> 47
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (47, 1000000001, 'TTMIS', 'Chen Zhing Wei', 'CCIND', 
			'IDNIC', '861107-56-5680', 47, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0162101128', '', '', 'MSOTH', '', 19861107,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (47, '45, Jalan Nikmat,', 'Taman Bukit Aman,', '', '',
			'58200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 47);

-- >> 48
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (48, 1000000001, 'TTMIS', 'Chen Zhing Yee', 'CCIND', 
			'IDNIC', '850206-14-5768', 48, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0163859142', '', '', 'MSOTH', '', 19850206,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (48, '45, Jalan Nikmat,', 'Taman Bukit Aman,', '', '',
			'58200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 48);

-- >> 49
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (49, 1000000001, 'TTMIS', 'Cheong Kai Yan', 'CCIND', 
			'IDNIC', '820114-08-5334', 49, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820114,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (49, 'No 155,', 'Taman Desa Minang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 49);

-- >> 50
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (50, 1000000001, 'TTMIS', 'Chew Huey Bee', 'CCIND', 
			'IDNIC', '800503-08-5014', 50, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0126737611', '', '', 'MSOTH', 'hbc3580@hotmail.com', 19800503,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (50, '73, Desa Damai,', 'Alam Damai,', 'Cheras,', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 50);


-- >> 51
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (51, 1000000001, 'TTMST', 'Cheong Meng Kiat', 'CCIND', 
			'IDNIC', '771230-14-6175', 51, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19771230,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (51, '1-11-7, Genting Court Condo,', 'Taman Setapak Indah Jaya,', 'Off Jalan Genting Kelang,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 51);

-- >> 52
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (52, 1000000001, 'TTMST', 'Cheong Wen Chiet', 'CCIND', 
			'IDNIC', '850301-06-5483', 52, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850301,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (52, 'C-2-08, Drimba Apartment,', 'Jalan Kenyalang 11/14,', '', '',
			'47810', 'Kota Damansara,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 52);

-- >> 53
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (53, 1000000001, 'TTMST', 'Chew Chin Tong', 'CCIND', 
			'IDNIC', '841216-08-6103', 53, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841216,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (53, 'VS9-17Jalan Wangsa 2/6,', 'Vista Saujana,', 'Taman Wangsa Permai,', 'Kepong,',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 53);

-- >> 54
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (54, 1000000001, 'TTMST', 'Chew Kwok Hwa', 'CCIND', 
			'IDNIC', '681211-10-5459', 54, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19681211,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (54, 'No 2073, West Street 6,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 54);
	
-- >> 55
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (55, 1000000001, 'TTMST', 'Chew Kwok Lim', 'CCIND', 
			'IDNIC', '731130-14-5259', 55, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19731130,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (55, 'No 2073, West Street 6,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 55);

-- >> 56
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (56, 1000000001, 'TTMST', 'Chia Joo Ee', 'CCIND', 
			'IDNIC', '700722-10-5259', 56, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19700722,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (56, 'B-12-2, Selayang Point,', 'Jalan SP 1,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 56);

-- >> 57
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (57, 1000000001, 'TTMIS', 'Chia Mei Ling', 'CCIND', 
			'IDNIC', '890206-08-6530', 57, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19890206,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (57, 'No.24, Jalan SJ 3,', 'Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 57);

-- >> 58
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (58, 1000000001, 'TTMST', 'Chiew Chee Hoe', 'CCIND', 
			'IDNIC', '860920-43-6457', 58, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19860920,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (58, 'No.181, Taman City,', 'Jalan Kuching', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 58);	

-- >> 59
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (59, 1000000001, 'TTMIS', 'Chin Souk Mee', 'CCIND', 
			'IDNIC', '870406-56-5204', 59, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19870406,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (59, '343, Kawasan 6,', '', '', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 59);		

-- >> 60
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (60, 1000000001, 'TTMST', 'Chin Sow Keng', 'CCIND', 
			'IDNIC', '690422-10-5357', 60, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19690422,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (60, 'B-G-07, Jalan Indah 2/12,', 'Red Ruby 2 Shop Apartment,', 'Taman University Indah,', '',
			'43300', 'Seri Kembangan,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 60);

-- >> 61
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (61, 1000000001, 'TTMST', 'Choe Jia Jen', 'CCIND', 
			'IDNIC', '821014-07-5221', 61, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19881014,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (61, '146, Lorong 8,', 'Taman Jana Permai,', '', '',
			'34600', 'Kamunting,', 'STPER', 'CTMAS', 20130625, 'sysadm', 61);

-- >> 62
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (62, 1000000001, 'TTMST', 'Chong Chee Seng', 'CCIND', 
			'IDNIC', '880811-56-5637', 62, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880811,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (62, 'No. 3, Jalan Flora Impian', 'Taman Flora Impian,', 'Segambut Tengah,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 62);

-- >> 63
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (63, 1000000001, 'TTMST', 'Chong Cheong Jun', 'CCIND', 
			'IDNIC', '880820-14-5263', 63, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880820,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (63, 'No.22, Jalan 8/17,', 'Off Jalan Kepong,', 'Taman Fadason,', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 63);

-- >> 64
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (64, 1000000001, 'TTMIS', 'Chong Chooi Yong', 'CCIND', 
			'IDNIC', '780719-08-5720', 64, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19780719,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (64, 'MG 8, Selayang Mesra,', 'Jalan SJ 17A,', 'Taman Selayang Bahagia,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 64);

-- >> 65
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (65, 1000000001, 'TTMST', 'Chong Kim Boon', 'CCIND', 
			'IDNIC', '760713-14-5835', 65, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760713,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (65, '19-1-6 Block 19 Jalan 3/50C,', 'Taman Setapak Indah Jaya,', 'Jalan Bukit Idaman 6,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 65);

-- >> 66
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (66, 1000000001, 'TTMST', 'Chong Xin Jian', 'CCIND', 
			'IDNIC', '851231-10-5201', 66, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851231,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (66, 'Block H2-02-03,', 'Jalan SH 2/2,', 'Andari Townvilla', 'Selayang Height,',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 66);

-- >> 67
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (67, 1000000001, 'TTMIS', 'Choo Seck Ling', 'CCIND', 
			'IDNIC', '761122-14-5950', 67, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19761122,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (67, 'No.1 Ground Floor,', 'Jalan 3/62A,', 'Bandar Menjalara,', 'Kepong,',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 67);

-- >> 68
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (68, 1000000001, 'TTMST', 'Chua Hong Seng', 'CCIND', 
			'IDNIC', '840629-10-5603', 68, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840629,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (68, 'A-6-5 Villa Lagenda,', 'Jalan 4/2B,	Taman Desa Bakti,', 'Bandar Baru Wangsa Maju,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 68);

-- >> 69
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (69, 1000000001, 'TTMIS', 'Chua Li-Shun', 'CCIND', 
			'IDNIC', '850613-10-5106', 69, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0123325104', '', '', 'MSOTH', '', 19850613,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (69, 'No. 1, Jalan SS 2/85,', '', '', '',
			'47300', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 69);

-- >> 70
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (70, 1000000001, 'TTMST', 'Chua Yeow Kwong', 'CCIND', 
			'IDNIC', '611022-07-5461', 70, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19611022,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (70, '198-B, Jalan Kampung Pisang,', '', '', '',
			'11500', 'Air Itam,', 'STPEN', 'CTMAS', 20130625, 'sysadm', 70);

-- >> 71
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (71, 1000000001, 'TTMIS', 'Chung Foong Ting', 'CCIND', 
			'IDNIC', '820922-14-5526', 71, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820922,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (71, 'No. 22 Jalan Melati 11,', 'Taman Sri Melati,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 71);

-- >> 72
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (72, 1000000001, 'TTDAT', 'Abdul Hamid Bin Bador', 'CCIND', 
			'IDNIC', '580807-10-6599', 72, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0192435082', '', '', 'MSOTH', '', 19580807,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (72, 'No. 71,	Jalan Taman Melati 6,', 'Setapak,', '', '',
			'53100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 72);

-- >> 73
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (73, 1000000001, 'TTDAT', 'Seri Akhil Bin Bulat', 'CCIND', 
			'IDNIC', '530818-05-5437', 73, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0192435082', '', '', 'MSOTH', '', 19530818,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (73, 'No. 1, Jalan Mawar 3A,', 'Prima Beruntung,', '', '',
			'48300', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 73);

-- >> 74
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (74, 1000000001, 'TTENC', 'Dazrin Bin Mohd Darbi', 'CCIND', 
			'IDNIC', '781205-10-5573', 74, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19781205,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (74, 'No 5, Jalan Serampang 11/2J,', '', '', '',
			'40100', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 74);

-- >> 75
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (75, 1000000001, 'TTMIS', 'Ek Mee Lan', 'CCIND', 
			'IDNIC', '640111-08-5066', 75, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0192435082', '', '', 'MSOTH', '', 19640111,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (75, '86, Jalan 27/164,', 'Taman Bukit Anggerik,', 'Cheras,', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 75);

-- >> 76
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (76, 1000000001, 'TTMST', 'Eng Kong Ming', 'CCIND', 
			'IDNIC', '741028-10-5751', 76, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163221738', '', '', 'MSOTH', '', 19741028,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (76, 'No 25, Jalan U16/11,', 'Bukit Subang,', '', '',
			'40160', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 76);

-- >> 77
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (77, 1000000001, 'TTMIS', 'Er Suen Kae', 'CCIND', 
			'IDNIC', '801029-01-5725', 77, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19801029,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (77, '289 Taman Bakri Jaya,', '', '', '',
			'84200', 'Muar,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 77);

-- >> 78
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (78, 1000000001, 'TTMST', 'Er Suen Xuang', 'CCIND', 
			'IDNIC', '901018-01-5031', 78, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19901018,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (78, '289, Taman Bakri Jaya,', '', '', '',
			'84200', 'Muar,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 78);

-- >> 79
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (79, 1000000001, 'TTMST', 'Foo Lik Chung', 'CCIND', 
			'IDNIC', '871201-14-5315', 79, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0176065580', '', '', 'MSOTH', 'likchungfoo@yahoo.com', 19871201,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (79, '223 A, Casa Prima Condo,', 'Metro Prima 2,', 'Metro Prima Kepong,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 79);

-- >> 80
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (80, 1000000001, 'TTMIS', 'Foong Pei Wen', 'CCIND', 
			'IDNIC', '840811-14-5310', 80, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840811,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (80, 'No.10, Jalan Anggerik 10A,', 'Taman Puchong Perdana,', '', '',
			'47100', 'Puchong,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 80);

-- >> 81
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (81, 1000000001, 'TTMST', 'Gan Hin Ming', 'CCIND', 
			'IDNIC', '790715-10-5615', 81, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19790715,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (81, 'No 156, Lorong 3,', 'Site B,', '', '',
			'45400', 'Sekinchan,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 81);

-- >> 82
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (82, 1000000001, 'TTMST', 'Goo Chee Huat', 'CCIND', 
			'IDNIC', '830616-14-5527', 82, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19830616,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (82, '20, Jalan Wangsa 1/7,', 'Taman Wanga Permai,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 82);

-- >> 83
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (83, 1000000001, 'TTMIS', 'Goo I Ling', 'CCIND', 
			'IDNIC', '780405-10-5258', 83, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0122181288', '', '', 'MSOTH', '', 19780405,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (83, '1, Jalan 5/58A,', 'Taman Kaya,', 'ff Jalan Ipoh,', '',
			'51100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 83);

-- >> 84
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (84, 1000000001, 'TTMIS', 'Goo Mei Leng', 'CCIND', 
			'IDNIC', '760820-14-5478', 84, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19760820,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (84, '20, Jalan Wangsa 1/7,', 'Taman Wanga Permai,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 84);

-- >> 85
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (85, 1000000001, 'TTENC', 'Hasbullah Bin Harun', 'CCIND', 
			'IDNIC', '850220-08-5001', 85, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850220,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (85, 'F2-G-02, Garden Ville,', 'Jalan SH 2/1,', 'Selayang Heights,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 85);

-- >> 86
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (86, 1000000001, 'TTMST', 'Heng Kae Lih', 'CCIND', 
			'IDNIC', '870504-14-5297', 86, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870504,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (86, 'No.7 Lorong 6C,', 'Taman Indah Baiduri,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 86);

-- >> 87
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (87, 1000000001, 'TTMIS', 'Heng Kai Sin', 'CCIND', 
			'IDNIC', '900603-14-5254', 87, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19900603,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (87, 'No.7 Lorong 6C,', 'WTaman Indah Baiduri,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 87);

-- >> 88
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (88, 1000000001, 'TTMST', 'Heng Mok Hooi', 'CCIND', 
			'IDNIC', '630609-08-5267', 88, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19630609,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (88, 'No.7 Lorong 6C,', 'Taman Indah Baiduri,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 88);	

-- >> 89
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (89, 1000000001, 'TTMST', 'Heng Wang Ping', 'CCIND', 
			'IDNIC', '840620-08-6637', 89, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0177737082	', '', '', 'MSOTH', 'm', 19840620,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (89, 'No. 27/29, Jalan Cahaya 9,', 'Taman Bedena Jaya,', '', '',
			'45300', 'Sungai Besar,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 89);
	
-- >> 90
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (90, 1000000001, 'TTMST', 'Ho Kok Lim', 'CCIND', 
			'IDNIC', '821125-08-5713', 90, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19821125,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (90, 'No 249 & 251, Jalan Selingsing 7,', 'Titian Waris Business Park,', 'Off Jalan Kuching,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 90);

-- >> 91
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (91, 1000000001, 'TTMST', 'Ho Kok Siong', 'CCIND', 
			'IDNIC', '730316-14-5375', 91, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19730316,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (91, 'No.1003, Jalan Jinjang Murni 7,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 91);

-- >> 92
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (92, 1000000001, 'TTMIS', 'Ho Sze Whei', 'CCIND', 
			'IDNIC', '850526-14-5994', 92, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'012626139', '', '', 'MSOTH', 'whei85@hotmail.com', 19850526,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (92, 'No 9, Jalan 47,	Selayang Baru,', '', '', '',
			'68100', 'Batu Caves', 'STSEL', 'CTMAS', 20130625, 'sysadm', 92);

-- >> 93
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (93, 1000000001, 'TTMST', 'Hong Eng Sing', 'CCIND', 
			'IDNIC', '610820-10-6627', 93, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192305610', '', '', 'MSOTH', 'albertes_hong@gmail.com', 19620820,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (93, 'No 2, Jalan Safa 6,', 'Safa Terraces,', 'Desa Parkcity,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 93);
			
-- >> 94
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (94, 1000000001, 'TTMST', 'How Kian Ming', 'CCIND', 
			'IDNIC', '690905-10-5415', 94, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0', '', '', 'MSOTH', '', 19690905,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (94, 'No 8, Jalan Safa 1,', 'Safa Terraces,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 94);	
	
-- >> 95
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (95, 1000000001, 'TTMIS', 'How Siow Khim', 'CCIND', 
			'IDNIC', '820705-14-5642', 95, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820705,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (95, 'Block H2-01-02,	Jalan SH 2/2,', 'Andari Townvilla,', 'Selayang Height,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 95);	
	
-- >> 96
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (96, 1000000001, 'TTMIS', 'Hu Foong Lian', 'CCIND', 
			'IDNIC', '780922-14-5928', 96, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19780922,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (96, 'B-01-23, Damansara Mas Apartment,', 'Taman KIP,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 96);	
			
-- >> 97
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (97, 1000000001, 'TTMST', 'Hu Poh Han', 'CCIND', 
			'IDNIC', '810702-14-5381', 97, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810702,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (97, 'No.64, Jalan 10/38D,', 'Taman Sri Sinar Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 97);	

-- >> 98
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (98, 1000000001, 'TTMST', 'Huang Yi Tsu', 'CCIND', 
			'IDNIC', '890918-43-5129', 98, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19890918,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (98, '6, Jalan Bullion Mewah 12,', 'Taman Bullion Mewah,', 'Sentul,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 98);	

-- >> 99
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (99, 1000000001, 'TTENC', 'Ismadi Faizal Bin Ishak', 'CCIND', 
			'IDNIC', '831210-07-5439', 99, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0122726574', '', '', 'MSOTH', 'ismadifaizal@muamalat.com.my', 19831210,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (99, 'No 29, Jalan Templer Suasana 4', 'Templer Park Resort,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 99);	

-- >> 100
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (100, 1000000001, 'TTMIS', 'Jasvinder Kaur A/P Bajan Singh', 'CCIND', 
			'IDNIC', '760925-07-5234', 100, 'RCIND', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19760925,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (100, 'C5-7 Tudor Court Apartment, Jalan Dedap', 'Taman Rasmi Jaya,', '', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 100);

-- >> 101
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (101, 1000000001, 'TTMST', 'John Looi', 'CCIND', 
			'IDNIC', '999999-99-9999', 101, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19990909,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (101, 'John Looi', '', '', '',
			'88888', '', 'STKUL', 'CTMAS', 20130625, 'sysadm', 101);

-- >> 102
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (102, 1000000001, 'TTMST', 'Jujaar Singh A/L Maggar Singh', 'CCIND', 
			'IDNIC', '791123-14-5343', 102, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'0129190819', '', '', 'MSOTH', 'jujaarsingh25@yahoo.com', 19791123,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (102, 'No. 58A, Jalan LP 3,', 'Taman Laksamana Permai,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 102);

-- >> 103
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (103, 1000000001, 'TTMST', 'Kanesan A/L Chinniah', 'CCIND', 
			'IDNIC', '831221-02-5461', 103, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831221,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (103, '7-9 Pangsapuri Bukit Segambut,', 'Taman Sri Bintang,', 'Jalan Seri Bintang,', 'Segambut,',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 103);

-- >> 104
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (104, 1000000001, 'TTMST', 'Kee Hong Kuang', 'CCIND', 
			'IDNIC', '910503-06-5045', 104, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19910503,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (104, 'No. 26, Jalan Pandan Indah 16,', '', '', '',
			'55100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 104);

-- >> 105
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (105, 1000000001, 'TTMST', 'Kesavan A/L Suprmaniam', 'CCIND', 
			'IDNIC', '870406-56-5263', 105, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870406,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (105, 'B2-2-W3 Jalan Sri Ehsan 15,', 'Taman Sri Ehsan,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 105);

-- >> 106
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (106, 1000000001, 'TTMST', 'Khairulnizam Bin Yusof', 'CCIND', 
			'IDNIC', '770906-04-5565', 106, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192806921', '', '', 'MSOTH', '', 19770906,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (106, 'No. 24, Jalan Melor 3B,	Desa Melor,', '', '', '',
			'48200', '', 'STSEL', 'CTMAS', 20130625, 'sysadm', 106);

-- >> 107
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (107, 1000000001, 'TTMIS', 'Khew Hoong Ying', 'CCIND', 
			'IDNIC', '450203-08-5496', 107, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19450203,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (107, 'B-3-6, Block B,	SMC Taman Sri Manja,', 'Jalan PJS 3/40,', '', '',
			'46000', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 107);

-- >> 108
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (108, 1000000001, 'TTMST', 'Koh Ing Sing', 'CCIND', 
			'IDNIC', '341107-08-5303', 108, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122960916', '', '', 'MSOTH', '', 19341107,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (108, 'No. 6, Jalan SS2/80,', '', '', '',
			'47300', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 108);

-- >> 109
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (109, 1000000001, 'TTMIS', 'Cheong Kai Yan', 'CCIND', 
			'IDNIC', '810804-14-5892', 109, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0122286129', '', '', 'MSOTH', 'joeykjm@yahoo.com', 19810804,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (109, '1250, Jalan E4/9,', 'Taman Ehsan,', 'Kepong', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 109);

-- >> 110
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (110, 1000000001, 'TTMIS', 'Koh Kim Eng', 'CCIND', 
			'IDNIC', '631023-10-7208', 110, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19631023,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (110, 'No.5, Jalan Bullion Mewah 11,', 'Taman Bullion Mewah,', 'Sentul,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 110);

-- >> 111
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (111, 1000000001, 'TTMIS', 'Koh Suet Yin', 'CCIND', 
			'IDNIC', '830507-14-5456', 111, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0126769083', '', '', 'MSOTH', 'esther_7583@hotmail.com', 19830507,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (111, '21, Jalan 10/39,', 'Taman Petaling Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 111);

-- >> 112
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (112, 1000000001, 'TTMST', 'Kok Chun Foong', 'CCIND', 
			'IDNIC', '880215-08-5629', 112, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126127627', '', '', 'MSOTH', 'foong_2872@yahoo.com', 19880215,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (112, 'No 27, Jalan SJ 18,', 'Taman Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 112);

-- >> 113
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (113, 1000000001, 'TTMST', 'Kong Kah Shoong', 'CCIND', 
			'IDNIC', '870523-56-5457', 113, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870523,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (113, '101, Block G5, Sek 2,', 'Wangsa Maju,', 'Setapak,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 113);

-- >> 114
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (114, 1000000001, 'TTMST', 'Kua Hock Lai', 'CCIND', 
			'IDNIC', '640329-10-7037', 114, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193315568', '', '', 'MSOTH', 'zacksonkua@hotmail.com', 19640329,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (114, 'No. 3, Jalan Udang Harimau 3,', 'Medan Niaga Kepong,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 114);

-- >> 115
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (115, 1000000001, 'TTMST', 'Lai Kien Leak', 'CCIND', 
			'IDNIC', '850101-14-5681', 115, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850101,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (115, 'No 342, Jalan Jambu Berasa Dua,', 'Jinjang Selatan,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 115);

-- >> 116
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (116, 1000000001, 'TTMST', 'Lai Wei Jin', 'CCIND', 
			'IDNIC', '850905-14-5513', 116, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850905,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (116, '1338-A, West Street 3,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 116);

-- >> 117
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (117, 1000000001, 'TTMST', 'Lau Chee Siong', 'CCIND', 
			'IDNIC', '730126-14-5147', 117, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19730126,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (117, 'A-12-01, Vista Mutiara,', 'Jalan Vista Mutiara 1,', 'Off Jalan Kepong,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 117);

-- >> 118
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (118, 1000000001, 'TTMST', 'Lau Cheng Kok', 'CCIND', 
			'IDNIC', '871116-14-5791', 118, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0197710663', '', '', 'MSOTH', 'lilguo@hire.com', 19871116,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (118, '27, Jalan Tasik Indah 4,', 'Taman Tasik Indah,', 'Off Jalan Ipoh,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 118);	

-- >> 119
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (119, 1000000001, 'TTMST', 'Lau Er Kheng', 'CCIND', 
			'IDNIC', '820913-14-6025', 119, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19820913,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (119, 'No 12, Lorong Hulubalang 27B,', 'Taman Sentosa,', '', '',
			'41200', 'Klang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 119);		

-- >> 120
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (120, 1000000001, 'TTMST', 'Lau Kee Boon', 'CCIND', 
			'IDNIC', '690616-10-6059', 120, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19690616,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (120, 'No 937 Jalan E4/5,', 'Taman Ehsan Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 120);

-- >> 121
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (121, 1000000001, 'TTMIS', 'Law Geok Imm', 'CCIND', 
			'IDNIC', '720426-08-5650', 121, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19720426,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (121, 'No 63 Jalan 19,	Desa Jaya,', 'Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 121);

-- >> 122
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (122, 1000000001, 'TTMST', 'Law Kok Thai', 'CCIND', 
			'IDNIC', '790510-14-5103', 122, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19790510,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (122, 'Lot 35, Kawasan Perindustrian,', 'Batu 61/2 Jalan Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 122);

-- >> 123
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (123, 1000000001, 'TTMST', 'Lean Hin Who', 'CCIND', 
			'IDNIC', '690223-08-5373', 123, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162060188', '', '', 'MSOTH', '', 19690223,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (123, '55-1 Block 2,', 'Jalan Metro Perdana Timur 3,', 'Taman Usahawan Kepong Utara,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 123);

-- >> 124
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (124, 1000000001, 'TTMST', 'Lee Bong Hwang', 'CCIND', 
			'IDNIC', '830922-14-5103', 124, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'012-3690531', '', '', 'MSOTH', 'leemax19@hotmail.com', 19830922,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (124, '47, Jalan 7/1A,', 'Taman Kepong Indah,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 124);

-- >> 125
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (125, 1000000001, 'TTMST', 'Lee Chee Yam', 'CCIND', 
			'IDNIC', '880319-14-6131', 125, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'85297159385', '', '', 'MSOTH', 'jacky319@hotmail.com', 19880319,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (125, '12, Jalan Segambut Dalam,', '', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 125);

-- >> 126
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (126, 1000000001, 'TTMIS', 'Lee Cheng Sim', 'CCIND', 
			'IDNIC', '801106-08-6018', 126, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19801106,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (126, 'C-1-09 Blok C,', 'Jalan Beringin 8F,', 'Taman Selayang Makmur,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 126);

-- >> 127
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (127, 1000000001, 'TTMST', 'Lee Choon Han', 'CCIND', 
			'IDNIC', '780308-13-6183', 127, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19780308,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (127, 'No.11 Jalan SU 6,', 'Taman Selayang Utama,', '', '',
			'68100', 'Batu Caves', 'STSEL', 'CTMAS', 20130625, 'sysadm', 127);

-- >> 128
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (128, 1000000001, 'TTMST', 'Lee Choon Tuck', 'CCIND', 
			'IDNIC', '821116-14-6465', 128, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19821116,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (128, 'Blk 988A,', 'Jurong West Street 93,', '#11-625,', '',
			'641988', '', 'STOTH', 'CTSIN', 20130625, 'sysadm', 128);	

-- >> 129
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (129, 1000000001, 'TTMST', 'Lee Eng Soon', 'CCIND', 
			'IDNIC', '870627-56-5603', 129, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123078693', '', '', 'MSOTH', 'leees@fiamma.com.my', 19870627,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (129, '18, Lorong Burung Sintar 3,', 'Taman Bukit Maluri,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 129);
	
-- >> 130
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (130, 1000000001, 'TTMST', 'Lee Heng Cheng', 'CCIND', 
			'IDNIC', '830619-14-5995', 130, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123383361', '', '', 'MSOTH', '', 19830619,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (130, '117, Jalan Bidara 3/6,', 'Taman Bidara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 130);

-- >> 131
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (131, 1000000001, 'TTMST', 'Lee Hock Lin @ Lee Beng Kwez', 'CCIND', 
			'IDNIC', '690905-10-5837', 131, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122182348', '', '', 'MSOTH', '', 19690905,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (131, 'DG-06, Apt Sri Hijauana,', 'Jalan Ukay Perdana 2/1,', 'Taman Ukay Perdana,', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 131);

-- >> 132
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (132, 1000000001, 'TTMST', 'Lee Hon Wah', 'CCIND', 
			'IDNIC', '841002-08-6693', 132, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841002,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (132, 'B-13-11, Plaza Metro Prima,', 'Jalan Metro Prima,', 'Kepong,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 132);

-- >> 133
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (133, 1000000001, 'TTMIS', 'Lee Jia Yi', 'CCIND', 
			'IDNIC', '780311-14-5806', 133, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0123919296', '', '', 'MSOTH', '', 19780311,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (133, 'No. 29, Jalan Kemuning Bayu 33/33A,', 'Kemuning Utama Sect 33,', '', '',
			'40400', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 133);
			
-- >> 134
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (134, 1000000001, 'TTMIS', 'Lee Kah Hooi', 'CCIND', 
			'IDNIC', '810313-14-5396', 134, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19810313,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (134, 'No 49, Jalan Bukit Idaman 1,', 'Taman Bukit Idaman,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 134);	
	
-- >> 135
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (135, 1000000001, 'TTMST', 'Lee Kim Wooi', 'CCIND', 
			'IDNIC', '670416-06-5063', 135, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163363222', '0199185963', '', 'MSOTH', '', 19670416,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (135, '16, Jalan UB-8,', 'Ukay Bistari,', '', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 135);	
	
-- >> 136
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (136, 1000000001, 'TTENC', 'Mohd Azlan Bin Amin', 'CCIND', 
			'IDNIC', '850416-14-5731', 136, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0105020061', '', '', 'MSOTH', 'mamin@servicesource.com', 19850416,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (136, '152, Jalan Bidara 2/3,', 'Taman Bidara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 136);	
			
-- >> 137
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (137, 1000000001, 'TTENC', 'Mohd Fairuz bin Abd Rashid', 'CCIND', 
			'IDNIC', '820527-06-5059', 137, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0177645054', '', '', 'MSOTH', 'yuki_yeow@yahoo.com', 19820527,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (137, '80-2-3 Midah Heights Condo 17/105,', 'Taman Midah,', 'Cheras,', '',
			'56000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 137);	

-- >> 138
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (138, 1000000001, 'TTMIS', 'Lee Lai Chee', 'CCIND', 
			'IDNIC', '750611-06-5392', 138, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0122366844', '', '', 'MSOTH', 'vivenlclee@yahoo.com', 19750611,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (138, 'No. 35, Jalan BP5,', 'Taman Bukit Permata,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 138);	

-- >> 139
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (139, 1000000001, 'TTMST', 'Lee Lian Foong', 'CCIND', 
			'IDNIC', '610521-10-5923', 139, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122020879', '0380520073', '', 'MSOTH', 'alan.lee@gab.com.my', 19610521,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (139, 'No.22 ,Jalan Puteri 12/20,', 'Bandar Puteri,', '', '',
			'47100', 'Puchong,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 139);	

-- >> 140
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (140, 1000000001, 'TTMST', 'Lee Lian Seng', 'CCIND', 
			'IDNIC', '700201-01-5485', 140, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193308026', '0361369741', '', 'MSOTH', '', 19700201,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (140, 'No. B1-11, Selayang Court,', 'SJ 30, Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 140);

-- >> 141
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (141, 1000000001, 'TTMIS', 'Lee Poh Ling', 'CCIND', 
			'IDNIC', '820629-10-5234', 141, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820629,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (141, 'No. 5 Jalan 1,', 'Taman Radin Jaya,', '', '',
			'45500', 'Tanjong Karang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 141);

-- >> 142
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (142, 1000000001, 'TTMIS', 'Lee Soo Ling', 'CCIND', 
			'IDNIC', '850716-02-5192', 142, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19850716,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (142, 'BLK A-3a-09,', 'Damansara Sutra Apartment,', 'Persiaran KIP Utama,', 'Taman KIP,',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 142);

-- >> 143
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (143, 1000000001, 'TTMST', 'Lee Wai Lun', 'CCIND', 
			'IDNIC', '861020-56-6111', 143, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19861020,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (143, 'No.6, Jalan 40-B,', 'Selayang Baru,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 143);

-- >> 144
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (144, 1000000001, 'TTMST', 'Lee Wan Cheng', 'CCIND', 
			'IDNIC', '890519-66-5007', 144, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19890519,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (144, '11 Jalan 34C/38A,', 'Taman Sri Sinar Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 144);

-- >> 145
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (145, 1000000001, 'TTMST', 'Lee Wei Pin', 'CCIND', 
			'IDNIC', '840618-14-5095', 145, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840618,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (145, 'No 155, Jalan Sibu,', 'Taman Wahyu,', 'Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 145);

-- >> 146
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (146, 1000000001, 'TTMIS', 'Lee Yau Tang Tang', 'CCIND', 
			'IDNIC', '850624-14-6210', 146, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19850624,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (146, 'Level 9-16A, Kipark Selayang,', 'Persiaran 3 Lot 46883,', 'Bandar Baru Selayang,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 146);

-- >> 147
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (147, 1000000001, 'TTMIS', 'Len Lai Kuan', 'CCIND', 
			'IDNIC', '740206-14-5330', 147, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0116121011128', '', '', 'MSOTH', '', 19740206,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (147, 'AD 2-7-N, Aman Dua,', 'Jalan Aman,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 147);

-- >> 148
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (148, 1000000001, 'TTMIS', 'Leng Mei Kiew @ Lai Mei Kiew', 'CCIND', 
			'IDNIC', '750316-14-5656', 148, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'012-2228667', '', '', 'MSOTH', 'k.saujana@yahoo.com', 19750316,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (148, '12-2, Jalan Ara SD 7/3A,', 'Bandar Sri Damansara,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 148);

-- >> 149
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (149, 1000000001, 'TTMST', 'Leong Chun Lim', 'CCIND', 
			'IDNIC', '831101-14-6269', 149, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831101,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (149, '28, Jalan Margosa SD 10/3,', 'Bandar Sri Damansara,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 149);

-- >> 150
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (150, 1000000001, 'TTMST', 'Leong Chun Peng', 'CCIND', 
			'IDNIC', '831101-14-5805', 150, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831101,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (150, '28, Jalan Margosa SD 10/3,', 'Bandar Sri Damansara,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 150);


-- >> 151
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (151, 1000000001, 'TTMST', 'Leong Han Jey', 'CCIND', 
			'IDNIC', '871029-08-5073', 151, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19871029,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (151, 'No. 2517, Taman Bandar,', '', '', '',
			'35900', 'Tanjung Malim,', 'STPER', 'CTMAS', 20130625, 'sysadm', 151);

-- >> 152
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (152, 1000000001, 'TTMIS', 'Leong Sook Mun', 'CCIND', 
			'IDNIC', '600717-06-5020', 152, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19600717,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (152, 'No.12, Jalan Putra Bistari 2/5A,', 'Sek 2 Putra Heights,', '', '',
			'47650', 'Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 152);

-- >> 153
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (153, 1000000001, 'TTMIS', 'Leong Wai Ling', 'CCIND', 
			'IDNIC', '860421-43-5994', 153, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0166224993', '', '', 'MSOTH', '', 19860421,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (153, 'No. 1, Jalan Relung 19/44,', 'Seksyen 19,', '', '',
			'40300', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 153);

-- >> 154
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (154, 1000000001, 'TTMST', 'Lew Kok Way', 'CCIND', 
			'IDNIC', '850104-14-5281', 154, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193133199', '', '', 'MSOTH', '', 19850104,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (154, 'B-7-2, Avenue Court,', 'Taman Sri Sentosa,', 'Jalan Klang Lama,', '',
			'58200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 154);
	
-- >> 155
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (155, 1000000001, 'TTMST', 'Lian Chee Shan', 'CCIND', 
			'IDNIC', '780114-14-6367', 155, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19780114,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (155, 'A-9-17, No.5 Residensi Unggul Kepong,', 'JJalan Vista Mutiara 1,', 'Kepong Baru,', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 155);

-- >> 156
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (156, 1000000001, 'TTMIS', 'Liang Chea Ying', 'CCIND', 
			'IDNIC', '870208-14-5014', 156, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19870208,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (156, 'No 27, Jalan 1,', 'Taman Desa Jaya,', '', '',
			'45500', 'Tanjong Karang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 156);

-- >> 157
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (157, 1000000001, 'TTMST', 'Liew Ee-Kin', 'CCIND', 
			'IDNIC', '861205-56-5449', 157, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122998408', '', '', 'MSOTH', 'eekin@tekat.edu.my', 19861205,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (157, 'No 11, Jalan 9/1A,', 'Kepong Indah,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 157);

-- >> 158
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (158, 1000000001, 'TTMST', 'Liew Poh Heon', 'CCIND', 
			'IDNIC', '840607-14-5655', 158, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840607,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (158, 'No. 502 Jalan 8,', 'Kepong Ulu,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 158);	

-- >> 159
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (159, 1000000001, 'TTMST', 'Liew Sip Chon', 'CCIND', 
			'IDNIC', '580304-02-5455', 159, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19580304,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (159, 'No 41, Jalan U1/13A,', 'Glemmarie Residences,', 'Seksyen U1,', '',
			'40150', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 159);		

-- >> 160
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (160, 1000000001, 'TTMIS', 'Liew Siut Fong', 'CCIND', 
			'IDNIC', '730721-08-5046', 160, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19730721,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (160, '1-18-3, Prima Tiara 1,', 'No.4 Jalan 6/38A,', 'Taman Sri Sinar Segambut,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 160);

-- >> 161
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (161, 1000000001, 'TTMST', 'Liew Wong Sing', 'CCIND', 
			'IDNIC', '760129-08-6059', 161, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760129,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (161, 'B-13-6, Sang Suria Condo,', 'Bt. 3 1/2,', 'Jalan Ipoh,', '',
			'51100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 161);

-- >> 162
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (162, 1000000001, 'TTMST', 'Liew Yat Wah', 'CCIND', 
			'IDNIC', '860730-56-5303', 162, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0169184784', '', '', 'MSOTH', 'melven_liew@hotmail.com', 19860730,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (162, 'K5-2-10,	Kenari Court,', 'Jalan Pandan Indah 6/1', 'Pandan Indah,', '',
			'55100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 162);

-- >> 163
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (163, 1000000001, 'TTMIS', 'Lim Bee Swat', 'CCIND', 
			'IDNIC', '900423-14-5900', 163, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19900423,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (163, '30, Jalan Impian 12,', 'Taman Impian Indah,', '', '',
			'47000', 'Sungai Buloh,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 163);

-- >> 164
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (164, 1000000001, 'TTMIS', 'Lim Bee Yong', 'CCIND', 
			'IDNIC', '851222-14-5666', 164, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19851222,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (164, 'No. 15-1-1, Jalan 7/40,', 'Taman Pusat Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 164);

-- >> 165
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (165, 1000000001, 'TTMST', 'Lim Chin Shen', 'CCIND', 
			'IDNIC', '860726-43-6517', 165, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19860726,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (165, 'No 17, Jalan 11/2,', 'Rawang Perdana 2,', 'Jalan Bukit Idaman 6,', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 165);

-- >> 166
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (166, 1000000001, 'TTMST', 'Lim Eng Hai', 'CCIND', 
			'IDNIC', '800217-14-5231', 166, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0199303113', '', '', 'MSOTH', 'issolution.biz@gmail.com', 19800217,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (166, 'A-06-05, Damansara Sutera Apartment,', 'Jalan KIP 1,', 'Taman KIP,','',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 166);

-- >> 167
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (167, 1000000001, 'TTMST', 'Lim Fong Kim', 'CCIND', 
			'IDNIC', '810609-14-5555', 167, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810609,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (167, 'No 14, Jalan Gelama 2,', '', '', '',
			'42800', 'Tanjong Sepat,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 167);

-- >> 168
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (168, 1000000001, 'TTMST', 'Lim Keh Boon', 'CCIND', 
			'IDNIC', '840409-14-6239', 168, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840409,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (168, 'No.7, Jalan 5/5,', 'Pandan Indah,', '', '',
			'55100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 168);

-- >> 169
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (169, 1000000001, 'TTMST', 'Lim Keh Boon', 'CCIND', 
			'IDNIC', '840409-14-6239', 169, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840409,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (169, 'No.7, Jalan 5/5,', 'Pandan Indah,', '', '',
			'55100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 169);

-- >> 170
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (170, 1000000001, 'TTMIS', 'Lim Khor Chai', 'CCIND', 
			'IDNIC', '821002-08-6118', 170, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0169268862', '', '', 'MSOTH', 'kclim1002@hotmail.com', 19821002,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (170, 'B1-09, Jalan SJ30,', 'Selayang Court,', 'Taman Selayang Jaya,', '',
			'68100', 'Batu Caves', 'STSEL', 'CTMAS', 20130625, 'sysadm', 170);

-- >> 171
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (171, 1000000001, 'TTMST', 'Lim Kian Hsia', 'CCIND', 
			'IDNIC', '850926-10-5449', 171, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850926,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (171, 'No 55, SJ 5,', 'Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 171);

-- >> 172
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (172, 1000000001, 'TTMST', 'Lim Kuok Soon', 'CCIND', 
			'IDNIC', '731214-13-5373', 172, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19731214,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (172, '1-3B, Jalan Anggerik Vanilla P31/P,', 'Kota Kemuning,', '', '',
			'40460', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 172);

-- >> 173
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (173, 1000000001, 'TTMST', 'Lim Seik Hwei', 'CCIND', 
			'IDNIC', '820826-06-5155', 173, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126348877', '092771367', '', 'MSOTH', 'superpippo2181@hotmail.com', 19820826,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (173, '14, Jalan Seraya,', 'Taman Rimba,', '', '',
			'28400', 'Mentakab,', 'STPAH', 'CTMAS', 20130625, 'sysadm', 173);

-- >> 174
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (174, 1000000001, 'TTMIS', 'Lim Seiw Phing', 'CCIND', 
			'IDNIC', '710911-10-6348', 174, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0163831306', '', '', 'MSOTH', 'seiwphing.lim@cimb.com', 19710911,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (174, 'No. B-08-3A, Jalan SH 1/2,', 'Apartment Jelutong,', 'Selayang Heights,', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 174);

-- >> 175
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (175, 1000000001, 'TTMIS', 'Lim Siew Leng', 'CCIND', 
			'IDNIC', '761216-14-5206', 175, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0123608521', '', '', 'MSOTH', 'ctkl24@yahoo.com', 19761216,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (175, 'No 14-3, Jalan AmanSiara 2/7,', 'Taman AmanSiara,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 175);

-- >> 176
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (176, 1000000001, 'TTMIS', 'Lim Siew Moy', 'CCIND', 
			'IDNIC', '661120-10-5930', 176, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19661120,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (176, 'No 45-4, Jalan Amansiara 2/2,', 'Taman Amansiara,', '', '',
			'48000', 'Selayang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 176);

-- >> 177
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (177, 1000000001, 'TTMST', 'Lim Wee Vien', 'CCIND', 
			'IDNIC', '840326-14-5983', 177, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840326,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (177, '53, Jalan Sibu 7,', 'Taman Wahyu,', 'Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 177);

-- >> 178
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (178, 1000000001, 'TTMIS', 'Lim Yik Chia', 'CCIND', 
			'IDNIC', '830916-02-5252', 178, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0164423916', '', '', 'MSOTH', 'yikchia@hotmail.com	', 19830916,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (178, '1-412,	Apartment Kenanga,', 'Bandar Baru Selayang,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 178);

-- >> 179
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (179, 1000000001, 'TTMST', 'Loh Ta Wei', 'CCIND', 
			'IDNIC', '820419-14-61695', 179, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19820419,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (179, 'B-7-10 Jalan Metro Perdana 2,', 'Taman Usahawan,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 179);

-- >> 180
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (180, 1000000001, 'TTMIS', 'Loh Wai San', 'CCIND', 
			'IDNIC', '741123-05-5094', 180, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19741123,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (180, 'No 474, Jalan Margosa 16,', 'Taman Margosa,', '', '',
			'70400', 'Seremban,', 'STSEM', 'CTMAS', 20130625, 'sysadm', 180);

-- >> 181
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (181, 1000000001, 'TTMIS', 'Loke Lai Chang', 'CCIND', 
			'IDNIC', '840507-14-5666', 181, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840507,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (181, 'B-07-16, PPR Salak Selatan,', 'Jalan Mukim Petaling,', '', '',
			'57100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 181);

-- >> 182
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (182, 1000000001, 'TTMST', 'Looi Kim Fai', 'CCIND', 
			'IDNIC', '741217-14-5867', 182, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19741217,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (182, '39, Jalan 14/42,', 'Taman Sejahtera,', 'Off Jalan Kuching,', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 182);

-- >> 183
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (183, 1000000001, 'TTMIS', 'Loong Seow Yen', 'CCIND', 
			'IDNIC', '850120-06-5062', 183, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19850120,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (183, '1, Jalan 5/158A,', '', '', '',
			'25250', 'Kuantan,', 'STPAH', 'CTMAS', 20130625, 'sysadm', 183);

-- >> 184
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (184, 1000000001, 'TTMST', 'Low An Chow', 'CCIND', 
			'IDNIC', '620721-10-5783', 184, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19620721,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (184, 'No.11-G&M,', 'Jalan Maju 3/3,', '(Block G) Taman Lembah Maju,', '',
			'56100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 184);

-- >> 185
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (185, 1000000001, 'TTMST', 'Low Chen Han', 'CCIND', 
			'IDNIC', '850404-10-5257', 185, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122296100', '0361205600', '', 'MSOTH', 'elvenLCT@gmail.com', 19850404,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (185, 'No 33, Jalan 1/5,', 'Taman Bidara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 185);

-- >> 186
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (186, 1000000001, 'TTMST', 'Low Kah Keong', 'CCIND', 
			'IDNIC', '770319-14-5115', 186, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0199009263', '', '', 'MSOTH', 'nbc_superkent@yahoo.com', 19770319,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (186, '53, Jalan 14/18A,', 'Taman Mastiara,', 'Jalan Ipoh,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 186);

-- >> 187
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (187, 1000000001, 'TTMST', 'Low Lam Foong', 'CCIND', 
			'IDNIC', '830524-14-5351', 187, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19830524,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (187, '111, Jalan 2/37B,', 'Taman Bukit Maluri,', 'Kepong', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 187);

-- >> 188
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (188, 1000000001, 'TTMIS', 'Low Shiao', 'CCIND', 
			'IDNIC', '820702-14-6180', 188, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820702,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (188, 'No 39, Jalan Bersatu 9,', 'Taman Bersatu,', '', '',
			'48000', 'Rawang, ', 'STSEL', 'CTMAS', 20130625, 'sysadm', 188);	

-- >> 189
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (189, 1000000001, 'TTMIS', 'Low Yee Ting', 'CCIND', 
			'IDNIC', '840412-14-5938', 189, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840412,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (189, 'No 24, Jalan Bidara 3/16,', 'Taman Bidara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 189);
	
-- >> 190
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (190, 1000000001, 'TTMST', 'Mai Kah Chong', 'CCIND', 
			'IDNIC', '670119-08-5877', 190, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126223599', '', '', 'MSOTH', '', 19670119,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (190, '15, Lorong Lang Tompok 1,', 'Taman Sri Bintang,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 190);

-- >> 191
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (191, 1000000001, 'TTMST', 'Mai Kah Meng', 'CCIND', 
			'IDNIC', '680521-08-5911', 191, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126223599', '0126223799', '', 'MSOTH', '', 19680521,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (191, '15, Lorong Lang Tompok 1,', 'Taman Sri Bintang,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 191);

-- >> 192
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (192, 1000000001, 'TTMST', 'Mai Yoong Kang', 'CCIND', 
			'IDNIC', '860820-56-5411', 192, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126416826', '', '', 'MSOTH', 'yoongkang86@gmail.com', 19860820,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (192, '28, Jalan Jati SD 4/4,', 'Bandar Baru Sri Damansara,', '', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 192);

-- >> 193
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (193, 1000000001, 'TTMIS', 'Mak Chooi Min', 'CCIND', 
			'IDNIC', '800321-14-5418', 193, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0124743887', '', '', 'MSOTH', 'carmen0321@hotmail.com', 19800321,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (193, '20, Jalan SJ 3,', 'Taman Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 193);
			
-- >> 194
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (194, 1000000001, 'TTMIS', 'Malathi A/P Masilamani', 'CCIND', 
			'IDNIC', '811119-04-5484', 194, 'RCIND', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19811119,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (194, '60, Jalan 39/10,', 'Taman Koperasi Polis,', 'Fasa 2,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 194);	
	
-- >> 195
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (195, 1000000001, 'TTMST', 'Management', 'CCIND', 
			'IDNIC', '999999-99-9999', 195, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880808,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (195, 'Management', '', '', '',
			'50000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 195);	
											
-- >> 196
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (196, 1000000001, 'TTMIS', 'Mano A/P K. Doresamy', 'CCIND', 
			'IDNIC', '810511-06-5434', 196, 'RCIND', 'CTMAS', 'BMNON', 'SXFEM',
			'0129638373', '', '', 'MSOTH', 'mano.doresamy@cimb.com', 19810511,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (196, 'No 9 Long SKD 8,', 'Taman PSJ,', '', '',
			'25300', 'Kuantan,', 'STPAH', 'CTMAS', 20130625, 'sysadm', 196);	
			
-- >> 197
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (197, 1000000001, 'TTMST', 'Max Chan Choon Yee', 'CCIND', 
			'IDNIC', '670821-08-5009', 197, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19670821,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (197, 'No.94, Indah Permai 2,', 'Taman Saleng Indah,', '', '',
			'81000', 'Kulai,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 197);	

-- >> 198
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (198, 1000000001, 'TTENC', 'Megat Saifulrizal Bin Megat Husin', 'CCIND', 
			'IDNIC', '781103-07-5001', 198, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0173046228', '', '', 'MSOTH', '', 19781103,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (198, 'No. 45-51, Jalan USJ 21/11,', '', '', '',
			'47630', 'UEP Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 198);	

-- >> 199
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (199, 1000000001, 'TTENC', 'Mohamad Nuzul Bin Mohamad Yusof', 'CCIND', 
			'IDNIC', '780821-08-5751', 199, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0133633369', '', '', 'MSOTH', 'mnjb_1088@yahoo.com', 19780821,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (199, 'No. 32, Kampung Pasir Sg Trap,', '', '', '',
			'31000', 'Batu Gajah,', 'STPER', 'CTMAS', 20130625, 'sysadm', 199);	

-- >> 200
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (200, 1000000001, 'TTENC', 'Mohammed Azwan Bin Md Arif', 'CCIND', 
			'IDNIC', '790606-01-5223', 200, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0162326403', '', '', 'MSOTH', 'daniasary@yahoo.com', 19790606,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (200, 'Messrs The & Azlina,', 'B-5-10, 5th Floor,', 'Megan Avenue II,', 'No12, Jalan Yap Kwan Seng,',
			'50450', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 200);

-- >> 201
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (201, 1000000001, 'TTENC', 'JMohd Foudzi Bin Md. Nor', 'CCIND', 
			'IDNIC', '730110-11-5373', 201, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0162022008', '0340500592', '', 'MSOTH', 'm_faudzi@yahoo.com.my', 19730110,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (201, 'A-12-9, PV 5 ,', 'Platinum Hill Condo,', 'No 2, Jalan Melati Utama 3,', 'Setapak,',
			'53100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 201);

-- >> 202
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (202, 1000000001, 'TTENC', 'Mohd Hafizal Bin Mohamad Hamka', 'CCIND', 
			'IDNIC', '830310-12-5259', 202, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0128449211', '', '', 'MSOTH', 'ezal83@yahoo.com', 19830310,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (202, 'Law & Commerce Trust Ltd,', 'Block B-17-9, Megan Avenue 2,', 'No. 12, Jalan Yap Kwan Seng,', '',
			'50450', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 202);

-- >> 203
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (203, 1000000001, 'TTENC', 'Mohd Razlan Bin Ramlee', 'CCIND', 
			'IDNIC', '831123-08-6009', 203, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831123,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (203, 'No.3, Jalan SJ 16B,', 'Taman Selayang Bahagia,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 203);

-- >> 204
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (204, 1000000001, 'TTMST', 'Mok Kien Nam', 'CCIND', 
			'IDNIC', '891127-14-6501', 204, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19891127,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (204, 'No 2A, Jalan Wangsa Cheras 1/6,', 'Taman Wangsa Cheras,', '', '',
			'43200', 'Batu 9 Cheras,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 204);

-- >> 205
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (205, 1000000001, 'TTMST', 'Mot Kam Wai', 'CCIND', 
			'IDNIC', '770324-08-5209', 205, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19770324,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (205, 'No 39, Jalan 37/27B,', 'Taman Desa Setapak,', '', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 205);

-- >> 206
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (206, 1000000001, 'TTMST', '', 'CCIND', 
			'IDNIC', '999999-99-9999', 206, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880808,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (206, 'MULTI BINA SDN BHD', '', '', '',
			'88888', '', 'STKUL', 'CTMAS', 20130625, 'sysadm', 206);

-- >> 207
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (207, 1000000001, 'TTMIS', 'Ng Bee Fong', 'CCIND', 
			'IDNIC', '611219-10-5636', 207, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19611219,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (207, 'No 6, Jalan SJ 19,', 'Taman Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 207);

-- >> 208
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (208, 1000000001, 'TTMST', 'Ng Boon Kuan', 'CCIND', 
			'IDNIC', '791001-08-6699', 208, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0165922824', '', '', 'MSOTH', 'boonkuan@hotmail.com', 19791001,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (208, 'No 57, Jalan PP 2/11,', 'Taman Putra Prima,', '', '',
			'47100', 'Puchong,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 208);

-- >> 209
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (209, 1000000001, 'TTMST', 'Ng Boon Poh', 'CCIND', 
			'IDNIC', '821125-08-6177', 209, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0125889866', '', '', 'MSOTH', 'printview@hotmail.com', 19821125,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (209, 'No 57, Jalan PP 2/11,', 'Taman Putra Prima,', '', '',
			'47100', 'Puchong,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 209);

-- >> 210
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (210, 1000000001, 'TTMST', 'Ng Cheng Ning', 'CCIND', 
			'IDNIC', '710606-10-5357', 210, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19710606,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (210, 'G-15-2, Menara Manjalara,', 'Jalan 1/62B,', 'Bandar Sri Manjalara,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 210);

-- >> 211
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (211, 1000000001, 'TTMIS', 'Ng Choon Hwa', 'CCIND', 
			'IDNIC', '621025-10-6744', 211, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19621025,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (211, 'No 155, Jalan Sibu,', 'Taman Wahyu,', 'Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 211);

-- >> 212
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (212, 1000000001, 'TTMIS', 'Ng Jing Xi', 'CCIND', 
			'IDNIC', '930318-14-5818', 212, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19930318,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (212, 'No 1, Jalan SU4,', 'Taman Selayang Utama,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 212);

-- >> 213
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (213, 1000000001, 'TTMIS', 'Ng Kwee Fun', 'CCIND', 
			'IDNIC', '780810-01-5010', 213, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0122272793', '', '', 'MSOTH', 'kweefun@yahoo.com', 19780810,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (213, '33, Jalan Metro Perdana Barat 15,', 'Taman Usahawan Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 213);

-- >> 214
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (214, 1000000001, 'TTMST', 'Ng Loy Man', 'CCIND', 
			'IDNIC', '810501-08-5407', 214, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810501,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (214, 'No 15, Jalan Saujana 3,', 'Ampang Saujana,', '', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 214);

-- >> 215
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (215, 1000000001, 'TTMIS', 'Ng Pei Chun', 'CCIND', 
			'IDNIC', '790426-08-5558', 215, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19790426,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (215, '1813, Jalan 1,', 'Taman Setia Rawang,', '', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 215);

-- >> 216
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (216, 1000000001, 'TTMIS', 'Ng Pek Kee', 'CCIND', 
			'IDNIC', '540415-07-5328', 216, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0166242206', '0123706827', '', 'MSOTH', '', 19540415,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (216, 'No. 34, Jalan 23,', 'Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 216);

-- >> 217
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (217, 1000000001, 'TTMIS', 'Ng Shoo Kuan', 'CCIND', 
			'IDNIC', '840803-14-5708', 217, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840803,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (217, '111, Jalan Jambu Melaka 5,', 'Jinjang Selatan,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 217);

-- >> 218
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (218, 1000000001, 'TTMST', 'Ng Wes Kim', 'CCIND', 
			'IDNIC', '851202-08-5563', 218, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851202,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (218, 'H1-07-01, Goodyear Court,', '6, Jalan Kewajipan,	USJ 6,', '', '',
			'47500', 'Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 218);	

-- >> 219
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (219, 1000000001, 'TTMST', 'Ngai Siew Cheong', 'CCIND', 
			'IDNIC', '721125-14-5343', 219, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'6581828757', '192896288', '', 'MSOTH', 'wky70@yahoo.com', 19721125,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (219, 'No. 361, Jalan E2/7,', 'Taman Ehsan Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 219);		

-- >> 220
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (220, 1000000001, 'TTMST', 'Ngan Shu How', 'CCIND', 
			'IDNIC', '650502-08-5281', 220, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192435032', '', '', 'MSOTH', '', 19650502,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (220, 'A01-11, USJ One Avenue,', 'Persiaran Mewah USJ 1,', '', '',
			'47600', 'Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 220);

-- >> 221
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (221, 1000000001, 'TTMST', 'Ngan Tan Keat', 'CCIND', 
			'IDNIC', '920905-08-5021', 221, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19920905,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (221, 'No.36 Taman Jasmin,', '', '', '',
			'32600', 'Ayer Tawar,', 'STPER', 'CTMAS', 20130625, 'sysadm', 221);

-- >> 222
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (222, 1000000001, 'TTMST', 'Ngee Wan Heong', 'CCIND', 
			'IDNIC', '770514-14-5495', 222, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0126173933', '', '', 'MSOTH', 'wenyml@yahoo.com', 19770514,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (222, '85, Jalan Metro Perdana Barat 16,', 'Taman Usahawan,	Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 222);

-- >> 223
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (223, 1000000001, 'TTCIK', 'Nilam Sari Bt Md Taib', 'CCIND', 
			'IDNIC', '831220-14-6210', 223, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0122543611', '', '', 'MSOTH', 'nilamsari83@gmail.com', 19831220,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (223, 'No 19, Jalan Siakap Tiga 17/39C,', 'Seksyen 17,', '', '',
			'40200', 'Shah Alam,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 223);

-- >> 224
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (224, 1000000001, 'TTCIK', 'Nooridayu Binti Razali', 'CCIND', 
			'IDNIC', '850721-11-5440', 224, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0133588001', '', '', 'MSOTH', '', 19850721,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (224, '25, Putra Bahagia 8/4L,', 'Putra Heights,', '', '',
			'47650', 'Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 224);

-- >> 225
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (225, 1000000001, 'TTCIK', 'Nor Nazatul Shima Bt Muhammad Zin', 'CCIND', 
			'IDNIC', '840127-05-5212', 225, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'', '', '', 'MSOTH', '', 19840127,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (225, 'No 14, Jalan ST 1C/3,', 'Taman Selasih,', 'Bandar Baru Salak Tinggi,', '',
			'43900', 'Sepang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 225);

-- >> 226
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (226, 1000000001, 'TTCIK', 'Norafizah Bt Isthnin', 'CCIND', 
			'IDNIC', '830205-04-5388', 226, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'', '', '', 'MSOTH', '', 19830205,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (226, '11-2-2 Indah Apartment,', 'Jalan 1D/6,', 'Taman Setapak Indah,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 226);

-- >> 227
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (227, 1000000001, 'TTCIK', 'Norhafiza Bt Samsudin', 'CCIND', 
			'IDNIC', '800407-06-5478', 227, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'', '', '', 'MSOTH', '', 19800407,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (227, 'C-15-06 Kondominium Sentul Utama,', 'Taman Dato Senu,', 'Sentul,', '',
			'54100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 227);

-- >> 228
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (228, 1000000001, 'TTCIK', 'Nur Azma Binti Amin', 'CCIND', 
			'IDNIC', '791214-14-5314', 228, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0164109387', '', '', 'MSOTH', 'wnm7912@gmail.com', 19791214,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (228, '152, Jalan Bidara 2/3,', 'Taman Bidara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 228);	

-- >> 229
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (229, 1000000001, 'TTMST', 'Ong Beng Keong', 'CCIND', 
			'IDNIC', '820925-14-5847', 229, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0169101194', '', '', 'MSOTH', 'anthony_gf@digiscan.com.my', 19820925,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (229, 'No. 3 Jalan 3A/2B,', 'Taman Desa Bakti,', 'Off Jalan Ipoh,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 229);
	
-- >> 230
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (230, 1000000001, 'TTMST', 'Ong Chee Hong', 'CCIND', 
			'IDNIC', '831207-71-5095', 230, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19831207,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (230, 'Blk A, Unit 605,', 'Paradesa Rustica Condo,', '', '',
			'52200', 'Bdr Sri Damansara,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 230);

-- >> 231
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (231, 1000000001, 'TTMST', 'Ong Jackson', 'CCIND', 
			'IDNIC', '930928-14-6033', 231, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19930928,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (231, 'No 35, Jalan SJ 25,', 'Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 231);

-- >> 232
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (232, 1000000001, 'TTMST', 'Ong Rong Bin', 'CCIND', 
			'IDNIC', '860427-29-5355', 232, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19860427,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (232, 'No 38, Jalan USJ 20/6A,', '', '', '',
			'47600', 'Subang Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 232);

-- >> 233
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (233, 1000000001, 'TTMST', 'Oo Tuck Khuen', 'CCIND', 
			'IDNIC', '840222-14-5611', 233, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123643122', '0361203932', '', 'MSOTH', 'jeffdestin@hotmail.co.uk', 19840222,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (233, 'No 27, Jalan SJ 21,', 'Taman Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 233);
			
-- >> 234
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (234, 1000000001, 'TTMST', 'Ooi Khai Loon', 'CCIND', 
			'IDNIC', '820109-02-5417', 234, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19820109,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (234, 'A-6-28,	162 Residensi,', 'Jalan Ipoh KM 12,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 234);	
	
-- >> 235
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (235, 1000000001, 'TTMST', 'Ooi Kong Hui', 'CCIND', 
			'IDNIC', '710725-08-5387', 235, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'016-9309219', '', '', 'MSOTH', '', 19710725,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (235, '41, Jalan 1, Kawasan 2,', 'Taman Sri Andalas,', '', '',
			'41200', 'Klang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 235);	
	
-- >> 236
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (236, 1000000001, 'TTMST', 'Pang Ching Kau', 'CCIND', 
			'IDNIC', '680307-12-5441', 236, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19680307,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (236, 'No.10334 Taman Berjaya 2,', 'Jalan Apas Mile 3,', '', '',
			'91000', 'Tawau,', 'STSAB', 'CTMAS', 20130625, 'sysadm', 236);	
			
-- >> 237
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (237, 1000000001, 'TTMST', 'Pang Wee Seng', 'CCIND', 
			'IDNIC', '840308-14-5401', 237, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'012-6523263', '', '', 'MSOTH', 'v_seng84@hotmail.com', 19840308,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (237, '01-H, Condo Villa,', 'Jalan Villa Mas,', 'Tamn Villa Mas,', '',
			'47000', 'Sungai Buluh,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 237);	

-- >> 238
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (238, 1000000001, 'TTCIK', 'Pauziah Binti Muhamad', 'CCIND', 
			'IDNIC', '740602-06-5092', 238, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0133504321', '0322031221', '', 'MSOTH', 'jiecumlah@yahoo.com', 19740602,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (238, 'Malaysian Japan International ', 'Institute of Tech (MJIIT),', 'UTM Jalan Semarak,', '',
			'54100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 238);	

-- >> 239
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (239, 1000000001, 'TTMST', 'Peh Wee Tat', 'CCIND', 
			'IDNIC', '760519-14-5823', 239, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760519,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (239, 'No 1, Jalan 36/10A,', 'Taman Perindustrian IKS (miel),', 'Taman Batu Muda,', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 239);	

-- >> 240
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (240, 1000000001, 'TTMST', 'Peh Wee Tat', 'CCIND', 
			'IDNIC', '760519-14-5823', 240, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19760519,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (240, 'No 1, Jalan 36/10A,', 'Taman Perindustrian IKS (MIEL),', 'Taman Batu Muda,', '',
			'68100', 'kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 240);

-- >> 241
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (241, 1000000001, 'TTMIS', 'Phang Sim Yen', 'CCIND', 
			'IDNIC', '820603-08-5060', 241, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19820603,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (241, 'No. 5, Lorong Intan Baiduri 4B,', 'Taman Intan Baiduri,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 241);

-- >> 242
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (242, 1000000001, 'TTMIS', 'Phon Wai Fun', 'CCIND', 
			'IDNIC', '761220-14-5532', 242, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19761220,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (242, '228, Jalan E 2/5,', 'Taman Ehsan Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 242);

-- >> 243
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (243, 1000000001, 'TTMST', 'Pua Beng Hock', 'CCIND', 
			'IDNIC', '710414-08-5785', 243, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19710414,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (243, 'No.38, Jalan SS4D/12,', '', '', '',
			'47301', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 243);

-- >> 244
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (244, 1000000001, 'TTMST', 'Pua Hok Lai', 'CCIND', 
			'IDNIC', '560923-10-5667', 244, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0193838211', '', '', 'MSOTH', '', 19560923,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (244, '968, Jalan Kuang Gunung,', 'Taman Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 244);

-- >> 245
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (245, 1000000001, 'TTENC', 'Rafiz Bin Abdul Rani', 'CCIND', 
			'IDNIC', '810201-71-5067', 245, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0193396990', '', '', 'MSOTH', '', 19810201,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (245, '90, Jalan K2,', 'Taman Melawati,', '', '',
			'53100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 245);

-- >> 246
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (246, 1000000001, 'TTCIK', 'Rahayu Binti Mohadzir', 'CCIND', 
			'IDNIC', '790911-01-5174', 246, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19790911,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (246, 'No. 407 Blok F11,', 'Seksyen 1,', 'Bandar Baru Wangsa Maju,', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 246);

-- >> 247
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (247, 1000000001, 'TTMST', 'Rajdev Singh A/L Gurmeet Singh', 'CCIND', 
			'IDNIC', '999999-99-9999', 247, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'016-3943325', '', '', 'MSOTH', 'rajdev_singh@hotmail.com', 19880808,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (247, '2068 Jalan Jambu 5,', 'Taman Rasah,', '', '',
			'70300', 'Seremban,', 'STSEM', 'CTMAS', 20130625, 'sysadm', 247);

-- >> 248
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (248, 1000000001, 'TTMST', 'Rajvinder Singh A/L Kaka Singh', 'CCIND', 
			'IDNIC', '790310-10-5545', 248, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19790310,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (248, 'No. 15, Jalan Cokmar 2J,', 'Taman Mutiara Bukit Raja,', 'Jalan Meru,', '',
			'41050', 'Klang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 248);

-- >> 249
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (249, 1000000001, 'TTENC', 'Rosdan Bin Md Yasan @ Rahman', 'CCIND', 
			'IDNIC', '701117-04-5299', 249, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0193232992', '', '', 'MSOTH', 'myrosdan@ymail.com', 19701117,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (249, 'No.7 Jalan Idaman 5,', 'Idaman Hills,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 249);

-- >> 250
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (250, 1000000001, 'TTCIK', 'Rosealinda Binti Jhaya', 'CCIND', 
			'IDNIC', '760829-06-5028', 250, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0162229152', '0192840272', '', 'MSOTH', 'desajaya51@yahoo.com', 19760829,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (250, 'No 10, Jalan 51 Desa Jaya,', 'Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 250);

-- >> 251
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (251, 1000000001, 'TTENC', 'Saibol Hamid Bin Mat Isa', 'CCIND', 
			'IDNIC', '670203-02-5789', 251, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'0193553958', '', '', 'MSOTH', 'saibolh@gmail.com', 19670203,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (251, '7/35 Jalan 5,', 'Taman Selayang Baru,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 251);

-- >> 252
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (252, 1000000001, 'TTMST', 'Saran Raj A.L Sakar', 'CCIND', 
			'IDNIC', '891020-14-5525', 252, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'0165536649', '0146200356', '', 'MSOTH', 'saran_sakar@astro.com.my', 19891020,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (252, 'Blok 2, 2-13A-G,', 'Lorong D 1/5, Desa Dua Apartment,', 'Desa Aman Puri,', 'Kepong,',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 252);

-- >> 253
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (253, 1000000001, 'TTMST', 'Sashitahran A/L Nadarajah', 'CCIND', 
			'IDNIC', '870510-08-6297', 253, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870510,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (253, 'A-03-07, Pangsapuri Bukit Baru,', 'Jalan Keramat Hujung,', '', '',
			'54000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 253);

-- >> 254
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (254, 1000000001, 'TTMST', 'Sasitharan A/L Pala Subramaniam', 'CCIND', 
			'IDNIC', '791227-07-5693', 254, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19791227,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (254, 'Unit I-2-12, Block I,', 'Apartment Perdana Puri,', 'Desa Aman Puri,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 254);
	
-- >> 255
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (255, 1000000001, 'TTMST', 'Saw Soo Sen', 'CCIND', 
			'IDNIC', '850908-07-5557', 255, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850908,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (255, '30, Lorong Sentul 10,', 'Taman Sentul Jaya,', '', '',
			'14000', 'Bukit Mertajam', 'STPEN', 'CTMAS', 20130625, 'sysadm', 255);

-- >> 256
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (256, 1000000001, 'TTMIS', 'Seah Leng Leng', 'CCIND', 
			'IDNIC', '740819-14-5886', 256, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19740819,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (256, '2919, Jalan Timur 3,', 'Jinjang Utara,', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 256);

-- >> 257
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (257, 1000000001, 'TTMST', 'See Boon Koon', 'CCIND', 
			'IDNIC', '800906-10-5403', 257, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19800906,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (257, 'No.2, Jalan RP 7/10,', 'Rawang Perdana,', '', '',
			'48000', 'Rawang', 'STSEL', 'CTMAS', 20130625, 'sysadm', 257);

-- >> 258
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (258, 1000000001, 'TTENV', 'Serhan Rizal bin Yahya Sofi', 'CCIND', 
			'IDNIC', '840628-14-6075', 258, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840628,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (258, '332B-17C GCB Court,', 'Jalan Ampang,', '', '',
			'50450', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 258);	

-- >> 259
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (259, 1000000001, 'TTMIS', 'Sew Chiat Tyng', 'CCIND', 
			'IDNIC', '851108-02-5310', 259, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19851108,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (259, 'A-42, Taman Kok Doh,', 'Jalan Segambut,', '', '',
			'51200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 259);		

-- >> 260
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (260, 1000000001, 'TTCIK', 'Shamsiah Farida Bt Osman Wahid', 'CCIND', 
			'IDNIC', '770410-14-5714', 260, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0192112578', '', '', 'MSOTH', 'shamsiahfarida@yahoo.com', 19770410,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (260, 'No. C2-LG-02,', 'Andari Town Villa,', 'Jalan SH 2/1,', 'Selayang Heights,',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 260);

-- >> 261
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (261, 1000000001, 'TTMST', 'Shashiram A/L Sangroo', 'CCIND', 
			'IDNIC', '851027-14-6153', 261, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19851027,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (261, 'Blok 48-2-15 Teratai Mewah Condo,', 'Taman Teratai Mewah,', 'Jalan Langkawi Setapak,', '',
			'53000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 261);

-- >> 262
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (262, 1000000001, 'TTMIS', 'Sheila A/P Bahsu', 'CCIND', 
			'IDNIC', '810718-01-5258', 262, 'RCIND', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19810718,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (262, '97, Jalan Sanggul 3,', 'Bandar Puteri,', '', '',
			'41200', 'Klang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 262);

-- >> 263
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (263, 1000000001, 'TTMIS', 'Sheng Yee Siew', 'CCIND', 
			'IDNIC', '811209-03-5466', 263, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0129586831', '', '', 'MSOTH', '', 19811209,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (263, 'PT 320,', 'Jalan Tiga Desa Darul Naim,', 'Pasir Tumboh,', '',
			'16150', 'Kota Bharu,', 'STKEL', 'CTMAS', 20130625, 'sysadm', 263);

-- >> 264
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (264, 1000000001, 'TTMST', 'Siew Chee Hoo', 'CCIND', 
			'IDNIC', '720729-14-5059', 264, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0122251491', '', '', 'MSOTH', 'danielsiew1972@hotmail.com', 19720729,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (264, '1411, Jalan 36,', 'Taman Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 264);

-- >> 265
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (265, 1000000001, 'TTMST', 'Sim Mong Yong', 'CCIND', 
			'IDNIC', '680903-10-5383', 265, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0192148497', '', '', 'MSOTH', '', 19680903,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (265, 'No.20, Jalan 3/2C,', 'Taman Desa Padu,', '', '',
			'68100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 265);

-- >> 266
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (266, 1000000001, 'TTMIS', 'Sin Chooi Shan', 'CCIND', 
			'IDNIC', '860302-43-5772', 266, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19860302,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (266, 'No 12, Jalan SU 35,', 'Taman Selayang Utama,', '','',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 266);

-- >> 267
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (267, 1000000001, 'TTMIS', 'Sin Chui Ling', 'CCIND', 
			'IDNIC', '830922-14-5824', 267, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0162298543', '', '', 'MSOTH', 'sheryl_sin2@yahoo.com', 19830922,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (267, 'No 48, Jalan SJ 34,', 'Taman Selayang Jaya,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 267);

-- >> 268
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (268, 1000000001, 'TTMST', 'Sin Kah Hui', 'CCIND', 
			'IDNIC', '880711-56-5373', 268, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880711,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (268, 'No 12, Jalan SU 35,', 'Taman Selayang Utama,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 268);

-- >> 269
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (269, 1000000001, 'TTMST', 'Sin Kar Lim', 'CCIND', 
			'IDNIC', '870217-08-5957', 269, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19870217,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (269, 'No.12 Jalan SU 35,', 'Taman Selayang Utama,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 269);

-- >> 270
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (270, 1000000001, 'TTMIS', 'Siti Fatimah Binti Mohd Salleh', 'CCIND', 
			'IDNIC', '801225-04-5024', 270, 'RCMLY', 'CTMAS', 'BMBUM', 'SXFEM',
			'0127205400', '', '', 'MSOTH', 'sitiwansyg@yahoo.com', 19801225,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (270, 'No. 20, Jalan Kempas Indah 5/1,', 'Taman Kempas Indah,', '', '',
			'81300', '', 'STJOH', 'CTMAS', 20130625, 'sysadm', 270);

-- >> 271
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (271, 1000000001, 'TTMIS', 'Soh Siew Kiok', 'CCIND', 
			'IDNIC', '660324-06-5366', 271, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19660324,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (271, 'No 29, Kampung Sempalit,', '', '', '',
			'27600', 'Raub', 'STPAH', 'CTMAS', 20130625, 'sysadm', 271);

-- >> 272
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (272, 1000000001, 'TTMST', 'Soo Tor Chai', 'CCIND', 
			'IDNIC', '520328-08-6071', 272, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162271566	', '', '', 'MSOTH', '', 19520328,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (272, '53, Jalan SS23/2,', '', '', '',
			'47400', 'Petaling Jaya,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 272);

-- >> 273
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (273, 1000000001, 'TTMST', 'Sundaresan A/L Kathigasu', 'CCIND', 
			'IDNIC', '840818-14-5313', 273, 'RCIND', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19840818,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (273, 'No 58, Taman KKB Utama,', '', '', '',
			'44000', 'K. Kubu Bharu,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 273);

-- >> 274
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (274, 1000000001, 'TTMST', 'Swee Kee Ming', 'CCIND', 
			'IDNIC', '850327-14-6089', 274, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19850327,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (274, 'No 2A, Jalan Helang Siput 1,', 'Taman Kepong Baru,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 274);

-- >> 275
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (275, 1000000001, 'TTMST', 'Syabas Expo Event', 'CCCOM', 
			'IDBRE', '001936210-U', 275, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162323287', '', '', 'MSOTH', 'phung001@syabas-expo.com', 19990909,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (275, 'No.89-G, Jalan 2/3A,', 'Pusat Bandar Utara,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 275);

-- >> 276
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (276, 1000000001, 'TTENC', 'Syamsul Firdaus bin Abdul Rahman', 'CCIND', 
			'IDNIC', '841122-05-5349', 276, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841122,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (276, 'Blok 37-13-11, Flat Sri Perak,', 'Bandar Baru Sentul,', '', '',
			'51000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 276);

-- >> 277
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (277, 1000000001, 'TTMST', 'Tai Keen Chee', 'CCIND', 
			'IDNIC', '810329-08-5375', 277, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19810329,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (277, 'No 3, Jalan Ampang Jaya 4,', 'Taman Ampang Jaya,', '', '',
			'83000', 'Batu Pahat,', 'STJOH', 'CTMAS', 20130625, 'sysadm', 277);

-- >> 278
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (278, 1000000001, 'TTENC', 'Tajul Arifin Bin Saleh', 'CCIND', 
			'IDNIC', '770106-08-6043', 278, 'RCMLY', 'CTMAS', 'BMBUM', 'SXMAL',
			'', '', '', 'MSOTH', '', 19770106,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (278, 'No.6, Jalan Villa Putra 2,', 'Taman Villa Putra,', '', '',
			'47000', 'Sungai Buloh,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 278);

-- >> 279
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (279, 1000000001, 'TTMST', 'Tam Wai Seng', 'CCIND', 
			'IDNIC', '811107-12-5727', 279, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19811107,
			'', 'sysadm', 20130625, 'CCACT');	

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (279, 'No.3A-3-A, Block 3A,', 'Desa Dua Apartment,', 'Lorong D1/5 Desa Aman Puri,', 'Kepong,',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 279);

-- >> 280
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (280, 1000000001, 'TTMST', 'Tan Chee Boon', 'CCIND', 
			'IDNIC', '780817-14-5635', 280, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19780817,
			'', 'sysadm', 20130625, 'CCACT');		

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (280, '13 D, Jinjang Selatan Tambahan,', '', '', '',
			'52000', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 280);

-- >> 281
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (281, 1000000001, 'TTMST', 'Tan Chong Wah', 'CCIND', 
			'IDNIC', '860420-56-5009', 281, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0173453876', '', '', 'MSOTH', '', 19860420,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (281, 'No 40, Jalan 26,', 'Taman Daya Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 281);

-- >> 282
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (282, 1000000001, 'TTMST', 'Tan Goon Chuan', 'CCIND', 
			'IDNIC', '871210-56-5135', 282, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0163266633', '', '', 'MSOTH', 'brian_6633@hotmail.com', 19871210,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (282, '40, Jalan 5/37,', 'Taman Bukit Maluri,', 'Kepong,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 282);

-- >> 283
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (283, 1000000001, 'TTMST', 'Tan Ho Lin', 'CCIND', 
			'IDNIC', '880207-14-5505', 283, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0169155531', '0163288633', '', 'MSOTH', '', 19880207,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (283, 'No 16, Jalan 10,', 'Selayang Baru,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 283);

-- >> 284
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (284, 1000000001, 'TTMIS', 'Tan Hui Hui', 'CCIND', 
			'IDNIC', '850524-14-5544', 284, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19850524,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (284, 'No 1 Jalan 7C/6,', 'Taman Setapak Indah,', '', '',
			'53300', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 284);

-- >> 285
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (285, 1000000001, 'TTMST', 'Tan Kah Soon', 'CCIND', 
			'IDNIC', '800205-14-5517', 285, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162101138', '', '', 'MSOTH', '', 19800205,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (285, '968, Jalan Kuang Gunung,', 'Taman Kepong,', '', '',
			'52100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 285);

-- >> 286
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (286, 1000000001, 'TTMST', 'Tan Ker Xian', 'CCIND', 
			'IDNIC', '841214-14-5245', 286, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19841214,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (286, 'No 26, Jalan KPK 1/7,', 'Kawasan Perindustrian Kundang,', '', '',
			'48020', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 286);

-- >> 287
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (287, 1000000001, 'TTMST', 'Tan Kian Han', 'CCIND', 
			'IDNIC', '880304-08-5559', 287, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19880304,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (287, 'E-23-03 Symphony Heights,', 'Jalan Medan Selayang 1,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 287);

-- >> 288
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (288, 1000000001, 'TTMST', 'Tan Kian Peng', 'CCIND', 
			'IDNIC', '880528-56-5965', 288, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123332708', '', '', 'MSOTH', 'jeffeytan@hotmail.com', 29820702,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (288, 'No. 2, Jalan C off Jalan Jambu,', 'Jalan Kuching,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 288);	

-- >> 289
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (289, 1000000001, 'TTMST', 'Tan Kok Chai', 'CCIND', 
			'IDNIC', '840528-14-6289', 289, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'012-2513618', '019-2333618', '', 'MSOTH', 'sincere_auto@hotmail.com', 19840528,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (289, 'Blok 10-10-13,', 'Jalan 1/1A,', 'Taman Kepong Indah,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 289);
	
-- >> 290
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (290, 1000000001, 'TTMIS', 'Tan Kok Lam', 'CCIND', 
			'IDNIC', '830429-14-5310', 290, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0109317233', '', '', 'MSOTH', 'patrick.koklam@gmail.com', 19830429,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (290, '3-3, Block Cempaka,', 'Lorong Dagang 5/1B,', 'Taman Dagang,', '',
			'68000', 'Ampang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 290);

-- >> 291
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (291, 1000000001, 'TTMST', 'Tan Kuan Cian', 'CCIND', 
			'IDNIC', '880706-56-6099', 291, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0123893208', '', '', 'MSOTH', '', 19880706,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (291, '968, Jalan Kuang Gunung,', 'Taman Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 291);

-- >> 292
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (292, 1000000001, 'TTMST', 'Tan Lai Hoe', 'CCIND', 
			'IDNIC', '740811-14-5531', 292, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'0162281707', '', '', 'MSOTH', 'ptcs707@yahoo.co.uk', 19740811,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (292, 'No 2b, Jalan Safa 1,', 'Desa Parkcity,', 'off Jalan Damansara,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 292);

-- >> 293
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (293, 1000000001, 'TTMST', 'Tan Lip Seng', 'CCIND', 
			'IDNIC', '820114-14-5501', 293, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'016-2945013', '019-2781437', '', 'MSOTH', '', 19820114,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (293, 'No 39, Rancangan Penyusunan Semula,', 'Batu 18,', 'Jalan Ipoh,', '',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 293);
			
-- >> 294
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (294, 1000000001, 'TTMIS', 'Tan Mei Ling', 'CCIND', 
			'IDNIC', '731108-10-5592', 294, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0123209980', '', '', 'MSOTH', 'uniqsecure@yahoo.com', 19731108,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (294, '303, Jalan 23/39,', 'Petaling Garden,', 'Kepong Baru,', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 294);	
	
-- >> 295
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (295, 1000000001, 'TTMST', 'Tan Ser Yong', 'CCIND', 
			'IDNIC', '750812-01-6853', 295, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19750812,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (295, 'PS-15-23 Prima Saujana Apartment,', 'No.2 Jalan Wangsa 2/6,', 'Taman Wangsa Permai,', '',
			'52200', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 295);	
											
-- >> 296
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (296, 1000000001, 'TTMST', 'Tan Tee Kiat', 'CCIND', 
			'IDNIC', '890221-10-5357', 296, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19890221,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (296, 'No. 71, Jalan SJ 30,', 'Taman Selayang Jaya', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 296);	
			
-- >> 297
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (297, 1000000001, 'TTMIS', 'Tan Tin Tieng', 'CCIND', 
			'IDNIC', '750725-14-5112', 297, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19750725,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (297, '968, Jalan Kuang Gunung,', 'Taman Kepong,', '', '',
			'52100', 'Kuala Lumpur', 'STKUL', 'CTMAS', 20130625, 'sysadm', 297);	

-- >> 298
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (298, 1000000001, 'TTMST', 'Tan Tze Unn', 'CCIND', 
			'IDNIC', '860610-43-5977', 298, 'RCCHI', 'CTMAS', 'BMNON', 'SXMAL',
			'', '', '', 'MSOTH', '', 19860610,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (298, 'No 6, Jalan SJ 17A,', 'Taman Selayang Bahagia,', '', '',
			'68100', 'Batu Caves,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 298);	

-- >> 299
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (299, 1000000001, 'TTMIS', 'Tang Chai Wei', 'CCIND', 
			'IDNIC', '860509-56-6366', 299, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'', '', '', 'MSOTH', '', 19860509,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (299, '29, Jalan 1/38E,', 'Taman Sri Sinar,', '', '',
			'51200', 'Segambut,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 299);	

-- >> 300
INSERT INTO vipro.customer (customer_id, institution_id, title, full_name, customer_category,
	        identity_type, identity_no, address_id, race, citizenship, bumi_indicator, sex,
			mobile_no, house_tel_no, office_tel_no, marital_status, email, date_of_birth,
			remarks, created_by, date_created, customer_status)
     VALUES (300, 1000000001, 'TTMIS', 'Tang Su Ping', 'CCIND', 
			'IDNIC', '840625-13-5194', 300, 'RCCHI', 'CTMAS', 'BMNON', 'SXFEM',
			'0168959584', '', '', 'MSOTH', 'Sharis_tang@yahoo.com', 19840625,
			'', 'sysadm', 20130625, 'CCACT');

INSERT INTO vipro.address (address_id, address_line_1, address_line_2, address_line_3, address_line_4, 
			postcode, city, state, country, created_on, created_by, customer_id)
     VALUES (300, '10, Persiaran Bestari 1,', 'Templer Bestari,', 'Templer Park Resort,', 'No12, Jalan Yap Kwan Seng,',
			'48000', 'Rawang,', 'STSEL', 'CTMAS', 20130625, 'sysadm', 300);

