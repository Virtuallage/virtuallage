ALTER TABLE vipro.case 
CHANGE COLUMN name project_id BIGINT(20) NULL DEFAULT NULL ,
CHANGE COLUMN mobile_no unit_id BIGINT(20) NULL DEFAULT NULL ,
CHANGE COLUMN email assignee_group_id VARCHAR(10) NULL DEFAULT NULL ;

ALTER TABLE vipro.case_activity 
ADD COLUMN action VARCHAR(5) NOT NULL AFTER note;

DROP TABLE IF EXISTS vipro.case_route;
CREATE TABLE vipro.case_route (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , case_type VARCHAR(10)
     , case_status VARCHAR(10)
     , project_id BIGINT
     , group_id VARCHAR(10)
     , user_id BIGINT
	 , due_day DECIMAL(3)
     , target_group_id VARCHAR(10)
     , target_user_id BIGINT
     , next_action VARCHAR(10)
	 , changed_by BIGINT
	 , last_changed DATE
     , PRIMARY KEY (case_id)
);

DROP TABLE IF EXISTS vipro.case_link;
CREATE TABLE vipro.case_link (
       case_id BIGINT NOT NULL AUTO_INCREMENT
     , case_type VARCHAR(10)
     , case_link VARCHAR(100)
     , PRIMARY KEY (case_id)
);

ALTER TABLE vipro.case 
CHANGE COLUMN unit_id unit_id VARCHAR(12) NULL DEFAULT NULL ;

ALTER TABLE vipro.case 
DROP FOREIGN KEY FK_case_2;
ALTER TABLE vipro.case 
CHANGE COLUMN assignee_id assignee_id BIGINT(20) NULL ;
ALTER TABLE vipro.case 
ADD CONSTRAINT FK_case_2
  FOREIGN KEY (assignee_id)
  REFERENCES vipro.user_profile (user_id);