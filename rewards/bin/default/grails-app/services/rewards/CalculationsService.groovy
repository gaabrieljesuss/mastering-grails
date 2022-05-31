package rewards

import grails.gorm.transactions.Transactional

@Transactional
class CalculationsService {

    def welcome(params) {
        def first = params.first
        def totalPoints = params.points.toInteger()
        def welcomeMessage = ""
        switch(totalPoints){
            case 5:
                welcomeMessage = "Welcome back" + " " + first + "." + " You have "+ totalPoints + " " + "points."
                break
            case 6:
                welcomeMessage = "Welcome back" + " " + first + "." + " You have "+ totalPoints + " " + "points."
                break
            default: 
                welcomeMessage = "Welcome back $first, you now have $totalPoints points."
        }
    }

    def getTotalPoints(customer) {
        def totalAwards = 0
        customer.awards.each{
            totalAwards = totalAwards + it.points
        }
        customer.totalPoints = totalAwards
        return customer
    }

    def processCheckin(lookupInstance) {
        def customerInstance = Customer.findByPhone(lookupInstance.phone)

        if (customerInstance == null) {
            customerInstance = lookupInstance
            customerInstance.firstName = "Customer"
        }

        def totalAwards = 0
        customerInstance.awards.each{
            totalAwards = totalAwards + it.points
        }
        customerInstance.totalPoints = totalAwards
        def welcomeMessage = ""

        switch(totalAwards){
            case 5:
                welcomeMessage = "Welcome back $customerInstance.firstName. This drink is on us."
                break
            case 4:
                welcomeMessage = "Welcome back $customerInstance.firstName. Your next drink is free."
                break
            case 1..3:
                welcomeMessage = "Welcome back $customerInstance.firstName. You now have ${totalAwards + 1} points."
                break
            default: 
                welcomeMessage = "Welcome $customerInstance.firstName, Thank you for registering."
        }

        if (totalAwards < 5){
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Purchase", points: 1))
        } else{
            customerInstance.addToAwards(new Award(awardDate: new Date(), type: "Reward", points: -5))
        }

        customerInstance.save()

        return [customerInstance, welcomeMessage]
    }
}
