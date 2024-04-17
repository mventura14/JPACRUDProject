-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema runlog
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `runlog` ;

-- -----------------------------------------------------
-- Schema runlog
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `runlog` ;
USE `runlog` ;

-- -----------------------------------------------------
-- Table `run_log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `run_log` ;

CREATE TABLE IF NOT EXISTS `run_log` (
  `id` INT(10) NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(1000) NULL,
  `type` VARCHAR(45) NULL,
  `distance_in_miles` DECIMAL(5,2) NULL,
  `time_in_minutes` INT(3) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS runner;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'runner' IDENTIFIED BY 'runner';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'runner';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'runner';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `run_log`
-- -----------------------------------------------------
START TRANSACTION;
USE `runlog`;
INSERT INTO `run_log` (`id`, `description`, `type`, `distance_in_miles`, `time_in_minutes`) VALUES (1, 'fartlek', 'fartlek', 10, 10);
INSERT INTO `run_log` (`id`, `description`, `type`, `distance_in_miles`, `time_in_minutes`) VALUES (2, 'distance', 'distance', 20, 90);

COMMIT;

