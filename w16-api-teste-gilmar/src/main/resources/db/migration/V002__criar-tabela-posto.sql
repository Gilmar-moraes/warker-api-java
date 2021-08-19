CREATE TABLE Postos(
	id int not null auto_increment,
    cidade_id int not null,
    reservatorio int not null,
    latitude double not null,
    lontitude double not null,
    created_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at timestamp NULL DEFAULT CURRENT_TIMESTAMP,
    gas_price double not null,
    
    primary key (id)
);

ALTER TABLE Postos ADD CONSTRAINT fk_cidades FOREIGN KEY (cidade_id) REFERENCES Cidades(id);