insert into user(id, name, firstname, email, password, age) values(1, 'BARTHEZ', 'Fanny', 'fanny.barthez@hotmail.fr', 'FBpassword', 37)
insert into user(id, name, firstname, email, password, age) values(2, 'DEVAUX', 'Clara', 'clara.devaux31@outlook.fr', 'CDpassword', 25)
insert into user(id, name, firstname, email, password, age) values(3, 'MENDOLA', 'Thomas', 'thomasmendola@outlook.fr', 'TMpassword', 36)
insert into user(id, name, firstname, email, password, age) values(4, 'CHANEL', 'Marie', 'marie-benedicte.chanel@wanadoo.fr', 'MCpassword', 36)
insert into user(id, name, firstname, email, password, age) values(5, 'REVILLON', 'Thaïs', 'trevillon@jehann.fr', 'TRpassword', 28)

insert into budget(id, name, description) values(1, 'Projet Java', 'Ceci est une réussite!!')
insert into budget(id, name, description) values(2, 'Vacances', 'Ceci est une réussite aussi!!')
insert into budget(id, name, description) values(3, 'Epargne', 'Ceci est une réussite encore!!')

insert into participant(id, username, user_id, budget_id) values(1, 'FannyP', 1, 1)
insert into participant(id, username, user_id, budget_id) values(2, 'ClaraP', 2, 1)
insert into participant(id, username, user_id, budget_id) values(3, 'ThomasP', 3, 1)
insert into participant(id, username, user_id, budget_id) values(4, 'MarieP', 4, 1)

insert into participant(id, username, user_id, budget_id) values(5, 'FannyP', 1, 2)
insert into participant(id, username, user_id, budget_id) values(6, 'ClaraP', 2, 2)
insert into participant(id, username, user_id, budget_id) values(7, 'ThomasP', 3, 2)
insert into participant(id, username, user_id, budget_id) values(8, 'MarieP', 4, 2)
insert into participant(id, username, user_id, budget_id) values(9, 'ThaïsP', 5, 2)
insert into participant(id, username, user_id, budget_id) values(11, 'TotoP', 2, 3)
insert into participant(id, username, budget_id) values(10, 'Mamie', 2)

insert into expense(id, name, description, montant, budget_id, payeur_id) values(1, 'Test 1', 'ceci est un test', 100, 1, 1)
insert into expense(id, name, description, montant, budget_id, payeur_id) values(2, 'Test 2', 'ceci est un 2eme test', 100, 1, 2)

insert into participant_expense(participant_id, expense_id) values(1,1)