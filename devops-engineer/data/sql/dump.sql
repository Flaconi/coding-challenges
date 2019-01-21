CREATE DATABASE mydb;

create TABLE mydb.users (
 id int(8) unsigned zerofill not null auto_increment primary key,
 name varchar(30) not null
);
INSERT INTO mydb.users (name) VALUES ('user1');
INSERT INTO mydb.users (name) VALUES ('user2');
INSERT INTO mydb.users (name) VALUES ('user3');
INSERT INTO mydb.users (name) VALUES ('user4');
INSERT INTO mydb.users (name) VALUES ('user5');
INSERT INTO mydb.users (name) VALUES ('user6');
INSERT INTO mydb.users (name) VALUES ('user7');

