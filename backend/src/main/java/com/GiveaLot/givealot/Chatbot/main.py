import nltk
from nltk.stem.lancaster import LancasterStemmer

stemmer = LancasterStemmer()
nltk.download('punkt')
import numpy as np
import tflearn as tfl
import tensorflow as tf
from tensorflow.python.framework import ops
import random
import json
import pickle

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


# def bag_of_words(stem, words):
#     bag = [0 for _ in range(len(words))]
#
#     wordStem = nltk.word_tokenize(stem)
#     wordStem = [stemmer.stem(word.lower()) for word in wordStem]
#
#     for s in wordStem:
#         for i, w in enumerate(words):
#             if w == s:
#                 bag[i] = 1
#     return np.array(bag)
#
#
# def chat():
#     print("Ask the Give A Lot bot a question! (Type 'quit' to stop)")
#     while True:
#         inp = input("You: ")
#         if inp.lower() == "quit":
#             break
#         results = model.predict([bag_of_words(inp, words)])[0]
#         index = np.argmax(results)
#         tag = labels[index]
#         if results[index] > 0.7:
#             for t in data["intents"]:
#                 if t['tag'] == tag:
#                     responses = t['responses']
#             print(random.choice(responses))
#         else:
#             options = [1, 2, 3, 4]
#             res = random.choice(options)
#             if res == 1:
#                 print("I don't quite understand, please can you ask another question?")
#             elif res == 2:
#                 print("Could you please rephrase the question, I'll try better to understand!")
#             elif res == 3:
#                 print("I'm not sure, please ask another question.")
#             elif res == 4:
#                 print("Sorry, I can't help you with that question. Try again please!")
#
#
#
#
# chat()

