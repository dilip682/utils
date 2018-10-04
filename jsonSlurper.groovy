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

def jsonData = new groovy.json.JsonSlurper().parseText(JSON_DATA)
println jsonData.params.subMap(jsonData.params.keySet())

JsonSlurper jsonResponseContent = new JsonSlurper()
def jsonResponseObject = jsonResponseContent.parseText(ITEM_DATA)
//arrayAmount = jsonResponseObject.items.saleInfo?.listPrice?.amount
arrayAmount = jsonResponseObject.items.saleInfo?.listPrice?.amount
arrayCurrencyCode = jsonResponseObject.items.saleInfo?.listPrice?.currencyCode

println "list price amount : ${arrayAmount}"
println "list price currency code : ${arrayCurrencyCode}"
