CREATE TABLE group_user (
  id SERIAL PRIMARY KEY,
  login VARCHAR(50),
  password VARCHAR(50),
  name VARCHAR(50),
  age INTEGER
);

CREATE TABLE auto (
  id SERIAL PRIMARY KEY,
  model VARCHAR(50),
  color VARCHAR(50),
  carMileage DECIMAL,
  used BOOL,
  owner_id INTEGER REFERENCES group_user(id)
);