CREATE TABLE user (
  id                    SERIAL          NOT NULL    CONSTRAINT user_pkey PRIMARY KEY,
  user_name             VARCHAR(50)     NOT NULL    UNIQUE,
  password              VARCHAR(50)     NOT NULL,
  full_name             VARCHAR(200)    NOT NULL,
  created_at            TIMESTAMP       NOT NULL    DEFAULT now(),
  modified_at           TIMESTAMP       NOT NULL    DEFAULT now()
);