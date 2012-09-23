DELETE FROM tarifa;
DELETE FROM tipo_envio;

--Siendo las prioridades:
	-- 1. Ordinarios
	-- 2. Encomienda Nacional
	-- 3. Curier Nacional
	-- 4. No prioritarios
	-- 5. Prioritarios
	-- 6. Certificados (Nacionales e Internacionales)
	-- 7. Tarjetas postales internacionales

INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('1','Ordinarios');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('2','Encomienda Nacional');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('3','Curier Nacional');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('4','No prioritarios');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('5','Prioritarios');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('6','Certificados');
INSERT INTO TIPO_ENVIO(codigo,nombre) VALUES ('7','Tarjetas Postales Internacionales');

--Envíos ordinarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'NAC','1',140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,100,'NAC','1',220);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,250,'NAC','1',330);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (251,500,'NAC','1',400);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,1000,'NAC','1',900);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,2000,'NAC','1',1700);

--Envíos nacionales certificados
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'NAC','6',480);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,100,'NAC','6',540);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,250,'NAC','6',470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (251,500,'NAC','6',940);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,1000,'NAC','6',1240);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,2000,'NAC','6',2040);

-- Envíos nacionales encomienda
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'NAC','2',480);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,100,'NAC','2',540);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,250,'NAC','2',470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (251,500,'NAC','2',940);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,1000,'NAC','2',1240);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,2000,'NAC','2',2040);

--Envíos nacionales curier
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'NAC','6',480);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,100,'NAC','6',540);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,250,'NAC','6',470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (251,500,'NAC','6',940);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,1000,'NAC','6',1240);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,2000,'NAC','6',2040);

--Tarjetas postales internacionales
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,0,'G1','7',120);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,0,'G2','7',135);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,0,'G3','7',145);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,0,'G4','7',195);

--Envios al grupo I no prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G1','4',155);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G1','4',175);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G1','4',245);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G1','4',510);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G1','4',755);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G1','4',1000);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G1','4',1245);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G1','4',1490);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G1','4',1735);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G1','4',1980);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G1','4',2225);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G1','4',2470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G1','4',2715);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G1','4',2940);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G1','4',3205);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G1','4',3450);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G1','4',3495);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G1','4',3940);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G1','4',4185);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G1','4',4430);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G1','4',4475);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G1','4',4920);

--Envios al grupo II no prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G2','4',140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G2','4',225);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G2','4',320);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G2','4',445);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G2','4',910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G2','4',1205);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G2','4',1500);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G2','4',1795);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G2','4',2090);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G2','4',2385);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G2','4',2480);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G2','4',2975);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G2','4',3270);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G2','4',3545);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G2','4',3840);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G2','4',4155);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G2','4',4450);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G2','4',4745);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G2','4',5040);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G2','4',5335);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G2','4',5430);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G2','4',5925);

--Envios al grupo III no prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G3','4',145);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G3','4',250);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G3','4',375);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G3','4',725);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G3','4',1075);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G3','4',1425);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G3','4',1775);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G3','4',2125);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G3','4',2475);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G3','4',2825);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G3','4',3175);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G3','4',3425);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G3','4',3875);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G3','4',4225);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G3','4',4575);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G3','4',4925);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G3','4',5275);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G3','4',5425);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G3','4',5975);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G3','4',4325);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G3','4',4475);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G3','4',7025);

--Envios al grupo IV no prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G4','4',220);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G4','4',350);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G4','4',730);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G4','4',1410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G4','4',2090);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G4','4',2770);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G4','4',3450);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G4','4',4130);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G4','4',4810);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G4','4',5490);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G4','4',4170);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G4','4',4850);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G4','4',7530);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G4','4',8210);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G4','4',8890);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G4','4',9570);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G4','4',10250);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G4','4',10930);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G4','4',11410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G4','4',12290);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G4','4',12970);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G4','4',13450);

--Envios al grupo I prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G1','5',140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G1','5',195);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G1','5',325);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G1','5',435);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G1','5',945);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G1','5',1255);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G1','5',1545);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G1','5',1875);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G1','5',2185);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G1','5',2495);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G1','5',2805);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G1','5',3115);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G1','5',3425);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G1','5',3735);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G1','5',4045);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G1','5',4355);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G1','5',4445);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G1','5',4975);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G1','5',5285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G1','5',5595);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G1','5',5902);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G1','5',4215);

