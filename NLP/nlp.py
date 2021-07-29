from gensim.test.utils import datapath
from gensim import utils
import gensim.models

def getMostSimilar(technology):
    similar = list(model.wv.most_similar(positive=[technology], topn=1000))
    #similar_dict = {similar[i][0] : similar[i][1] for i in range (0, len(similar))}
    #print(type(similar_dict))
    #print(similar_dict)
    filtered = filter(lambda framework: framework[0] in frameworks and framework[1] > 0.50, similar)
    return list(filtered)

def load_model():
    global model
    with open("frameworks-libraries-model.bin", "r") as filepath:
        temporary_filepath = filepath.name
        model = gensim.models.Word2Vec.load(temporary_filepath)

def getSimilarity(first_technology, second_technology):
    return model.wv.similarity(first_technology, second_technology)

frameworks = ["ajax", "amp", "android", "angular", "aspdotnet", "bootstrap", "django", "dotnet", "electron", "express", "firebase", "flask", "jquery", "keras", "koa", "laravel", "nativescript", "node", "rails", "ratchet", "react", "reactiveui", "scikit", "spring", "symfony", "tensorflow", "thymeleaf", "vue"]

def main():
    load_model()
    while True:
        technology = input("Inserisci la tecnologia\n")
        getMostSimilar(technology)

if __name__ == "__main__":
    main()