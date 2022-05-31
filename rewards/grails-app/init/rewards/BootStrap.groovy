package rewards

class BootStrap {

    def init = { servletContext ->
        new Product(name: "Morning Blend", sku: "MB01", price: 14.95).save()
        new Product(name: "Dark Roast", sku: "DK01", price: 12.95).save()
        new Customer(phone: 5015551212, firstName: "Luther", lastName: "Allison", totalPoints: 1).save()
        new Customer(phone: 6015551212, firstName: "Gabriel", lastName: "Santos", totalPoints: 2).save()
        new Customer(phone: 7015551212, firstName: "Felipe", lastName: "Santos", totalPoints: 3).save()
        new Customer(phone: 8015551212, firstName: "Lucas", lastName: "Rodrigues", totalPoints: 4).save()
        new Customer(phone: 9015551212, firstName: "Micledson", lastName: "Carlos", totalPoints: 5).save()
    }
    def destroy = {
    }
}
