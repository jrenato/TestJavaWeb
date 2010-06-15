-- Table: "COORDENADA"

-- DROP TABLE "COORDENADA";

CREATE TABLE "COORDENADA"
(
  "ID" integer NOT NULL,
  "LATITUDE" double precision,
  "LONGITUDE" double precision,
  CONSTRAINT "PK_COORDENADA" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

-- Table: "ENDERECO"

-- DROP TABLE "ENDERECO";

CREATE TABLE "ENDERECO"
(
  "ID" integer NOT NULL,
  "LOGRADOURO" character varying(100),
  "NUMERO" integer,
  "BAIRRO" character varying(70),
  "CIDADE" character varying(100),
  "ESTADO" character varying(2),
  CONSTRAINT "PK_ENDERECO" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

-- Table: "TELEFONE"

-- DROP TABLE "TELEFONE";

CREATE TABLE "TELEFONE"
(
  "ID" integer NOT NULL,
  "TELEFONE" character varying(20),
  "TIPO" character varying(50),
  "FK_ENDERECO_ID" integer,
  CONSTRAINT "PK_TELEFONE" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);

-- Table: "ESTABELECIMENTO"

-- DROP TABLE "ESTABELECIMENTO";

CREATE TABLE "ESTABELECIMENTO"
(
  "ID" integer NOT NULL,
  "NOME" character varying(100),
  CONSTRAINT "PK_ESTABELECIMENTO" PRIMARY KEY ("ID")
)
WITH (
  OIDS=FALSE
);
