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

-- update all inventory discount price to 10%
UPDATE vipro.project_inventory
SET discount_amount = purchase_price * 0.10, discount_rate = 10.00
WHERE project_id = 1;

