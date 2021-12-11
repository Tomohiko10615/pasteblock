/* Populate tables */
INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(1, 'Andres', 'Guzman', 'profesor@bolsadeideas.com', 'pass1234', 934324234, TRUE, '2014-08-28');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(1, 1, 3, 'Av. Argentina 1515', 'Cercado de Lima', 7);

INSERT INTO roles (id, rol, usuario_id) VALUES(1, "Cliente", 1);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(2, 'Mylee', 'Fenton', 'mfenton@bolsadeideas.com', 'pass1234', 934554234, TRUE, '2018-01-18');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(2, 2, 4, 'Av. San Hilarion Este Mz. E1 Lt. 1', 'San Juan de Lurigancho', 15);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(3, 'Justo', 'Tejada', 'jtejada@bolsadeideas.com', 'pass1234',  91554634, FALSE, '2016-09-12');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(3, 3, 2.1, 'Jr. Alonso de Molina 1100', 'Santiago de Surco', 29);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(4, 'Isaac', 'Calvo', 'icalvo@bolsadeideas.com', 'pass1234', 934773244, TRUE, '2021-03-22');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(4, 4, NULL, 'Jr Nicanor Arteaga 340', 'San Borja', 3);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(5, 'Angelica', 'Ordoñez', 'angelica@bolsadeideas.com', 'pass1234', 94622545, TRUE, '2020-01-03');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(5, 5, 4.2, 'Arriba Peru 769', 'Villa EL Salvador', 9);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(6, 'Aurora', 'Tello', 'atello@bolsadeideas.com', 'pass1234', 94612745, TRUE, '2013-12-19');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(6, 6, 4.6, 'Avenida Javier Prado Este 4200', 'Santiago de Surco', 4);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(7, 'Joaquin', 'Tirado', 'jtirado@bolsadeideas.com', 'pass1234', 94612125, TRUE, '2019-05-30');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(7, 7, 2.0, 'Av. Malecón Checa 497', 'Cercado de Lima', 1);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(8, 'Antonia', 'Samper', 'asamper@bolsadeideas.com', 'pass1234', 93421125, TRUE, '2018-04-01');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(8, 8, 3.5, 'Av El Sol 857', 'Cercado de Lima', 7);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(9, 'Alexandra', 'Losada', 'alosada@bolsadeideas.com', 'pass1234', 95521525, TRUE, '2016-11-21');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(9, 9, NULL, 'Av. Union Jicamarca', 'San Juan de Lurigancho', 0);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(10, 'Piedad', 'Barbera', 'pbarbera@bolsadeideas.com', 'pass1234', 99981585, TRUE, '2018-10-11');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(10, 10, 4.9, 'Av. Canta Callao', 'San Martín de Porres', 1);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(11, 'Anastasio', 'Lloret', 'alloret@bolsadeideas.com', 'pass1234', 91287575, TRUE, '2015-02-01');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(11, 11, 3.1, 'Av Saenz Peña 1291', 'Callao', 23);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(12, 'Aziz', 'Hermida', 'ahermida@bolsadeideas.com', 'pass1234', 912563655, TRUE, '2021-04-27');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(12, 12, 1.6, 'Av. Defensores del Morro 2070', 'Chorrillos', 10);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(13, 'Miguel', 'Piñeiro', 'miguelp@bolsadeideas.com', 'pass1234', 911056235, TRUE, '2020-09-19');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(13, 13, 3.7, 'Asentamientos Humanos Unión y Paz s/n', 'Villa María del Triunfo', 13);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(14, 'Iciar', 'Ariza', 'iariza@bolsadeideas.com', 'pass1234', 911012233, TRUE, '2010-12-07');
INSERT INTO blockers (id, usuario_id, reputacion, presentacion, disponible, trabajos_en_proceso, numero_trabajos_culminados, foto) VALUES(1, 14, 2.4, 'Hola, soy Iciar.', TRUE, 1, 35, 'iariza.jpg');

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(15, 'Oliva', 'Navarro', 'onavarro@bolsadeideas.com', 'pass1234', 913011276, TRUE, '2017-11-28');
INSERT INTO blockers (id, usuario_id, reputacion, presentacion, disponible, trabajos_en_proceso, numero_trabajos_culminados, foto) VALUES(2, 15, 4.4, 'Hola, soy Oliva.', TRUE, 0, 29, 'onavarro.jpg');

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(16, 'Brahim', 'Zurita', 'bzurita@bolsadeideas.com', 'pass1234', 913611284, TRUE, '2019-04-25');
INSERT INTO blockers (id, usuario_id, reputacion, presentacion, disponible, trabajos_en_proceso, numero_trabajos_culminados, foto) VALUES(3, 16, 2.1, 'Hola, soy Brahim.', TRUE, 2, 51, 'bzurita.jpg');

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(17, 'Gabriela', 'Castello', 'gcastello@bolsadeideas.com', 'pass1234', 990434284, TRUE, '2018-08-08');
INSERT INTO blockers (id, usuario_id, reputacion, presentacion, disponible, trabajos_en_proceso, numero_trabajos_culminados, foto) VALUES(4, 17, 5.0, 'Hola, soy Gabriela.', TRUE, 1, 1, 'gcastello.jpg');

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(18, 'Marcial', 'Feijoo', 'feijoo@bolsadeideas.com', 'pass1234', 91577235, TRUE, '2020-05-05');
INSERT INTO clientes (id, usuario_id, reputacion, direccion, distrito, numero_servicios_contratados) VALUES(14, 18, 2.9, 'Prolongacion Los Fresnos', 'La Molina', 22);

INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(19, 'Aquilino', 'Gamez', 'agamez@bolsadeideas.com', 'pass1234', 994034184, TRUE, '2012-01-24');
INSERT INTO blockers (id, usuario_id, reputacion, presentacion, disponible, trabajos_en_proceso, numero_trabajos_culminados, foto) VALUES(5, 19, 3.7, 'Hola, soy Aquilino.', FALSE, 0, 39, 'agamez.jpg');

INSERT INTO servicios (id, tipo_servicio, costo_estimado_minimo, costo_estimado_maximo) VALUES(1, 'Albañilería', 10.00, 20.00);
INSERT INTO servicios (id, tipo_servicio, costo_estimado_minimo, costo_estimado_maximo) VALUES(2, 'Pintura', 15.50, 25.50);
INSERT INTO servicios (id, tipo_servicio, costo_estimado_minimo, costo_estimado_maximo) VALUES(3, 'Electricidad', 12.50, 22.50);
INSERT INTO servicios (id, tipo_servicio, costo_estimado_minimo, costo_estimado_maximo) VALUES(4, 'Gasfitería', 20.00, 30.00);

INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(1, 3);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(1, 2);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(2, 3);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(3, 4);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(4, 1);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(4, 3);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(4, 2);
INSERT INTO blockers_servicios (blockers_id, servicios_id) VALUES(5, 1);

INSERT INTO distritos (id, nombre) VALUES(1, 'Ancón');
INSERT INTO distritos (id, nombre) VALUES(2, 'Ate Vitarte');
INSERT INTO distritos (id, nombre) VALUES(3, 'Barranco');
INSERT INTO distritos (id, nombre) VALUES(4, 'Breña');
INSERT INTO distritos (id, nombre) VALUES(5, 'Carabayllo');
INSERT INTO distritos (id, nombre) VALUES(6, 'Chaclacayo');
INSERT INTO distritos (id, nombre) VALUES(7, 'Chorrillos');
INSERT INTO distritos (id, nombre) VALUES(8, 'Cieneguilla');
INSERT INTO distritos (id, nombre) VALUES(9, 'Comas');
INSERT INTO distritos (id, nombre) VALUES(10, 'El Augustino');
INSERT INTO distritos (id, nombre) VALUES(11, 'Independencia');
INSERT INTO distritos (id, nombre) VALUES(12, 'Jesús María');
INSERT INTO distritos (id, nombre) VALUES(13, 'La Molina');
INSERT INTO distritos (id, nombre) VALUES(14, 'La Victoria');
INSERT INTO distritos (id, nombre) VALUES(15, 'Lima');
INSERT INTO distritos (id, nombre) VALUES(16, 'Lince');
INSERT INTO distritos (id, nombre) VALUES(17, 'Los Olivos');
INSERT INTO distritos (id, nombre) VALUES(18, 'Lurigancho');
INSERT INTO distritos (id, nombre) VALUES(19, 'Lurín');
INSERT INTO distritos (id, nombre) VALUES(20, 'Magdalena del Mar');
INSERT INTO distritos (id, nombre) VALUES(21, 'Miraflores');
INSERT INTO distritos (id, nombre) VALUES(22, 'Pachacamac');
INSERT INTO distritos (id, nombre) VALUES(23, 'Pucusana');
INSERT INTO distritos (id, nombre) VALUES(24, 'Pueblo Libre');
INSERT INTO distritos (id, nombre) VALUES(25, 'Puente Piedra');
INSERT INTO distritos (id, nombre) VALUES(26, 'Punta Hermosa');
INSERT INTO distritos (id, nombre) VALUES(27, 'Punta Negra');
INSERT INTO distritos (id, nombre) VALUES(28, 'Rímac');
INSERT INTO distritos (id, nombre) VALUES(29, 'San Bartolo');
INSERT INTO distritos (id, nombre) VALUES(30, 'San Borja');
INSERT INTO distritos (id, nombre) VALUES(31, 'San Isidro');
INSERT INTO distritos (id, nombre) VALUES(32, 'San Juan de Lurigancho');
INSERT INTO distritos (id, nombre) VALUES(33, 'San Juan de Miraflores');
INSERT INTO distritos (id, nombre) VALUES(34, 'San Luis');
INSERT INTO distritos (id, nombre) VALUES(35, 'San Martín de Porres');
INSERT INTO distritos (id, nombre) VALUES(36, 'San Miguel');
INSERT INTO distritos (id, nombre) VALUES(37, 'Santa Anita');
INSERT INTO distritos (id, nombre) VALUES(38, 'Santa María del Mar');
INSERT INTO distritos (id, nombre) VALUES(39, 'Santa Rosa');
INSERT INTO distritos (id, nombre) VALUES(40, 'Santiago de Surco');
INSERT INTO distritos (id, nombre) VALUES(41, 'Surquillo');
INSERT INTO distritos (id, nombre) VALUES(42, 'Villa el Salvador');
INSERT INTO distritos (id, nombre) VALUES(43, 'Villa María del Triunfo');

INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 3);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 21);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 2);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 40);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 11);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(1, 32);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(2, 42);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(2, 12);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(3, 10);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(3, 25);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(3, 8);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(3, 39);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 12);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 3);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 23);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 40);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 19);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(4, 21);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(5, 22);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(5, 1);
INSERT INTO blockers_distritos (blockers_id, distritos_id) VALUES(5, 13);

INSERT INTO contratos (id, servicio_id, cliente_id, blocker_id, distrito_id, costo_final, ha_finalizado, fecha_inicio, fecha_final, calificacion_blocker, calificacion_cliente, confirmacion_cliente, culminacion_blocker, comentario_blocker, comentario_cliente, observaciones_blocker, observaciones_cliente) VALUES(1, 2, 7, 4, 33, 25.60, TRUE, '2020-08-13', '2020-08-15', 4, 3, TRUE, TRUE, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.', 'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?', 'Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?');
INSERT INTO contratos (id, servicio_id, cliente_id, blocker_id, distrito_id, costo_final, ha_finalizado, fecha_inicio, fecha_final, calificacion_blocker, calificacion_cliente, confirmacion_cliente, culminacion_blocker, comentario_blocker, comentario_cliente, observaciones_blocker, observaciones_cliente) VALUES(2, 3, 9, 1, 28, 32.50, TRUE, '2020-08-13', '2020-08-15', 4, 3, FALSE, TRUE, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.', 'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?', 'Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?');
INSERT INTO contratos (id, servicio_id, cliente_id, blocker_id, distrito_id, costo_final, ha_finalizado, fecha_inicio, fecha_final, calificacion_blocker, calificacion_cliente, confirmacion_cliente, culminacion_blocker, comentario_blocker, comentario_cliente, observaciones_blocker, observaciones_cliente) VALUES(3, 4, 2, 3, 15, 55.50, FALSE, '2020-08-13', '2020-08-15', 4, 3, FALSE, FALSE, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.', 'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?', 'Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?');
INSERT INTO contratos (id, servicio_id, cliente_id, blocker_id, distrito_id, costo_final, ha_finalizado, fecha_inicio, fecha_final, calificacion_blocker, calificacion_cliente, confirmacion_cliente, culminacion_blocker, comentario_blocker, comentario_cliente, observaciones_blocker, observaciones_cliente) VALUES(4, 4, 12, 1, 7, 80.00, TRUE, '2020-08-13', '2020-08-15', 4, 3, TRUE, TRUE, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.', 'Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?', 'Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?');

INSERT INTO mensajes (id, servicio_id, cliente_id, blocker_id, distrito_id, costo, tiempo_estimado, estado_confirmacion_blocker, estado_confirmacion_cliente, mensaje_blocker, mensaje_cliente) VALUES(1, 2, 11, 5, 24, NULL, NULL, NULL, NULL, NULL, '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');
INSERT INTO mensajes (id, servicio_id, cliente_id, blocker_id, distrito_id, costo, tiempo_estimado, estado_confirmacion_blocker, estado_confirmacion_cliente, mensaje_blocker, mensaje_cliente) VALUES(2, 3, 13, 3, 18, 40.00, 2, TRUE, FALSE, 'No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.', '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');
INSERT INTO mensajes (id, servicio_id, cliente_id, blocker_id, distrito_id, costo, tiempo_estimado, estado_confirmacion_blocker, estado_confirmacion_cliente, mensaje_blocker, mensaje_cliente) VALUES(3, 1, 1, 1, 43, 100.00, 4, TRUE, NULL, 'No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.', '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');
INSERT INTO mensajes (id, servicio_id, cliente_id, blocker_id, distrito_id, costo, tiempo_estimado, estado_confirmacion_blocker, estado_confirmacion_cliente, mensaje_blocker, mensaje_cliente) VALUES(4, 4, 5, 3, 3, NULL, NULL, FALSE, NULL, NULL, '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');
INSERT INTO mensajes (id, servicio_id, cliente_id, blocker_id, distrito_id, costo, tiempo_estimado, estado_confirmacion_blocker, estado_confirmacion_cliente, mensaje_blocker, mensaje_cliente) VALUES(5, 4, 8, 4, 17, 220.00, 2, TRUE, TRUE, 'No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful.', '"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness.');