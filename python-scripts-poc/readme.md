Homework 5-Python
=================

1. Create a python HTTP service that list all linux env_vars on the http endpoint localhost:8080/conf/env
2. Create a python script that recives a 2 parameter env_name, env_Var via HTTP and create a linux env_var. Endpoint: localhost:8080/env/$name/$var
3. Create a python script that list all running software(PID and cmd) send the list to a slack channel.

#### RUN:  
To run the scripts:  
- `python3 {script}.py`

#### env_vars.py
All Environment Variables will be listed at [localhost:8080/conf/env](localhost:8080/conf/env)

#### env_var_name_request.py
This script will create a new env var. To create go to: [localhost:8080/env/{env_name}/{env_var}](localhost:8080/env/{env_name}/{env_var}) and follow the pattern.

#### slack.py
The script will publish all processes in the machine on a Slack Channel. To configure, access `config/config.txt` and set a channel and a token.