CREATE TABLE post (
  id                    SERIAL          NOT NULL    CONSTRAINT post_pkey PRIMARY KEY,
  content                TEXT           NOT NULL,
  Status                VARCHAR(15)     NOT NULL,
  creator_id             INTEGER        NOT NULL    CONSTRAINT posts_user_id_fk REFERENCES user,
  created_at            TIMESTAMP       NOT NULL    DEFAULT now(),
  modified_at           TIMESTAMP       NOT NULL    DEFAULT now()
);
