drop table product;

/*create table product (
  id int not null GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
  product_name varchar(255) not null,
  price decimal(5,2) not null,
  primary key (id)
);*/

create table product (
  id int not null,
  product_name varchar(255) not null,
  price decimal(5,2) not null,
  primary key (id)
);