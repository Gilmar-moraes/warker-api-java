CREATE TABLE Cidades(
	id int not null auto_increment,
    nome_da_cidade varchar(60) not null,
    latitude double not null,
    lontitude double not null,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    
    primary key (id)
);