import flask
from flask import request
import nlp
import json

app = flask.Flask(__name__)
app.config["DEBUG"] = True
nlp.load_model()

@app.route('/nlp', methods=['GET'])
def getNlp():
    input = extractFromRequest(request)
    inputTechnologies = [item.lower() for item in input]
    for i in range(len(inputTechnologies)):
        if inputTechnologies[i] == "c++":
            inputTechnologies[i] = "cpp"
        elif inputTechnologies[i] == "c#":
            inputTechnologies[i] = "csharp"
    print(inputTechnologies)
    outputTechnologies = []
    for inputTechnology in inputTechnologies:
        suggested = nlp.getMostSimilar(inputTechnology)
        print(suggested)
        alreadyInserted = [item[0] for item in outputTechnologies]
        for tec in suggested:
            if tec[0] in alreadyInserted: 
                elem = [item for item in outputTechnologies if item[0] == tec[0]]
                if elem[0][1] < tec[1]:
                    outputTechnologies.remove(elem[0])
                    outputTechnologies.append(tec)          
            else:
                outputTechnologies.append(tec)
    print(outputTechnologies)
    return str(json.dumps(outputTechnologies))

def extractFromRequest(request):
    jsonTechnologies = request.args['technologies']
    technologies = json.loads(jsonTechnologies)
    return technologies

app.run()
