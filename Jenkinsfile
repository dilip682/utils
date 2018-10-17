import groovy.json.JsonSlurperClassic
import groovy.json.*
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
          def customer = readFile(file:'customer.json')
          
          def data = new JsonSlurperClassic().parseText(json)
          def custdata = new JsonSlurperClassic().parseText(customer)

          echo "color: ${data.attachments[0].color}"
          echo "fields.value: ${data.attachments[0].fields[0].value}"
          echo "fields.value: ${data.attachments[0].fields[0].value}"
          echo "fields.title: ${data.attachments[0].fields[0].title}"
          
          env.ENV_VAR1 = "${data.attachments[0].color}"
          env.ENV_VAR2 = "${data.attachments[0].fields[0].value}"
          
          echo "dev-hostname: ${custdata.customers.dcust.name}"
          echo "dev-hostname: ${custdata.customers.dcust.location}"
          
          echo "Customer Name from Parameter: ${params.CUST_NAME}"
          def cust_name_path = ${params.CUST_NAME}.name
          echo 'cust_name_path+cust_name_path+'
          echo "${cust_name_path}"
  //        echo "Customer Name from JSON matching Customer Param: ${custdata.customers.+.name}"
          
  /*        echo "dev-hostname: ${custdata.customers[0].lifecycle[0].name}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].description}"
          
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].app_servers[0].hostname}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].app_servers[0].ip_address}"
          
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].app_servers[1].hostname}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].app_servers[1].ip_address}"
          
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].db_servers[0].hostname}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].db_servers[0].ip_address}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].db_servers[0].db_name}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].db_servers[0].port}"
          echo "dev-hostname: ${custdata.customers[0].lifecycle[0].db_servers[0].user_name}"
 */               
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
    parameters {
    choice(name: 'CUST_NAME', choices: '''dcust
abc
xyz
aaa''', description: 'Enter Customer name ?')
        choice(name: 'LIFE_CYCLE', choices: '''dev
tst
stg
uat''', description: 'Enter Life cycle name ?')
    string(name: 'SFTP_FILE_PATH', defaultValue: 'BambooRoseTradeEngines-2017R1FP36-Tomcat.zip', description: 'Artifact to be downloaded')
    booleanParam(name: 'UPGRADE_DB_Q', defaultValue: true, description: 'Upgrade DB?')
  }
}
