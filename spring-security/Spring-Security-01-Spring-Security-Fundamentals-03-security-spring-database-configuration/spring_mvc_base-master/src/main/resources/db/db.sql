CREATE TABLE IF NOT EXISTS USERS(username VARCHAR(255) PRIMARY KEY, password VARCHAR(255), enabled BOOLEAN);

CREATE TABLE IF NOT EXISTS authorities(username VARCHAR(255), authority  VARCHAR(255), foreign key (username) references users(username));

insert into users values ('bryan', 'pass', true);
insert into authorities(username, authority) values ('bryan', 'ROLE_USER');
commit;
