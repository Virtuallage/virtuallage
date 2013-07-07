-- +-------------------------------------------------------------------------+
-- | Vipro - Virtuallage Property Development System                         |
-- | Copyright(C) 2013 Virtuallage Team  http://www.virtuallage.com          |
-- +-------------------------------------------------------------------------+
-- | Step 3: This SQL will perform the following: -                          |
-- | a. Final Update of Vipro Data                                           | 
-- +-------------------------------------------------------------------------+
-- | Date Created   : 01/06/2013           Last Updated On :  10/06/2013     |
-- | For any inquiry, please write to technical@virtuallage.com              |
-- +-------------------------------------------------------------------------+

-- update all inventory discount price to 15% for block A
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.15, discount_rate = 15.00
WHERE project_id = 1 and block_no = "A";

-- update special discount price to 18% for block A
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-02-07";

-- update special discount price to 18% for block A
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-02-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-03-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-03-03";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-03-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-03-07";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and project_id = 1 and unit_no = "A-03-11";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and project_id = 1 and unit_no = "A-03A-03";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-05-01";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-05-03";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-05-05";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-05-02A";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-06-01";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-06-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-08-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.18, discount_rate = 18.00
WHERE project_id = 1 and unit_no = "A-08-12";

-- update special discount price to 10% for block A
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-02-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-03A-11";


UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-05-7 ";


UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-05-13";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-07-09";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-08-13";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-09-11";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-10-03";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-11-12";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-13A-02A";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-13A-12";


UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-16-01";


UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-18-05";
 

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "A-18-12";


-- update all inventory discount price to 15% for block B
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.15, discount_rate = 15.00
WHERE project_id = 1 and block_no = "B";

-- update special discount price to 10% for block B
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-12";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-08";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-02";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-02A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-12";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-06-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-06-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-07-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-11-03";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-11-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-12-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-03";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-06";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-08";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-15-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-15-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-02";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-02A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-02";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-12";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-02-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-02";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-02A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03-06";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-02";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-02A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-06";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-08";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-3A-10";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-12";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-03A-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-05-08";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-07-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-08-13";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-09-08";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-11-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-12-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-02A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-12";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-13A-12A";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-15-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-15-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-16-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-16-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-16-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-03";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-17-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-03";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-09 ";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-18-11";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-01";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-05";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-07";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-09";

UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-11";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-02A";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-06";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-08";
 
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1 and unit_no = "B-19-10";
 


