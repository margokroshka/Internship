create table if not exists Goods (
    id int auto_increment primary key ,
    name varchar(100) not null ,
    price int not null
);

insert into Goods (name, price) values ('Book', 10);
insert into Goods (name, price) values ('Iphone', 1000);
insert into Goods (name, price) values ('Laptop', 2000);
insert into Goods (name, price) values ('Shirt', 50);
insert into Goods (name, price) values ('Shoes', 200);