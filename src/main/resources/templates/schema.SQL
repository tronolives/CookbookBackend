create database cookbook_db1;

CREATE USER 'springuser'@'%' IDENTIFIED BY 'password';
GRANT ALL ON *.* TO 'springuser'@'%';
flush privileges;