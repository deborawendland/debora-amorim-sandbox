Homework 4-Bash
===============

1. Create a calculator in bash(+, -, *, /) using functions and switch.
2. Create a bash script that ZIP the ALL content of a folder and move to a folder /backup/data/$TODAY/
3. Create a bash script that LIST of ENV_VARS in linux, store to a file called env_data.txt located at /backup/conf/$TODAY/

#### RUN:  
To run the scripts, you will need to make them executable:
- `chmod +x {script.sh}`
- Run: `./{script.sh}`

#### calculator.sh
The calculator allows 4 different operations (+ - x /).

#### backup.sh
The user will need to enter which folder would like to back up, with the path to it, as well.   
The backup will be available at `$HOME/backup/data/{date}`, and compressed as `{foldername}-{date}.tar.gz`.

#### get_env_vars.sh
The script will extract all the environment variables to `env_data.txt` located at `$HOME/backup/conf/{date}`.
