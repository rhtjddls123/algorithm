def solution(record):
    idNameDict = {}
    message = []
    for r in record:
        command = r.split(' ')
        action = command[0]
        id = command[1]
        if(action == 'Enter'):
            idNameDict[id] = command[2]
            message.append({'action': action, 'id': id})
        elif(action == 'Leave'):
            message.append({'action': action, 'id': id})
        elif(action == 'Change'):
            idNameDict[id] = command[2]
        
    result = []
    for m in message:
        name = idNameDict[m['id']]
        if m['action']=='Enter':
            result.append(f'{name}님이 들어왔습니다.')
        elif m['action']=='Leave':
            result.append(f'{name}님이 나갔습니다.')
            
    return result