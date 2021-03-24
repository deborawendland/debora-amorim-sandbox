import psutil
import requests
from configparser import ConfigParser

config = ConfigParser()
config.read('config/config.txt')

print('Create a python script that list all running software(PID and cmd) send the list to a slack channel.')

slack_channel = config['slack']['channel']
slack_token = config['slack']['token']
slack_api_url = 'https://slack.com/api/chat.postMessage'

print("Getting processes...")
message = ""
for proc in psutil.process_iter(['pid','name']):
    message = message + proc.info['name'] + ": " + str(proc.info['pid']) + "\n"

data = {
    "token": slack_token,
    "channel": slack_channel,
    "text": message,
    "as_user": "true"
}

print("Publishing into Slack...")
response = requests.post(url = slack_api_url, data = data)
body = response.json()
if body['ok']:
    print("Published on channel: " + slack_channel)
else:
    print("Error: \n" + str(body))