from twilio.rest.ip_messaging import TwilioIpMessagingClient

# Initialize the Client
account = 'AC0cbf540c508b2ee0d8d5531f0ebbbbb6'
token = '30553869e7158458f57b5c3d30adcfe7'
client = TwilioIpMessagingClient(account, token)

# List the channels
service = client.services.get(sid="IS20edbfa2c31f409eba302de9fa11b929")
for c in service.channels.list():
    channel = service.channels.get(c.sid)
    messages = channel.messages.list()
    for m in messages:
        print(m)
