CREATE TABLE IF NOT EXISTS `sleep_record`(
	`id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `date` DATE NOT NULL,
    `start_time` TIME NOT NULL,
    `end_time` TIME NOT NULL,
    `duration` INTEGER
);

