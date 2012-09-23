alter table pais add column tmp_nombre varchar(254);
update pais set tmp_nombre = nombre;
alter table pais alter column tmp_nombre set default '';
alter table pais alter column tmp_nombre set not NULL;
alter table pais drop column nombre;

alter table pais rename tmp_nombre to nombre;
