
-- modo de execucao -----------------------------------------------
-- crie um database testJavaWeb e um usuario testJavaWeb no postgre
-- rode o comando: psql dumpTestJavaWeb.sql 
-- (psql estah na pasta /bin do postgre)
-------------------------------------------------------------------

--
-- PostgreSQL database dump
--

-- Started on 2010-05-04 20:30:32 BRT

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 1773 (class 1262 OID 16516)
-- Name: testJavaWeb; Type: DATABASE; Schema: -; Owner: testJavaWeb
--

-- CREATE DATABASE "testJavaWeb" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'pt_BR';


ALTER DATABASE "testJavaWeb" OWNER TO "testJavaWeb";

\connect "testJavaWeb"

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1490 (class 1259 OID 16517)
-- Dependencies: 3
-- Name: PESSOA; Type: TABLE; Schema: public; Owner: testJavaWeb; Tablespace: 
--

CREATE TABLE "PESSOA" (
    "ID" integer NOT NULL,
    "NOME" character varying(100) NOT NULL,
    "EMAIL" character varying(100) NOT NULL
);


ALTER TABLE public."PESSOA" OWNER TO "testJavaWeb";

--
-- TOC entry 1770 (class 0 OID 16517)
-- Dependencies: 1490
-- Data for Name: PESSOA; Type: TABLE DATA; Schema: public; Owner: testJavaWeb
--

COPY "PESSOA" ("ID", "NOME", "EMAIL") FROM stdin;
1	Zé	renato@lavabit.com
2	Daniel	medeiros@lavabit.com
\.


--
-- TOC entry 1769 (class 2606 OID 16521)
-- Dependencies: 1490 1490
-- Name: pk_id; Type: CONSTRAINT; Schema: public; Owner: testJavaWeb; Tablespace: 
--

ALTER TABLE ONLY "PESSOA"
    ADD CONSTRAINT pk_id PRIMARY KEY ("ID");


--
-- TOC entry 1775 (class 0 OID 0)
-- Dependencies: 3
-- Name: public; Type: ACL; Schema: -; Owner: daniel
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM daniel;
GRANT ALL ON SCHEMA public TO daniel;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 1776 (class 0 OID 0)
-- Dependencies: 1490
-- Name: PESSOA; Type: ACL; Schema: public; Owner: testJavaWeb
--

REVOKE ALL ON TABLE "PESSOA" FROM PUBLIC;
REVOKE ALL ON TABLE "PESSOA" FROM "testJavaWeb";
GRANT ALL ON TABLE "PESSOA" TO "testJavaWeb";


-- Completed on 2010-05-04 20:30:32 BRT

--
-- PostgreSQL database dump complete
--

