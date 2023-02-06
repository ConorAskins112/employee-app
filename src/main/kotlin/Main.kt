package ie.setu.main.kt


val firstName = "Joe"
val surname = "Soap"
val gender='m'
val employeeId=6143
val grossSalary= 67543.21
val payePercentage = 38.5
val prsiPercentage = 5.2
val annualBonus = 1450.50
val cycleToWorkScheme = 54.33


/**
 * This is the main function of the program that starts execution
 */

fun main() {
    // Prints the title of the program
    println("Pay slip Printer")
    // Calls the payslipLayout function with the inputs as arguments
    payslipLayout(gender, firstName, surname, grossSalary, annualBonus, employeeId, payePercentage, prsiPercentage,
        cycleToWorkScheme)
}

/**
 * This function returns the full name of the employee based on their gender
 */

fun getFullname(sex:Char, first:String,last:String): String {
    // Returns the full name formatted differently based on the gender
    return when(sex){
        // If the gender is 'm', returns "Mr first last"
        'm'->"Mr $first $last"
        // If the gender is 'f', returns "Ms first last"
        'f'->"Ms $first $last"
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
/**
 * prints the payslip menu with the finished values
 */

fun payslipLayout(gender:Char,first: String,surname:String,gross: Double,bonus: Double,employID: Int,paye:Double,prsi: Double,ctwScheme: Double){
    val fullName= getFullname(gender,first,surname)
    val monSalary= getMonthSalary(gross)
    val monPAYE= getMonthlyPAYE(monSalary,paye)
    val monPRSI= getMonthlyPRSI(monSalary,prsi)
    val monBonus= getBonus(bonus)
    val monGross= getGrossMonthlyPay(monSalary, monBonus)
    val monDeductions = getTotalMonthlyDeductions(monPAYE,monPRSI,ctwScheme)
    val monNet= getNetMonthlyPay(monGross,monDeductions)

    println("""                __________________________________________________________
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
                __________________________________________________________""")
}

/**
 * rounds values to the 2 decimal points
 */
