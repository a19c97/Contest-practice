class Employee:

    def __init__(self, id):
        self.id = id
        self.salary = 0
        self.boss = None
        self.max = 0
        self.min = 0

    def setBoss(self, boss): # boss should be an Employee object or None
        self.boss = boss
        # if self.boss is not None:
        #     print("I am " + str(self.id) + " and my boss is " + str(self.boss.id))

    def setSalary(self, salary):
        self.salary = salary
        if salary > self.max or self.max == 0:
            self.max = salary
        if salary < self.min or self.min == 0:
            self.min = salary
        if self.boss is not None:
            # print("Id " + str(self.id) + " has a boss; need to update " + str(self.boss.id))
            self.boss.updateMaxMin(salary)

    def updateMaxMin(self, subSalary):
        if self.max < subSalary:
            self.max = subSalary
        if self.min > subSalary:
            self.min = subSalary
        if self.boss is not None:
            self.boss.updateMaxMin(subSalary)

    def query(self):
        print(self.max - self.min)

    def __str__(self):
        print("Employee: ")
        print("Id: " + str(self.id))
        print("Boss: " + str(self.boss))
        print("Salary: " + str(self.salary))
        print("Max: " + str(self.max) + " Min: " + str(self.min))

class Company:

    def __init__(self, numEmployees):
        self.numEmployees = numEmployees
        # initialize all employees
        self.employees = []
        for i in range(1, numEmployees + 1):
            em = Employee(i)
            self.employees.append(em)

    def assignBoss(self, employeeId, bossId):
        if bossId == 0:
            self.employees[employeeId].setBoss(None)
        else:
            self.employees[employeeId].setBoss(self.employees[bossId-1])

    def assignSalary(self, employeeId, salary):
        self.employees[employeeId].setSalary(salary)

    def giveRaise(self, employeeId, raiseBy):
        newSalary = self.employees[employeeId].salary + raiseBy
        self.employees[employeeId].setSalary(newSalary)

    def query(self, employeeId):
        self.employees[employeeId].query()


if __name__ == "__main__":
    numCompanies = int(input())
    numEmployees = int(input())
    company = Company(numEmployees)

    bossesRaw = input()
    bosses = bossesRaw.split(" ")

    # set boss of 1 to none
    company.assignBoss(0, 0)

    for i in range(numEmployees - 1):
        company.assignBoss(i + 1, int(bosses[i]))

    salariesRaw = input()
    salaries = salariesRaw.split(" ")

    for i in range(numEmployees):
        company.assignSalary(i, int(salaries[i]))



    numEvents = int(input())

    for i in range(numEvents):
        event = input()
        if event[0] == "Q":
            # This is a query
            query = event.split(" ")
            company.query(int(query[1]) - 1)
        else:
            # This is a raise
            aRaise = event.split(" ")
            company.giveRaise(int(aRaise[1]) - 1, int(aRaise[2]))

    # print(company.employees[0].max)
    # print(company.employees[0].min)