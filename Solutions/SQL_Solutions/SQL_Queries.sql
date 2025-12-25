-- SQL Solutions for JALA Academy Assignments

-- Create tables as given in the assignment
CREATE TABLE SALESPEOPLE (
    SNUM INT PRIMARY KEY,
    SNAME VARCHAR(50),
    CITY VARCHAR(50),
    COMM DECIMAL(3,2)
);

CREATE TABLE CUST (
    CNUM INT PRIMARY KEY,
    CNAME VARCHAR(50),
    CITY VARCHAR(50),
    RATING INT,
    SNUM INT,
    FOREIGN KEY (SNUM) REFERENCES SALESPEOPLE(SNUM)
);

CREATE TABLE ORDERS (
    ONUM INT PRIMARY KEY,
    AMT DECIMAL(10,2),
    ODATE DATE,
    CNUM INT,
    SNUM INT,
    FOREIGN KEY (CNUM) REFERENCES CUST(CNUM),
    FOREIGN KEY (SNUM) REFERENCES SALESPEOPLE(SNUM)
);

-- Insert sample data as provided in the assignment
INSERT INTO SALESPEOPLE VALUES 
(1001, 'Peel', 'London', 0.12),
(1002, 'Serres', 'San Jose', 0.13),
(1004, 'Motika', 'London', 0.11),
(1007, 'Rafkin', 'Barcelona', 0.15),
(1003, 'Axelrod', 'New york', 0.10);

INSERT INTO CUST VALUES 
(2001, 'Hoffman', 'London', 100, 1001),
(2002, 'Giovanne', 'Rome', 200, 1003),
(2003, 'Liu', 'San Jose', 300, 1002),
(2004, 'Grass', 'Brelin', 100, 1002),
(2006, 'Clemens', 'London', 300, 1007),
(2007, 'Pereira', 'Rome', 100, 1004);

INSERT INTO ORDERS VALUES 
(3001, 18.69, '1994-10-03', 2008, 1007),
(3003, 767.19, '1994-10-03', 2001, 1001),
(3002, 1900.10, '1994-10-03', 2007, 1004),
(3005, 5160.45, '1994-10-03', 2003, 1002),
(3006, 1098.16, '1994-10-04', 2008, 1007),
(3009, 1713.23, '1994-10-04', 2002, 1003),
(3007, 75.75, '1994-10-05', 2004, 1002),
(3008, 4723.00, '1994-10-05', 2006, 1001),
(3010, 1309.95, '1994-10-06', 2004, 1002),
(3011, 9891.88, '1994-10-06', 2006, 1001);

-- SQL Queries Solutions:

-- 1. Display snum,sname,city and comm of all salespeople.
SELECT snum, sname, city, comm
FROM salespeople;

-- 2. Display all snum without duplicates from all orders.
SELECT DISTINCT snum 
FROM orders;

-- 3. Display names and commissions of all salespeople in london.
SELECT sname, comm
FROM salespeople
WHERE city = 'London';

-- 4. All customers with rating of 100.
SELECT cname 
FROM cust
WHERE rating = 100;

-- 5. Produce orderno, amount and date form all rows in the order table.
SELECT onum, amt, odate
FROM orders;

-- 6. All customers in San Jose, who have rating more than 200.
SELECT cname
FROM cust
WHERE city = 'San Jose' AND rating > 200;

-- 7. All customers who were either located in San Jose or had a rating above 200.
SELECT cname
FROM cust
WHERE city = 'San Jose' OR rating > 200;

-- 8. All orders for more than $1000.
SELECT * 
FROM orders
WHERE amt > 1000;

-- 9. Names and cities of all salespeople in london with commission above 0.10.
SELECT sname, city
FROM salespeople
WHERE comm > 0.10 AND city = 'London';

-- 10. All customers excluding those with rating <= 100 unless they are located in Rome.
SELECT cname
FROM cust
WHERE rating > 100 OR city = 'Rome';

