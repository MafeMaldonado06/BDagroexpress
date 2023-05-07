create database Agroexpress;

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

create table Lista_Producto(
	LisP_Id int primary key not null,
    LisP_Nombre varchar(50) not null
);

create table Detalle_Producto(
	Det_Id int primary key not null,
	Det_Usuario bigint not null,
	Det_IdProducto int not null,
	Det_Precio double not null,
    cantidad int not null,
    foreign key (Det_Usuario) references Usuario(Usu_Id),
    foreign key (Det_IdProducto) references Lista_Producto(LisP_Id)
);

create table factura(
	Fac_Id varchar(20) primary key not null,
    Fac_Cantidad int,
    Fac_FechaVenta date,
    Fac_Total_Precio double not null,
    Fac_IdCamp bigint not null,
    Fac_IdProducto int not null,
    foreign key (Fac_IdCamp) references Usuario(Usu_Id),
    foreign key (Fac_IdProducto) references Detalle_Producto(Det_Id)
);

create table OrdenCompra(
	OrdC_Id varchar(20) primary key not null,
    OrdC_IdComp bigint not null,
    OrdC_IdVenta varchar(20) not null,
    OrdC_IdProducto int not null,
    OrdC_Fecha varchar(30),
    OrdC_Total_pagar int not null,
    foreign key (OrdC_IdVenta) references factura(Fac_Id),
    foreign key (OrdC_IdComp) references Usuario(Usu_Id),
    foreign key (OrdC_IdProducto) references Detalle_Producto(Det_Id)
);

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