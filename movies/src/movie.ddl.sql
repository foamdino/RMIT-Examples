drop table actor_movie;
drop table actor;
drop table movie;

create table actor (
  id int not null,
  name varchar(255) not null,
  primary key(id)
);

create table movie (
  id int not null,
  name varchar(255) not null,
  primary key(id)
);

create table actor_movie (
  actor_id int not null,
  movie_id int not null,
  foreign key(actor_id) references actor (id),
  foreign key(movie_id) references movie (id)
);