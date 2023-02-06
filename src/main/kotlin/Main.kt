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
 * payslip calculations
 */

var monthlySalary = grossSalary/12
var monthPaye = monthlySalary*(payePercentage/100)
var monthlyPrsi = monthlySalary*(prsiPercentage/100)
var totalDeductions = monthPaye+monthlyPrsi+cycleToWorkScheme
var bonus = annualBonus/12
var gross= monthlySalary+ bonus
var netPay = gross-totalDeductions


fun main() {
    println("Pay slip Printer")
   payslipLayout()
}

/**
 * prints the payslip menu with the finished values
 */

fun payslipLayout(){
    println("""____________________________________________________________
                                    Monthly Payslip                      
               __________________________________________________________
                                                             
                Employee Name: ${firstName.uppercase()} ${surname.uppercase()}(${gender.uppercase()}            Employee ID:$employeeId  
    
                __________________________________________________________
                                                              
                                    PAYMENT DETAILS         
                __________________________________________________________
                                                              
                            Salary:${rounding(monthlySalary)}                            
                            bonus:${rounding(bonus)}                               
                      --------------------------------------------
                            Gross:${rounding(gross)}
                __________________________________________________________
                                DEDUCTION DETAILS
                __________________________________________________________
                                
                            PAYE:${rounding(monthPaye)}
                            PRSI:${rounding(monthlyPrsi)} 
                            Cycle To Work:$cycleToWorkScheme
                      ----------------------------------------
                            Total Deductions:${rounding(totalDeductions)}                                                      
                __________________________________________________________
                        NET PAY:${rounding(netPay)}                       
                __________________________________________________________""")
}

/**
 * rounds values to the 2 decimal points
 */

//rounds values to the 2 decimal points
fun rounding(num:Double): String {
    return "%.2f".format(num)
}