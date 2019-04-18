create table book (
  book_id int,
  title text,
  author text,
  pages int,
  publicationYear int,
  primary key (book_id)
  );
  
create table reader (
  reader_id int,
  name text,
  address text,
  phone text,
  primary key (reader_id)
  );
  
create table borrow (
  book_id int,
  reader_id int,
  startDate Date,
  dueDate Date,
  primary key (book_id, reader_id),
  foreign key (book_id) references book (book_id),
  foreign key (reader_id) references reader (reader_id)
  );


