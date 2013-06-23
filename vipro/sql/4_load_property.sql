-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Loading of first project information and property unit for V-Resindesi  
-- | Selayang Heights Block A Units
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+
-- Load the V-Residensi Project Record
-- Load Both Block A & B units

-- Load Project Record
INSERT INTO vipro.project (project_id, project_name, project_code, property_type, report_group, address1, project_office_tel_no, project_office_fax_no, person_in_charge, pic_mobile_no, city, state, country, staff_booking_fee, public_booking_fee, launch_date, institution_id, status, postcode, discount_rate, sales_commission, developer_id, land_proprietor_id)
     VALUES (1, 'V-Residensi @ Selayang Heights', 'VRSH', 'PTCON', 'RGVRS', '25, Jalan USJ 21/10,', '0380239988', '0380249185', 'Hasrina', '0192326080', 'UEP Subang Jaya', 'STSEL', 'CTMAS', 500.00, 5000.00, 20130601, 1000000001, 'SSACT', '47630', 10.00, 800.00, 2, 3);

-- Block A Level 2
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-01', 'A', '02', 'A1', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-03', 'A', '02', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-05', 'A', '02', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-07', 'A', '02', 'D', 1042, 'ACTV', 415500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-09', 'A', '02', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-11', 'A', '02', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-13', 'A', '02', 'B', 1187, 'ACTV', 485500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-02', 'A', '02', 'A1', 1210, 'ACTV', 449500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-02A', 'A', '02', 'A', 1210, 'ACTV', 444000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-06', 'A', '02', 'A', 1210, 'ACTV', 444000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-08', 'A', '02', 'A2', 1210, 'ACTV', 449500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-10', 'A', '02', 'A2', 1210, 'ACTV', 449500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-12', 'A', '02', 'A', 1210, 'ACTV', 444000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-02-12A', 'A', '02', 'A', 1210, 'ACTV', 444000.00, 1);

-- Block A Level 3
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-01', 'A', '03', 'A1', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-03', 'A', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-05', 'A', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-07', 'A', '03', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-09', 'A', '03', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-11', 'A', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-13', 'A', '03', 'B', 1187, 'ACTV', 487500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-02', 'A', '03', 'A1', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-02A', 'A', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-06', 'A', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-08', 'A', '03', 'A2', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-10', 'A', '03', 'A2', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-12', 'A', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03-12A', 'A', '03', 'A', 1210, 'ACTV', 446000.00, 1);

-- Block A Level 3A
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-01', 'A', '03A', 'A1', 1210, 'ACTV', 487000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-03', 'A', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-05', 'A', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-07', 'A', '03A', 'A2', 1210, 'ACTV', 487000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-09', 'A', '03A', 'A2', 1210, 'ACTV', 487000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-11', 'A', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-13', 'A', '03A', 'B', 1187, 'ACTV', 490000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-02', 'A', '03A', 'A1', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-02A', 'A', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-06', 'A', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-08', 'A', '03A', 'A2', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-10', 'A', '03A', 'A2', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-12', 'A', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-03A-12A', 'A', '03A', 'A', 1210, 'ACTV', 448500.00, 1);

-- Block A Level 05
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-01', 'A', '05', 'A1', 1210, 'ACTV', 489500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-03', 'A', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-05', 'A', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-07', 'A', '05', 'A2', 1210, 'ACTV', 489500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-09', 'A', '05', 'A2', 1210, 'ACTV', 489500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-11', 'A', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-13', 'A', '05', 'B', 1187, 'ACTV', 492000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-02', 'A', '05', 'A1', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-02A', 'A', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-06', 'A', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-08', 'A', '05', 'A2', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-10', 'A', '05', 'A2', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-12', 'A', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-05-12A', 'A', '05', 'A', 1210, 'ACTV', 450500.00, 1);

-- Block A Level 06
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-01', 'A', '06', 'A1', 1210, 'ACTV', 491500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-03', 'A', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-05', 'A', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-07', 'A', '06', 'A2', 1210, 'ACTV', 491500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-09', 'A', '06', 'A2', 1210, 'ACTV', 491500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-11', 'A', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-13', 'A', '06', 'B', 1187, 'ACTV', 494500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-02', 'A', '06', 'A1', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-02A', 'A', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-06', 'A', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-08', 'A', '06', 'A2', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-10', 'A', '06', 'A2', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-12', 'A', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-06-12A', 'A', '06', 'A', 1210, 'ACTV', 453000.00, 1);

