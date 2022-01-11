# marvel-api


#### Crear Base de Datos 
CREATE DATABASE marvel
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Mexico.1252'
    LC_CTYPE = 'Spanish_Mexico.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
	
CREATE TABLE public.ss_usuarios(
    id_usuario bigserial NOT NULL DEFAULT ,
    codigo_usuario character varying(15) ,
    nombre_usuario character varying(100) ,
    telefono character varying(20) ,
    email character varying(100) ,
    bloqueado boolean DEFAULT false,
    clave character varying(100) ,
    usuario_registro character varying(15)  NOT NULL,
    fecha_registro date NOT NULL,
    usuario_ultima_modificacion character varying(15) ,
    fecha_ultima_modificacion date,
    fecha_inicial_vigencia date NOT NULL,
    fecha_final_vigencia date,
    CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario),
    CONSTRAINT uk_codigo_usuario UNIQUE (codigo_usuario)
);

INSERT INTO public.ss_usuarios(
	 codigo_usuario, nombre_usuario, telefono, email, bloqueado, 
	clave, usuario_registro, fecha_registro, 
	fecha_inicial_vigencia)
	VALUES ('admin2','Hilson','7201XXXX','hilsoncarballo@x',false,'$2a$10$XURPShQNCsLjp1ESc2laoObo9QZDhxz73hJPaEv7/cBha4pk0AgP.','admin',current_date,current_date);

## Insertar registro


#### Obtener Token
http://localhost:8095/login

{ "username": "admin", "password": "password"}

### Documentacion Servicios
http://localhost:8095/v2/api-docs

##Servicios
* http://localhost:8095/login
* http://localhost:8095/api/usuarios/listar
* http://localhost:8095/api/characters
* 1http://localhost:8095/api/characters/Spider-dok/w/w
* 2 http://localhost:8095/api/characters/Spider-dok
* 3 .http://localhost:8095/api/charactersimage/3-D Man
* 4. http://localhost:8095/api/comics
* 5 http://localhost:8095/api/comics/331
*6. 
*7. http://localhost:8095/api/stories
 http://localhost:8095/api/stories/nombre_stories
 
#### Tecnologia

Open your browser in http://localhost:8095/login
```
#### Technologies

* Java 8
* Spring Boot 2.5.4
* Lombok
* Swagger
* Eclipse / Netbeans
