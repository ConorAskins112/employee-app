package ie.setu.main.kt

import ie.setu.main.kt.ie.setu.controllers.EmployeeAPI
import ie.setu.main.kt.ie.setu.models.Employee
import mu.KotlinLogging

var employees = EmployeeAPI()
val logger = KotlinLogging.logger {}



/**
 * This is the main function of the program that starts execution
 */

fun main() {
    logger.info { "Launching Employee App" }

    start()
}
fun start() {
    var input: Int

    do {
        input = menu()
        when (input) {
            1 -> add()
            2 -> list()
            3 -> search()
            4 -> paySlip()
            5-> delete()
            6-> update()
            -99 -> dummyData()
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}
fun list(){
    employees.findAll()
        .forEach{ println(it) }
}

internal fun getEmployeeById(): Employee? {
    print("Enter the employee id: ")
    val employeeID = readLine()!!.toInt()
    return employees.findOne(employeeID)
}
fun search() {
    val employee = getEmployeeById()
    if (employee == null)
        println("No employee found")
    else
        println(employee)
}
fun delete(){
    val employee = getEmployeeById()

    if (employee != null) {
        employees.delete(employee)
        println("")
    }
    else
        println("No employee found")

}
fun update(){
    val employee = getEmployeeById()
    var employId = employee!!.getemployeeId()
    var fName= employee!!.getfirstName()
    var lName = employee!!.getsurname()
    var gender = employee!!.getgender()
    var grossSalary = employee!!.getgrossSalary()
    var bonus=employee!!.getannualBonus()
    var paye=employee!!.getpayePercentage()
    var prsi= employee!!.getprsiPercentage()
    var ctws= employee!!.getcycleToWorkScheme()

    println(employee)
        println("What value would your like to edit")
        print("""
        |Employee Menu
         |   1. First Name
         |   2. Last Name
         |   3. Gender
         |   4. Gross Salary
         |   5. Annual Bonus
         |   6. PAYE Percentage
         |   7. PRSI Percentage
         |   8. Cycle To Work Scheme
         |  -1. Finish Update
         |       
         |Enter Option :        
    """.trimMargin())

        val input = readLine()!!.toInt()
        do {
            when(input){
                1->{
                    println("Enter The new First Name:")
                    fName= readLine().toString()
                    break
                }

                2->{
                    println("Enter The new Last Name:")
                    lName= readLine().toString()
                    break
                }
                3->{
                    println("Enter The Gender:")
                    gender= readLine()!!.toCharArray()[0]
                    break
                }
                4->{
                    println("Enter the new gross salary")
                    grossSalary= readLine()!!.toDouble()
                    break
                }
                5-> {
                    println("Enter the new gross salary")
                    bonus= readLine()!!.toDouble()
                    break
                }
                6-> {
                println("Enter the new gross salary")
                paye= readLine()!!.toDouble()
                break
                }
                7-> {
                println("Enter the new gross salary")
                prsi= readLine()!!.toDouble()
                break
                }
                8->{
                println("Enter the new gross salary")
                    ctws= readLine()!!.toDouble()
                break
                }
                -1->
                    println("Update Finished")
                else-> println("Invalid Option")
            }
        }while(input!=-1)

    if (employee != null) {
        employees.delete(employee)
        employees.create(Employee(fName,lName,gender,employId,grossSalary,paye,prsi,bonus,ctws))
        employees.findOne(employId)
    }


}
fun paySlip(){
    val employee = getEmployeeById()
    if (employee != null)
        println(employee.getpayslipLayout())
}


fun dummyData() {
    employees.create(Employee("Joe", "Soap", 'm', 0, 35655.43, 31.0, 7.5, 2000.0, 25.6))
    employees.create(Employee("Joan", "Murphy", 'f', 0, 54255.13, 32.5, 7.0, 1500.0, 55.3))
    employees.create(Employee("Mary", "Quinn", 'f', 0, 75685.41, 40.0, 8.5, 4500.0, 0.0))
}
fun menu():Int{
    print(""" 
         |Employee Menu
         |   1. Add Employee
         |   2. List All Employees
         |   3. Search Employees 
         |   4. Print Payslip for Employee
         |   5. Delete an Employee
         |   6. Update an Employee
         |   99. Dummy Data
         |  -1. Exit
         |       
         |Enter Option : """.trimMargin())
    return readLine()!!.toInt()
}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter gross salary: ")
    val grossSalary = readLine()!!.toDouble()
    print("Enter PAYE %: ")
    val payePercentage = readLine()!!.toDouble()
    print("Enter PRSI %: ")
    val prsiPercentage = readLine()!!.toDouble()
    print("Enter Annual Bonus: ")
    val annualBonus= readLine()!!.toDouble()
    print("Enter Cycle to Work Deduction: ")
    val cycleToWorkMonthlyDeduction= readLine()!!.toDouble()

    employees.create(Employee(firstName, surname, gender, 0, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction))
}
