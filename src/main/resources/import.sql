insert into user(id, name, firstname, username, password, age) values(1, 'BARTHEZ', 'Fanny', 'fanny.barthez@hotmail.fr', 'FBpassword', 37)
insert into user(id, name, firstname, username, password, age) values(2, 'DEVAUX', 'Clara', 'clara.devaux31@outlook.fr', 'CDpassword', 25)
insert into user(id, name, firstname, username, password, age) values(3, 'MENDOLA', 'Thomas', 'thomasmendola@outlook.fr', 'TMpassword', 36)
insert into user(id, name, firstname, username, password, age) values(4, 'CHANEL', 'Marie', 'marie-benedicte.chanel@wanadoo.fr', 'MCpassword', 36)
insert into user(id, name, firstname, username, password, age) values(5, 'REVILLON', 'Thaïs', 'trevillon@jehann.fr', 'TRpassword', 28)

insert into budget(id, name, description) values(1, "Vacances Corse", "Départ Lyon - Bateau - Location voiture et plage dans les calanques au soleil. Du 12/08/2021 au 25/08/2021")
insert into budget(id, name, description) values(2, "Anniversaire Fanny", "Cagnotte pour la soirée et cadeau d'anniversaire")
insert into budget(id, name, description) values(3, "Anniversaire de mariage de Papi et Mamie", "")
insert into budget(id, name, description) values(4, "Vacances ski Février 2022 <3 *.*", "Essences, courses raclette et alcool, location matériels, forfaits, sorties")
insert into budget(id, name, description) values(5, "Erasmus en Italie", "Loyer logement, sorties, souvenirs, billets de transports, autres")
insert into budget(id, name, description) values(6, "Vacances Corse2", "Départ Lyon - Bateau - Location voiture et plage dans les calanques au soleil. Du 12/08/2022 au 25/08/2022")

insert into participant(id, username, user_id, budget_id) values(1, 'FannyB', 1, 1)
insert into participant(id, username, user_id, budget_id) values(2, 'FBarthez', 1, 3)
insert into participant(id, username, user_id, budget_id) values(3, 'CDevaux', 2, 3)
insert into participant(id, username, user_id, budget_id) values(4, 'Cailloux', 2, 1)
insert into participant(id, username, user_id, budget_id) values(5, 'TomTom', 3, 1)
insert into participant(id, username, user_id, budget_id) values(6, 'Toto', 3, 4)
insert into participant(id, username, user_id, budget_id) values(7, 'MarieC', 4, 1)
insert into participant(id, username, user_id, budget_id) values(8, 'MCHANEL', 4, 4)
insert into participant(id, username, user_id, budget_id) values(9, 'MCHANEL', 4, 5)
insert into participant(id, username, user_id, budget_id) values(10, 'Thaïs', 5, 1)
insert into participant(id, username, user_id, budget_id) values(11, 'Titi', 5, 2)
insert into participant(id, username, user_id, budget_id) values(12, 'TRevillon', 5, 6)
insert into participant(id, username, budget_id) values(13, 'Mamie', 2)
insert into participant(id, username, budget_id) values(14, 'Laura', 2)
insert into participant(id, username, budget_id) values(15, 'Julien', 5)
insert into participant(id, username, budget_id) values(16, 'Malena', 4)

insert into expense(id, name, description, montant, budget_id, payeur_id) values(1, 'Essence aller', '250km', 60, 1, 1)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(2, 'Essence retour', '250km', 60, 1, 4)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(3, 'Course apéro', 'Softs, bières et alcool', 120.54, 1, 10)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(4, "Billet bateau", 'Aller-retour pour les 5 personnes', 100, 1, 5)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(5, "Fleurs gateau et cadeaux", "", 75, 2, 11)

insert into expense(id, name, description, montant, budget_id, payeur_id) values(6, "Album photo", '', 38, 3, 3)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(7, 'Location ski', 'Batons, chaussures, ski pour 2', 150, 4, 8)

insert into expense(id, name, description, montant, budget_id, payeur_id) values(8, "Billet d'avion", 'Aller Retour', 400, 5, 15)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(9, 'Soirée', 'Bar + Boite', 60, 5, 9)

insert into expense(id, name, description, montant, budget_id, payeur_id) values(10, 'Essence aller', '250km', 60, 6, 12)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(11, 'Essence retour', '250km', 60, 6, 12)

insert into participant_expense(participant_id, expense_id) values(1, 1)
insert into participant_expense(participant_id, expense_id) values(4, 1)
insert into participant_expense(participant_id, expense_id) values(5, 1)
insert into participant_expense(participant_id, expense_id) values(10, 1)

insert into participant_expense(participant_id, expense_id) values(1, 2)
insert into participant_expense(participant_id, expense_id) values(4, 2)
insert into participant_expense(participant_id, expense_id) values(5, 2)

insert into participant_expense(participant_id, expense_id) values(10, 2)

insert into participant_expense(participant_id, expense_id) values(1, 3)
insert into participant_expense(participant_id, expense_id) values(4, 3)
insert into participant_expense(participant_id, expense_id) values(5, 3)

insert into participant_expense(participant_id, expense_id) values(10, 3)

insert into participant_expense(participant_id, expense_id) values(1, 4)
insert into participant_expense(participant_id, expense_id) values(4, 4)
insert into participant_expense(participant_id, expense_id) values(5, 4)

insert into participant_expense(participant_id, expense_id) values(10, 4)

insert into participant_expense(participant_id, expense_id) values(11, 5)
insert into participant_expense(participant_id, expense_id) values(13, 5)
insert into participant_expense(participant_id, expense_id) values(14, 5)

insert into participant_expense(participant_id, expense_id) values(2, 6)
insert into participant_expense(participant_id, expense_id) values(3, 6)

insert into participant_expense(participant_id, expense_id) values(8, 7)
insert into participant_expense(participant_id, expense_id) values(16, 7)

insert into participant_expense(participant_id, expense_id) values(9, 8)
insert into participant_expense(participant_id, expense_id) values(15, 8)

insert into participant_expense(participant_id, expense_id) values(9, 9)
insert into participant_expense(participant_id, expense_id) values(15, 9)

insert into participant_expense(participant_id, expense_id) values(12, 10)
insert into participant_expense(participant_id, expense_id) values(12, 11)