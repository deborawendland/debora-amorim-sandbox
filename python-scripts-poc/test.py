import os
import psutil
from slack_sdk import WebClient

message = ''
for proc in psutil.process_iter():
    message = message + proc.name() + ' = ' + str(proc.pid) + '\n'

slack_token = 'xoxp-1197322682405-1183958687927-1197385299349-16242742d0b84d64defedebdb18e0bfd'
slack_channel = 'test'

client = WebClient(token=slack_token)

response = client.chat_postMessage(channel=slack_channel, text=message)
