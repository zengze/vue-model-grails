package vue.model.grails

class User {

    String accountId
    String account
    String password
    String name
    String mobile
    String email

    Date dateCreated, lastUpdated

    static constraints = {
        accountId(nullable: false)
        account(nullable: false)
        password(nullable: false)
        name(nullable: true)
        mobile(nullable: true)
        email(nullable: true)
    }
}
