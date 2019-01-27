# seyon-api

For mysql development , 

install mysql

create and alter users 
 
ALTER USER 'root'@'localhost' IDENTIFIED BY 'seyyon';

Create user seyon@localhost identified with mysql_native_password by 'pass';
use seyon
GRANT ALL ON seyon.* TO 'seyon'@'localhost';

create table user (email varchar(255) not null, active bit, company_id bigint, name varchar(255), primary key (email)); 