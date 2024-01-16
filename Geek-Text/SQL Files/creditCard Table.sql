CREATE TABLE credit_card(
	card_id INT auto_increment primary key,
    user_id int,
	cardNumber VARCHAR(40),
    cardExpiration DATE,
    cardCVV VARCHAR(5),
    billingAddress VARCHAR(75),
    FOREIGN KEY (user_id) REFERENCES Users(user_id)
);