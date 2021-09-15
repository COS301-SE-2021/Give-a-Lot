import nltk
from nltk.stem.lancaster import LancasterStemmer

from main import startup

stemmer = LancasterStemmer()
nltk.download('punkt')
import numpy as np
import tflearn as tfl
import tensorflow as tf
from tensorflow.python.framework import ops
import random
import json
import pickle
from flask import Flask, render_template, request
from flask_ngrok import run_with_ngrok
from keras.models import load_model

with open("intents.json") as file:
    data = json.load(file)
with open("data.pickle", "rb") as f:
    words, labels, training, output = pickle.load(f)
model = startup()

app = Flask(__name__)
run_with_ngrok(app)

@app.route("/")
def home():
    return render_template("index.html")



@app.route("/get", methods=["POST"])
def chat():
    inp = request.form["msg"]
    results = model.predict([bag_of_words(inp, words)])[0]
    index = np.argmax(results)
    tag = labels[index]
    if results[index] > 0.7:
        for t in data["intents"]:
            if t['tag'] == tag:
                responses = t['responses']
        return random.choice(responses)
    else:
        options = [1, 2, 3, 4]
        res = random.choice(options)
        if res == 1:
            return "I don't quite understand, please can you ask another question?"
        elif res == 2:
            return "Could you please rephrase the question, I'll try better to understand!"
        elif res == 3:
            return "I'm not sure, please ask another question."
        elif res == 4:
            return "Sorry, I can't help you with that question. Try again please!"


def bag_of_words(stem, words):
    bag = [0 for _ in range(len(words))]

    wordStem = nltk.word_tokenize(stem)
    wordStem = [stemmer.stem(word.lower()) for word in wordStem]

    for s in wordStem:
        for i, w in enumerate(words):
            if w == s:
                bag[i] = 1
    return np.array(bag)


if __name__ == "__main__":
    app.run()