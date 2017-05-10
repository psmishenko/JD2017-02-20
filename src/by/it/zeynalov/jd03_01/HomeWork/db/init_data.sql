INSERT INTO roles (Title) VALUES ('Oficiant');
INSERT INTO roles (Title) VALUES ('Manager');
INSERT INTO roles (Title) VALUES ('Client');
INSERT INTO roles (Title) VALUES ('Director');

INSERT INTO users (name, role) VALUES ('Bob1', 1);
INSERT INTO users (name, role) VALUES ('Bob2', 4);

INSERT INTO menu (title, recept, price) VALUES ('чай', '-', 100);
INSERT INTO menu (title, recept, price) VALUES ('суп', '-', 200);

INSERT INTO orders (userID, menuID) VALUES (1, 1);
INSERT INTO orders (userID, menuID) VALUES (2, 2);