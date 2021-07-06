from gensim.test.utils import datapath
from gensim import utils
import gensim.models

class MyCorpus:
    """An iterator that yields sentences (lists of str)."""

    def __iter__(self):
        corpus_path = datapath('corpus.cor')
        for line in open(corpus_path):
            # assume there's one document per line, tokens separated by whitespace
            yield utils.simple_preprocess(line)

sentences = MyCorpus()
model = gensim.models.Word2Vec(sentences=sentences)
vec_javascript = model.wv['javascript']
console.log(vec_javascript)
