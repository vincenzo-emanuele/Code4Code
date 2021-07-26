import flask
from flask import request
import nlp
import json

app = flask.Flask(__name__)
app.config["DEBUG"] = True
nlp.load_model()

@app.route('/nlp', methods=['GET'])
def getNlp():
    inputTechnologies = extractFromRequest(request)
    outputTechnologies = []
    for inputTechnology in inputTechnologies:
        suggested = nlp.getMostSimilar(inputTechnology)
        alreadyInserted = [item[0] for item in outputTechnologies]
        for tec in suggested:
            if tec[0] in alreadyInserted: 
                elem = [item for item in outputTechnologies if item[0] == tec[0]]
                print(type(elem))
                print(type(tec))
                if elem[0][1] < tec[1]:
                    outputTechnologies.remove(elem[0])
                    outputTechnologies.append(tec)          
            else:
                outputTechnologies.append(tec)
    return str(outputTechnologies)

def extractFromRequest(request):
    jsonTechnologies = request.args['technologies']
    technologies = json.loads(jsonTechnologies)
    return technologies

app.run()