-- Block A Level 07
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-01', 'A', '07', 'A1', 1210, 'ACTV', 494000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-03', 'A', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-05', 'A', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-07', 'A', '07', 'A2', 1210, 'ACTV', 494000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-09', 'A', '07', 'A2', 1210, 'ACTV', 494000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-11', 'A', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-13', 'A', '07', 'B', 1187, 'ACTV', 496500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-02', 'A', '07', 'A1', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-02A', 'A', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-06', 'A', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-08', 'A', '07', 'A2', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-10', 'A', '07', 'A2', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-12', 'A', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-07-12A', 'A', '07', 'A', 1210, 'ACTV', 455000.00, 1);

-- Block A Level 08
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-01', 'A', '08', 'A1', 1210, 'ACTV', 496000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-03', 'A', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-05', 'A', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-07', 'A', '08', 'A2', 1210, 'ACTV', 496000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-09', 'A', '08', 'A2', 1210, 'ACTV', 496000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-11', 'A', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-13', 'A', '08', 'B', 1187, 'ACTV', 499000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-02', 'A', '08', 'A1', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-02A', 'A', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-06', 'A', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-08', 'A', '08', 'A2', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-10', 'A', '08', 'A2', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-12', 'A', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-08-12A', 'A', '08', 'A', 1210, 'ACTV', 457000.00, 1);

-- Block A Level 09
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-01', 'A', '09', 'A1', 1210, 'ACTV', 498500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-03', 'A', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-05', 'A', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-07', 'A', '09', 'A2', 1210, 'ACTV', 498500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-09', 'A', '09', 'A2', 1210, 'ACTV', 498500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-11', 'A', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-13', 'A', '09', 'B', 1187, 'ACTV', 501000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-02', 'A', '09', 'A1', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-02A', 'A', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-06', 'A', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-08', 'A', '09', 'A2', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-10', 'A', '09', 'A2', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-12', 'A', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-09-12A', 'A', '09', 'A', 1210, 'ACTV', 459500.00, 1);

-- Block A Level 10
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-01', 'A', '10', 'A1', 1210, 'ACTV', 500500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-03', 'A', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-05', 'A', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-07', 'A', '10', 'A2', 1210, 'ACTV', 500500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-09', 'A', '10', 'A2', 1210, 'ACTV', 500500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-11', 'A', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-13', 'A', '10', 'B', 1187, 'ACTV', 503500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-02', 'A', '10', 'A1', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-02A', 'A', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-06', 'A', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-08', 'A', '10', 'A2', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-10', 'A', '10', 'A2', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-12', 'A', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-10-12A', 'A', '10', 'A', 1210, 'ACTV', 461500.00, 1);

-- Block A Level 11
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-01', 'A', '11', 'A1', 1210, 'ACTV', 503000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-03', 'A', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-05', 'A', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-07', 'A', '11', 'A2', 1210, 'ACTV', 503000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-09', 'A', '11', 'A2', 1210, 'ACTV', 503000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-11', 'A', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-13', 'A', '11', 'B', 1187, 'ACTV', 505500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-02', 'A', '11', 'A1', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-02A', 'A', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-06', 'A', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-08', 'A', '11', 'A2', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-10', 'A', '11', 'A2', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-12', 'A', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-11-12A', 'A', '11', 'A', 1210, 'ACTV', 464000.00, 1);

-- Block A Level 12
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-01', 'A', '12', 'A1', 1210, 'ACTV', 505000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-03', 'A', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-05', 'A', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-07', 'A', '12', 'A2', 1210, 'ACTV', 505000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-09', 'A', '12', 'A2', 1210, 'ACTV', 505000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-11', 'A', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-13', 'A', '12', 'B', 1187, 'ACTV', 507500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-02', 'A', '12', 'A1', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-02A', 'A', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-06', 'A', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-08', 'A', '12', 'A2', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-10', 'A', '12', 'A2', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-12', 'A', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-12-12A', 'A', '12', 'A', 1210, 'ACTV', 466000.00, 1);

