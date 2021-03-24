#!/bin/bash

echo "Create a bash script that ZIP the ALL content of a folder and move to a folder /backup/data/$TODAY/"

continue_backups_question () {
  echo "Do you want to perform another backup? [y/n]"
  read answer
  if [ $answer != "y" ]
  then
    exit 0
  fi
}

today_date=$(date +%d-%m-%Y)
backup_path=$HOME/backup/data/

while [ true ]
do
    echo "Enter the directory path to backup: "
    read directory_path

    if [ ! -d $directory_path ]
    then
        echo "Error: Path: " $directory_path " does not exist!"
    else
        if [ ! -d $backup_path/$today_date ]
        then
          echo "Creating backup directory: " $backup_path/$today_date
          mkdir -p $backup_path/$today_date
        fi
        cd $backup_path/$today_date
        echo "Backing up"
        tar -zcvf $(basename $directory_path)-$today_date.tar.gz $directory_path
        echo "Backup finished, files at " $backup_path/$today_date
    fi
    continue_backups_question
done