-- 11. All salespeople either in Barcelona or in london.
SELECT sname, city
FROM salespeople
WHERE city IN ('Barcelona', 'London');

-- 12. All salespeople with commission between 0.10 and 0.12. (Boundary values should be excluded)
SELECT sname, comm
FROM salespeople
WHERE comm > 0.10 AND comm < 0.12;

-- 13. All customers with NULL values in city column.
SELECT cname
FROM cust
WHERE city IS NULL;

-- 14. All orders taken on Oct 3rd and Oct 4th 1994.
SELECT *
FROM orders 
WHERE odate IN ('1994-10-03', '1994-10-04');

-- 15. All customers serviced by peel or Motika.
SELECT cname
FROM cust, orders
WHERE orders.cnum = cust.cnum AND 
     orders.snum IN (SELECT snum 
                     FROM salespeople
                     WHERE sname IN ('Peel', 'Motika'));

-- 16. All customers whose names begin with a letter from A to B.
SELECT cname
FROM cust
WHERE cname LIKE 'A%' OR cname LIKE 'B%';

-- 17. All orders except those with 0 or NULL value in amt field.
SELECT onum
FROM orders
WHERE amt != 0 AND amt IS NOT NULL;

-- 18. Count the number of salespeople currently listing orders in the order table.
SELECT COUNT(DISTINCT snum)
FROM orders;

-- 19. Largest order taken by each salesperson, datewise.
SELECT odate, snum, MAX(amt)
FROM orders
GROUP BY odate, snum
ORDER BY odate, snum;

-- 20. Largest order taken by each salesperson with order value more than $3000.
SELECT odate, snum, MAX(amt)
FROM orders
WHERE amt > 3000
GROUP BY odate, snum
ORDER BY odate, snum;

-- 21. Which day had the highest total amount ordered.
SELECT odate, SUM(amt) as total_amount
FROM orders
GROUP BY odate
ORDER BY total_amount DESC
LIMIT 1;

-- 22. Count all orders for Oct 3rd.
SELECT COUNT(*)
FROM orders
WHERE odate = '1994-10-03';

-- 23. Count the number of different non NULL city values in customers table.
SELECT COUNT(DISTINCT city)
FROM cust
WHERE city IS NOT NULL;

-- 24. Select each customer's smallest order.
SELECT cnum, MIN(amt)
FROM orders
GROUP BY cnum;

-- 25. First customer in alphabetical order whose name begins with G.
SELECT MIN(cname)
FROM cust
WHERE cname LIKE 'G%';

-- 26. Get the output like "For dd/mm/yy there are ___ orders."
SELECT CONCAT('For ', DATE_FORMAT(odate, '%d/%m/%y'), ' there are ', COUNT(*), ' Orders') AS output
FROM orders
GROUP BY odate;

-- 27. Assume that each salesperson has a 12% commission. Produce order no., salesperson no., and amount of salesperson's commission for that order.
SELECT onum, snum, amt, amt * 0.12 AS commission
FROM orders
ORDER BY snum;

-- 28. Find highest rating in each city. Put the output in this form. For the city (city), the highest rating is : (rating).
SELECT CONCAT('For the city (', city, '), the highest rating is : (', MAX(rating), ')') AS output
FROM cust
GROUP BY city;

-- 29. Display the totals of orders for each day and place the results in descending order.
SELECT odate, SUM(amt) AS total_amount
FROM orders
GROUP BY odate
ORDER BY total_amount DESC;

-- 30. All combinations of salespeople and customers who shared a city. (ie same city).
SELECT sname, cname
FROM salespeople, cust
WHERE salespeople.city = cust.city;

-- 31. Name of all customers matched with the salespeople serving them.
SELECT cname, sname
FROM cust, salespeople
WHERE cust.snum = salespeople.snum;

-- 32. List each order number followed by the name of the customer who made the order.
SELECT onum, cname
FROM orders, cust
WHERE orders.cnum = cust.cnum;

