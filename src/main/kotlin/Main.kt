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

//payslip calculations
var monthlySalary = grossSalary/12
var monthPaye = monthlySalary*(payePercentage/100)
var monthlyPrsi = monthlySalary*(prsiPercentage/100)
var totalDeductions = monthPaye+monthlyPrsi+cycleToWorkScheme
var bonus = annualBonus/12
var gross= monthlySalary+ bonus
var netPay = gross-totalDeductions


fun main(args: Array<String>) {
    println("Pay slip Printer")
   payslipLayout()
}


//prints the payslip menu with the finished values
fun payslipLayout(){
    println("____________________________________________________________")
    println("|                   Monthly Payslip                        |")
    println("|                                                          |")
    println("|__________________________________________________________|")
    println("|                                                          |")
    println("| Employee Name: "+firstName.uppercase()+" "+ surname.uppercase()+"("+ gender.uppercase()+")"+"            Employee ID:$employeeId   |")
    println("|                                                          |")
    println("|__________________________________________________________|")
    println("|                                                          |")
    println("|    PAYMENT DETAILS          DEDUCTION DETAILS            |")
    println("|__________________________________________________________|")
    println("|                                                          |")
    println("|    Salary:"+ rounding(monthlySalary)+"           PAYE:"+ rounding(monthPaye)+"                 |")
    println("|    bonus:"+ rounding(bonus)+"             PRSI:"+ rounding(monthlyPrsi)+"                  |")
    println("|                             Cycle To Work:$cycleToWorkScheme          |")
    println("|__________________________________________________________|")
    println("|    Gross:"+ rounding(gross)+"            Total Deductions:"+ rounding(totalDeductions)+"     |")
    println("|__________________________________________________________|")
    println("|                    NET PAY:"+ rounding(netPay)+"                       |")
    println("|__________________________________________________________|")
}
//rounds values to the 2 decimal points
fun rounding(num:Double): String {
    return "%.2f".format(num)
}