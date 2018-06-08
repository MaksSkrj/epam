USE userdb;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS user_groups;

CREATE TABLE users
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  login VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO users VALUES (NULL, "ivanov");

CREATE TABLE groups
(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20) NOT NULL UNIQUE
);

INSERT INTO groups VALUES(NULL, "teamA");

CREATE TABLE user_groups
(
  user_id INT,
  group_id INT,
  PRIMARY KEY (user_id, group_id),
  FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (group_id) REFERENCES groups(id) ON DELETE CASCADE ON UPDATE CASCADE
);



