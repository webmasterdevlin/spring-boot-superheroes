set transaction read write;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE user_entity
(
    id       uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    username VARCHAR(50) UNIQUE  NOT NULL,
    password VARCHAR(50)         NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE hero
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(50) UNIQUE NOT NULL,
    lastName  VARCHAR(50) UNIQUE NOT NULL,
    house     VARCHAR(50) NULL,
    knownAs   VARCHAR(50) NULL,
    createdAt TIMESTAMP NULL
);

CREATE TABLE villain
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(50) UNIQUE NOT NULL,
    lastName  VARCHAR(50) UNIQUE NOT NULL,
    house     VARCHAR(50) NULL,
    knownAs   VARCHAR(50) NULL,
    createdAt TIMESTAMP NULL
);

CREATE TABLE anti_hero_entity
(
    id        uuid PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(50) UNIQUE NOT NULL,
    lastName  VARCHAR(50) UNIQUE NOT NULL,
    house     VARCHAR(50) NULL,
    knownAs   VARCHAR(50) NULL,
    createdAt TIMESTAMP NULL
);
