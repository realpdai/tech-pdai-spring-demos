CREATE TABLE public.tb_user
(
    id bigint NOT NULL,
    user_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    phone_number bigint,
    description character varying(255) COLLATE pg_catalog."default",
    create_time timestamp(6) with time zone,
    update_time timestamp(6) with time zone,
    CONSTRAINT tb_user_pkey PRIMARY KEY (id)
)

CREATE TABLE public.tb_role
(
    id bigint NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    role_key character varying(255) COLLATE pg_catalog."default",
    description character varying(255) COLLATE pg_catalog."default",
    create_time timestamp(6) with time zone,
    update_time timestamp(6) with time zone,
    CONSTRAINT tb_role_pkey PRIMARY KEY (id)
)

CREATE TABLE public.tb_user_role
(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
)