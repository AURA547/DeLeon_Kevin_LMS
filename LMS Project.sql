CREATE DATABASE library_db;
USE library_db;

CREATE TABLE books (
    barcode INT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    genre VARCHAR(255),
    status VARCHAR(50),
    due_date DATE
);

INSERT INTO books (barcode, title, author, genre, status, due_date)
VALUES
(101, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', 'Checked In', NULL),
(102, 'Pride and Prejudice', 'Jane Austen', 'Romance', 'Checked In', NULL),
(103, 'The Hobbit', 'J.R.R. Tolkien', 'Fantasy', 'Checked In', NULL),
(104, 'The Da Vinci Code', 'Dan Brown', 'Mystery', 'Checked In', NULL),
(105, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Fantasy', 'Checked In', NULL),
(106, 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', 'Checked In', NULL),
(107, 'Harry Potter and the Sorcerer\'s Stone', 'J.K. Rowling', 'Fantasy', 'Checked In', NULL),
(108, 'The Shining', 'Stephen King', 'Horror', 'Checked In', NULL),
(109, 'Brave New World', 'Aldous Huxley', 'Science Fiction', 'Checked In', NULL),
(110, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', 'Checked In', NULL),
(111, 'Moby-Dick', 'Herman Melville', 'Adventure', 'Checked In', NULL),
(112, 'The Hunger Games', 'Suzanne Collins', 'Dystopian', 'Checked In', NULL),
(113, 'Frankenstein', 'Mary Shelley', 'Gothic', 'Checked In', NULL),
(114, 'The Odyssey', 'Homer', 'Epic Poetry', 'Checked In', NULL),
(115, 'Alice\'s Adventures in Wonderland', 'Lewis Carroll', 'Fantasy', 'Checked In', NULL),
(116, 'The Chronicles of Narnia', 'C.S. Lewis', 'Fantasy', 'Checked In', NULL),
(117, 'One Hundred Years of Solitude', 'Gabriel García Márquez', 'Magical Realism', 'Checked In', NULL),
(118, 'The Road', 'Cormac McCarthy', 'Post-Apocalyptic', 'Checked In', NULL),
(119, 'Jane Eyre', 'Charlotte Brontë', 'Gothic', 'Checked In', NULL),
(120, 'Dune', 'Frank Herbert', 'Science Fiction', 'Checked In', NULL);

SELECT * FROM books;