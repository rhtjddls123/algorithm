def solution(n, k, cmd):
    table = [{ 'prev': None if i==0 else i-1, 'index':i,'deleted': False, 'next': None if i==n-1 else i+1 } for i in range(n)]
    stack = []
    
    for c in cmd:
        commands = c.split(' ')
        action = commands[0]
        if(action=='C'):
            stack.append(k)
            table[k]['deleted']=True
            if(table[k]['next']==None):
                if(table[k]['prev'] != None):
                  table[table[k]['prev']]['next'] = None
                k = table[k]['prev']
            else:
                if(table[k]['prev'] != None):
                  table[table[k]['prev']]['next'] = table[k]['next']
                table[table[k]['next']]['prev'] = table[k]['prev']
                k = table[k]['next']
        elif(action=='Z'):
            r = stack.pop()
            table[r]['deleted'] = False
            if(table[r]['prev']): table[table[r]['prev']]['next'] = r
            if(table[r]['next']): table[table[r]['next']]['prev'] = r
        elif(action=='U' or action=='D'):
            for i in range(int(commands[1])):
                if(action=='U'):
                    k = table[k]['prev']
                elif(action=='D'):
                    k = table[k]['next']
    result = ""
    for t in table:
        if t['deleted']:
            result += 'X'
        else:
            result += 'O'
            
    return result
