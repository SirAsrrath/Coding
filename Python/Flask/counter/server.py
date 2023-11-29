from flask import Flask , render_template, request, redirect, session 
app = Flask(__name__)    
app.secret_key = "session_key"

# Main Page, opening visits and counter
@app.route('/')
def index():
    if 'count' not in session:
        session['count'] = 0
    else:
        session['count'] = session['count']
    if 'visits' not in session:
        session["visits"] = 1
    else:
        session["visits"] = session["visits"] + 1
    return render_template('index.html')


# Clear statement

@app.route('/destroy_session' , methods=['POST'])
def reset():
    session.clear()
    return redirect('/')

# Add visits by 2
@app.route('/multiple_visits' , methods=['POST'])
def multiple():
    session["count"] = session["count"] + 2
    return redirect('/')

# Add any number of visits

@app.route('/variable_visits' , methods=['POST'])
def variable():
    session['nm'] = request.form['num']
    session["count"] = session["count"] + int(session['nm'])
    return redirect('/')
if __name__=="__main__":    
    app.run(debug=True)    