-- Block A Level 13
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-01', 'A', '13', 'A1', 1210, 'ACTV', 507000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-03', 'A', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-05', 'A', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-07', 'A', '13', 'A2', 1210, 'ACTV', 507000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-09', 'A', '13', 'A2', 1210, 'ACTV', 507000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-11', 'A', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-13', 'A', '13', 'B', 1187, 'ACTV', 510000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-02', 'A', '13', 'A1', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-02A', 'A', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-06', 'A', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-08', 'A', '13', 'A2', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-10', 'A', '13', 'A2', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-12', 'A', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13-12A', 'A', '13', 'A', 1210, 'ACTV', 468500.00, 1);

-- Block A Level 13A
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-01', 'A', '13A', 'A1', 1210, 'ACTV', 509000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-03', 'A', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-05', 'A', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-07', 'A', '13A', 'A2', 1210, 'ACTV', 509500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-09', 'A', '13A', 'A2', 1210, 'ACTV', 509500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-11', 'A', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-13', 'A', '13A', 'B', 1187, 'ACTV', 512000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-02', 'A', '13A', 'A1', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-02A', 'A', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-06', 'A', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-08', 'A', '13A', 'A2', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-10', 'A', '13A', 'A2', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-12', 'A', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-13A-12A', 'A', '13A', 'A', 1210, 'ACTV', 470500.00, 1);

-- Block A Level 15
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-01', 'A', '15', 'A1', 1210, 'ACTV', 511500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-03', 'A', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-05', 'A', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-07', 'A', '15', 'A2', 1210, 'ACTV', 511500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-09', 'A', '15', 'A2', 1210, 'ACTV', 511500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-11', 'A', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-13', 'A', '15', 'B', 1187, 'ACTV', 514500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-02', 'A', '15', 'A1', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-02A', 'A', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-06', 'A', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-08', 'A', '15', 'A2', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-10', 'A', '15', 'A2', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-12', 'A', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-15-12A', 'A', '15', 'A', 1210, 'ACTV', 473000.00, 1);

-- Block A Level 16
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-01', 'A', '16', 'A1', 1210, 'ACTV', 514000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-03', 'A', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-05', 'A', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-07', 'A', '16', 'A2', 1210, 'ACTV', 514000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-09', 'A', '16', 'A2', 1210, 'ACTV', 514000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-11', 'A', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-13', 'A', '16', 'B', 1187, 'ACTV', 516500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-02', 'A', '16', 'A1', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-02A', 'A', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-06', 'A', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-08', 'A', '16', 'A2', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-10', 'A', '16', 'A2', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-12', 'A', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-16-12A', 'A', '16', 'A', 1210, 'ACTV', 475000.00, 1);

-- Block A Level 17
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-01', 'A', '17', 'A1', 1210, 'ACTV', 516000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-03', 'A', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-05', 'A', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-07', 'A', '17', 'A2', 1210, 'ACTV', 516000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-09', 'A', '17', 'A2', 1210, 'ACTV', 516000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-11', 'A', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-13', 'A', '17', 'B', 1187, 'ACTV', 519000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-02', 'A', '17', 'A1', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-02A', 'A', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-06', 'A', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-08', 'A', '17', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-10', 'A', '17', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-12', 'A', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-17-12A', 'A', '17', 'A', 1210, 'ACTV', 477000.00, 1);

-- Block A Level 18
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-01', 'A', '18', 'A1', 1210, 'ACTV', 518500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-03', 'A', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-05', 'A', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-07', 'A', '18', 'A2', 1210, 'ACTV', 518500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-09', 'A', '18', 'A2', 1210, 'ACTV', 518500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-11', 'A', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-13', 'A', '18', 'B', 1187, 'ACTV', 521000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-02', 'A', '18', 'A1', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-02A', 'A', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-06', 'A', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-08', 'A', '18', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-10', 'A', '18', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-12', 'A', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('A-18-12A', 'A', '18', 'A', 1210, 'ACTV', 479500.00, 1);

-- +-------------------------------------------------------------------------+

-- Block B Level 2
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-09', 'B', '02', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-11', 'B', '02', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-13', 'B', '02', 'B', 1187, 'ACTV', 485500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-10', 'B', '02', 'A2', 1210, 'ACTV', 449500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-12', 'B', '02', 'A', 1210, 'ACTV', 444000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-02-12A', 'B', '02', 'A', 1210, 'ACTV', 444000.00, 1);

