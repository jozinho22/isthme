CREATE TABLE avis  (
	id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(255) NOT NULL,
    quote VARCHAR(255) NOT NULL,
    to_validate VARCHAR(1) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO avis (author, quote, to_validate) VALUES ("Socrate", "Tout ce que je sais...", "1");
INSERT INTO avis (author, quote, to_validate) VALUES ("Coubertin", "L'important c'est de participer...", "1");
INSERT INTO avis (author, quote, to_validate) VALUES ("La fontaine", "On a toujours besoin d'un...", "1");
INSERT INTO avis (author, quote, to_validate) VALUES ("Descartes", "Je pense donc je suis...", "1");
INSERT INTO avis (author, quote, to_validate) VALUES ("Einstein", "Il est plus facile de briser un atome...", "1");
INSERT INTO avis (author, quote, to_validate) VALUES ("La fontaine", "Rien ne sert de courir...", "1");


CREATE TABLE IF NOT EXISTS client (
	id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    tel VARCHAR(255) NOT NULL,
    adresse VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS commande (
	id INT AUTO_INCREMENT PRIMARY KEY,
    montant INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	client_id INT REFERENCES client(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS gestion (
	id INT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(14) NOT NULL,
    password VARCHAR(14) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

