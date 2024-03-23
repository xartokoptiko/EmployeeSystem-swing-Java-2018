#! /usr/bin/env python3

import sqlite3
import sys
import os

class DataHandler:
    def __init__(self):
        self.pathToData = "{path}/Data/employees.db".format(path=os.getcwd())
        self.conn = sqlite3.connect(self.pathToData)
        self.c = self.conn.cursor()

    def createTable(self):
        self.c.execute("CREATE TABLE IF NOT EXISTS employee('id' INTEGER, 'first' TEXT, 'last' TEXT, 'payment' INTEGER)")
        self.conn.commit()

    def createColumn(self):
        self.c.execute("ALTER TABLE employee ADD COLUMN hours INTEGER")
        self.conn.commit()

    def addEmployee(self, id, first, last, hours ,payment):
        self.c.execute("INSERT INTO employee VALUES('{id}', '{first}', '{last}', '{hours}','{payment}')".format(id=id,
        first=first,
        last=last, 
        hours=hours,
        payment=payment))
        self.conn.commit()

    def deleteEmployee(self, id):
        self.c.execute("DELETE FROM employee WHERE id={id}".format(id=id))
        self.conn.commit()

    def editEmployee(self, id, column, new):
        self.c.execute("UPDATE employee SET {column}='{new}' WHERE id={id}".format(column=column, new=new, id=id))
        self.conn.commit()

    def printAll(self):
        self.c.execute("SELECT * FROM employee")
        self.conn.commit
        self.data = self.c.fetchall()
        for row in self.data:
            print("{id} {first} {last} {hours} {payment}".format(id=row[0], first=row[1], last=row[2], payment=row[3], hours=row[4]))

    def printSpec(self, column):
        self.c.execute("SELECT {column} FROM employee".format(column=column))
        self.conn.commit()
        self.data = self.c.fetchall()
        for row in self.data:
            print(row[0])

    def closeConnection(self):
        self.conn.close()



class Login:
    def __init__(self, username, password):
        self.pathToData = "{path}/Data/userData.db".format(path=os.getcwd())
        self.username = username
        self.password = password
        self.conn = sqlite3.connect(self.pathToData)
        self.c = self.conn.cursor()

    def checkUser(self):
        self.c.execute("SELECT * FROM user")
        self.data = self.c.fetchall()
        for row in self.data:
            self.Username = row[0]
            self.Passworrd = row[1]

        if self.username == self.Username and self.password == self.Passworrd:
            print("o/k")
        else:
            print("n/o/t/o/k")

        self.conn.close()

    



    


class inputHandler:
    def __init__(self, commands):
        self.input = commands
        self.Data = DataHandler()
    
    def findDataCommand(self):
        if len(self.input) >= 1:

            if self.input[0] == "-a":
                # ADD EMPLOYEE COMMAND
                self.id = self.input[1]
                self.first = self.input[2]
                self.last = self.input[3]
                self.hours = self.input[4]
                self.payment = self.input[5]

                self.Data.addEmployee(self.id, self.first, self.last, self.hours ,self.payment)

            elif self.input[0] == "-d":
                # DELETE EMPLOYEE COMMAND
                self.id = int(self.input[1])

                self.Data.deleteEmployee(self.id)

            elif self.input[0] == "-p":
                # PRINT ALL COMMANT 
                self.Data.printAll()

            elif self.input[0] == "-e":
                #EDIT EMPLOYEE COMMAND

                self.Data.editEmployee(id=int(self.input[1]),column=self.input[2],new=self.input[3])

            elif self.input[0] == "-sp":
                # PRINT SPECIFIC COLUMN FROM THE DATABASE 
                self.Data.printSpec(column=self.input[1])

            elif self.input[0] == "-lg":
                # LOGIN TO THE ADMIN SECTION
                login = Login(username=self.input[1], password=self.input[2])
                login.checkUser()


        else:
            print("error")



if __name__ == "__main__":
    user_input = inputHandler(sys.argv[1:])
    user_input.findDataCommand()
    user_input.Data.closeConnection()


