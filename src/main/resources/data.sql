DROP TABLE IF EXISTS userdata;

CREATE TABLE userdata
(id_user     INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
name        TEXT NOT NULL,
password    TEXT NOT NULL,
description TEXT);

INSERT INTO userdata (name, password, description) VALUES ('01haru',  '$2a$10$sshMrue/Q/JniEX7C575f.WiimO.T0wgHjbKClC6HSuVRcw6g3j5G', 'はる');
INSERT INTO userdata (name, password, description) VALUES ('02natsu', '$2a$10$FqOsfjGVZHtfj7CrLdaaV.wf1VofgacH8.yGcU20obZn0IVPXP8ni', 'なつ');
INSERT INTO userdata (name, password, description) VALUES ('03aki',   '$2a$10$xIRvwEv6vdCpdj67epB2feWGgl6qyevhgFPMyDJY4gdVNIbA51TI6', 'あき');
INSERT INTO userdata (name, password, description) VALUES ('04fuyu',  '$2a$10$.Qh/e91KqiPOgM/0aU29J.STG.snSFBSB/ccgKD3So0kDDEGFGLjy', 'ふゆ');

				
DROP TABLE IF EXISTS role;
CREATE TABLE role
(id_role  INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
no       INT  NOT NULL,
name TEXT  NOT NULL);

INSERT INTO role (no, name) VALUES (1, 'ADMIN');
INSERT INTO role (no, name) VALUES (2, 'MANAGER');
INSERT INTO role (no, name) VALUES (3, 'USER');

				
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(id_user_role  INT  NOT NULL PRIMARY KEY AUTO_INCREMENT,
id_user       INT  NOT NULL,
role_no INT  NOT NULL);

INSERT INTO user_role (id_user, role_no) VALUES (1, 1);
INSERT INTO user_role (id_user, role_no) VALUES (2, 2);
INSERT INTO user_role (id_user, role_no) VALUES (2, 3);
INSERT INTO user_role (id_user, role_no) VALUES (3, 2);
INSERT INTO user_role (id_user, role_no) VALUES (4, 3);
