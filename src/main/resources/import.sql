insert into cozinha (nome) values ('Tailandesa');
insert into cozinha (nome) values ('Brasileira');
insert into cozinha (nome) values ('Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 8.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Mandir', 7.99, 3);
insert into restaurante (nome, taxa_frete, cozinha_id) values ('Bar da Lôra', 3.99, 2);

insert into estado (nome) values ('Minas Gerais');
insert into estado (nome) values ('Ceará');
insert into estado (nome) values ('Rio Grande do Sul');

insert into cidade (nome, estado_id) values ('Pacatuba', 2);
insert into cidade (nome, estado_id) values ('Uberlândia', 1);

