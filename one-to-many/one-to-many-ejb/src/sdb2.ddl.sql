drop table student;
drop table department;

create table department (
  id int not null,
  department_name varchar(255) not null,
  primary key(id)
);

create table student (
  id int not null,
  student_name varchar(255) not null,
  department_id int,
  primary key (id),
  foreign key(department_id) references department(id)
);