-- Block B Level 3
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-01', 'B', '03', 'C', 1213, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-03', 'B', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-05', 'B', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-07', 'B', '03', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-09', 'B', '03', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-11', 'B', '03', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-13', 'B', '03', 'B', 1187, 'ACTV', 487500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-02', 'B', '03', 'A1', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-02A', 'B', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-06', 'B', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-08', 'B', '03', 'A2', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-10', 'B', '03', 'A2', 1210, 'ACTV', 451500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-12', 'B', '03', 'A', 1210, 'ACTV', 446000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03-12A', 'B', '03', 'A', 1210, 'ACTV', 446000.00, 1);

-- Block B Level 3A
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-01', 'B', '03A', 'C', 1213, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-03', 'B', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-05', 'B', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-07', 'B', '03A', 'A2', 1210, 'ACTV', 487000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-09', 'B', '03A', 'A2', 1210, 'ACTV', 487000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-11', 'B', '03A', 'A', 1210, 'ACTV', 481500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-13', 'B', '03A', 'B', 1187, 'ACTV', 490000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-02', 'B', '03A', 'A1', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-02A', 'B', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-06', 'B', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-08', 'B', '03A', 'A2', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-10', 'B', '03A', 'A2', 1210, 'ACTV', 454000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-12', 'B', '03A', 'A', 1210, 'ACTV', 448500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-03A-12A', 'B', '03A', 'A', 1210, 'ACTV', 448500.00, 1);

-- Block B Level 05
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-01', 'B', '05', 'C', 1213, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-03', 'B', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-05', 'B', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-07', 'B', '05', 'A2', 1210, 'ACTV', 489500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-09', 'B', '05', 'A2', 1210, 'ACTV', 489500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-11', 'B', '05', 'A', 1210, 'ACTV', 484000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-13', 'B', '05', 'B', 1187, 'ACTV', 492000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-02', 'B', '05', 'A1', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-02A', 'B', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-06', 'B', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-08', 'B', '05', 'A2', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-10', 'B', '05', 'A2', 1210, 'ACTV', 456000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-12', 'B', '05', 'A', 1210, 'ACTV', 450500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-05-12A', 'B', '05', 'A', 1210, 'ACTV', 450500.00, 1);

-- Block B Level 06
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-01', 'B', '06', 'C', 1213, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-03', 'B', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-05', 'B', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-07', 'B', '06', 'A2', 1210, 'ACTV', 491500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-09', 'B', '06', 'A2', 1210, 'ACTV', 491500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-11', 'B', '06', 'A', 1210, 'ACTV', 486000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-13', 'B', '06', 'B', 1187, 'ACTV', 494500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-02', 'B', '06', 'A1', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-02A', 'B', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-06', 'B', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-08', 'B', '06', 'A2', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-10', 'B', '06', 'A2', 1210, 'ACTV', 458500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-12', 'B', '06', 'A', 1210, 'ACTV', 453000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-06-12A', 'B', '06', 'A', 1210, 'ACTV', 453000.00, 1);

-- Block A Level 07
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-01', 'B', '07', 'C', 1213, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-03', 'B', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-05', 'B', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-07', 'B', '07', 'A2', 1210, 'ACTV', 494000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-09', 'B', '07', 'A2', 1210, 'ACTV', 494000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-11', 'B', '07', 'A', 1210, 'ACTV', 488500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-13', 'B', '07', 'B', 1187, 'ACTV', 496500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-02', 'B', '07', 'A1', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-02A', 'B', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-06', 'B', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-08', 'B', '07', 'A2', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-10', 'B', '07', 'A2', 1210, 'ACTV', 460500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-12', 'B', '07', 'A', 1210, 'ACTV', 455000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-07-12A', 'B', '07', 'A', 1210, 'ACTV', 455000.00, 1);

