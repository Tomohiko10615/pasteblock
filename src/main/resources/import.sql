INSERT INTO usuarios (id, nombre, apellido, email, password, celular, esta_activo, fecha_de_registro) VALUES(20, 'Richard', 'Inafuko', 'richard.inafuko@unmsm.edu.pe', '$2a$10$Uf2nInYbjlYFu1dkHqGeY.CR/n.5pdEyW0075DHY.8Do3X3YOwt7K', 938732234, TRUE, '2017-12-28');
INSERT INTO authorities (id, authority, usuario_id) VALUES(2, 'Admin', 20);