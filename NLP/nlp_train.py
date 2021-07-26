from gensim.test.utils import datapath
from gensim import utils
import gensim.models

class Code4CodeCorpus:
    def __iter__(self):
        corpus_path = datapath('code4code_corpus.cor')
        for line in open(corpus_path):
            yield utils.simple_preprocess(gensim.parsing.preprocessing.remove_stopwords(line))
            #yield utils.simple_preprocess(gensim.parsing.preprocessing.remove_stopwords(gensim.parsing.preprocessing.stem(line)))

def train_model():
    sentences = Code4CodeCorpus()
    global model 
    #model = gensim.models.Word2Vec(sentences=sentences, vector_size=150, epochs=50)
    model = gensim.models.Word2Vec(sentences=sentences, vector_size=200, epochs=50)
    return model

def store_model(model):
    with open("frameworks-libraries-model.bin", "w+") as filepath:
        temporary_filepath = filepath.name
        model.save(temporary_filepath)

def main():
    model = train_model()
    store_model(model)

if __name__ == "__main__":
    main()