-- Block B Level 08
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-01', 'B', '08', 'C', 1213, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-03', 'B', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-05', 'B', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-07', 'B', '08', 'A2', 1210, 'ACTV', 496000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-09', 'B', '08', 'A2', 1210, 'ACTV', 496000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-11', 'B', '08', 'A', 1210, 'ACTV', 490500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-13', 'B', '08', 'B', 1187, 'ACTV', 499000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-02', 'B', '08', 'A1', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-02A', 'B', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-06', 'B', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-08', 'B', '08', 'A2', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-10', 'B', '08', 'A2', 1210, 'ACTV', 463000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-12', 'B', '08', 'A', 1210, 'ACTV', 457000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-08-12A', 'B', '08', 'A', 1210, 'ACTV', 457000.00, 1);

-- Block B Level 09
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-01', 'B', '09', 'C', 1213, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-03', 'B', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-05', 'B', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-07', 'B', '09', 'A2', 1210, 'ACTV', 498500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-09', 'B', '09', 'A2', 1210, 'ACTV', 498500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-11', 'B', '09', 'A', 1210, 'ACTV', 493000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-13', 'B', '09', 'B', 1187, 'ACTV', 501000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-02', 'B', '09', 'A1', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-02A', 'B', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-06', 'B', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-08', 'B', '09', 'A2', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-10', 'B', '09', 'A2', 1210, 'ACTV', 465000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-12', 'B', '09', 'A', 1210, 'ACTV', 459500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-09-12A', 'B', '09', 'A', 1210, 'ACTV', 459500.00, 1);

-- Block B Level 10
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-01', 'B', '10', 'C', 1213, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-03', 'B', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-05', 'B', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-07', 'B', '10', 'A2', 1210, 'ACTV', 500500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-09', 'B', '10', 'A2', 1210, 'ACTV', 500500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-11', 'B', '10', 'A', 1210, 'ACTV', 495000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-13', 'B', '10', 'B', 1187, 'ACTV', 503500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-02', 'B', '10', 'A1', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-02A', 'B', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-06', 'B', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-08', 'B', '10', 'A2', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-10', 'B', '10', 'A2', 1210, 'ACTV', 467000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-12', 'B', '10', 'A', 1210, 'ACTV', 461500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-10-12A', 'B', '10', 'A', 1210, 'ACTV', 461500.00, 1);

-- Block B Level 11
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-01', 'B', '11', 'C', 1213, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-03', 'B', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-05', 'B', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-07', 'B', '11', 'A2', 1210, 'ACTV', 503000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-09', 'B', '11', 'A2', 1210, 'ACTV', 503000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-11', 'B', '11', 'A', 1210, 'ACTV', 497000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-13', 'B', '11', 'B', 1187, 'ACTV', 505500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-02', 'B', '11', 'A1', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-02A', 'B', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-06', 'B', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-08', 'B', '11', 'A2', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-10', 'B', '11', 'A2', 1210, 'ACTV', 469500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-12', 'B', '11', 'A', 1210, 'ACTV', 464000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-11-12A', 'B', '11', 'A', 1210, 'ACTV', 464000.00, 1);

-- Block B Level 12
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-01', 'B', '12', 'C', 1213, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-03', 'B', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-05', 'B', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-07', 'B', '12', 'A2', 1210, 'ACTV', 505000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-09', 'B', '12', 'A2', 1210, 'ACTV', 505000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-11', 'B', '12', 'A', 1210, 'ACTV', 499500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-13', 'B', '12', 'B', 1187, 'ACTV', 507500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-02', 'B', '12', 'A1', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-02A', 'B', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-06', 'B', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-08', 'B', '12', 'A2', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-10', 'B', '12', 'A2', 1210, 'ACTV', 471500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-12', 'B', '12', 'A', 1210, 'ACTV', 466000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-12-12A', 'B', '12', 'A', 1210, 'ACTV', 466000.00, 1);

-- Block B Level 13
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-01', 'B', '13', 'C', 1213, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-03', 'B', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-05', 'B', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-07', 'B', '13', 'A2', 1210, 'ACTV', 507000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-09', 'B', '13', 'A2', 1210, 'ACTV', 507000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-11', 'B', '13', 'A', 1210, 'ACTV', 501500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-13', 'B', '13', 'B', 1187, 'ACTV', 510000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-02', 'B', '13', 'A1', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-02A', 'B', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-06', 'B', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-08', 'B', '13', 'A2', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-10', 'B', '13', 'A2', 1210, 'ACTV', 474000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-12', 'B', '13', 'A', 1210, 'ACTV', 468500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13-12A', 'B', '13', 'A', 1210, 'ACTV', 468500.00, 1);

