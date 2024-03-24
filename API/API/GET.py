from flask import Flask, request, jsonify
import json

app = Flask(__name__)

with open('src/database.json', 'r') as f:
    xpos_map = json.load(f)

@app.route('/get_xpos_by_player_id')
def get_xpos_by_player_id():
    player_id = request.args.get('playerId')
    for key, value in xpos_map.items():
        if value == player_id:
            return key
    return 'Hmm... That\'s an error "getNoPID"', 404

@app.route('/get_player_id_by_xpos')
def get_player_id_by_xpos():
    xpos = request.args.get('xpos')
    player_id = xpos_map.get(xpos)
    if player_id is not None:
        return player_id
    return 'Hmm... That\'s an error "getNoXpos', 404

if __name__ == '__main__':
    app.run(port=8080)