--Envios al grupo II prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G2','5',170);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G2','5',235);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G2','5',410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G2','5',735);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G2','5',1140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G2','5',1535);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G2','5',1910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G2','5',2285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G2','5',2440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G2','5',3035);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G2','5',3410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G2','5',3785);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G2','5',4140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G2','5',4535);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G2','5',4910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G2','5',5285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G2','5',5440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G2','5',4035);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G2','5',4410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G2','5',4785);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G2','5',7140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G2','5',7535);

--Envios al grupo III prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G3','5',190);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G3','5',320);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G3','5',420);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G3','5',1195);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G3','5',1770);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G3','5',2345);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G3','5',2920);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G3','5',3495);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G3','5',4070);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G3','5',4445);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G3','5',5220);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G3','5',5795);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G3','5',4370);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G3','5',4945);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G3','5',7520);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G3','5',8095);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G3','5',8470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G3','5',9245);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G3','5',9820);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G3','5',10395);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G3','5',10970);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G3','5',11545);

--Envios al grupo IV prioritarios
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G4','5',240);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G4','5',410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G4','5',800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G4','5',1550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G4','5',2300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G4','5',3050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G4','5',3800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G4','5',4550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G4','5',5300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G4','5',4050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G4','5',4800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G4','5',7550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G4','5',8300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G4','5',9050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G4','5',9800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G4','5',10550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G4','5',11300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G4','5',12050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G4','5',12800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G4','5',13550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G4','5',14300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G4','5',15050);

--Envios al grupo I certificados
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G1','6',440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G1','6',495);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G1','6',825);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G1','6',1135);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G1','6',1445);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G1','6',1755);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G1','6',2045);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G1','6',2375);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G1','6',2485);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G1','6',2995);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G1','6',3305);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G1','6',3415);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G1','6',3925);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G1','6',4235);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G1','6',4545);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G1','6',4855);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G1','6',5145);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G1','6',5475);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G1','6',5785);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G1','6',4095);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G1','6',4405);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G1','6',4715);

--Envios al grupo II certificado
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G2','6',470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G2','6',735);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G2','6',910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G2','6',1285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G2','6',1440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G2','6',2035);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G2','6',2410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G2','6',2785);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G2','6',3140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G2','6',3535);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G2','6',3910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G2','6',4285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G2','6',4440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G2','6',5035);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G2','6',5410);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G2','6',5785);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G2','6',4140);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G2','6',4535);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G2','6',4910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G2','6',7285);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G2','6',7440);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G2','6',8035);

--Envios al grupo III certificado
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G3','6',490);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G3','6',820);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G3','6',1120);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G3','6',1495);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G3','6',2270);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G3','6',2845);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G3','6',3420);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G3','6',3995);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G3','6',4570);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G3','6',5145);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G3','6',5720);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G3','6',4295);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G3','6',4870);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G3','6',7445);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G3','6',8020);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G3','6',8595);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G3','6',9170);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G3','6',9745);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G3','6',10320);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G3','6',10895);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G3','6',11470);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G3','6',12045);

--Envios al grupo IV certificado
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (0,20,'G4','6',740);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (21,50,'G4','6',910);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (51,100,'G4','6',1300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (101,200,'G4','6',2050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (201,300,'G4','6',2800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (301,400,'G4','6',3550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,500,'G4','6',4300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (501,400,'G4','6',5050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (401,700,'G4','6',5800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (701,800,'G4','6',4550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (801,900,'G4','6',7300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (901,1000,'G4','6',8050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1001,1100,'G4','6',8800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1101,1200,'G4','6',9550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1201,1300,'G4','6',10300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1301,1400,'G4','6',11050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1500,'G4','6',11800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1501,1400,'G4','6',12550);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1401,1700,'G4','6',13300);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1701,1800,'G4','6',14050);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1801,1900,'G4','6',14800);
INSERT INTO tarifa(peso_inicio,peso_final,codigo_grupo_envio,tipo,precio) VALUES (1901,2000,'G4','6',15500);
