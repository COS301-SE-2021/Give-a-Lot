import nltk
from nltk.stem.lancaster import LancasterStemmer
import numpy as np
import tflearn as tfl
from tensorflow.python.framework import ops
import json
import pickle

stemmer = LancasterStemmer()


def startup():
    with open("intents.json") as file:
        data = json.load(file)

    try:
        with open("data.pickle", "rb") as f:
            words, labels, training, output = pickle.load(f)
    except:
        words = []
        labels = []
        documents_pattern = []
        documents_tag = []

        for intent in data["intents"]:
            for pattern in intent["patterns"]:
                wordTokens = nltk.word_tokenize(pattern)
                words.extend(wordTokens)
                documents_pattern.append(wordTokens)
                documents_tag.append(intent["tag"])

            if intent["tag"] not in labels:
                labels.append(intent["tag"])

        words = [stemmer.stem(w.lower()) for w in words if w != "?"]
        words = sorted(list(set(words)))

        labels = sorted(labels)

        training = []
        output = []

        out_empty = [0 for _ in range(len(labels))]
        for x, doc in enumerate(documents_pattern):
            bag = []
            wordStems = [stemmer.stem(w) for w in doc]

            for w in words:
                if w in wordStems:
                    bag.append(1)
                else:
                    bag.append(0)

            output_row = out_empty[:]
            output_row[labels.index(documents_tag[x])] = 1

            training.append(bag)
            output.append(output_row)

        training = np.array(training)
        output = np.array(output)

        with open("data.pickle", "wb") as f:
            pickle.dump((words, labels, training, output), f)

    ops.reset_default_graph()

    net = tfl.input_data(shape=[None, len(training[0])])
    net = tfl.fully_connected(net, 8)
    net = tfl.fully_connected(net, 8)
    net = tfl.fully_connected(net, len(output[0]), activation="softmax")
    net = tfl.regression(net)

    model = tfl.DNN(net)
    try:
        model.load("model.tflearn")
        return model

    except:
        model = tfl.DNN(net)
        model.fit(training, output, n_epoch=1000, batch_size=8, show_metric=True)
        model.save("model.tflearn")
        return model


startup()
