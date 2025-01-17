-- Insertar usuarios con la columna hasVoted = false
INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('juanperez@example.com', '9101', 'Juan Pérez López', 'VOTER', '71781236', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('mariagonzalez@example.com', '1122', 'María González García', 'VOTER', '71781237', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('pedroalvarez@example.com', '1314', 'Pedro Álvarez Ruiz', 'VOTER', '71781238', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('lauracastillo@example.com', '1516', 'Laura Castillo Fernández', 'VOTER', '71781239', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('rodrigomoreno@example.com', '1718', 'Rodrigo Moreno Díaz', 'VOTER', '71781240', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('anahernandez@example.com', '1920', 'Ana Hernández Paredes', 'VOTER', '71781241', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('jorgegarcia@example.com', '2122', 'Jorge García Ramírez', 'VOTER', '71781242', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('susanafernandez@example.com', '2324', 'Susana Fernández Torres', 'VOTER', '71781243', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('victordelacruz@example.com', '2526', 'Víctor del Cruz Martínez', 'VOTER', '71781244', false);

INSERT INTO voter(email, code, name, role, dni, has_voted)
VALUES ('luisrodriguez@example.com', '2728', 'Luis Rodríguez Sánchez', 'VOTER', '71781245', false);

-- Insertar administrador
INSERT INTO admin(email, password, role)
VALUES ('danielsmart5@hotmail.com', '123456', 'ADMIN');
