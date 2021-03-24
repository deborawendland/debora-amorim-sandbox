#!/bin/bash

echo "Create a calculator in bash(+, -, *, /) using functions and switch."

do_operation () {
  case $2 in
  "+")
    result=$(($1 + $3))
    echo "Result: " $result
    ;;
  "-")
    result=$(($1 - $3))
    echo "Result: " $result
    ;;
  "x")
    result=$(($1 * $3))
    echo "Result: " $result
    ;;
  "/")
    if [ $3 = 0 ]
    then
      echo "Error: A number cannot be divided by 0."
    else
      result=$(($1 / $3))
      echo "Result: " $result
    fi
    ;;
  *)
    echo "Error: Invalid Operation."
    ;;
  esac
}

exit_question () {
  echo "Do you want to continue? [y/n]"
  read answer
  if [ $answer != "y" ]
  then
    exit 0
  fi
}

while [ true ]
do
  echo "enter first number"
  read first_number
  echo "enter second number"
  read second_number
  echo "Enter operation (+ - x /)"
  read operation

  do_operation $first_number $operation $second_number
  exit_question
done