-- DML

insert into property_type(property_type.type)
values
('INDUSTRIAL'),
('HOUSE'),
('APARTMENT'),
('COMMERCIAL'),
('ADMINISTRATIVE');

insert into city (city.name) value ('Vilnius');
insert into city (city.name) value ('Kaunas');
insert into city (city.name) value ('Klaipeda');

insert into person (person.name, person.last_name) values ('Jonas', 'Jonaitis');
insert into person (person.name, person.last_name) values ('Petras', 'Petraitis');
insert into person (person.name, person.last_name) values ('Tadas', 'Tadaitis');


insert into address (street, number, city_id) values ('Savanoriai', 10, (select id from city where name = 'Vilnius'));
insert into address (street, number, city_id) values ('Maironio', 5, (select id from city where name = 'Kaunas'));
insert into address (street, number, city_id) values ('Vokieciu', 33, (select id from city where name = 'Klaipeda'));

insert into building(size, market_value, address_id, person_id, type_name) values (10, 21000, (select id from address where street = 'Savanoriai'), (select id from person where name = 'Jonas'), (select type from property_type where type = 'APARTMENT'));
insert into building(size, market_value, address_id, person_id, type_name) values (78, 50000, (select id from address where street = 'Maironio'), (select id from person where name = 'Tadas'), (select type from property_type where type = 'INDUSTRIAL'));
insert into building(size, market_value, address_id, person_id, type_name) values (15, 110000, (select id from address where street = 'Vokieciu'), (select id from person where name = 'Petras'), (select type from property_type where type = 'HOUSE'));
