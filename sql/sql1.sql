SELECT Persons.firstName, Persons.Birthday, Persons.id
FROM Persons
WHERE Persons.Birthday<#1/1/1997# AND Persons.Weight > 64
ORDER BY Persons.Birthday DESC;
