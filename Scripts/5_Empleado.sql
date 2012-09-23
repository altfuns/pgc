﻿DELETE FROM empleado_permisos;
DELETE FROM empleado;

INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('admin','admin','admin','admin',1,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('104860059','Roy',null,'Carvajal Molina',1,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('401740259','Angie',null,'Garita Cambronero',2,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('108370252','Jorge','Francisco','Mena Argüello',3,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('401150476','Sergio',null,'Arguedas Campos',3,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('401360836','William',null,'Lopéz Bonilla',3,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('401820054','Marcos',null,'García Zamora',3,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('107890623','Jose',null,'Villarreal Chavarría',3,TRUE);
INSERT INTO empleado (id, nombre, middle_name,apellidos,tipo,activo) VALUES ('106590931','Leonardo',null,'Rojas Monge',3,TRUE);

INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','1');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','2');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','3');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','4');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','5');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','6');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','7');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','8');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','9');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','10');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','11');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','12');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','13');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','14');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','15');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','16');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','17');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('104860059','18');

INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','1');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','2');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','3');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','4');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','12');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','13');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','14');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','15');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','16');
INSERT INTO empleado_permisos(id_empleado,codigo_permiso) VALUES('401740259','17');

INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('108370252', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('108370252', '3');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401150476', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401150476', '3');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401360836', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401360836', '3');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401820054', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('401820054', '3');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('107890623', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('107890623', '3');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('106590931', '1');
INSERT INTO empleado_permisos (id_empleado, codigo_permiso) VALUES ('106590931', '3');