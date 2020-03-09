
CREATE DATABASE BD_GuanaRenta;

USE BD_GuanaRenta;

CREATE TABLE TblPropietario (
cedPropiet INT NOT NULL, 
nomPropiet VARCHAR(40) NOT NULL,
genero CHAR(1) NOT NULL,
direccion VARCHAR(40) NOT NULL,
telefono int NOT NULL,
email VARCHAR(35)NOT NULL,

CONSTRAINT PK_TblPropietario PRIMARY KEY (cedPropiet),
CONSTRAINT UQ_email UNIQUE (email),
CONSTRAINT UQ_telefono UNIQUE (telefono),
CONSTRAINT CK CHECK(genero = 'F' OR genero = 'M'),
CONSTRAINT CK_Cedula CHECK(cedPropiet LIKE '[1-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]')
) ENGINE = InnoDB;

CREATE TABLE TblInquilino(
cedInqui INT NOT NULL, 
nomInqui VARCHAR(40) NOT NULL,
genero CHAR(1) NOT NULL,
fechNac DATE   NOT NULL,
direccion TEXT NOT NULL,
telefono VARCHAR(20) NOT NULL, -- se agrega
email VARCHAR(35) NOT NULL,
ocupacion VARCHAR(40) NOT NULL,

CONSTRAINT PK_TblInquilino PRIMARY KEY (cedInqui),
CONSTRAINT UQ_email_ UNIQUE (email),
CONSTRAINT CK_Genero CHECK(genero = 'F' OR genero = 'M')
) ENGINE = InnoDB;


