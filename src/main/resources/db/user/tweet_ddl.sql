create table tweet (
   id integer primary key auto_increment,
   user_id integer,
   content varchar(1000) not null,
   create_time timestamp default current_timestamp,
   update_time timestamp default current_timestamp on update current_timestamp,
   foreign key (user_id) references user(id) on delete cascade
);
