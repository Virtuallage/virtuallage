-- Account Table
ALTER TABLE vipro.account CHANGE COLUMN purchase_price purchase_price DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN discounted_amount discounted_amount DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN net_price net_price DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN loan_amount loan_amount DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN total_payment_todate total_payment_todate DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN bank_redemption_sum bank_redemption_sum DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN bank_redemption_todate bank_redemption_todate DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN account_balance account_balance DEC(11, 2);
ALTER TABLE vipro.account CHANGE COLUMN book_pymt_card_chq_no book_pymt_card_chq_no VARCHAR(20);

-- Inventory Table
ALTER TABLE vipro.project_inventory CHANGE COLUMN redemption_amount redemption_amount DEC(11, 2);

ALTER TABLE vipro.project_inventory ADD facing VARCHAR(5) AFTER orientation;


-- Insert new code Layout Type
INSERT INTO code_header VALUES ('LT', 'PROPERTY LAYOUT TYPE');
INSERT INTO code_det VALUES ('LT', 'LTSDE', 'SOFO - DELUXE', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTSST', 'SOFO - STANDARD', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSA', 'PREMIUM SUITE A', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSB', 'PREMIUM SUITE B', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'LTPSC', 'PREMIUM SUITE C', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'A1', 'A1', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'A2', 'A2', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'B', 'B', 'SSACT');
INSERT INTO code_det VALUES ('LT', 'D', 'D', 'SSACT');

INSERT INTO code_header VALUES ('FC', 'PROPERTY FACING DIRECTION');
INSERT INTO code_det VALUES ('FC', 'FCSOE', 'SOUTH EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOW', 'NORTH WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOE', 'NORTH EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCSOW', 'SOUTH WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCSOU', 'SOUTH', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCEAS', 'EAST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCWES', 'WEST', 'SSACT');
INSERT INTO code_det VALUES ('FC', 'FCNOR', 'NORTH', 'SSACT');


