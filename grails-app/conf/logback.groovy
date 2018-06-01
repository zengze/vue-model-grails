import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.FileAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import grails.util.BuildSettings
import grails.util.Environment

appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "%d %level %logger %thread - %msg%n"
    }
}

def targetDir = BuildSettings.TARGET_DIR
appender('FILE', RollingFileAppender){
    encoder(PatternLayoutEncoder) {
        Pattern = "%d %level %logger %thread - %msg%n"
    }
    rollingPolicy(TimeBasedRollingPolicy) {
        FileNamePattern = "${BuildSettings.BASE_DIR}/logs/log.%d{yyyy-MM-dd}.log"
        maxHistory = 30
    }
}

root(INFO, ['STDOUT', 'FILE'])

if (Environment.isDevelopmentMode() && targetDir) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%d %level %logger %thread - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}
