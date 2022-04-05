CREATE TABLE IF NOT EXISTS z_user (
    id bigint auto_increment primary key,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    work_experience text not null,
    photo text not null,
    username_twitter varchar(100) not null
);