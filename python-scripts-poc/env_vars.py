import flask
import os

print("Create a python HTTP service that list all linux env_vars on the http endpoint localhost:8080/conf/env")
app = flask.Flask(__name__)

@app.route("/conf/env")
def getEnvVariables ():
    return dict(os.environ)

app.run(port='8080')