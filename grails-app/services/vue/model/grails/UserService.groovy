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
            log.info("user regUser fail:" + user.errors)
        }
        return result
    }

}
