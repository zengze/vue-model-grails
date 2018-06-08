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
        accountId(nullable: false, unique: true)
        account(nullable: false, unique: true)
        password(nullable: false)
        name(nullable: true)
        mobile(nullable: true, unique: true)
        email(nullable: true, unique: true)
    }
}
