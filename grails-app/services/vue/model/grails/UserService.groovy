package vue.model.grails

import grails.gorm.transactions.Transactional

@Transactional
class UserService {

    def commonService

    def regUser(params) {
        def result = [success: false, message: "注册失败！"]
        def user = new User()
        user.accountId = commonService.randomId()
        user.account = params.account
        user.password = String.valueOf(params.password).encodeAsMD5()
        if(params.name && params.name != "" && params.name != "null") { user.name = params.name }
        if(params.mobile && params.mobile != "" && params.mobile != "null") { user.mobile = params.mobile }
        if(params.email && params.email != "" && params.email != "null") { user.email = params.email }
        if(user.save()) {
            result.success = true
            result.message = "注册成功！"
        } else {
            def errorList = [] as List
            user.errors.allErrors.each {
                def error = [:] as Map
                error.arguments = it.arguments
                error.message = it.defaultMessage
                errorList.add(error)
            }
            log.info("====注册失败原因====" + errorList)
        }
        return result
    }

}
