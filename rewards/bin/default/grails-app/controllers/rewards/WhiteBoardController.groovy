package rewards

class WhiteBoardController {
    def calculationsService

    def index() { }

    def variables() {
        def myTotal = 1
        render("Total: " + myTotal)
        render("</br>" + myTotal.class)

        def firstName = "Mike"
        render("</br>First Name: " + firstName)
        render("</br>" + firstName.class)

        def today = new Date("5/30/2022")
        render("</br>Today is: " + today)
        render("</br>" + today.class)
    }

    def strings(){
        def first = "Mike"
        def last = "Kelly"
        def points = 4
        def input = "SHOUTING"
        render "Welcome back" + " " + first + " " + last + "." + " You have "+ points + " " + "points."
        render "</br>Please stop ${input.toLowerCase()}!"
    }

    def conditions(){
        def welcomeMessage = calculationsService.welcome(params)
        render welcomeMessage
    }
}
