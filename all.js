#!/usr/bin/jjs -fv

var uri = "http://localhost:8080/doit/api/todos";
var command = "curl ${uri}";
print(">> "+command);
$EXEC(command);
print($OUT);

var result = JSON.parse($OUT);
for(todo in result){
    print(result[todo].caption+" -- "+result[todo].description+" -- "+result[todo].priority);
}