DROP TABLE IF EXISTS `users_groups`;
DROP TABLE IF EXISTS `groups`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE users(
    `id` INT NOT NULL AUTO_INCREMENT,
    `login` VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `groups`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) UNIQUE NOT NULL,
    PRIMARY KEY (`id`)
);
CREATE TABLE `users_groups`(
    `user_id` INT UNIQUE NOT NULL,
    `group_id` INT UNIQUE NOT NULL,
    FOREIGN KEY(`user_id`) REFERENCES `users`(`id`),
    FOREIGN KEY(`group_id`) REFERENCES `groups`(`id`)
);


INSERT INTO `users`(id, login)
VALUES (default, "ivanov");

INSERT INTO `users`(id, login)
VALUES (default, "teamA");



