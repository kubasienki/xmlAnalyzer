# xmlAnalyzer
Stack overflow's xml Analyzer - a spring boot application, implemented in hexagon architecture, which analyzes xmls from [Stack Exchange Data Dump](https://archive.org/details/stackexchange). 

App interface consists of a REST single endpoint to which, via POST request, you can send url pointing to resource containing XML file (over 1GB files supported)  
to be analysed - app wil respond with statistics of stack overflow's posts contained in that file.
However thanks to ports and adapters architecture rest could be easily swapped for any other client technology.


### Example of api's usage
Example of calling api with curl:
```
curl -i -X POST \
    -H "Content-Type:application/json" \
    -d \
 '{
   "url": "https://s3-eu-west-1.amazonaws.com/merapar-assessment/arabic-posts.xml"
 }' \
  'http://localhost:8080/analyze/'
  ```
  Respective response:
  ```
  {
      "analyseDate": "2019-03-18T01:39:21.674",
      "details": {
          "firstPost": "2016-01-12T18:45:19.963",
          "lastPost": "2016-03-04T13:30:22.41",
          "totalPosts": 655,
          "totalAcceptedPosts": 102,
          "avgScore": 3.2732824427480915
      }
  }
```
### Assertions an decisions made
##### _(in regard to recruitment process for which this code was created)_

* As observed on [Stack Exchange Data Dump](https://archive.org/details/stackexchange) <row> elements in xmls have chronological order.
* Default spring boot exception handling was used - this could be changed in future if there would be any need, but for now it's enough.