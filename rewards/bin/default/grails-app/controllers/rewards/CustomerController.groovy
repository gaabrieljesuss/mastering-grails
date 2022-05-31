package rewards

class CustomerController {

    static scaffold = Customer

    def calculationsService

    def lookup() {
        //def customerInstance = Customer.list(sort: "firstName", order:"cres", max: 5)
        //def customerInstance = Customer.findAllByLastName("Santos", [sort: "firstName", order: "cres"])
        //def customerInstance = Customer.findAllByPhone(params.id)
        //def customerInstance = Customer.findAllByLastNameIlike("s%")
        //def customerInstance = Customer.findAllByTotalPointsGreaterThanEquals(2)
        //def customerInstance = Customer.findAllByTotalPointsBetween(2,5)
        def customerInstance = Customer.findAllByFirstNameAndTotalPoints("Gabriel", 2)
        [customerInstanceList: customerInstance]
    }
    
    def customerLookup(Customer lookupInstance) {
        def (customerInstance, welcomeMessage) = calculationsService.processCheckin(lookupInstance)
        render(view: "checkin", model: [customerInstance: customerInstance, welcomeMessage: welcomeMessage])
    }

    def checkin() {}

    def index() {
        params.max = 10
        [customerList: Customer.list(params), customerCount: Customer.count()]
    }

    def create() {
        [customer: new Customer()]
    }

    def save (Customer customer) {
        customer.save()
        redirect(action: "show", id: customer.id)
    }

    def show(Long id) {
        def customer = Customer.get(id)
        customer = calculationsService.getTotalPoints(customer)
        [customer: customer]
    }

    def edit(Long id) {
        def customer = Customer.get(id)
        [customer: customer]
    }

    def profile() {
        def customer = Customer.findByPhone(params.id)
        [customerInstance: customer]
    }

    def updateProfile(Customer customerInstance){
        customerInstance.save()
        render(view: "profile", model: [customerInstance: customerInstance])
    }
}
