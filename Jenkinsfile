import groovy.json.JsonSlurperClassic
import groovy.json.*
import hudson.EnvVars
import hudson.model.Environment
pipeline {
  agent any
  stages {
    stage('Environment') {
      steps {
        sh 'echo "FOO is $FOO"'
        sh 'echo "BUILD_NUM_ENV is $BUILD_NUM_ENV"'
        sh 'echo "ANOTHER_ENV is $ANOTHER_ENV"'
        sh 'echo "INHERITED_ENV is $INHERITED_ENV"'
      }
    }
    stage('readCustomerFile') {
      steps {
        echo 'Reading file'
        readFile 'customer.json'
        echo 'Writing file'
        writeFile file: 'customer-write.json', text: 'Testing'
        script {
          def json = readFile(file:'message.json')
          def data = new JsonSlurperClassic().parseText(json)
          def build = Thread.currentThread().executable
          def vars = [ENV_VAR1: 'value1', ENV_VAR2: 'value2']
          
          echo "color: ${data.attachments[0].color}"
          echo "fields.title: ${data.attachments[0].fields[0].title}"
          echo "color: ${data.attachments[0].fields[0].title}"
          build.environments.add(0, Environment.create(new EnvVars(vars)))
        }
        sh 'echo "### ENV_VAR1 $ENV_VAR1"'
        sh 'echo "### ENV_VAR2 $ENV_VAR2"'        
      }
    }
  }
  environment {
    FOO = 'BAR'
    BUILD_NUM_ENV = currentBuild.getNumber()
    ANOTHER_ENV = "${currentBuild.getNumber()}"
    INHERITED_ENV = '${BUILD_NUM_ENV} is inherited'
  }
}
