drop table if exists user;

create table user (
    id integer primary key auto_increment,
    username varchar(100) not null,
    password varchar(100) not null,
    create_time timestamp default current_timestamp,
    update_time timestamp default current_timestamp on update current_timestamp
);
