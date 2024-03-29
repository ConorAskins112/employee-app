package ie.setu.main.kt.ie.setu.controllers

import ie.setu.main.kt.ie.setu.models.Employee


var lastId = 0

internal fun getId(): Int {
    return lastId++
}

class EmployeeAPI {


    private val employees = ArrayList<Employee>()

    fun findAll(): List<Employee> {
        return employees
    }

    fun findOne(id: Int): Employee? {
        return employees.find { p -> p.employeeId == id }
    }

    fun create(employee: Employee) {
        employee.employeeId = getId()
        employees.add(employee)
    }
    fun delete(employee:Employee){
        employee.employeeId = getId()
        employees.remove(employee)
    }

    fun update(employee:Employee){
        var id = employee.employeeId
        employees.set(id,employee)
    }



}
