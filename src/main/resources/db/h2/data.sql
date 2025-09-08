INSERT INTO vets VALUES (default, 'James', 'Carter');
INSERT INTO vets VALUES (default, 'Helen', 'Leary');
INSERT INTO vets VALUES (default, 'Linda', 'Douglas');
INSERT INTO vets VALUES (default, 'Rafael', 'Ortega');
INSERT INTO vets VALUES (default, 'Henry', 'Stevens');
INSERT INTO vets VALUES (default, 'Sharon', 'Jenkins');

INSERT INTO specialties VALUES (default, 'radiology');
INSERT INTO specialties VALUES (default, 'surgery');
INSERT INTO specialties VALUES (default, 'dentistry');

INSERT INTO vet_specialties VALUES (2, 1);
INSERT INTO vet_specialties VALUES (3, 2);
INSERT INTO vet_specialties VALUES (3, 3);
INSERT INTO vet_specialties VALUES (4, 2);
INSERT INTO vet_specialties VALUES (5, 1);

INSERT INTO types VALUES (default, 'cat');
INSERT INTO types VALUES (default, 'dog');
INSERT INTO types VALUES (default, 'lizard');
INSERT INTO types VALUES (default, 'snake');
INSERT INTO types VALUES (default, 'bird');
INSERT INTO types VALUES (default, 'hamster');



INSERT INTO owners VALUES (default, 'George', 'Franklin', '110 W. Liberty St.', 'Madison', '6085551023');
INSERT INTO owners VALUES (default, 'Betty', 'Davis', '638 Cardinal Ave.', 'Sun Prairie', '6085551749');
INSERT INTO owners VALUES (default, 'Eduardo', 'Rodriquez', '2693 Commerce St.', 'McFarland', '6085558763');
INSERT INTO owners VALUES (default, 'Harold', 'Davis', '563 Friendly St.', 'Windsor', '6085553198');
INSERT INTO owners VALUES (default, 'Peter', 'McTavish', '2387 S. Fair Way', 'Madison', '6085552765');
INSERT INTO owners VALUES (default, 'Jean', 'Coleman', '105 N. Lake St.', 'Monona', '6085552654');
INSERT INTO owners VALUES (default, 'Jeff', 'Black', '1450 Oak Blvd.', 'Monona', '6085555387');
INSERT INTO owners VALUES (default, 'Maria', 'Escobito', '345 Maple St.', 'Madison', '6085557683');
INSERT INTO owners VALUES (default, 'David', 'Schroeder', '2749 Blackhawk Trail', 'Madison', '6085559435');
INSERT INTO owners VALUES (default, 'Carlos', 'Estaban', '2335 Independence La.', 'Waunakee', '6085555487');

INSERT INTO pets VALUES (default, 'Leo', '2010-09-07', 1, 1,1);
INSERT INTO pets VALUES (default, 'Basil', '2012-08-06', 6, 2,2);
INSERT INTO pets VALUES (default, 'Rosy', '2011-04-17', 2, 3,3);
INSERT INTO pets VALUES (default, 'Jewel', '2010-03-07', 2, 3,4);
INSERT INTO pets VALUES (default, 'Iggy', '2010-11-30', 3, 4,5);
INSERT INTO pets VALUES (default, 'George', '2010-01-20', 4, 5,6);
INSERT INTO pets VALUES (default, 'Samantha', '2012-09-04', 1, 6,7);
INSERT INTO pets VALUES (default, 'Max', '2012-09-04', 1, 6,8);
INSERT INTO pets VALUES (default, 'Lucky', '2011-08-06', 5, 7,9);
INSERT INTO pets VALUES (default, 'Mulligan', '2007-02-24', 2, 8,10);
INSERT INTO pets VALUES (default, 'Freddy', '2010-03-09', 5, 9,11);
INSERT INTO pets VALUES (default, 'Lucky', '2010-06-24', 2, 10,12);
INSERT INTO pets VALUES (default, 'Sly', '2012-06-08', 1, 10,13);

INSERT INTO ATTRIBUTES VALUES(default,1,12,30,'Friendly','MALE');
INSERT INTO ATTRIBUTES VALUES(default,2,13,31,'Aggressive','FEMALE');
INSERT INTO ATTRIBUTES VALUES(default,3,14,24,'Shy', 'NEUTERED');
INSERT INTO ATTRIBUTES VALUES(default,4,10,23,'Timid','MALE');
INSERT INTO ATTRIBUTES VALUES(default,5,9,20,'Playful','FEMALE');
INSERT INTO ATTRIBUTES VALUES(default,6,8,22,'Independent', 'NEUTERED');
INSERT INTO ATTRIBUTES VALUES(default,7,9,24,'Protective','MALE');
INSERT INTO ATTRIBUTES VALUES(default,8,12,26,'Docile','FEMALE');
INSERT INTO ATTRIBUTES VALUES(default,9,13,28,'Curious', 'NEUTERED');
INSERT INTO ATTRIBUTES VALUES(default,10,15,29,'Lazy','MALE');
INSERT INTO ATTRIBUTES VALUES(default,11,5,15,'Hyperactive','FEMALE');
INSERT INTO ATTRIBUTES VALUES(default,12,6,12,'Stubborn', 'NEUTERED');
INSERT INTO ATTRIBUTES VALUES(default,13,7,8,'Obedient','MALE');

INSERT INTO visits VALUES (default, 7, '2013-01-01', 'rabies shot');
INSERT INTO visits VALUES (default, 8, '2013-01-02', 'rabies shot');
INSERT INTO visits VALUES (default, 8, '2013-01-03', 'neutered');
INSERT INTO visits VALUES (default, 7, '2013-01-04', 'spayed');
INSERT INTO pet_properties (property_key, property_value, description) VALUES ('pet.attribute.weight', '100', 'Maximum allowed weight for pet');
INSERT INTO pet_properties (property_key, property_value, description) VALUES ('pet.attribute.height', '300', 'Maximum allowed height for pet');
