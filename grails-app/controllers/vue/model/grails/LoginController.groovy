package vue.model.grails

import grails.converters.JSON

class LoginController {

    def loginService

    def login = {
        try {
            log.info("login login params:" + params)
            def result = loginService.login(params)
            log.info("login login result:" + result)
            render(text: result as JSON, contentType: "application/json")
        }
        catch(Exception e) {
            log.error("login login error:", e)
        }
    }

}
