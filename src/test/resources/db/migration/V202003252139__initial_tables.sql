CREATE TABLE `ong` (
  `id` VARCHAR(8) NOT NULL,
  `name` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `whatsapp` VARCHAR(30) NULL,
  `city` VARCHAR(200) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `whatsapp_UNIQUE` (`whatsapp` ASC));


CREATE TABLE `incident` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(300) NOT NULL,
    `description` VARCHAR(400) NOT NULL,
    `value` DECIMAL(10,2) NOT NULL,
    `ong_id` VARCHAR(8) NOT NULL,
    CONSTRAINT `incident_ong`
      FOREIGN KEY (`ong_id`)
      REFERENCES `ong` (`id`),
    PRIMARY KEY (`id`)
);
