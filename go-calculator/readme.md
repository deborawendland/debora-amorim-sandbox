Homework GO
===========

1. Make a simple microservice using go. This should be a calculator Microservice where
   you need to have one endpoint per operation .ie:
   /calc/sum/$a/$b
   /calc/sub/$a/$b
   /calc/mul/$a/$b
   /calc/div/$a/$b
2. We also need to have a operation which show all previous operations like:
   /calc/history
   
#### Run
In order to run, just enter:
- `go run calculator.go operations.go`

You can access your application on: 
- `http://localhost:8080/calc/{operation}/{firstTerm}/{secondTerm}`

Examples:
- Sum: `http://localhost:8080/calc/sum/3/4`
- Sub: `http://localhost:8080/calc/sub/5/-2`
- Mul: `http://localhost:8080/calc/mul/3/3`
- Div: `http://localhost:8080/calc/div/9/4.5`
- History: `http://localhost:8080/calc/history`