CREATE TABLE TblVivienda(
idVivienda INT AUTO_INCREMENT NOT NULL,
descripcion TEXT NOT NULL,
direccion TEXT NOT NULL,
mtsConstrucc FLOAT NOT NULL,
mtsLote FLOAT NOT NULL,
tipoConstrucc VARCHAR(35) NOT NULL,
cochera tinytext NOT NULL,
cantHabitac INT NOT NULL,
cantBanios INT NOT NULL,
carretera VARCHAR(20) NOT NULL,
precioBase INT NOT NULL,
deposGarantia INT NOT NULL,
cedPropiet INT NOT NULL,
estado VARCHAR(10) NOT NULL,

CONSTRAINT PK_TblVivienda PRIMARY KEY (idVivienda),
CONSTRAINT CK_estado CHECK(estado = 'Disponible' OR estado = 'Alquilada' OR estado = 'Inactiva'),

CONSTRAINT CK_carretera CHECK(carretera = 'Pavimentada' OR carretera = 'Lastre'
OR carretera = 'Adoquinada'),

CONSTRAINT CK_tipoConstrucc CHECK(tipoConstrucc = 'Block' OR tipoConstrucc = 'Baldosa'
OR tipoConstrucc = 'Super Block' OR tipoConstrucc = 'Madera' OR tipoConstrucc = 'Mixta'),

CONSTRAINT CK_deposGarantia CHECK (deposGarantia >= 0),
CONSTRAINT CK_precioBase CHECK(precioBase >= 0),

CONSTRAINT FK_cedPropiet FOREIGN KEY (cedPropiet) REFERENCES TblPropietario (cedPropiet)
ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;


CREATE TABLE TblAlquileres(
numAlquiler INT AUTO_INCREMENT NOT NULL,
fechContrato DATE NOT NULL,
cantMeses INT NOT NULL,
numAdultos INT NOT NULL,
numNinos INT NOT NULL,
deposGarantia DECIMAL(7,2) NOT NULL,
precioAlquiler DECIMAL(7,2) NOT NULL,
porcIncremAnual INT NOT NULL,
cedInqui INT NOT NULL,
idVivienda INT NOT NULL,
estado VARCHAR(20) NOT NULL,

CONSTRAINT PK_TblAlquileres PRIMARY KEY (numAlquiler),
CONSTRAINT CK_precioAlquiler CHECK(porcIncremAnual >= 0 OR porcIncremAnual <= 100),
CONSTRAINT CK_deposGarantia CHECK(deposGarantia >= 0),
CONSTRAINT CK_estado CHECK(estado = 'Vigente' OR estado = 'Vencido' OR estado = 'Cancelado'),

-- CONSTRAINT FK_deposGarantia FOREIGN KEY (deposGarantia) REFERENCES TblVivienda(deposGarantia),

CONSTRAINT FK_cedInquilino FOREIGN KEY (cedInqui) REFERENCES TblInquilino (cedInqui)
ON UPDATE CASCADE ON DELETE CASCADE,

CONSTRAINT FK_idVivienda FOREIGN KEY (idVivienda) REFERENCES TblVivienda (idVivienda)
ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;


CREATE TABLE TblMensualidades(
consecutivo INT AUTO_INCREMENT NOT NULL,
numAlquiler INT NOT NULL,
fechCreacion DATE NOT NULL,
nomInqui INT NOT NULL,
mesCobro SMALLINT NOT NULL,
anioActual YEAR NOT NULL,
descuento DECIMAL(5,2) NOT NULL,
montoMes INT NOT NULL,
estado VARCHAR(20),

CONSTRAINT PK_TblMensualidades PRIMARY KEY (consecutivo),
CONSTRAINT CK_mesCobro CHECK (mesCobro >= 1 OR mesCobro <= 12),
CONSTRAINT CK_estado CHECK (estado = 'Pendiente' OR estado = 'Cancelado'),

CONSTRAINT FK_numAlquiler FOREIGN KEY (numAlquiler) REFERENCES TblAlquileres (numAlquiler)
ON UPDATE CASCADE ON DELETE CASCADE,

CONSTRAINT FK_nomInqui FOREIGN KEY (nomInqui) REFERENCES TblInquilino (cedInqui)
ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE = InnoDB;

-- PROCEDIMIEMTOS ALMACENDADOS
-- Insertamos al usuario propietario
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpGuardarPropietario
($cedPropiet INT, 
$nomPropiet VARCHAR(40),
$genero CHAR(1),
$direccion VARCHAR(40),
$telefono INT,
$email VARCHAR(35))

BEGIN
     IF EXISTS (SELECT cedPropiet FROM TblPropietario WHERE cedPropiet = $cedPropiet) THEN
           SELECT 'EL PROPIETARIO CON CÉDULA #'+$cedPropiet+' YA EXISTE';
	  ELSE
		   INSERT INTO TblPropietario (cedPropiet, nomPropiet, genero, direccion, telefono, email)
                         VALUES ($cedPropiet, $nomPropiet, $genero, $direccion, $telefono, $email);
      END IF;
END$$
DELIMITER ;

-- PROPIETARIO ------------------------------------
-- revisar la política si permite modificar la cédula
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpEditarPropietario
($cedPropiet INT, 
$nomPropiet VARCHAR(40),
$genero CHAR(1),
$direccion VARCHAR(40),
$telefono INT,
$email VARCHAR(35))

BEGIN
     IF NOT EXISTS (SELECT cedPropiet FROM TblPropietario WHERE cedPropiet = $cedPropiet) THEN
           SELECT 'EL PROPIETARIO CON CÉDULA #'+$cedPropiet+' NO EXISTE';
	  ELSE
           UPDATE TblPropietario SET
           -- cedPropiet = $cedPropiet,
           nomPropiet = $nomPropiet,
           genero     = $genero,
		   direccion  = $direccion,
           telefono   = $telefono,
           email      = $email
           WHERE cedPropiet = $cedPropiet;
           
      END IF;
END$$
DELIMITER ;

-- Eliminamos al usuario propietario, la idea es que recibamos la cédula para eliminarlo
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpEliminarPropietario
($cedPropiet INT)

BEGIN
     IF EXISTS (SELECT cedPropiet FROM TblPropietario WHERE cedPropiet = $cedPropiet) THEN
           
			DELETE FROM TblPropietario WHERE cedPropiet = $cedPropiet;
           
	  ELSE
			SELECT 'EL PROPIETARIO CON CÉDULA #'+$cedPropiet+' NO EXISTE';
      END IF;
END$$
DELIMITER ;

-- VIVIENDA ----------------------------------------
-- Insertamos a una vivienda
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpGuardarVivienda
(
$descripcion TEXT,
$direccion TEXT,
$mtsConstrucc FLOAT, -- se cambia de int a float
$mtsLote FLOAT, -- se cambia de int a float
$tipoConstrucc VARCHAR(35),
$cochera TINYINT(1),
$cantHabitac INT,
$cantBanios INT,
$carretera VARCHAR(20),
$precioBase INT, -- Se cambia de decimal 7,2 a int
$deposGarantia INT, -- Se cambia de decimal 7,2 a int
$cedPropiet INT,
$estado VARCHAR(10))

BEGIN
     -- No hace falta validar, ya que el ID siempre será diferente y unas viviendas pueden tener
     -- características en común
    
			INSERT INTO TblVivienda (descripcion,direccion,mtsConstrucc,mtsLote,tipoConstrucc,
									cochera,cantHabitac,cantBanios,carretera,precioBase,
									deposGarantia,cedPropiet,estado)
			VALUES ($descripcion,$direccion,$mtsConstrucc,$mtsLote,$tipoConstrucc,
					$cochera,$cantHabitac,$cantBanios,$carretera,$precioBase,
					$deposGarantia,$cedPropiet,$estado);
     
END$$
DELIMITER ;

-- Editamos a una vivienda
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpEditarVivienda
($idVivienda INT,
$descripcion TEXT,
$direccion TEXT,
$mtsConstrucc FLOAT, -- se cambia de int a float
$mtsLote FLOAT, -- se cambia de int a float
$tipoConstrucc VARCHAR(35),
$cochera TINYINT(1),
$cantHabitac INT,
$cantBanios INT,
$carretera VARCHAR(20),
$precioBase INT, -- Se cambia de decimal 7,2 a int
$deposGarantia INT, -- Se cambia de decimal 7,2 a int
$cedPropiet INT,
$estado VARCHAR(10))

BEGIN
     IF NOT EXISTS (SELECT idVivienda FROM TblVivienda WHERE idVivienda = $idVivienda) THEN
           
		 SELECT 'LA VIVIENDA CON EL ID '+$idVivienda+' NO EXISTE';
         
	  ELSE
          UPDATE TblVivienda SET
				descripcion  = $descripcion,
				direccion = $direccion,
				mtsConstrucc = $mtsConstrucc,
				mtsLote = $mtsLote,
				tipoConstrucc = $tipoConstrucc,
				cochera = $cochera,
				cantHabitac = $cantHabitac,
				cantBanios = $cantBanios,
				carretera = $carretera,
				precioBase = $precioBase,
				deposGarantia = $deposGarantia,
				cedPropiet = $cedPropiet,
				estado = $estado
           WHERE idVivienda = $idVivienda;
	 END IF;
END$$
DELIMITER ;

-- Eliminamos a la vivienda, la idea es que recibamos el ID
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpEliminarVivienda
($idVivienda INT)

BEGIN
     IF EXISTS (SELECT idVivienda FROM TblVivienda WHERE idVivienda = $idVivienda) THEN
           
			DELETE FROM TblVivienda WHERE idVivienda = $idVivienda;
           
	  ELSE
			SELECT 'LA VIVIENDA CON EL ID '+$idVivienda+' NO EXISTE';
      END IF;
END$$
DELIMITER ;


-- Este procedure permite cambiar solo el estado la vivienda
-- Simplemente en la red transmistiremos esos 2 datos y no todo
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEditarEstadoVivienda
($idVivienda INT, $estado VARCHAR(10))

BEGIN
	IF EXISTS (SELECT idVivienda FROM TblVivienda WHERE idVivienda = $idVivienda) THEN
		
        UPDATE TblVivienda SET estado = $estado WHERE idVivienda = $idVivienda;
    
    ELSE
		
        SELECT 'LA VIVIENDA CON EL ID '+$idVivienda+' NO EXISTE';
    
	END IF;
END$$
DELIMITER ;


-- INQUILINO --------------------
-- Isertamos un inquilino
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpGuardarInquilino
($cedInqui INT, 
$nomInqui VARCHAR(40),
$genero CHAR(1),
$fechNac DATE,
$direccion TEXT,
$telefono INT,
$email VARCHAR(35),
$ocupacion VARCHAR(40))

BEGIN
	IF NOT EXISTS (SELECT cedInqui FROM TblInquilino WHERE cedInqui = $cedInqui) THEN
		
        INSERT INTO TblInquilino (cedInqui,nomInqui,genero,fechNac,
								  direccion,telefono,email,ocupacion)
			VALUES ($cedInqui,$nomInqui,$genero,$fechNac,$direccion,
					$telefono,$email,$ocupacion);
    ELSE
        SELECT 'EL USUARIO CON CÉDULA '+$cedInqui+' YA EXISTE';
        
    END IF;
END$$
DELIMITER ;

-- Modificamos los datos del inquilino
-- revisar la política si permite modificar la cédula
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEditarInquilino
($cedInqui INT, 
$nomInqui VARCHAR(40),
$genero CHAR(1),
$fechNac DATE,
$direccion TEXT,
$telefono INT,
$email VARCHAR(35),
$ocupacion VARCHAR(40))

BEGIN
	IF EXISTS (SELECT cedInqui FROM TblInquilino WHERE cedInqui = $cedInqui) THEN
		
        UPDATE TblInquilino SET
				nomInqui = $nomInqui,
				genero = $genero,
				fechNac = $fechNac,
				direccion = $direccion,
				telefono = $telefono,
				email = $email,
				ocupacion = $ocupacion
        WHERE cedInqui = $cedInqui;
        
    ELSE
		SELECT 'EL INQUILINO CON CÉDULA '+$cedInqui+' NO EXISTE';
    END IF;
END $$
DELIMITER ;

-- Eliminamos al inquilino
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEliminarInquilino
($cedInqui INT)

BEGIN 
    IF EXISTS (SELECT cedInqui FROM TblInquilino WHERE cedInqui = $cedInqui) THEN
		
        DELETE FROM TblInquilino WHERE cedInqui = $cedInqui;
        
    ELSE 
		SELECT 'EL INQUILINO CON CÉDULA '+$cedInqui+' NO EXISTE';
    END IF;
END $$
DELIMITER ;


-- ALQUILERES -------------------- Aquí se deben modificar el estado de la vivienda alquilada
-- Insertamos un alquiler
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpGuardarAlquiler
(-- $numAlquiler INT,
$fechContrato DATE,
$cantMeses INT,
$numAdultos INT,
$numNinos INT,
$deposGarantia DOUBLE,
$precioAlquiler DOUBLE,
$porcIncremAnual INT,
$cedInqui INT,
$idVivienda INT,
$estado VARCHAR(20))

BEGIN
	-- No hace falta comprobar el ID, ya que es auto incrementable
    INSERT INTO TblAlquileres (fechContrato, cantMeses, numAdultos, numNinos, deposGarantia,
								precioAlquiler, porcIncremAnual, cedInqui, idVivienda, estado)
		VALUES ($fechContrato,$cantMeses,$numAdultos,$numNinos,$deposGarantia,
				$precioAlquiler,$porcIncremAnual,$cedInqui,$idVivienda,$estado);
    
    -- A ver si funciona
    CALL `BD_GuanaRenta`.`stpEditarEstadoVivienda`($idVivienda,'Alquilada');
    
    
END$$
DELIMITER ;

-- Editar un registro de alquiler
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEditarAlquiler
($numAlquiler INT,
$fechContrato DATE,
$cantMeses INT,
$numAdultos INT,
$numNinos INT,
$deposGarantia DOUBLE,
$precioAlquiler DOUBLE,
$porcIncremAnual INT,
$cedInqui INT,
$idVivienda INT,
$estado VARCHAR(20))

BEGIN
	IF EXISTS (SELECT numAlquiler FROM TblAlquileres WHERE numAlquiler = $numAlquiler) THEN
		
        UPDATE TblAlquileres SET	
			fechContrato = $fechContrato,
			cantMeses = $cantMeses,
			numAdultos = $numAdultos,
			numNinos = $numNinos,
			deposGarantia = $deposGarantia,
			precioAlquiler = $precioAlquiler,
			porcIncremAnual = $porcIncremAnual,
			cedInqui = $cedInqui,
			idVivienda = $idVivienda,
			estado = $estado
		WHERE numAlquiler = $numAlquiler;
    ELSE
		SELECT 'EL ALQUILER #'+$numAlquiler+' NO EXISTE';
    END IF;
END $$
DELIMITER ;


-- ELiminar alquiler
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEliminarAlquiler
($numAlquiler INT)

BEGIN
	IF EXISTS (SELECT numAlquiler FROM TblAlquileres WHERE numAlquiler = $numAlquiler) THEN
    
		DELETE FROM TblAlquiler WHERE numAlquiler = $numAlquiler;
        
    ELSE
    
		SELECT 'EL ALQUILER #'+$numAlquiler+' NO EXISTE';
        
    END IF;
END$$
DELIMITER ;

-- Modificar el estado del alquiler, tal vez no hace falta, no se está usando
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpEditarEstadoAlquiler
($numAlquier INT,
$estado VARCHAR(20))

BEGIN
	IF EXISTS (SELECT numAlquiler FROM TblAlquileres WHERE numAlquiler = $numAlquiler) THEN
    
		UPDATE TblAlquiler SET estado = $estado WHERE numAlquier = $numAlquiler;
        
    ELSE
    
		SELECT 'EL ALQUILER #'+$numAlquiler+' NO EXISTE';
        
    END IF;
END$$
DELIMITER ;

-- MENSUALIDADES ----------------------------
-- Inserta una mensualidad
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpGeneraMensualidad
($numAlquiler INT,
$fechCreacion DATE,
$nomInqui INT,
$mesCobro SMALLINT,
$anioActual YEAR,
$descuento DECIMAL(5,2),
$montoMes INT,
$estado VARCHAR(20))

BEGIN 
	
    INSERT INTO TblMensualidades (numAlquiler,fechCreacion,nomInqui,mesCobro,
								anioActual,descuento,montoMes,estado)
	VALUES ($numAlquiler,$fechCreacion,$nomInqui,$mesCobro,$anioActual,$descuento,$montoMes,$estado);
    
END $$
DELIMITER ;

-- Cancela la mensualidad
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpCancelarMensualidad
($consecutivo INT,
$estado VARCHAR(20))

BEGIN
	
    IF $estado = 'Cancelada' THEN
		SELECT 'La mensualidad con el consecutivo #'+$consecutivo+' ya está cancelada';
    ELSE
		UPDATE TblMensualidades SET estado = 'Cancelada' WHERE consecutivo = $consecutivo;
    END IF;
    
END $$
DELIMITER ;


-- Creacion de una vista
CREATE VIEW VTblViviendas
	as
	SELECT V.idVivienda,V.descripcion,V.direccion,V.mtsConstrucc,
                V.mtsLote,V.tipoConstrucc,V.cochera,V.cantHabitac,V.cantBanios,V.carretera,
                V.precioBase,V.deposGarantia,P.cedPropiet,V.estado
                        FROM TblVivienda V INNER JOIN TblPropietario P 
                         ON V.cedPropiet = P.cedPropiet;

-- Procedimiento que muestra todos los datos de las tablas
DELIMITER $$
CREATE  PROCEDURE stpMostrarDatos(
$Tabla VARCHAR(20))
BEGIN	
    CASE $Tabla
			   WHEN 'Propietarios'  THEN SELECT * FROM TblPropietario;
               -- WHEN 'Viviendas'     THEN SELECT * FROM VTblViviendas;
               WHEN 'Viviendas'     THEN SELECT * FROM TblVivienda;
               WHEN 'Inquilinos'    THEN SELECT * FROM TblInquilino;
               WHEN 'Alquileres'    THEN SELECT * FROM TblAlquileres; -- en teoria estas 2 ultimas dan error
               WHEN 'Mensualidades' THEN SELECT * FROM TblMensualidades;
    END CASE;
END$$
DELIMITER ;

USE BD_GuanaRenta;
SELECT * FROM TblVivienda;

-- Almacenamiento que nos muestra si un usuario existe
DELIMITER $$
CREATE DEFINER = `root`@`localhost` PROCEDURE stpExisteUsuario
($id INT,
$tipoUsuario VARCHAR(20))

BEGIN
	
    CASE $tipoUsuario
		WHEN 'Propietario' THEN SELECT COUNT(cedPropiet) FROM TblPropietario WHERE cedPropiet = $id;
        WHEN 'Inquilino'   THEN SELECT COUNT(cedInqui) FROM TblInquilino WHERE cedInqui =$id;
	END CASE;
END$$
DELIMITER ;

-- Este procedimiento recibe la tabla a buscar el dato y el campo donde está el dato
-- luego llama a los procedimientos correspondientes
DELIMITER $$
CREATE DEFINER = 'root'@'localhost' PROCEDURE stpBuscarPrincipal
($campo TEXT,
$dato TEXT,
$tabla TEXT)
BEGIN
	
    CASE $tabla
				WHEN 'TblPropietario'   THEN CALL `BD_GuanaRenta`.`stpBuscarPropietario`($campo,$dato);
				WHEN 'TblInquilino'     THEN CALL `BD_GuanaRenta`.`stpBuscarInquilino`($campo,$dato);
                WHEN 'TblVivienda'      THEN CALL `BD_GuanaRenta`.`stpBuscarVivienda`($campo,$dato);
                WHEN 'TblMensualidades' THEN CALL `BD_GuanaRenta`.`stpBuscarMensualidad`($campo,$dato);
                WHEN 'TblAlquileres' THEN CALL `BD_GuanaRenta`.`stpBuscarAlquiler`($campo,$dato);
			ELSE
				SELECT 'NO HAY COINCIDENCIAS';
	END CASE;
END$$
DELIMITER ;

-- Almacenamiento que permite mostrarnos los ALQUILERES
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE stpBuscarAlquiler
($campo TEXT,
$dato TEXT)

BEGIN
      CASE $campo 
                WHEN 'numAlquiler'     THEN SELECT * FROM TblAlquileres WHERE numAlquiler LIKE CONCAT('%',$dato,'%');
                WHEN 'fechContrato'    THEN SELECT * FROM TblAlquileres WHERE fechContrato LIKE CONCAT('%',$dato,'%');
                WHEN 'cantMeses'       THEN SELECT * FROM TblAlquileres WHERE cantMeses LIKE CONCAT('%',$dato,'%');
                WHEN 'numAdultos'      THEN SELECT * FROM TblAlquileres WHERE numAdultos LIKE CONCAT('%',$dato,'%');
                WHEN 'numNinos'        THEN SELECT * FROM TblAlquileres WHERE numNinos LIKE CONCAT('%',$dato,'%');
                WHEN 'deposGarantia'   THEN SELECT * FROM TblAlquileres WHERE deposGarantia LIKE CONCAT('%',$dato,'%');
                WHEN 'precioAlquiler'  THEN SELECT * FROM TblAlquileres WHERE precioAlquiler LIKE CONCAT('%',$dato,'%');
                WHEN 'porcIncremAnual' THEN SELECT * FROM TblAlquileres WHERE porcIncremAnual LIKE CONCAT('%',$dato,'%');
                WHEN 'cedInqui'        THEN SELECT * FROM TblAlquileres WHERE cedInqui LIKE CONCAT('%',$dato,'%');
                WHEN 'idVivienda'      THEN SELECT * FROM TblAlquileres WHERE idVivienda LIKE CONCAT('%',$dato,'%');
                WHEN 'estado'          THEN SELECT * FROM TblAlquileres WHERE estado LIKE CONCAT('%',$dato,'%');
			ELSE 
				Select * FROM TblAlquileres;
		END CASE;
END$$
DELIMITER ;

-- Almacenamiento que permite mostrarnos las MENSUALIDADES
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE stpBuscarMensualidad
($campo TEXT,
$dato TEXT)

BEGIN
      CASE $campo 
                WHEN 'consecutivo'  THEN SELECT * FROM TblMensualidades WHERE consecutivo LIKE CONCAT('%',$dato,'%');
                WHEN 'numAlquiler'  THEN SELECT * FROM TblMensualidades WHERE numAlquiler LIKE CONCAT('%',$dato,'%');
                WHEN 'fechCreacion' THEN SELECT * FROM TblMensualidades WHERE fechCreacion LIKE CONCAT('%',$dato,'%');
                WHEN 'nomInqui'     THEN SELECT * FROM TblMensualidades WHERE nomInqui LIKE CONCAT('%',$dato,'%');
                WHEN 'mesCobro'     THEN SELECT * FROM TblMensualidades WHERE mesCobro LIKE CONCAT('%',$dato,'%');
                WHEN 'anioActual'   THEN SELECT * FROM TblMensualidades WHERE anioActual LIKE CONCAT('%',$dato,'%');
                WHEN 'descuento'    THEN SELECT * FROM TblMensualidades WHERE descuento LIKE CONCAT('%',$dato,'%');
                WHEN 'montoMes'     THEN SELECT * FROM TblMensualidades WHERE montoMes LIKE CONCAT('%',$dato,'%');
                WHEN 'estado'       THEN SELECT * FROM TblMensualidades WHERE estado LIKE CONCAT('%',$dato,'%');                
			ELSE 
				Select * FROM TblMensualidades;
		END CASE;
END$$
DELIMITER ;

-- Almacenamiento que permite mostrarnos las VIVIENDAS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE stpBuscarVivienda
($campo TEXT,
$dato TEXT)

BEGIN
      CASE $campo 
                WHEN 'idVivienda'    THEN SELECT * FROM TblVivienda WHERE idVivienda LIKE CONCAT('%',$dato,'%');
                WHEN 'descripcion'   THEN SELECT * FROM TblVivienda WHERE descripcion LIKE CONCAT('%',$dato,'%');
                WHEN 'mtsConstrucc'  THEN SELECT * FROM TblVivienda WHERE mtsConstrucc LIKE CONCAT('%',$dato,'%');
                WHEN 'mtsLote'       THEN SELECT * FROM TblVivienda WHERE mtsLote LIKE CONCAT('%',$dato,'%');
                WHEN 'tipoConstrucc' THEN SELECT * FROM TblVivienda WHERE tipoConstrucc LIKE CONCAT('%',$dato,'%');
                WHEN 'cochera' 		 THEN SELECT * FROM TblVivienda WHERE cochera LIKE CONCAT('%',$dato,'%');
                WHEN 'cantHabitac'   THEN SELECT * FROM TblVivienda WHERE cantHabitac LIKE CONCAT('%',$dato,'%');
                WHEN 'cantBanios'    THEN SELECT * FROM TblVivienda WHERE cantBanios LIKE CONCAT('%',$dato,'%');
                WHEN 'carretera'     THEN SELECT * FROM TblVivienda WHERE carretera LIKE CONCAT('%',$dato,'%');
                WHEN 'precioBase'    THEN SELECT * FROM TblVivienda WHERE precioBase LIKE CONCAT('%',$dato,'%');
                WHEN 'deposGarantia' THEN SELECT * FROM TblVivienda WHERE deposGarantia LIKE CONCAT('%',$dato,'%');
                WHEN 'cedPropiet'    THEN SELECT * FROM TblVivienda WHERE cedPropiet LIKE CONCAT('%',$dato,'%');
                WHEN 'estado'        THEN SELECT * FROM TblVivienda WHERE estado LIKE CONCAT('%',$dato,'%');
			ELSE 
				Select * FROM TblVivienda;
		END CASE;
END$$
DELIMITER ;

-- Almacenamiento que permite mostrarnos los INQUILINOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE stpBuscarInquilino
($campo TEXT,
$dato TEXT)

BEGIN
      CASE $campo 
                 WHEN 'cedInqui'  THEN SELECT * FROM TblInquilino WHERE cedInqui LIKE CONCAT('%',$dato,'%');
                 WHEN 'nomInqui'  THEN SELECT * FROM TblInquilino WHERE nomInqui LIKE CONCAT('%',$dato,'%');
                 WHEN 'genero'    THEN SELECT * FROM TblInquilino WHERE genero LIKE CONCAT('%',$dato,'%');
                 WHEN 'fechNac'   THEN SELECT * FROM TblInquilino WHERE fechNac LIKE CONCAT('%',$dato,'%');
                 WHEN 'direccion' THEN SELECT * FROM TblInquilino WHERE direccion LIKE CONCAT('%',$dato,'%');
                 WHEN 'email'     THEN SELECT * FROM TblInquilino WHERE email LIKE CONCAT('%',$dato,'%');
                 WHEN 'ocupacion' THEN SELECT * FROM TblInquilino WHERE ocupacion LIKE CONCAT('%',$dato,'%');
			ELSE 
                 Select * FROM TblInquilino;
     END CASE;
END$$
DELIMITER ;

-- Almacenamiento que permite mostrarnos los PROPIETARIOS
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE stpBuscarPropietario
($campo TEXT,
$dato TEXT)

BEGIN
      CASE $campo 
                 WHEN 'cedPropiet' THEN SELECT * FROM TblPropietario WHERE cedPropiet LIKE CONCAT('%',$dato,'%');
                 WHEN 'nomPropiet' THEN SELECT * FROM TblPropietario WHERE nomPropiet LIKE CONCAT('%',$dato,'%');
                 WHEN 'genero'     THEN SELECT * FROM TblPropietario WHERE genero LIKE CONCAT('%',$dato,'%');
                 WHEN 'telefono'   THEN SELECT * FROM TblPropietario WHERE telefono LIKE CONCAT('%',$dato,'%');
                 WHEN 'email'      THEN SELECT * FROM TblPropietario WHERE email LIKE CONCAT('%',$dato,'%');
            ELSE
				Select * FROM TblPropietario;
	END CASE;
END$$
DELIMITER ;

-- Por aquello xd
FLUSH PRIVILEGES;



-- INNER JOINS agregados








