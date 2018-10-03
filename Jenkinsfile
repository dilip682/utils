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
        readFile 'customer.json'
        echo 'Reading file'
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