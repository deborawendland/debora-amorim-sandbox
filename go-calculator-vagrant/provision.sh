sudo add-apt-repository ppa:longsleep/golang-backports -y
sudo apt update
sudo apt install golang-go -y

cd /vagrant/calculator-app
go get -d -v ./...