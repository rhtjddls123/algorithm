def solution(phone_book):
    phone_book = sorted(phone_book)
    for i in range(len(phone_book)-1):
        n=len(phone_book[i])
        if(phone_book[i+1][:n]==phone_book[i]): return False
            
    return True