CREATE TABLE `demo`.`LoginChart` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

INSERT INTO `demo`.`LoginChart` (`username`, `password`) VALUES ('sidd1', 'pass1');
INSERT INTO `demo`.`LoginChart` (`username`, `password`) VALUES ('sidd2', 'pass2');
INSERT INTO `demo`.`LoginChart` (`username`, `password`) VALUES ('sidd3', 'pass3');

ALTER TABLE `demo`.`LoginChart` 
ADD COLUMN `name` VARCHAR(45) NOT NULL AFTER `password`;

UPDATE `demo`.`LoginChart` SET `name`='Siddharth' WHERE `id`='1';
UPDATE `demo`.`LoginChart` SET `name`='David' WHERE `id`='2';
UPDATE `demo`.`LoginChart` SET `name`='Mike' WHERE `id`='3';


--Table should look like this:

--	id		username	password	name
---------------------------------------
--	1		sidd1		pass1		Siddharth
--	2		sidd2		pass2		David
--	3 		sidd3		pass3		Mike