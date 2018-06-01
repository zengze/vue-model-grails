package vue.model.grails

import grails.gorm.transactions.Transactional

@Transactional
class CommonService {

    String randomId() {
        Random random = new Random()
        StringBuffer sb = new StringBuffer("vue_")
        String str = "0123456789abcdefghijklmnopqrstuvwxyz"
        for (int i = 0; i < 16; i++) {
            sb.append(str.charAt(random.nextInt(36)))
        }
        return sb.toString()
    }
}
