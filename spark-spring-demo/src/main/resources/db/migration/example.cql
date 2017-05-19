-- the following is the equivilent of creating a database and should be done outside the app


CREATE KEYSPACE stock_data WITH replication =
  {'class': 'SimpleStrategy', 'replication_factor': '1'} AND durable_writes = true;

use stock_data;

-- break out the date into year/month/day for illustrative purposes...
-- plus, we could then cluster by a symbol's year,
-- getting increased distribution
create table daily_price_record (
  symbol text,
  year int,
  month int,
  day int,
  value double,
  previous_value double,
  value_change double,
  percent_change double,
  share_volume int,

  Primary Key ((symbol), year, month, day)
);

CREATE TABLE company (
    symbol text,
    name text,
    address text,

    Primary Key ((symbol), name)
);

  -- toy example, but hopefully it is illustrative.
  -- both of these tables will end up containing the same
  -- number of rows... however, each will be optimized
  -- towards a particular query.
  -- this is acceptable in c* land!
  create table movies_by_release_date (
    title text,
    release_date date,
    genre text,
    rating int,

    Primary Key (date, title)
  );

  create table movies_by_rating (
    title text,
    release_date date,
    genre text,
    rating int,

    Primary Key (rating, title)
  );

insert into company(symbol, name, address) values ('FOOO', 'Foobar incorporated', '123 Test Street, Springfield USA');,
insert into company(symbol, name, address) values ('HELO', 'Helo World Co', '123 Test Street, Springfield USA');,
insert into company(symbol, name, address) values ('RNDM', 'Random Pharmaceuticals', '123 Test Street, Springfield USA');
insert into company(symbol, name, address) values ('WRLD', 'WorldWide Consulting', '123 Test Street, Springfield USA');
insert into company(symbol, name, address) values ('SPQR', 'Roman Colossem Builders', '123 Test Street, Springfield USA');
insert into company(symbol, name, address) values ('PVTL', 'Pivotal Technologies', '123 Test Street, Springfield USA');
insert into company(symbol, name, address) values ('THRC', 'ThirdChannel, Inc', '123 Test Street, Springfield USA');