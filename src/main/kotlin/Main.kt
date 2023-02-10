package ie.setu.main.kt


var employee =  Employee("Joe", "Soap", 'm', 6143, 67543.21, 38.5, 5.2, 1450.50, 54.33)



/**
 * This is the main function of the program that starts execution
 */

fun main() {
    // Prints the title of the program
    println("Pay slip Printer")
    menu(
        employee.gender, employee.firstName, employee.surname, employee.grossSalary, employee.annualBonus, employee.employeeId, employee.payePercentage, employee.prsiPercentage,
        employee.cycleToWorkScheme)
}

/**
 * This function returns the full name of the employee based on their gender
 */

fun getFullname(sex:Char, first:String,last:String): String {
    // Returns the full name formatted differently based on the gender
    return when(sex){
        // If the gender is 'm', returns "Mr first last"
        'm','M'->"Mr $first $last"
        // If the gender is 'f', returns "Ms first last"
        'f','F'->"Ms $first $last"
        // If the gender is not 'm' or 'f', returns "first last"
        else -> "$first $last"
    }
}
/**
 *This function calculates the employee's monthly salary
 **/

fun getMonthSalary(gross: Double): Double {
    // Returns the gross salary divided by 12
    return gross/12
}

/**
 * payslip calculations
 */

/**
 *This function calculates the employee's monthly PRSI
 **/
fun getMonthlyPRSI(monSalary:Double,prsi: Double): Double{
    // Returns the monthly salary multiplied by the PRSI percentage
    return monSalary*(prsi/100)
}
/**
 *This function calculates the employee's monthly PAYE
 **/
fun getMonthlyPAYE(monSalary:Double,paye: Double): Double{
    // Returns the monthly salary multiplied by the PAYE percentage
    return monSalary*(paye/100)
}
/**
 *This function calculates the employee's monthly bonus
 **/

fun getBonus(bonus: Double): Double{
    // Returns the annual bonus divided by 12
    return bonus/12
}
/**
 *This function calculates the employee's gross monthly pay
 **/
fun getGrossMonthlyPay(monSalary:Double,bonus:Double): Double{
    // Returns the sum of the monthly salary and bonus
    return monSalary+bonus
}
/**
 *This function calculates the employee's total monthly deductions
 **/
fun getTotalMonthlyDeductions(paye:Double,prsi:Double,ctwScheme:Double): Double{
    // Returns the sum of the monthly PAYE, PRSI, and cycle-to-work scheme
    return paye+prsi+ctwScheme
}

/**
 * This function calculates the employee's net monthly pay
 **/

fun getNetMonthlyPay(gross:Double,deductions:Double): Double{
    // Returns the difference between the gross monthly pay and total deductions
    return gross-deductions
}
/**
 * rounds values to the 2 decimal points
 */
fun rounding(num:Double): String {
    return "%.2f".format(num)
}

fun menuFormat(gender: Char,first: String,last: String) :Int {
    print("""
        Employee Menu for ${getFullname(gender,first,last)}
        1. Monthly Salary
        2. Monthly PRSI
        3. Monthly PAYE
        4. Monthly Gross Pay
        5. Monthly Total Deductions
        6. Monthly Net Pay
        7. Full Payslip
        -1. Exit
        Enter Option :       
    """)
    return readLine()!!.toInt()
}
fun menu(gender:Char,first: String,surname:String,gross: Double,bonus: Double,employID: Int,paye:Double,prsi: Double,ctwScheme: Double){
    val monSalary= getMonthSalary(gross)
    val monPAYE= getMonthlyPAYE(monSalary,paye)
    val monPRSI= getMonthlyPRSI(monSalary,prsi)
    val monBonus= getBonus(bonus)
    val monGross= getGrossMonthlyPay(monSalary, monBonus)
    val monDeductions = getTotalMonthlyDeductions(monPAYE,monPRSI,ctwScheme)
    val monNet= getNetMonthlyPay(monGross,monDeductions)
    var input:Int

    add()

    do {
        input = menuFormat(gender,first,surname)
        when(input) {
            1 -> println("Monthly Salary: ${rounding(monSalary)}")
            2 -> println("Monthly PRSI: ${rounding(monPRSI)}")
            3 ->println("Monthly PAYE: ${rounding(monPAYE)}")
            4 -> println("Monthly Gross Pay: ${rounding(monGross)}")
            5 -> println("Monthly Total Deductions: ${rounding(monDeductions)}")
            6 -> println("Monthly Net Pay: ${rounding(monNet)}")
            7 -> println(getpayslipLayout(gender,first,surname, gross,bonus,employID,paye,prsi,ctwScheme))
            -1 -> println("Exiting App")
            else -> println("Invalid Option")
        }
        println()
    } while (input != -1)
}

fun add(){
    print("Enter first name: ")
    val firstName = readLine().toString()
    print("Enter surname: ")
    val surname = readLine().toString()
    print("Enter gender (m/f): ")
    val gender = readLine()!!.toCharArray()[0]
    print("Enter employee ID: ")
    val employeeID = readLine()!!.toInt()
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

    employee = Employee(firstName, surname, gender, employeeID, grossSalary, payePercentage, prsiPercentage, annualBonus, cycleToWorkMonthlyDeduction)
}




/**
 * prints the payslip menu with the finished values
 */

fun getpayslipLayout(gender:Char,first: String,surname:String,gross: Double,bonus: Double,employID: Int,paye:Double,prsi: Double,ctwScheme: Double):String{
    val fullName= getFullname(gender,first,surname)
    val monSalary= getMonthSalary(gross)
    val monPAYE= getMonthlyPAYE(monSalary,paye)
    val monPRSI= getMonthlyPRSI(monSalary,prsi)
    val monBonus= getBonus(bonus)
    val monGross= getGrossMonthlyPay(monSalary, monBonus)
    val monDeductions = getTotalMonthlyDeductions(monPAYE,monPRSI,ctwScheme)
    val monNet= getNetMonthlyPay(monGross,monDeductions)

    return """                __________________________________________________________
                                    Monthly Payslip                      
                __________________________________________________________
                                                             
                Employee Name: $fullName(${gender.uppercase()})            Employee ID:$employID  
    
                __________________________________________________________
                                                              
                                    PAYMENT DETAILS         
                __________________________________________________________
                                                              
                            Salary:${rounding(getMonthSalary(gross))}                            
                            bonus:${rounding(getBonus(bonus))}                               
                      --------------------------------------------
                            Gross:${rounding(monGross)}
                __________________________________________________________
                                DEDUCTION DETAILS
                __________________________________________________________
                                
                            PAYE:${rounding(monPAYE)}
                            PRSI:${rounding(monPRSI)} 
                            Cycle To Work:$ctwScheme
                      ----------------------------------------
                            Total Deductions:${rounding(monDeductions)}                                                      
                __________________________________________________________
                        NET PAY:${rounding(monNet)}                       
                __________________________________________________________"""
}

