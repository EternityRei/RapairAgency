DROP database if exists R_a;
CREATE database R_a;

USE R_a;

create table Users (
      id                INT primary key not null,
      email             varchar(40) not null,
      passwd            varchar(40) not null,
      name              varchar(40) not null,
      surname           varchar(40) not null
);

create table Roles (
      id                INT primary key not null,
      name              varchar(40) not null,
      user_id           INT,
                        foreign key (user_id) references Users(id)
);

create table Managers (
       id               INT not null primary key,
       role_id          INT,
                        foreign key (role_id) references Roles(id)
);

create table Employees (
        id              INT not null primary key,
        role_id         INT,
                        foreign key (role_id) references Roles(id)
);

create table Customers (
        id              INT not null primary key,
        user_id         INT,
                        foreign key (user_id) references Users(id)
);

create table Orders (
        id              INT not null auto_increment primary key,
        employee_id     INT not null,
                        foreign key (employee_id) references Employees(id),
        customer_id     INT not null,
                        foreign key (customer_id) references Customers(id),
        manager_id      INT not null,
                        foreign key (manager_id) references Managers(id),
        cost            float(9,2) not null,
        description     varchar(60) not null,
        work_status     varchar(40) not null,
        payment_status  varchar(40) not null
);

INSERT INTO Users values (1, 'juliaMask1991@gmail.com', 'juliaMask1991', 'Julia', 'Mask');
INSERT INTO Roles(id, name) values (1, 'Manager'), (2, 'Employee'), (3, 'Customer');
INSERT INTO Managers values(1, 1);
