Ansible Homework
================

1. Using proper ROLES/Structure in Ansbile provision your go microservice in ansible.
   You need to have generic ROLEs such as:
    - base (where you will update the os and install commons packages - could be ubuntu or centos)
    - go (proper install go)
2. Create a BASH script using ansible to check if your go microservice is running(PID check)

#### Install
In order to run your microservice you need to install Vagrant, and to use Vagrant you need to have Virtual Box installed, as well.
1. Vagrant:
    - `sudo apt install vagrant`
2. Virtual Box:
    - `sudo apt install virtualbox`
    
#### Run
When everything is installed, you can run you project! Go to the project's root and run the command:
- `vagrant up`