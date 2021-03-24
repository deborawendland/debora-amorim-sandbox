package main

import (
	"encoding/json"
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
	"strconv"
	"strings"
)

func operationHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")

	firstTerm, secondTerm, operator, err := parseURIParams(r)

	if err == nil {
		operation := Operation{
			FirstTerm:  firstTerm,
			SecondTerm: secondTerm,
			Operator:   operator,
		}
		operation, err = doOperation(operation)
		if err == nil {
			operationJson, _ := json.Marshal(operation)
			fmt.Fprint(w, string(operationJson))
		} else {
			fmt.Fprint(w, err)
		}
	} else {
		fmt.Fprint(w, err)
	}

}
func historyHandler(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json")
	historyJson, _ := json.Marshal(history)
	fmt.Fprint(w, string(historyJson))
}

func parseURIParams(r *http.Request) (float64, float64, string, error) {
	params := mux.Vars(r)
	var err error
	firstTerm, err := strconv.ParseFloat(params["firstTerm"], 64)
	erro := err
	secondTerm, err := strconv.ParseFloat(params["secondTerm"], 64)
	if err != nil {
		erro = err
	}
	operator := strings.ToLower(params["operator"])
	return firstTerm, secondTerm, operator, erro
}

func main() {
	router := mux.NewRouter()
	router.HandleFunc("/calc/history", historyHandler)
	router.HandleFunc("/calc/{operator}/{firstTerm}/{secondTerm}", operationHandler)

	http.ListenAndServe(":8080", router)
}
