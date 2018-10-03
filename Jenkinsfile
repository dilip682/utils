import groovy.json.JsonSlurperClassic
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
        
        def json = readFile(file:'message.json')
        def data = new JsonSlurperClassic().parseText(json)
        echo "color: ${data.attachments[0].color}"
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
