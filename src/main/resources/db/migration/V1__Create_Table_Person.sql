CREATE TABLE person (
    id BIGSERIAL PRIMARY KEY,
    address character varying(255) NOT NULL,
    first_name character varying(80) NOT NULL,
    gender character varying(6) NOT NULL,
    last_name character varying(80) NOT NULL
);

-- Indices -------------------------------------------------------

CREATE UNIQUE INDEX person_pkey2 ON person(id int8_ops);