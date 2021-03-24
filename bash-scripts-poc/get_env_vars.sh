#!/bin/bash

echo "Create a bash script that LIST of ENV_VARS in linux, store to a file called env_data.txt located at /backup/conf/TODAY/"

today_date=$(date +%d-%m-%Y)
backup_path=$HOME/backup/conf
file_name=env_data.txt

if [ ! -d $backup_path/$today_date ]
then
  echo "Creating backup directory: " $backup_path/$today_date
  mkdir -p $backup_path/$today_date
fi
  if [ ! -f $backup_path/$today_date/$file_name ]
  then
    echo "Creating file: " $file_name
    touch $backup_path/$today_date/$file_name
  fi

echo "Exporting ENV_VARS into " $backup_path/$today_date/$file_name
env >> $backup_path/$today_date/$file_name
echo "Exported"