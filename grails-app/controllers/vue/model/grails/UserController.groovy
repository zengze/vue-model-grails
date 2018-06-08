package vue.model.grails

import grails.converters.JSON

class UserController {

    def userService

    def regUser = {
        try {
            log.info("====user regUser params====" + params)
            def result = userService.regUser(params)
            log.info("====user regUser result====" + result)
            render(text: result as JSON, contentType: "application/json")
        }
        catch(Exception e) {
            log.error("===user regUser error===", e)
            render(text: [success: false, message: "注册失败！"] as JSON, contentType: "application/json")
        }
    }
}
