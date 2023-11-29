from flask import Flask , render_template # Import Flask to allow us to create our app
app = Flask(__name__)    # Create a new instance of the Flask class called "app"


@app.route('/')
def hello_world():
    return render_template('index.html')

@app.route('/play')
def route_play():
    return render_template('index.html',num=3,color = "blue")

@app.route('/play/<int:box_num>')
def route_box(box_num):
    return render_template('index.html', num = box_num,color = "blue")

@app.route('/play/<int:box_num>/<string:color>')
def route_color(box_num,color):
    return render_template('index.html', num = box_num , color = color)

if __name__=="__main__":   # Ensure this file is being run directly and not from a different module    
    app.run(debug=True)    # Run the app in debug mode.

