def Node(v):
    return { 'left': None, 'value': v, 'right': None }

def solution(nodeinfo):
    index_info = [{'x':x[0], 'y':x[1], 'index':i+1} for i,x in enumerate(nodeinfo)]
    sorted_info = sorted(index_info, key=lambda x:x['y'], reverse=True)
    root = Node(sorted_info[0])
    for i in range(1, len(sorted_info)):
        info = sorted_info[i]
        cur = root
        while True:
            if(cur['value']['x']<info['x']):
                if(cur['right']==None):
                    cur['right']=Node(info)
                    break
                else:
                    cur=cur['right']
            elif(cur['value']['x']>info['x']):
                if(cur['left']==None):
                    cur['left'] = Node(info)
                    break
                else:
                    cur=cur['left']
    pre = []
    post = []
    
    def prefix(root):
        stack = [root]
        while stack:
            node = stack.pop()
            pre.append(node['value']['index'])
            if node['right']: stack.append(node['right'])  # 오른쪽 먼저 push
            if node['left']: stack.append(node['left'])    # 왼쪽 나중에 push
    
    def postfix(root):
        stack = [root]
        while stack:
            node = stack.pop()
            post.append(node['value']['index'])
            if node['left']: stack.append(node['left'])
            if node['right']: stack.append(node['right'])
        post.reverse()  # 후위순회는 결과를 뒤집기
        
    prefix(root)
    postfix(root)

    return [pre, post]