-- Block B Level 13A
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-01', 'B', '13A', 'C', 1213, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-03', 'B', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-05', 'B', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-07', 'B', '13A', 'A2', 1210, 'ACTV', 509500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-09', 'B', '13A', 'A2', 1210, 'ACTV', 509500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-11', 'B', '13A', 'A', 1210, 'ACTV', 504000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-13', 'B', '13A', 'B', 1187, 'ACTV', 512000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-02', 'B', '13A', 'A1', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-02A', 'B', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-06', 'B', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-08', 'B', '13A', 'A2', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-10', 'B', '13A', 'A2', 1210, 'ACTV', 476000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-12', 'B', '13A', 'A', 1210, 'ACTV', 470500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-13A-12A', 'B', '13A', 'A', 1210, 'ACTV', 470500.00, 1);

-- Block B Level 15
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-01', 'B', '15', 'C', 1213, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-03', 'B', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-05', 'B', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-07', 'B', '15', 'A2', 1210, 'ACTV', 511500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-09', 'B', '15', 'A2', 1210, 'ACTV', 511500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-11', 'B', '15', 'A', 1210, 'ACTV', 506000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-13', 'B', '15', 'B', 1187, 'ACTV', 514500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-02', 'B', '15', 'A1', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-02A', 'B', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-06', 'B', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-08', 'B', '15', 'A2', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-10', 'B', '15', 'A2', 1210, 'ACTV', 478500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-12', 'B', '15', 'A', 1210, 'ACTV', 473000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-15-12A', 'B', '15', 'A', 1210, 'ACTV', 473000.00, 1);

-- Block B Level 16
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-01', 'B', '16', 'C', 1213, 'ACTV', 515000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-03', 'B', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-05', 'B', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-07', 'B', '16', 'A2', 1210, 'ACTV', 514000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-09', 'B', '16', 'A2', 1210, 'ACTV', 514000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-11', 'B', '16', 'A', 1210, 'ACTV', 508500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-13', 'B', '16', 'B', 1187, 'ACTV', 516500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-02', 'B', '16', 'A1', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-02A', 'B', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-06', 'B', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-08', 'B', '16', 'A2', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-10', 'B', '16', 'A2', 1210, 'ACTV', 480500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-12', 'B', '16', 'A', 1210, 'ACTV', 475000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-16-12A', 'B', '16', 'A', 1210, 'ACTV', 475000.00, 1);

-- Block B Level 17
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-01', 'B', '17', 'C', 1213, 'ACTV', 517000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-03', 'B', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-05', 'B', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-07', 'B', '17', 'A2', 1210, 'ACTV', 516000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-09', 'B', '17', 'A2', 1210, 'ACTV', 516000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-11', 'B', '17', 'A', 1210, 'ACTV', 510500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-13', 'B', '17', 'B', 1187, 'ACTV', 519000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-02', 'B', '17', 'A1', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-02A', 'B', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-06', 'B', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-08', 'B', '17', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-10', 'B', '17', 'A2', 1210, 'ACTV', 483000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-12', 'B', '17', 'A', 1210, 'ACTV', 477000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-17-12A', 'B', '17', 'A', 1210, 'ACTV', 477000.00, 1);

-- Block B Level 18
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-01', 'B', '18', 'C', 1213, 'ACTV', 519500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-03', 'B', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-05', 'B', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-07', 'B', '18', 'A2', 1210, 'ACTV', 518500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-09', 'B', '18', 'A2', 1210, 'ACTV', 518500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-11', 'B', '18', 'A', 1210, 'ACTV', 513000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-13', 'B', '18', 'B', 1187, 'ACTV', 521000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-02', 'B', '18', 'A1', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-02A', 'B', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-06', 'B', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-08', 'B', '18', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-10', 'B', '18', 'A2', 1210, 'ACTV', 485000.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-12', 'B', '18', 'A', 1210, 'ACTV', 479500.00, 1);
INSERT INTO vipro.project_inventory (unit_no, block_no, level, layout_type, built_up_area, property_status, purchase_price, project_id) 
     VALUES ('B-18-12A', 'B', '18', 'A', 1210, 'ACTV', 479500.00, 1);

