CREATE DATABASE mada_immo;
\c mada_immo;

Fenosoa Randrii
DROP DATABASE IF EXISTS mada_immo;
    CREATE DATABASE mada_immo;
    \c mada_immo;

    CREATE SEQUENCE admin_seq;
    CREATE TABLE IF NOT EXISTS admin (
        id VARCHAR PRIMARY KEY DEFAULT CONCAT('ADM', LPAD(nextval('admin_seq')::TEXT, 3, '0')),
        login VARCHAR NOT NULL NOT NULL,
        password VARCHAR NOT NULL
    );

    CREATE SEQUENCE proprietaire_seq;
    CREATE TABLE IF NOT EXISTS proprietaire (
        id VARCHAR PRIMARY KEY DEFAULT CONCAT('PRO', LPAD(nextval('proprietaire_seq')::TEXT, 3, '0')),
        tel VARCHAR UNIQUE NOT NULL
    );

    CREATE SEQUENCE client_seq;
    CREATE TABLE IF NOT EXISTS client (
        id VARCHAR PRIMARY KEY DEFAULT CONCAT('CLI', LPAD(nextval('client_seq')::TEXT, 3, '0')),
        email VARCHAR UNIQUE NOT NULL
    );

    -- CREATE SEQUENCE type_de_bien_seq;
    -- CREATE TABLE IF NOT EXISTS type_de_bien (
    --     id VARCHAR PRIMARY KEY DEFAULT CONCAT('TYP', LPAD(nextval('type_de_bien_seq')::TEXT, 3, '0')),
    --     nom VARCHAR NOT NULL,
    --     commission NUMERIC --en %
    -- );
    -- CREATE SEQUENCE region_seq;
    -- CREATE TABLE IF NOT EXISTS region(
    --     id VARCHAR PRIMARY KEY DEFAULT CONCAT('REG', LPAD(nextval('region_seq')::TEXT, 3, '0')),
    --     nom VARCHAR NOT NULL
    -- );
    
    CREATE SEQUENCE bien_seq;
    CREATE TABLE IF NOT EXISTS bien (
        id VARCHAR PRIMARY KEY DEFAULT CONCAT('BIEN', LPAD(nextval('bien_seq')::TEXT, 3, '0')),
        nom VARCHAR NOT NULL,
        description TEXT NOT NULL,
        loyer NUMERIC NOT NULL,
        id_proprietaire VARCHAR NOT NULL REFERENCES proprietaire(id),
        id_region VARCHAR NOT NULL REFERENCES region(id),
        id_type_de_bien VARCHAR NOT NULL REFERENCES type_de_bien(id)
    );
    -- CREATE SEQUENCE photo_seq;
    -- CREATE TABLE IF NOT EXISTS photo(
    --     id VARCHAR PRIMARY KEY DEFAULT CONCAT('PHT', LPAD(nextval('photo_seq')::TEXT, 3, '0')),
    --     nom TEXT NOT NULL,
    --     id_bien VARCHAR NOT NULL REFERENCES bien(id)
    -- );

    -- CREATE SEQUENCE location_seq;
    -- CREATE TABLE IF NOT EXISTS location (
    --     id VARCHAR PRIMARY KEY DEFAULT CONCAT('LOC', LPAD(nextval('location_seq')::TEXT, 3, '0')),
    --     id_bien VARCHAR NOT NULL REFERENCES bien(id),
    --     id_client VARCHAR NOT NULL REFERENCES client(id),
    --     duree INT NOT NULL, 
    --     date_debut DATE NOT NULL
    -- );

    INSERT INTO admin(login,password) values('admin@gmail.com','admin');
    INSERT INTO proprietaire(tel, nom) values('1234', 'Rakoto');
    INSERT INTO client(email, nom) values('client@gmail.com', 'Rabe');

-- Insertion de données dans la table admin
INSERT INTO admin (login, password) VALUES
('admin1', '12345'),
('admin2', '54321');

-- Insertion de données dans la table proprietaire
INSERT INTO proprietaire (tel) VALUES
('0326851080'),
('0341676690');

-- Insertion de données dans la table client
INSERT INTO client (email) VALUES
('nelly@gmail.com'),
('anouchka@gmail.com');

-- Insertion de données dans la table type_de_bien
INSERT INTO type_de_bien (nom, commission) VALUES
('Maison', 5.0),
('Appartement', 4.5),
('Villa', 6.0),
('Immeuble', 7.0);

-- Insertion de données dans la table region
INSERT INTO region (nom) VALUES
('Nord'),
('Est'),
('Sud'),
('Ouest');

-- Insertion de données dans la table bien
INSERT INTO bien (nom, description, loyer, id_proprietaire, id_region, id_type_de_bien) VALUES
('Maison du Lac', 'Maison spacieuse avec vue sur le lac', 600000, 'PRO001', 'REG001', 'TYP001'),
('Appartement Centre', 'Appartement moderne en centre-ville', 800000, 'PRO002', 'REG002', 'TYP002');

-- Insertion de données dans la table photo
INSERT INTO photo (nom, id_bien) VALUES
('maison_du_lac.jpg', 'BIEN001'),
('appartement_centre.jpg', 'BIEN002');

-- Insertion de données dans la table location
INSERT INTO location (id_bien, id_client, duree, date_debut) VALUES
('BIEN001', 'CLI001', 12, '2024-07-01'),
('BIEN002', 'CLI002', 6, '2024-08-01');
INSERT INTO location (id_bien, id_client, duree, date_debut) VALUES
('BIEN002', 'CLI001', 12, '2024-08-01'),
('BIEN001', 'CLI001', 20, '2024-10-01'),
('BIEN001', 'CLI001', 38, '2024-01-01'),
('BIEN002', 'CLI002', 6, '2024-09-01');