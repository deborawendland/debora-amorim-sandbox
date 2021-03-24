import flask
import os
from flask import Response

print('Create a python script that receives a 2 parameter env_name, env_Var via HTTP and create a linux env_var. Endpoint: localhost:8080/env/$name/$var')

app = flask.Flask(__name__)

@app.route("/env/<name>/<var>", methods=["POST"])
def env(name=None, var=None):
    if (os.getenv(name) is None ):
        os.environ[name] = var
        return Response("Created " + name + ":" + os.getenv(name), status=201)
    else:
        return Response(name + " already exists", status=400)

app.run(port='8080')