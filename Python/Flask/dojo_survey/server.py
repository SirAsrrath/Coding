from flask import Flask , render_template, request, redirect, session 
app = Flask(__name__)    
app.secret_key = "session_key"
@app.route('/')
def index():
    return render_template('index.html')

@app.route('/result', methods=['POST'])
def form_print():
    session['fn'] = request.form['name']
    session['mail'] = request.form['email']
    session['gender'] = request.form['gender_identity']
    session['lang'] = request.form['language']
    session['place'] = request.form['location']
    session['check'] = request.form['accept']
    return render_template('index2.html')



if __name__=="__main__":    
    app.run(debug=True)    