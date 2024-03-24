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

@app.route('/set_slice_owner_by_xpos', methods=['POST'])
def set_slice_owner_by_xpos():
    player_id = request.args.get('playerId')
    xpos = request.args.get('xpos')
    if not player_id or not xpos:
        return 'Hmm... That\'s an error "setNoXposPID"', 400

    for existing_xpos, existing_player_id in xpos_map.items():
        if existing_player_id == player_id:
            return 'Hmm... You already own a slice!', 403

    if xpos in xpos_map:
        return 'Hmm... That slice is already claimed!', 403

    xpos_map[xpos] = player_id
    with open('src/database.json', 'w') as f:
        json.dump(xpos_map, f, indent=4)

    return 'Slice Claimed!'

if __name__ == '__main__':
    app.run(port=8080)
