-- USUARIOS
INSERT INTO USUARIOS (id, nombre, email, user_type) VALUES (1, 'Juan Pérez', 'juan.perez@colegio.edu', 'TEACHER');
INSERT INTO USUARIOS (id, nombre, email, user_type) VALUES (2, 'Laura Gómez', 'laura.gomez@colegio.edu', 'STUDENT');
INSERT INTO USUARIOS (id, nombre, email, user_type) VALUES (3, 'Carlos Mendoza', 'carlos.mendoza@colegio.edu', 'STUDENT');

-- CURSOS
INSERT INTO CURSOS (id, nombre, descripcion, docent_id) VALUES (100, 'Matemáticas', 'Curso de álgebra y aritmética', 1);
INSERT INTO CURSOS (id, nombre, descripcion, docent_id) VALUES (101, 'Historia', 'Historia universal desde la antigüedad', 1);

-- RELACIÓN CURSO - ESTUDIANTE (MANY TO MANY)
INSERT INTO NOTAS_ESTUDIANTE_CURSO (id, cursos_id, estudiante_id, notas) VALUES (1, 100, 2, 3);
INSERT INTO NOTAS_ESTUDIANTE_CURSO (id, cursos_id, estudiante_id, notas) VALUES (2, 100, 3, 4);

-- ANUNCIOS DE CURSOS (ONE TO MANY)
INSERT INTO TAREAS (id, curso_id, titulo, descripcion, fecha_publicacion) VALUES (3, 100, 'Tarea 3', 'Bienvenidos al curso de matemáticas', CURRENT_TIMESTAMP);
INSERT INTO TAREAS (id, curso_id, titulo, descripcion, fecha_publicacion) VALUES (1, 100, 'Tarea 1', 'Bienvenidos al curso de matemáticas', CURRENT_TIMESTAMP);
INSERT INTO TAREAS (id, curso_id, titulo, descripcion, fecha_publicacion) VALUES (2, 100, 'Tarea 2', 'Bienvenidos al curso de matemáticas', CURRENT_TIMESTAMP);
