from flask import Flask, render_template, request, redirect, url_for
from twilio.rest.ip_messaging import TwilioIpMessagingClient

account = 'AC0cbf540c508b2ee0d8d5531f0ebbbbb6'
token = '30553869e7158458f57b5c3d30adcfe7'

client = TwilioIpMessagingClient(account, token)

app = Flask(__name__)

@app.route('/')
def main():

    sid = None
    name = None
    creation = None
    links = None
    #text = request.form['text']
    
    service = client.services.get(sid="IS20edbfa2c31f409eba302de9fa11b929")
    for c in service.channels.list():
        sid = c.sid
        name = c.friendly_name
        creation = c.created_by
        links = c.links

    channel = service.channels.get(sid)
    #message = channel.messages.create(body=text)
    messages = channel.messages.list()
    #message = channel.messages.create(body="where's the next hint?", From="Danny")
    #print(message)

    
    return render_template('main.html',
                           name = name,
                           creation = creation,
                           links = links,
                           messages = messages)

@app.route('/', methods=['POST'])
def post():
    text = request.form['text']
    sid = None
    service = client.services.get(sid="IS20edbfa2c31f409eba302de9fa11b929")
    for c in service.channels.list():
        sid = c.sid
    channel = service.channels.get(sid)
#    messages = channel.messages.list()
    message = channel.messages.create(body=text)
    return redirect(url_for('main'))
    
        
if __name__ == "__main__":
    app.debug = True
    app.run()
