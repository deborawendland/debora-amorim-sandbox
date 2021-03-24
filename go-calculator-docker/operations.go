package main

import "errors"

var history []Operation

type Operation struct {
	FirstTerm  float64 `json:"First Term"`
	SecondTerm float64 `json:"Second Term"`
	Operator   string  `json:"Operator"`
	Result     float64 `json:"Result"`
}

func sum(operation Operation) Operation {
	operation.Result = operation.FirstTerm + operation.SecondTerm
	return operation
}

func sub(operation Operation) Operation {
	operation.Result = operation.FirstTerm - operation.SecondTerm
	return operation
}

func mul(operation Operation) Operation {
	operation.Result = operation.FirstTerm * operation.SecondTerm
	return operation
}
func div(operation Operation) (Operation, error) {
	var err error
	if operation.SecondTerm == 0 {
		err = errors.New("cannot divide by 0")
	} else {
		operation.Result = operation.FirstTerm / operation.SecondTerm
	}
	return operation, err
}

func doOperation(operation Operation) (Operation, error) {
	var err error
	switch operation.Operator {
	case "sum":
		operation = sum(operation)
		break
	case "sub":
		operation = sub(operation)
		break
	case "mul":
		operation = mul(operation)
		break
	case "div":
		operation, err = div(operation)
		break
	default:
		err = errors.New("invalid operator: " + operation.Operator + ". Select sum/sub/div/mul")
	}

	if err == nil {
		history = append(history, operation)
	}
	return operation, err
}
