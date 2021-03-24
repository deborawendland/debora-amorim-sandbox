#!/bin/bash
if pidof calculator
then
    echo RUNNING
else
    echo NOT RUNNING
fi