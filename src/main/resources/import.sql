/* Populate tables */
INSERT INTO usuarios (id, nombre, apellido, email, password, rol, celular, esta_activo, fecha_de_registro) VALUES(1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com', 'pass', 'Cliente', 934324234, TRUE, '2017-08-28');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(1, 1, 3, 'Av. Argentina 1515', 'Cercado de Lima', 7);

INSERT INTO usuarios (id, nombre, apellido, email, password, rol, celular, esta_activo, fecha_de_registro) VALUES(2, 'Mylee', 'Fenton', 'mfenton@bolsadeideas.com', 'pass', 'Cliente', 934554234, TRUE, '2018-01-18');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(2, 2, 4, 'Av. San Hilarion Este Mz. E1 Lt. 1', 'San Juan de Lurigancho', 15);

INSERT INTO usuarios (id, nombre, apellido, email, password, rol, celular, esta_activo, fecha_de_registro) VALUES(3, 'Justo', 'Tejada', 'jtejada@bolsadeideas.com', 'pass', 'Cliente', 91554634, FALSE, '2016-09-12');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(3, 3, 2.1, 'Jr. Alonso de Molina 1100', 'Santiago de Surco', 29);

INSERT INTO usuarios (id, nombre, apellido, email, password, rol, celular, esta_activo, fecha_de_registro) VALUES(4, 'Isaac', 'Calvo', 'icalvo@bolsadeideas.com', 'pass', 'Cliente', 934773244, TRUE, '2021-03-22');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(4, 4, NULL, 'Jr Nicanor Arteaga 340', 'San Borja', 3);

INSERT INTO usuarios (id, nombre, apellido, email, password, rol, celular, esta_activo, fecha_de_registro) VALUES(5, 'Angelica', 'Ordoñez', 'angelica@bolsadeideas.com', 'pass', 'Cliente', 94622545, TRUE, '2020-01-03');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(5, 5, 4.2, 'Arriba Peru 769', 'Villa EL Salvador', 9);