package vue.model.grails

import grails.gorm.transactions.Transactional

@Transactional
class LoginService {

    def login(params) {
        def result = [success: false, message: "登录失败！"]
        def user = User.findAllByAccount(params.account)
        if(user) {
            def password = String.valueOf(params.password).encodeAsMD5()
            def userPassword = user.password[0]
            if(userPassword == password) {
                result.success = true
                result.message = "登录成功"
            } else {
                result.message = "密码错误"
            }
        } else {
            result.message = "账号不存在"
        }
        return result
    }
}
