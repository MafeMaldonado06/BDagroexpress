create database Agroexpress;

#OJO lo borran#
drop database agroexpress;

use agroexpress;

create table rol(
	Rol_Id int primary key not null,
    Rol_Nombre varchar(50) not null
);

insert into rol values (1,"Comprador"),
						(2,"Campesino"),
                        (3,"Transportador"),
                        (4,"Administrador");
                        
create table Usuario(
	Usu_Id bigint primary key not null,
    Usu_UrlImg text,
    Usu_Nombre varchar(50) not null,
    Usu_Apellidos varchar(50) not null,
    Usu_Correo varchar(150),
    Usu_Celular integer,
    Usu_Telefono integer,
    Usu_Departamento varchar(50) not null,
    Usu_Ciudad varchar(50) not null,
    Usu_Direccion varchar(50) not null,
    Usu_Contraseña varchar(10) not null,
    Usu_Rol int not null,
    foreign key (Usu_Rol) references rol(Rol_Id)
);

INSERT INTO Usuario () VALUES
(1, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Juan', 'Pérez', 'juanperez@example.com', 123456, 1234567, 'Antioquia', 'Medellín', 'Calle 123', 'contrase1', 2),
(2, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','María', 'González', 'mariagonzalez@example.com', 098765, 7654321, 'Valle del Cauca', 'Cali', 'Carrera 456', 'contrase2', 2),
(3, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Pedro', 'López', 'pedrolopez@example.com', 11111, 2222222, 'Bogotá D.C.', 'Bogotá', 'Avenida 789', 'contrase3', 2),
(4, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Ana', 'Martínez', 'anamartinez@example.com', 33333, 4444444, 'Atlántico', 'Barranquilla', 'Diagonal 135', 'contrase4', 2),
(5, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Gillermo', 'Rojas', 'Grojas@example.com', 12465, 1547896, 'Bogota D.c', 'Bogota', 'Diagonal 125', 'contrase5', 1),
(6, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Andres', 'Parada', 'Andres@example.com', 12456, 4563214, 'Atlántico', 'Barranquilla', 'Diagonal 425', 'contrase6', 3),
(7, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Paola', 'Triana', 'Triana@example.com', 55632, 3654789, 'Valle del cauca', 'Cali', 'Diagonal 555', 'contrase7', 4),
(8, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Martin', 'Rojas', 'Matiti@example.com', 12545, 1547896, 'Bogota D.c', 'Bogota', 'Diagonal 125', 'contrase8', 1),
(9, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Juan', 'Morris', 'JuaM@example.com', 52357, 1562216, 'Atlántico', 'Barranquilla', 'Diagonal 425', 'contrase9', 3),
(10, 'https://cdn-icons-png.flaticon.com/512/3059/3059518.png','Lina', 'Mar', 'Limar@example.com', 55541, 3789589, 'Valle del cauca', 'Cali', 'Diagonal 5', 'contrase10', 4);





create table Lista_Producto(
	LisP_Id int primary key not null,
    LisP_UrlImg text,
    LisP_Nombre varchar(50) not null
);

INSERT INTO Lista_Producto (LisP_Id, Lisp_UrlImg ,LisP_Nombre) VALUES
(1, 'https://delahuertacasa.com/wp-content/uploads/2022/01/manzana-roja-product.jpg','Manzanas'),
(2, 'https://sicarfarms.com/wp-content/uploads/2021/01/Naranja.png','Naranjas'),
(3, 'https://goldenfruit.com.co/wp-content/uploads/2020/05/papa.jpg','Papas'),
(4, 'https://static.vecteezy.com/system/resources/previews/013/442/147/original/tomatoes-on-a-transparent-background-free-png.png','Tomates');



create table Detalle_Producto(
	Det_Id int primary key not null,
	Det_Usuario bigint not null,
	Det_IdProducto int not null,
	Det_Precio double not null,
    cantidad int not null,
    foreign key (Det_Usuario) references Usuario(Usu_Id),
    foreign key (Det_IdProducto) references Lista_Producto(LisP_Id)
);

INSERT INTO Detalle_Producto (Det_Id, Det_Usuario, Det_IdProducto, Det_Precio, cantidad) VALUES
(1, 1, 1, 1000, 50),
(2, 2, 2, 500, 10),
(3, 3, 3, 200, 20),
(4, 4, 4, 300, 15);




create table factura(
	Fac_Id varchar(20) primary key not null,
    Fac_Cantidad int,
    Fac_FechaVenta date,
    Fac_Total_Precio decimal(10,2) not null,
    Fac_OrdCId varchar(20) not null,
    foreign key (Fac_OrdCId) references OrdenCompra(OrdC_Id)
);

insert into factura (Fac_Id, Fac_Cantidad, Fac_FechaVenta, Fac_Total_Precio, Fac_OrdCId) values 
('FAC004', 5, '2023-05-01', 3400.00, 'ORDC001'),
('FAC002',8,'2023-08-10',3800.00,'ORDC002');

create table OrdenCompra(
	OrdC_Id varchar(20) primary key not null,
    OrdC_IdComp bigint not null,
    OrdC_IdProducto int not null,
    OrdC_Fecha varchar(30),
    OrdC_Total_pagar int not null,
    foreign key (OrdC_IdComp) references Usuario(Usu_Id),
    foreign key (OrdC_IdProducto) references Detalle_Producto(Det_Id)
);
insert into OrdenCompra values ('ORDC001', 5, 1, '2022-05-01', 50000),
							   ('ORDC002', 8, 3, '2023-05-09',10000);

create table OrdenEntrega(
	OrdE_Id varchar(20) primary key not null,
    OrdE_IdCompra varchar(20) not null,
    OrdE_IdTransportador bigint not null,
    OrdE_Cantidad int,
    OrdE_Fecha varchar(30),
    OrdE_Total_pagar int not null,
    OrdE_Fecha_despacho varchar(30),
    OrdE_Fecha_entrega varchar(30),
    foreign key (OrdE_IdCompra) references OrdenCompra(OrdC_Id),
    foreign key (OrdE_IdTransportador) references Usuario(Usu_Id)
);
insert into OrdenEntrega values ('ORDE001', 'ORDC001', 6, 10, '2022-05-01', 25000, '2022-05-02', '2022-05-03'),
('ORDE002', 'ORDC002', 8, 10, '2023-08-02', 45000, '2023-08-12', '2022-9-13');

