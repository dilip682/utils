import groovy.json.JsonSlurperClassic
import groovy.json.*

String JSON_DATA = """{
    "params": {
        "firstName": {
            "label": "First Name",
            "type": "String"
        },
        "surname": {
            "label": "Last Name",
            "type": "String"
        }
    }
}
"""
String ITEM_DATA = """{
  "items": [
  {
    "kind": "books#volume",
    "id": "nwy8akU-nJUC",
    "volumeInfo": {
      "title": "Light In August",
      "authors": ["William Faulkner"],
      "publisher": "Random House",
      "publishedDate": "2013-07-05",
      "pageCount": 384,
      "categories": ["Fiction"]
    },
    "saleInfo": {
      "country": "IN",
      "saleability": "FOR_SALE",
      "isEbook": true,
      "listPrice": {
        "amount": 339.0,
        "currencyCode": "INR"
      }
    }
  }
]
}"""

String CUST_DATA = """{
  "customers": {
    "dcust": {
      "name": "dcust",
      "location": "USA",
      "lifecycle": {
        "dev": {
          "app_servers": {
            "node1": {
              "hostname": "app-node1-host",
              "ip_address": "10.0.3.28"
            },
            "node2": {
              "hostname": "app-node2-host",
              "ip_address": "10.0.3.28"
            }
          },
          "db_servers": {
            "node1": {
              "hostname": "db-node1-host",
              "ip_address": "10.0.3.148",
              "db_name": "DEV",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            },
            "node2": {
              "hostname": "db-node2-host",
              "ip_address": "10.0.3.150",
              "db_name": "DEV",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            }
          }
        },
        "test": {
          "app_servers": {
            "node1": {
              "hostname": "app-node1-host",
              "ip_address": "10.0.3.28"
            },
            "node2": {
              "hostname": "app-node2-host",
              "ip_address": "10.0.3.28"
            }
          },
          "db_servers": {
            "node1": {
              "hostname": "db-node1-host",
              "ip_address": "10.0.3.148",
              "db_name": "TEST",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            },
            "node2": {
              "hostname": "db-node2-host",
              "ip_address": "10.0.3.150",
              "db_name": "TEST",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            }
          }
        },
        "prod": {
          "app_servers": {
            "node1": {
              "hostname": "app-node1-host",
              "ip_address": "10.0.3.28"
            },
            "node2": {
              "hostname": "app-node2-host",
              "ip_address": "10.0.3.28"
            }
          },
          "db_servers": {
            "node1": {
              "hostname": "db-node1-host",
              "ip_address": "10.0.3.148",
              "db_name": "PROD",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            },
            "node2": {
              "hostname": "db-node2-host",
              "ip_address": "10.0.3.150",
              "db_name": "PROD",
              "port": "1521",
              "user_name": "tssdemo",
              "passwd": "stone01"
            }
          }
        }
      }
    }
  }
}
"""

//def jsonData = new groovy.json.JsonSlurper().parseText(JSON_DATA)
//println jsonData.params.subMap(jsonData.params.keySet())

JsonSlurper jsonResponseContent = new JsonSlurper()
def jsonResponseObject = jsonResponseContent.parseText(ITEM_DATA)

arrayAmount = jsonResponseObject.items.saleInfo?.listPrice?.amount
arrayCurrencyCode = jsonResponseObject.items.saleInfo?.listPrice?.currencyCode

//println "list price amount : ${arrayAmount}"
//println "list price currency code : ${arrayCurrencyCode}"



//String inputFile = 'customers.json'
//String fileContents = new File(inputFile).getText('UTF-8')
//def jsoncustSlurper = new JsonSlurper()
//def jsoncustObject = jsoncustSlurper.parseText(fileContents)


JsonSlurper custdataContent = new JsonSlurper()
def custdataObject = new groovy.json.JsonSlurperClassic().parseText(CUST_DATA)

custName = custdataObject.customers.dcust.name
println "Customer Name : ${custName}"

appServer1Host = custdataObject.customers.dcust.lifecycle.dev.app_servers.node1.hostname
println "appServer1Host : ${appServer1Host}"

appServer1IP = custdataObject.customers.dcust.lifecycle.dev.app_servers.node1.ip_address
println "appServer1Host : ${appServer1IP}"

//appServer1IP = custdataObject.customers.lifecycle.dev.app_servers.node1.ip_address
//println "appServer1IP : ${appServer1IP}"

println "list price amount : ${arrayAmount}"
println "list price currency code : ${arrayCurrencyCode}"

//println "dev-hostname: ${custdataObject.customers[0].name}"
//println "dev-hostname: ${custdataObject.customers[0].location}"
