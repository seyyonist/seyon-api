# seyon
Manage your Vouchers and GST's in via seyon application.

# Required softwares
Java SDK 8
Mysql latest
Gmail Oauth Client Id
Nginx for static hosting.
Admin rights

# steps

1) install mysql and create new user seyon with password and follow the mysql setup instructions
2) Download the seyyon application from [GATEWAY](https://github.com/seyyonist/seyon-gw/releases), [API](https://github.com/seyyonist/seyon-api/releases), [UI](https://github.com/seyyonist/seyon-api/releases)
3) Create a folder called 'seyyon' in any drive and unzip the releases in this 'seyyon' folder.
4) follow the setup instructions below for API, GW and UI 

## mysql setup
1) install mysql
2) create and alter users 

ALTER USER 'root'@'localhost' IDENTIFIED BY 'seyyon';

create database seyyon;

Create user seyyon@localhost identified with mysql_native_password by '********';

use seyon

GRANT ALL ON seyyon.* TO 'seyyon'@'localhost';

create table user (email varchar(255) not null, active bit, company_id bigint, name varchar(255), primary key (email)); 

## API setup
1) goto the unziped API folder 
2) edit the application.properties 
3) change the MYSQL properties and save the file
4) Open command prompt in adminstrator mode 
5) run asService.bat
6) this will setup tyhe API as windows service
7) open windows service and locate seyon, then start the server
## Gateway Setup
1) goto the unziped GW folder 
2) edit the application.properties 
3) change the Oauth Google properties and save the file
4) Open command prompt in adminstrator mode 
5) run asService.bat
6) this will setup tyhe API as windows service
7) open windows service and locate seyon, then start the server

## UI setup
1) Goto Nginx installed folder , edit the conf/nginx.conf file
2) Copy the server settings and change the listener port to 3000
3) change the root to the new  'seyyon/UI folder'
4) reload the nginx 


# Setup is ready now we can access the application in http://localhost:8010.



