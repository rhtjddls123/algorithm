class Node{
    constructor(v){
        this.left = null;
        this.value = v;
        this.right = null;
    }
}

function solution(nodeinfo) {
    const mappedInfo = nodeinfo.map((v,i)=>({id:i+1, x:v[0], y:v[1]}));
    const sortedInfo = mappedInfo.sort((a,b)=>b.y-a.y)
    
    const tree = new Node(sortedInfo[0])
    
    for(let i=1; i<sortedInfo.length; i+=1){
        const info = sortedInfo[i];
        let curValue = tree
        while(true){
            if(curValue.value.x<info.x){
                // 오른쪽으로
                if(curValue.right===null){
                    curValue.right = new Node(info)
                    break;
                }else{
                    curValue = curValue.right;
                }
            }
            else if(curValue.value.x>info.x){
                // 왼쪽으로
                if(curValue.left===null){
                    curValue.left = new Node(info)
                    break;
                }else{
                    curValue = curValue.left;                    
                }
            }
        }
    }
    
    function preorder(node){
        // 나, 왼, 오
        preorderResult.push(node.value.id)
        if(node.left){
            preorder(node.left)
        }
        if(node.right){
            preorder(node.right)
        }
    }
    function postorder(node){
        // 왼, 오, 나
        if(node.left){
            postorder(node.left)
        }
        if(node.right){
            postorder(node.right)
        }
        postOrderResult.push(node.value.id)
    }
    
    const preorderResult = [];
    const postOrderResult = []
    preorder(tree)
    postorder(tree)
    return [preorderResult, postOrderResult]
}