-- 33. Names of salesperson and customer for each order after the order number.
SELECT onum, sname, cname
FROM orders, cust, salespeople
WHERE orders.cnum = cust.cnum AND orders.snum = salespeople.snum;

-- 34. Produce all customer serviced by salespeople with a commission above 12%.
SELECT cname, sname, comm
FROM cust, salespeople
WHERE comm > 0.12 AND cust.snum = salespeople.snum;

-- 35. Calculate the amount of the salesperson's commission on each order with a rating above 100.
SELECT sname, amt * comm AS commission
FROM orders, cust, salespeople
WHERE rating > 100 AND
      salespeople.snum = cust.snum AND
      salespeople.snum = orders.snum AND
      cust.cnum = orders.cnum;

-- 36. Find all pairs of customers having the same rating.
SELECT a.cname, b.cname, a.rating
FROM cust a, cust b
WHERE a.rating = b.rating AND a.cnum != b.cnum;

-- 37. Find all pairs of customers having the same rating, each pair coming once only.
SELECT a.cname, b.cname, a.rating
FROM cust a, cust b
WHERE a.rating = b.rating AND a.cnum != b.cnum AND a.cnum < b.cnum;

-- 38. Display all customers located in cities where salesman serres has customer.
SELECT cname
FROM cust
WHERE city IN (SELECT DISTINCT city
               FROM cust, salespeople
               WHERE cust.snum = salespeople.snum AND sname = 'Serres');

-- 39. Find all pairs of customers served by single salesperson.
SELECT cname FROM cust
WHERE snum IN (SELECT snum FROM cust
               GROUP BY snum
               HAVING COUNT(snum) > 1);

-- 40. Produce all pairs of salespeople which are living in the same city. Exclude combinations of salespeople with themselves as well as duplicates with the order reversed.
SELECT a.sname, b.sname
FROM salespeople a, salespeople b
WHERE a.snum > b.snum AND a.city = b.city;

-- 41. Produce names and cities of all customers with the same rating as Hoffman.
SELECT cname, city
FROM cust
WHERE rating = (SELECT rating
                FROM cust
                WHERE cname = 'Hoffman')
AND cname != 'Hoffman';

-- 42. Extract all the orders of Motika.
SELECT onum
FROM orders
WHERE snum = (SELECT snum
              FROM salespeople
              WHERE sname = 'Motika');

-- 43. All orders credited to the same salesperson who services Hoffman.
SELECT onum
FROM orders
WHERE snum = (SELECT snum
              FROM cust
              WHERE cname = 'Hoffman');

-- 44. All orders that are greater than the average for Oct 3rd.
SELECT * 
FROM orders
WHERE amt > (SELECT AVG(amt) 
             FROM orders
             WHERE odate = '1994-10-03');

-- 45. Find average commission of salespeople in london.
SELECT AVG(comm)
FROM salespeople
WHERE city = 'London';

-- 46. Find all orders attributed to salespeople servicing customers in london.
SELECT *
FROM orders
WHERE snum IN (SELECT snum 
               FROM cust
               WHERE city = 'London');

-- 47. Extract commissions of all salespeople servicing customers in London.
SELECT DISTINCT comm 
FROM salespeople
WHERE snum IN (SELECT snum
               FROM cust
               WHERE city = 'London');

-- 48. Find all customers whose cnum is 1000 above the snum of serres.
SELECT cnum, cname FROM cust
WHERE cnum > (SELECT snum + 1000 
              FROM salespeople
              WHERE sname = 'Serres');

-- 49. Count the customers with rating above San Jose's average.
SELECT COUNT(*) 
FROM cust
WHERE rating > (SELECT AVG(rating) 
                FROM cust
                WHERE city = 'San Jose');

-- 50. Obtain all orders for the customer named Cisnerous. (Assume you don't know his customer no. (cnum)).
SELECT *
FROM orders
WHERE cnum = (SELECT cnum
              FROM cust
              WHERE cname = 'Cisnerous');